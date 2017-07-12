package com.practice.ormlite.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by usera on 2017/6/15.
 */
@DatabaseTable(tableName = "tb_article")
public class Article {
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField
    private String title;
    @DatabaseField(canBeNull = false, foreign = true, columnName = "user_id")
    private User user;

    public Article() {
        id = 0;
        title = "";
        user = null;
    }

    public Article(String title, User user) {
        this();
        this.title = title;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", user=" + user +
                '}';
    }
}
