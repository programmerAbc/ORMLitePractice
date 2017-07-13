package com.practice.ormlite.dao;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.practice.ormlite.model.UploadProductEntity;

import java.sql.SQLException;

/**
 * Created by usera on 2017/6/15.
 */

public class UploadProductEntityDao {
    private static Dao<UploadProductEntity, Integer> dao = null;

    public static synchronized Dao<UploadProductEntity, Integer> getInstance(OrmLiteSqliteOpenHelper helper) throws SQLException {
        if (dao == null) {
            dao = helper.getDao(UploadProductEntity.class);
        }
        return dao;
    }

}
