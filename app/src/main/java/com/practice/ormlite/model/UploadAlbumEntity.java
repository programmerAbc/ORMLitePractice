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
    private int id;
    @DatabaseField
    private String title;
    @DatabaseField
    private String description;
    @DatabaseField
    private int uploadStatus;


    public UploadAlbumEntity(String title, String description, int uploadStatus) {
        this();
        this.title = title;
        this.description = description;
        this.uploadStatus = uploadStatus;
    }

    public UploadAlbumEntity() {
        id = 0;
        uploadStatus = 0;
        title = "";
        description = "";
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
                '}';
    }
}
