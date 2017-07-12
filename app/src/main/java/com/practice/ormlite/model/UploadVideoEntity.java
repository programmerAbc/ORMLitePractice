package com.practice.ormlite.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by usera on 2017/7/12.
 */
@DatabaseTable(tableName = UploadVideoEntity.TABLE_NAME)
public class UploadVideoEntity {
    public static final String TABLE_NAME = "tb_upload_video";
    public static final String FOREIGN_COLUMN_NAME = "upload_album_id";
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField
    private long totalSize;
    @DatabaseField
    private long uploadedSize;
    @DatabaseField
    private long uploadTimestamp;
    @DatabaseField
    private int uploadStatus;
    @DatabaseField(canBeNull = false, foreign = true, columnName = FOREIGN_COLUMN_NAME,foreignAutoRefresh = true)
    private UploadAlbumEntity uploadAlbumEntity;

    public UploadVideoEntity() {
        id = 0;
        totalSize = 0;
        uploadedSize = 0;
        uploadTimestamp = 0;
        uploadStatus = 0;
        uploadAlbumEntity = null;
    }

    public UploadVideoEntity(long totalSize, long uploadedSize, long uploadTimestamp, int uploadStatus, UploadAlbumEntity uploadAlbumEntity) {
        this();
        this.totalSize = totalSize;
        this.uploadedSize = uploadedSize;
        this.uploadTimestamp = uploadTimestamp;
        this.uploadStatus = uploadStatus;
        this.uploadAlbumEntity = uploadAlbumEntity;
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

    @Override
    public String toString() {
        return "UploadVideoEntity{" +
                "id=" + id +
                ", totalSize=" + totalSize +
                ", uploadedSize=" + uploadedSize +
                ", uploadTimestamp=" + uploadTimestamp +
                ", uploadStatus=" + uploadStatus +
                ", uploadAlbumEntity=" + uploadAlbumEntity +
                '}';
    }
}
