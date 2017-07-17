package com.practice.ormlite.dao;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.practice.ormlite.model.UploadSetEntity;

import java.sql.SQLException;

/**
 * Created by usera on 2017/6/15.
 */

public class UploadSetDao {
    private static Dao<UploadSetEntity, Integer> dao = null;

    public static synchronized Dao<UploadSetEntity, Integer> getInstance(OrmLiteSqliteOpenHelper helper) throws SQLException {
        if (dao == null) {
            dao = helper.getDao(UploadSetEntity.class);
        }
        return dao;
    }

}
