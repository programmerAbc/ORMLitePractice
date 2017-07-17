package com.practice.util;

/**
 * Created by usera on 2017/7/12.
 */

public class UploadUtil {
    public static final int CONTROL_OPTION_UPLOAD = 1;
    public static final int CONTROL_OPTION_STOP = 2;
    public static final int CONTROL_OPTION_EDIT = 3;

    public static final int PUBLISH_STATUS_UNPUBLISHED = 4;
    public static final int PUBLISH_STATUS_PUBLISHED = 5;

    public static final String RESOURCE_TYPE_VIDEO = "0";
    public static final String RESOURCE_TYPE_IMAGE = "1";
    public static final String RESOURCE_TYPE_AD = "2";

    public static String generateUploadItemId(int localId) {
//        String session = MyApplication.getInstance().getPrefs().getString(WuDaoConfig.signSession, "");
//        long timeMillis = System.currentTimeMillis();//系统时间毫秒（13位）
//
//        String fileName = timeMillis + session + localId;
//
//        int count = 32 - session.length() - 13;
//        int randNum[] = WuDaoUtils.randomCommon(0, 10, count);
//        for (int i = 0; i < randNum.length; i++) {
//            fileName += randNum[i];
//        }

        //return fileName;
        return localId + "";
    }

}
