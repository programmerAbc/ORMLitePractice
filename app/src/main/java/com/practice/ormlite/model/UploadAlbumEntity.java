package com.practice.ormlite.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by usera on 2017/7/12.
 */
@DatabaseTable(tableName = UploadAlbumEntity.TABLE_NAME)
public class UploadAlbumEntity {
    public static final String TABLE_NAME = "tb_upload_album";
    @DatabaseField(generatedId = true)
    private int id = 0;
    //标题
    @DatabaseField
    private String title = "";
    //描述
    @DatabaseField
    private String description = "";
    //上传的状态，包括:错误，上传中，上传完成，停止上传，已发布
    @DatabaseField
    private int uploadStatus = 0;
    //上传的作品的类型，包括:视频，图片，广告
    @DatabaseField
    private String resourceType = "";
    //用户ID
    @DatabaseField
    private String userId = "";
    @DatabaseField
    private String router = "";
    //舞蹈类型
    @DatabaseField
    private String danceType = "";
    //地址
    @DatabaseField
    private String address = "";
    //维度
    @DatabaseField
    private double lat = 0;
    //经度
    @DatabaseField
    private double lng = 0;
    //发布日期
    @DatabaseField
    private long releaseDate = 0;

    public UploadAlbumEntity() {
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRouter() {
        return router;
    }

    public void setRouter(String router) {
        this.router = router;
    }

    public String getDanceType() {
        return danceType;
    }

    public void setDanceType(String danceType) {
        this.danceType = danceType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public long getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(long releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUploadStatus() {
        return uploadStatus;
    }

    public void setUploadStatus(int uploadStatus) {
        this.uploadStatus = uploadStatus;
    }

    @Override
    public String toString() {
        return "UploadAlbumEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", uploadStatus=" + uploadStatus +
                ", resourceType='" + resourceType + '\'' +
                ", userId='" + userId + '\'' +
                ", router='" + router + '\'' +
                ", danceType='" + danceType + '\'' +
                ", address='" + address + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                ", releaseDate=" + releaseDate +
                '}';
    }
}
