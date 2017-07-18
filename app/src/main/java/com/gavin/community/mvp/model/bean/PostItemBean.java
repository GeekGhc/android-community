package com.gavin.community.mvp.model.bean;

/**
 * Created by Administrator on 2017/7/13.
 */

public class PostItemBean {

    private String id;
    private String title;
    private String createdAt;
    private String author;
    private String viewCount;
    private String commentCount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreated_at() {
        return createdAt;
    }

    public void setCreated_at(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getView_count() {
        return viewCount;
    }

    public void setView_count(String viewCount) {
        this.viewCount = viewCount;
    }

    public String getComment_count() {
        return commentCount;
    }

    public void setComment_count(String commentCount) {
        this.commentCount = commentCount;
    }
}
