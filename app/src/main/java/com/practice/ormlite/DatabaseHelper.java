package com.practice.ormlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.practice.ormlite.model.Article;
import com.practice.ormlite.model.UploadSetEntity;
import com.practice.ormlite.model.UploadItemEntity;
import com.practice.ormlite.model.User;

import java.io.File;

/**
 * Created by user1 on 2017/6/14.
 */

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
    public static final String TAG = DatabaseHelper.class.getSimpleName();
    private static final String DB_NAME = "ORMLitePractice.db";

    public DatabaseHelper(Context context) {
        super(context, Environment.getExternalStorageDirectory() + File.separator + DB_NAME, null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTableIfNotExists(connectionSource, User.class);
            TableUtils.createTableIfNotExists(connectionSource, Article.class);
            TableUtils.createTableIfNotExists(connectionSource, UploadSetEntity.class);
            TableUtils.createTableIfNotExists(connectionSource, UploadItemEntity.class);

        } catch (Exception e) {
            Log.e(TAG, "onCreate: " + Log.getStackTraceString(e));
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, User.class, true);
            TableUtils.dropTable(connectionSource, Article.class, true);
            TableUtils.dropTable(connectionSource, UploadSetEntity.class, true);
            TableUtils.dropTable(connectionSource, UploadItemEntity.class, true);
            onCreate(database, connectionSource);
        } catch (Exception e) {
            Log.e(TAG, "onUpgrade: " + Log.getStackTraceString(e));
        }
    }

    private static DatabaseHelper instance;

    public static synchronized DatabaseHelper getHelper(Context context) {
        if (instance == null) {
            instance = new DatabaseHelper(context);
        }
        return instance;
    }
}
