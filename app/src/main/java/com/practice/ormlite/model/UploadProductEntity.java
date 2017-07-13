package com.practice.ormlite.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by usera on 2017/7/12.
 */
@DatabaseTable(tableName = UploadProductEntity.TABLE_NAME)
public class UploadProductEntity {
    public static final String TABLE_NAME = "tb_upload_product";
    public static final String FOREIGN_COLUMN_NAME = "upload_album_id";
    @DatabaseField(generatedId = true)
    private int id = 0;
    //作品的大小
    @DatabaseField
    private long totalSize = 0;
    //作品已经上传的大小
    @DatabaseField
    private long uploadedSize = 0;
    //上传时间戳，每次上传一点都刷新一次，用于检测是否上传断流
    @DatabaseField
    private long uploadTimestamp = 0;
    //上传的状态，包括:错误，上传中，上传完成，停止上传，已发布
    @DatabaseField
    private int uploadStatus = 0;
    //上传的作品的类型，包括:视频，图片，广告
    @DatabaseField
    private String resourceType = "";
    @DatabaseField
    private String router = "";
    //可以认为是视频的唯一id，绝对不应该重复
    @DatabaseField
    private String videoName = "";
    //要上传的视频的路径
    @DatabaseField
    private String videoPath = "";
    //要上传的视频的url
    @DatabaseField
    private String videoUrl = "";
    //要上传的图片的路径
    @DatabaseField
    private String imgPath = "";
    //要上传的图片的url
    @DatabaseField
    private String imgUrl = "";
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
    //视频的播放时长
    @DatabaseField
    private long videoTime = 0;
    //作品的发布日期
    @DatabaseField
    private long releaseData = 0;
    //七牛的上传Token
    @DatabaseField
    private String uploadToken = "";
    //当发生错误时,记录错误信息
    @DatabaseField
    private String errorMsg = "";
    //外键关联到专辑表
    @DatabaseField(canBeNull = false, foreign = true, columnName = FOREIGN_COLUMN_NAME, foreignAutoRefresh = true)
    private UploadAlbumEntity uploadAlbumEntity;

    public UploadProductEntity() {
    }


    public int getId() {
        return id;
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

    public int getUploadStatus() {
        return uploadStatus;
    }

    public void setUploadStatus(int uploadStatus) {
        this.uploadStatus = uploadStatus;
    }

    public UploadAlbumEntity getUploadAlbumEntity() {
        return uploadAlbumEntity;
    }

    public void setUploadAlbumEntity(UploadAlbumEntity uploadAlbumEntity) {
        this.uploadAlbumEntity = uploadAlbumEntity;
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

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }


    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
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

    public long getVideoTime() {
        return videoTime;
    }

    public void setVideoTime(long videoTime) {
        this.videoTime = videoTime;
    }

    public long getReleaseData() {
        return releaseData;
    }

    public void setReleaseData(long releaseData) {
        this.releaseData = releaseData;
    }

    public String getUploadToken() {
        return uploadToken;
    }

    public void setUploadToken(String uploadToken) {
        this.uploadToken = uploadToken;
    }

    @Override
    public String toString() {
        return "UploadProductEntity{" +
                "id=" + id +
                ", totalSize=" + totalSize +
                ", uploadedSize=" + uploadedSize +
                ", uploadTimestamp=" + uploadTimestamp +
                ", uploadStatus=" + uploadStatus +
                ", resourceType='" + resourceType + '\'' +
                ", router='" + router + '\'' +
                ", videoName='" + videoName + '\'' +
                ", videoPath='" + videoPath + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", danceType='" + danceType + '\'' +
                ", location='" + location + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                ", videoTime=" + videoTime +
                ", releaseData=" + releaseData +
                ", uploadToken='" + uploadToken + '\'' +
                ", uploadAlbumEntity=" + uploadAlbumEntity +
                '}';
    }
}
