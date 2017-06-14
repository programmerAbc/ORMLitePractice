package com.practice.ormlite;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.j256.ormlite.table.TableUtils;
import com.practice.ormlite.model.User;

import org.junit.Test;
import org.junit.runner.RunWith;

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
        helper.getUserDao().create(new User("aaa", "普通用户"));
        helper.getUserDao().create(new User("bbb", "普通用户"));
        helper.getUserDao().create(new User("ccc", "高级用户"));
        helper.getUserDao().create(new User("ddd", "高级用户"));
        helper.getUserDao().create(new User("eee", "管理员用户"));
        helper.getUserDao().create(new User("fff", "管理员用户"));
        helper.getUserDao().create(new User("ggg", "普通用户"));
        helper.close();
        assertEquals("com.practice.ormlite", appContext.getPackageName());
    }

    @Test
    public void queryDatabase() throws Exception {
        Context appContext = InstrumentationRegistry.getTargetContext();
        DatabaseHelper helper = DatabaseHelper.getHelper(appContext);
        List<User> users = helper.getUserDao().queryForAll();
        helper.close();
        if(users.isEmpty()){
            Log.e(TAG,"queryDatabase: empty set");
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
        List<User> users = helper.getUserDao().queryForMatching(new User(null,"普通用户"));
        helper.close();
        if(users.isEmpty()){
            Log.e(TAG,"queryDatabase: empty set");
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
        List<User> users = helper.getUserDao().queryForMatchingArgs(new User(null,"普通用户"));
        helper.close();
        if(users.isEmpty()){
            Log.e(TAG,"queryDatabase: empty set");
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
        TableUtils.clearTable(helper.getConnectionSource(),User.class);
        assertEquals("com.practice.ormlite", appContext.getPackageName());
    }


}
