package com.bloglaptrinh.app.common.entity;

import com.bloglaptrinh.app.common.utils.JsonConverter;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Post extends JsonConverter<Post> implements Serializable{

    private long id;

    private String code;

    private String language = "vi";

    private String status;

    private LocalDateTime date;

    private String title;

    private String body;

    private Media cover;

    private User author;

    private Post drafted;

    private String draftedCode;

    private String seoTitle;

    private String seoDescription;

    private String seoKeywords;

    private String imageLink = "https://image.ibb.co/eO8oq8/default_1.png";

    private long views;

    /*private LocalDateTime createdAt = LocalDateTime.now()*/;

    private String createdBy;

    /*private LocalDateTime updatedAt = LocalDateTime.now()*/;

    private String updatedBy;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Media getCover() {
        return cover;
    }

    public void setCover(Media cover) {
        this.cover = cover;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Post getDrafted() {
        return drafted;
    }

    public void setDrafted(Post drafted) {
        this.drafted = drafted;
    }

    public String getDraftedCode() {
        return draftedCode;
    }

    public void setDraftedCode(String draftedCode) {
        this.draftedCode = draftedCode;
    }

    public String getSeoTitle() {
        return seoTitle;
    }

    public void setSeoTitle(String seoTitle) {
        this.seoTitle = seoTitle;
    }

    public String getSeoDescription() {
        return seoDescription;
    }

    public void setSeoDescription(String seoDescription) {
        this.seoDescription = seoDescription;
    }

    public String getSeoKeywords() {
        return seoKeywords;
    }

    public void setSeoKeywords(String seoKeywords) {
        this.seoKeywords = seoKeywords;
    }

    public long getViews() {
        return views;
    }

    public void setViews(long views) {
        this.views = views;
    }

    /*public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }*/

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /*public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }*/

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public Object convertJson(String json){
        Gson gson = new Gson();
        TypeToken<Post> token = new TypeToken<Post>(){};
        Object obj = gson.fromJson(json, token.getType());
        return obj;
    }
}
