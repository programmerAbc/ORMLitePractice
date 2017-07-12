package com.practice.ormlite.dao;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.practice.ormlite.model.User;

import java.sql.SQLException;

/**
 * Created by usera on 2017/6/15.
 */

public class UserDao {
    private static Dao<User, Integer> dao = null;

    public static synchronized Dao<User, Integer> getInstance(OrmLiteSqliteOpenHelper helper) throws SQLException {
        if (dao == null) {
            dao = helper.getDao(User.class);
        }
        return dao;
    }

}
