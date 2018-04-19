package com.practice.ormlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.table.DatabaseTableConfig;
import com.j256.ormlite.table.TableInfo;
import com.j256.ormlite.table.TableUtils;
import com.practice.ormlite.model.Article;
import com.practice.ormlite.model.UploadSetEntity;
import com.practice.ormlite.model.UploadItemEntity;
import com.practice.ormlite.model.User;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import timber.log.Timber;

/**
 * Created by user1 on 2017/6/14.
 */

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
    public static final String TAG = DatabaseHelper.class.getSimpleName();
    private static final String DB_NAME = "ORMLitePractice.db";
    List<Class<?>> tableList = Arrays.asList(
            User.class,
            Article.class,
            UploadSetEntity.class,
            UploadItemEntity.class);
    
    
    public DatabaseHelper(Context context) {
        super(context, Environment.getExternalStorageDirectory() + File.separator + DB_NAME, null, 5);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        for (Class<?> clazz : tableList) {
            createTableSilent(connectionSource, clazz);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        for (Class<?> clazz : tableList) {
            migrateTable(this, connectionSource, clazz);
        }
    }

    private static DatabaseHelper instance;

    public static synchronized DatabaseHelper getHelper(Context context) {
        if (instance == null) {
            instance = new DatabaseHelper(context);
        }
        return instance;
    }

    public static <T> void createTableSilent(ConnectionSource connectionSource, Class<T> clazz) {
        try {
            TableUtils.createTableIfNotExists(connectionSource, clazz);
        } catch (Exception e) {
            Timber.e("createTableSilent:" + Log.getStackTraceString(e));
        }
    }

    public static <T> void dropTableSilent(ConnectionSource connectionSource, Class<T> clazz) {
        try {
            TableUtils.dropTable(connectionSource, clazz, true);
        } catch (Exception e) {
            Timber.e("dropTableSilent:" + Log.getStackTraceString(e));
        }
    }
    private static boolean checkTableExists(final ConnectionSource connectionSource, final String tableName) throws Exception {
        boolean alreadyExists = false;
        DatabaseConnection databaseConnection = connectionSource.getReadOnlyConnection();
        Exception capturedException = null;
        try {
            alreadyExists = databaseConnection.isTableExists(tableName);
        } catch (Exception e) {
            capturedException = e;
        }
        if (capturedException != null) {
            throw capturedException;
        }
        return alreadyExists;

    }
    
    public static <T> void migrateTable(OrmLiteSqliteOpenHelper helper, ConnectionSource connectionSource, Class<T> clazz) {
        try {
            String tableName = DatabaseTableConfig.extractTableName(clazz);
            if (TextUtils.isEmpty(tableName)) {
                return;
            }
            boolean tableExist = checkTableExists(connectionSource, tableName);
            if (tableExist) {
                Dao<T,?> dao = helper.getDao(clazz);
                QueryBuilder queryBuilder = dao.queryBuilder();
                GenericRawResults<String[]> oldTableQueryResults = queryBuilder.queryRaw();
                String[] oldColumns = oldTableQueryResults.getColumnNames();
                oldTableQueryResults.close();
                String tempTableName = (tableName + "_OLD").toUpperCase();
                try {
                    boolean tempTableAlreadyExists = checkTableExists(connectionSource, tempTableName);

                    if (tempTableAlreadyExists) {
                        dao.executeRaw("DROP TABLE " + tempTableName);
                    }
                } catch (Throwable t) {
                }
                dao.executeRaw("ALTER TABLE '" + tableName + "' RENAME TO '" + tempTableName + "';");
                TableUtils.createTable(connectionSource, clazz);
                TableInfo tableInfo = new TableInfo(connectionSource, (BaseDaoImpl) dao, clazz);
                //loop around both sets of columns and build up a String listing the common column names
                StringBuilder columnNamesString = new StringBuilder();

                boolean first = true;
                for (String col : oldColumns) {
                    if (tableInfo.hasColumnName(col)) {
                        if (first == false) {
                            columnNamesString.append(", ");
                        }
                        first = false;
                        columnNamesString.append(col);
                    }
                }
                //build an SQL statement to copy data from matching columns from the old to new tables
                String statement = "INSERT INTO " + tableName + " (" + columnNamesString + ") SELECT " + columnNamesString + " FROM " + tempTableName;
                dao.executeRaw(statement);
                dao.executeRaw("DROP TABLE " + tempTableName);
            } else {
                TableUtils.createTableIfNotExists(connectionSource, clazz);
            }
        } catch (Exception e) {
            Timber.e("migrateTable error:" + Log.getStackTraceString(e));
            Timber.e("try create a new table:" + DatabaseTableConfig.extractTableName(clazz));
            dropTableSilent(connectionSource, clazz);
            createTableSilent(connectionSource, clazz);
        }
    }
}
