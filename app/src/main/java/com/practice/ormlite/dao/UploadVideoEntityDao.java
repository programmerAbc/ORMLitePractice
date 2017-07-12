package com.practice.ormlite.dao;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.practice.ormlite.model.Article;
import com.practice.ormlite.model.UploadAlbumEntity;
import com.practice.ormlite.model.UploadVideoEntity;

import java.sql.SQLException;

/**
 * Created by usera on 2017/6/15.
 */

public class UploadVideoEntityDao {
    private static Dao<UploadVideoEntity, Integer> dao = null;

    public static synchronized Dao<UploadVideoEntity, Integer> getInstance(OrmLiteSqliteOpenHelper helper) throws SQLException {
        if (dao == null) {
            dao = helper.getDao(UploadVideoEntity.class);
        }
        return dao;
    }

}
