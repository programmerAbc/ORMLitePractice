package com.practice.ormlite.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.List;

/**
 * Created by usera on 2017/7/12.
 */
@DatabaseTable(tableName = UploadSetEntity.TABLE_NAME)
public class UploadSetEntity {
    public static final String TABLE_NAME = "tb_upload_set";
    @DatabaseField(generatedId = true)
    private int id = 0;

    //标题
    @DatabaseField
    private String title = "";

    //描述
    @DatabaseField
    private String description = "";

    //上传的控制选项包括:编辑,上传,停止
    @DatabaseField
    private int controlOption = 0;

    //标记是发布状态包括:已发布和未发布
    @DatabaseField
    private int publishStatus = 0;

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

    //标签
    @DatabaseField
    private List<String> tag;

    //地址
    @DatabaseField
    private String showAddress = "";

    //维度
    @DatabaseField
    private double lat = 0;

    //经度
    @DatabaseField
    private double lng = 0;

    //时间
    @DatabaseField
    private long releaseDate;


    public UploadSetEntity() {
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

    public int getControlOption() {
        return controlOption;
    }

    public void setControlOption(int controlOption) {
        this.controlOption = controlOption;
    }

    public int getPublishStatus() {
        return publishStatus;
    }

    public void setPublishStatus(int publishStatus) {
        this.publishStatus = publishStatus;
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

    public List<String> getTag() {
        return tag;
    }

    public void setTag(List<String> tag) {
        this.tag = tag;
    }

    public String getShowAddress() {
        return showAddress;
    }

    public void setShowAddress(String showAddress) {
        this.showAddress = showAddress;
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
}
