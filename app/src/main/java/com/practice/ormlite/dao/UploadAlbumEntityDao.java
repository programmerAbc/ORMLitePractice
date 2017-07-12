package com.practice.ormlite.dao;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.practice.ormlite.model.Article;
import com.practice.ormlite.model.UploadAlbumEntity;

import java.sql.SQLException;

/**
 * Created by usera on 2017/6/15.
 */

public class UploadAlbumEntityDao {
    private static Dao<UploadAlbumEntity, Integer> dao = null;

    public static synchronized Dao<UploadAlbumEntity, Integer> getInstance(OrmLiteSqliteOpenHelper helper) throws SQLException {
        if (dao == null) {
            dao = helper.getDao(UploadAlbumEntity.class);
        }
        return dao;
    }

}
