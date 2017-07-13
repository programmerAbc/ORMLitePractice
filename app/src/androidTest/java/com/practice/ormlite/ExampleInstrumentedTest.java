package com.practice.ormlite;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.table.TableUtils;
import com.practice.ormlite.dao.ArticleDao;
import com.practice.ormlite.dao.UploadAlbumEntityDao;
import com.practice.ormlite.dao.UploadProductEntityDao;
import com.practice.ormlite.dao.UserDao;
import com.practice.ormlite.model.Article;
import com.practice.ormlite.model.UploadAlbumEntity;
import com.practice.ormlite.model.UploadProductEntity;
import com.practice.ormlite.model.User;
import com.practice.util.UploadUtil;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    public static final String TAG = ExampleInstrumentedTest.class.getSimpleName();

    @Test
    public void runTest() {
        Context appContext = InstrumentationRegistry.getTargetContext();
        Log.e(TAG, "runTest: HERE");
    }


    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Log.e(TAG, "useAppContext: start");
        Context appContext = InstrumentationRegistry.getTargetContext();
        DatabaseHelper helper = DatabaseHelper.getHelper(appContext);
        UserDao.getInstance(helper).create(new User("aaa", "普通用户"));
        UserDao.getInstance(helper).create(new User("bbb", "普通用户"));
        UserDao.getInstance(helper).create(new User("ccc", "高级用户"));
        UserDao.getInstance(helper).create(new User("ddd", "高级用户"));
        UserDao.getInstance(helper).create(new User("eee", "管理员用户"));
        UserDao.getInstance(helper).create(new User("fff", "管理员用户"));
        UserDao.getInstance(helper).create(new User("ggg", "普通用户"));
        helper.close();
        assertEquals("com.practice.ormlite", appContext.getPackageName());
    }

    @Test
    public void queryDatabase() throws Exception {
        Context appContext = InstrumentationRegistry.getTargetContext();
        DatabaseHelper helper = DatabaseHelper.getHelper(appContext);
        List<User> users = UserDao.getInstance(helper).queryForAll();
        helper.close();
        if (users.isEmpty()) {
            Log.e(TAG, "queryDatabase: empty set");
        }
        for (User user : users) {
            Log.e(TAG, "queryDatabase: " + user.toString());
        }
        assertEquals("com.practice.ormlite", appContext.getPackageName());
    }

    @Test
    public void queryNormalUser() throws Exception {
        Context appContext = InstrumentationRegistry.getTargetContext();
        DatabaseHelper helper = DatabaseHelper.getHelper(appContext);
        List<User> users = UserDao.getInstance(helper).queryForMatching(new User(null, "普通用户"));
        helper.close();
        if (users.isEmpty()) {
            Log.e(TAG, "queryDatabase: empty set");
        }
        for (User user : users) {
            Log.e(TAG, "queryDatabase: " + user.toString());
        }
        assertEquals("com.practice.ormlite", appContext.getPackageName());
    }

    @Test
    public void queryNormalUser2() throws Exception {
        Context appContext = InstrumentationRegistry.getTargetContext();
        DatabaseHelper helper = DatabaseHelper.getHelper(appContext);
        List<User> users = UserDao.getInstance(helper).queryForMatchingArgs(new User(null, "普通用户"));
        helper.close();
        if (users.isEmpty()) {
            Log.e(TAG, "queryDatabase: empty set");
        }
        for (User user : users) {
            Log.e(TAG, "queryDatabase: " + user.toString());
        }
        assertEquals("com.practice.ormlite", appContext.getPackageName());
    }

    @Test
    public void clearDatabase() throws Exception {
        Context appContext = InstrumentationRegistry.getTargetContext();
        DatabaseHelper helper = DatabaseHelper.getHelper(appContext);
        TableUtils.clearTable(helper.getConnectionSource(), User.class);
        assertEquals("com.practice.ormlite", appContext.getPackageName());
    }

    @Test
    public void foreignTest() throws SQLException {
        Context appContext = InstrumentationRegistry.getTargetContext();
        DatabaseHelper helper = DatabaseHelper.getHelper(appContext);
        Dao<Article, Integer> articleDao = ArticleDao.getInstance(helper);
        Dao<User, Integer> userDao = UserDao.getInstance(helper);
        User user = new User("张三", "文学家");
        userDao.create(user);
        articleDao.create(new Article("散文1", user));
        articleDao.create(new Article("散文2", user));
        articleDao.create(new Article("散文3", user));
        articleDao.create(new Article("散文4", user));
        articleDao.create(new Article("散文5", user));
        articleDao.create(new Article("散文6", user));
        List<Article> articles = articleDao.queryForEq("user_id", user);
        if (articles.isEmpty()) {
            Log.e(TAG, "foreignTest:empty");
        }
        for (Article article : articles) {
            Log.e(TAG, "foreignTest:" + article);
        }

    }

    @Test
    public void foreignTest2() throws SQLException {
        Context appContext = InstrumentationRegistry.getTargetContext();
        DatabaseHelper helper = DatabaseHelper.getHelper(appContext);
        Dao<UploadAlbumEntity, Integer> uploadAlbumEntityDao = UploadAlbumEntityDao.getInstance(helper);
        Dao<UploadProductEntity, Integer> uploadVideoEntityDao = UploadProductEntityDao.getInstance(helper);

        UploadAlbumEntity uploadAlbumEntity = new UploadAlbumEntity("专辑一", "发行的第一部专辑，里面包含几个视频", UploadUtil.UPLOAD_STATUS_UPLOADING);
        uploadAlbumEntityDao.create(uploadAlbumEntity);
        uploadVideoEntityDao.create(new UploadProductEntity(1000, 0, 0, UploadUtil.UPLOAD_STATUS_UPLOADING, uploadAlbumEntity));
        uploadVideoEntityDao.create(new UploadProductEntity(2000, 0, 0, UploadUtil.UPLOAD_STATUS_UPLOADING, uploadAlbumEntity));
        uploadVideoEntityDao.create(new UploadProductEntity(3000, 0, 0, UploadUtil.UPLOAD_STATUS_UPLOADING, uploadAlbumEntity));
        uploadVideoEntityDao.create(new UploadProductEntity(4000, 0, 0, UploadUtil.UPLOAD_STATUS_UPLOADING, uploadAlbumEntity));
        uploadVideoEntityDao.create(new UploadProductEntity(5000, 0, 0, UploadUtil.UPLOAD_STATUS_UPLOADING, uploadAlbumEntity));
        uploadVideoEntityDao.create(new UploadProductEntity(6000, 0, 0, UploadUtil.UPLOAD_STATUS_UPLOADING, uploadAlbumEntity));

        uploadAlbumEntity = new UploadAlbumEntity("专辑二", "发行的第二部专辑，里面包含几个视频", UploadUtil.UPLOAD_STATUS_UPLOADING);
        uploadAlbumEntityDao.create(uploadAlbumEntity);
        uploadVideoEntityDao.create(new UploadProductEntity(1100, 0, 0, UploadUtil.UPLOAD_STATUS_UPLOADING, uploadAlbumEntity));
        uploadVideoEntityDao.create(new UploadProductEntity(2200, 0, 0, UploadUtil.UPLOAD_STATUS_UPLOADING, uploadAlbumEntity));
        uploadVideoEntityDao.create(new UploadProductEntity(3300, 0, 0, UploadUtil.UPLOAD_STATUS_UPLOADING, uploadAlbumEntity));
        uploadVideoEntityDao.create(new UploadProductEntity(4400, 0, 0, UploadUtil.UPLOAD_STATUS_UPLOADING, uploadAlbumEntity));
        uploadVideoEntityDao.create(new UploadProductEntity(5500, 0, 0, UploadUtil.UPLOAD_STATUS_UPLOADING, uploadAlbumEntity));
        uploadVideoEntityDao.create(new UploadProductEntity(6600, 0, 0, UploadUtil.UPLOAD_STATUS_UPLOADING, uploadAlbumEntity));

        List<UploadAlbumEntity> uploadAlbumEntities = uploadAlbumEntityDao.queryForAll();
        for (UploadAlbumEntity albumEntity : uploadAlbumEntities) {
            Log.e(TAG, "album entity:" + albumEntity);
            List<UploadProductEntity> uploadVideoEntities = uploadVideoEntityDao.queryForEq(UploadProductEntity.FOREIGN_COLUMN_NAME, albumEntity);
            for (UploadProductEntity videoEntity : uploadVideoEntities) {
                Log.e(TAG, "     video entity:" + videoEntity);
            }
        }
    }



}
