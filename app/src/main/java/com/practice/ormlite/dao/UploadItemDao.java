package com.practice.ormlite.dao;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.practice.ormlite.model.UploadItemEntity;

import java.sql.SQLException;

/**
 * Created by usera on 2017/6/15.
 */

public class UploadItemDao {
    private static Dao<UploadItemEntity, String> dao = null;

    public static synchronized Dao<UploadItemEntity, String> getInstance(OrmLiteSqliteOpenHelper helper) throws SQLException {
        if (dao == null) {
            dao = helper.getDao(UploadItemEntity.class);
        }
        return dao;
    }

}
