package com.bloglaptrinh.app.web.form;

import com.bloglaptrinh.app.domain.Post;

public class PostCreateForm {
    private String title;
    private String language;
    private String status;
    private String views;
    private String createdAt;
    private String updatedAt;
    private String body;

    public enum Status {
        DRAFT, SCHEDULED, PUBLISHED
    }

    public PostCreateForm() {
    }


    public PostCreateForm(String title, String language, String status, String views, String createdAt, String updatedAt, String body) {
        this.title = title;
        this.language = language;
        this.status = status;
        this.views = views;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Post convertToPost(){
        return new Post(this.title, this.language, Post.Status.PUBLISHED, Long.valueOf(this.views), this.createdAt, this.updatedAt, this.body);
    }
}
