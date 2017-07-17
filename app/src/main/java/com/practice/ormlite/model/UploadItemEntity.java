package com.practice.ormlite.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by usera on 2017/7/12.
 */
@DatabaseTable(tableName = UploadItemEntity.TABLE_NAME)
public class UploadItemEntity {
    public static final String TABLE_NAME = "tb_upload_item";
    public static final String FOREIGN_COLUMN_NAME = "upload_set_id";

    @DatabaseField(id = true)
    private String id = "";

    //作品的大小
    @DatabaseField
    private long totalSize = 0;

    //作品已经上传的大小
    @DatabaseField
    private long uploadedSize = 0;

    //上传时间戳，每次上传一点都刷新一次，用于检测是否上传断流
    @DatabaseField
    private long uploadTimestamp = 0;

    //上传的作品的类型，包括:视频，图片，广告
    @DatabaseField
    private String resourceType = "";

    @DatabaseField
    private String router = "";

    //要上传的视频的路径
    @DatabaseField
    private String resourcePath = "";

    //要上传的视频的url
    @DatabaseField
    private String resourceUrl = "";

    //舞蹈类型
    @DatabaseField
    private String danceType = "";

    //地点
    @DatabaseField
    private String location = "";

    //维度
    @DatabaseField
    private double lat = 0;

    //经度
    @DatabaseField
    private double lng = 0;

    //视频的播放时长,如果不是视频的话就是0
    @DatabaseField
    private long duration = 0;

    //七牛的上传Token
    @DatabaseField
    private String uploadToken = "";

    //外键关联到上传集合表
    @DatabaseField(canBeNull = false, foreign = true, columnName = FOREIGN_COLUMN_NAME, foreignAutoRefresh = true)
    private UploadSetEntity uploadSetEntity;

    public UploadItemEntity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(long totalSize) {
        this.totalSize = totalSize;
    }

    public long getUploadedSize() {
        return uploadedSize;
    }

    public void setUploadedSize(long uploadedSize) {
        this.uploadedSize = uploadedSize;
    }

    public long getUploadTimestamp() {
        return uploadTimestamp;
    }

    public void setUploadTimestamp(long uploadTimestamp) {
        this.uploadTimestamp = uploadTimestamp;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getRouter() {
        return router;
    }

    public void setRouter(String router) {
        this.router = router;
    }

    public String getResourcePath() {
        return resourcePath;
    }

    public void setResourcePath(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    public String getDanceType() {
        return danceType;
    }

    public void setDanceType(String danceType) {
        this.danceType = danceType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getUploadToken() {
        return uploadToken;
    }

    public void setUploadToken(String uploadToken) {
        this.uploadToken = uploadToken;
    }

    public UploadSetEntity getUploadSetEntity() {
        return uploadSetEntity;
    }

    public void setUploadSetEntity(UploadSetEntity uploadSetEntity) {
        this.uploadSetEntity = uploadSetEntity;
    }
}
