package com.bloglaptrinh.app.elasticsearch.model;

import com.bloglaptrinh.app.domain.*;
import java.time.LocalDateTime;
import java.util.*;

public class PostSearch {

    private long id;

    private String code;

    private String language;

    private String title;

    private Media cover;

    private String body;

    private Seo seo = new Seo();

    private LocalDateTime date;

    private User author;

    private String status;

    private long views;

    private Post drafted;

    private String draftedCode;

    private SortedSet<Category> categories = new TreeSet<>();

    private SortedSet<Tag> tags = new TreeSet<>();

    private SortedSet<CustomFieldValue> customFieldValues = new TreeSet<>();

    private SortedSet<Post> drafts;

    private SortedSet<Comment> comments;

    private Set<Post> relatedToPosts = new HashSet<>();

    private Set<Post> relatedByPosts = new HashSet<>();

    private List<Media> medias;

    public PostSearch() {
    }

    public PostSearch(String title, String language, String status, long views, String createdAt, String updatedAt, String body) {
        this.title = title;
        this.language = language;
        this.status = status;
        this.views = views;
        this.body = body;
    }

    public Long getId() {
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Media getCover() {
        return cover;
    }

    public void setCover(Media cover) {
        this.cover = cover;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Seo getSeo() {
        return seo;
    }

    public void setSeo(Seo seo) {
        this.seo = seo;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getViews() {
        return views;
    }

    public void setViews(long views) {
        this.views = views;
    }

    public SortedSet<Category> getCategories() {
        return categories;
    }

    public void setCategories(SortedSet<Category> categories) {
        this.categories = categories;
    }

    public SortedSet<Tag> getTags() {
        return tags;
    }

    public void setTags(SortedSet<Tag> tags) {
        this.tags = tags;
    }

    public SortedSet<CustomFieldValue> getCustomFieldValues() {
        return customFieldValues;
    }

    public void setCustomFieldValues(SortedSet<CustomFieldValue> customFieldValues) {
        this.customFieldValues = customFieldValues;
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

    public SortedSet<Post> getDrafts() {
        return drafts;
    }

    public void setDrafts(SortedSet<Post> drafts) {
        this.drafts = drafts;
    }

    public SortedSet<Comment> getComments() {
        return comments;
    }

    public void setComments(SortedSet<Comment> comments) {
        this.comments = comments;
    }

    public Set<Post> getRelatedPosts() {
        return getRelatedToPosts();
    }

    public Set<Post> getRelatedToPosts() {
        return relatedToPosts;
    }

    public void setRelatedToPosts(Set<Post> relatedToPosts) {
        this.relatedToPosts = relatedToPosts;
    }

    public Set<Post> getRelatedByPosts() {
        return relatedByPosts;
    }

    public void setRelatedByPosts(Set<Post> relatedByPosts) {
        this.relatedByPosts = relatedByPosts;
    }

    public List<Media> getMedias() {
        return medias;
    }

    public void setMedias(List<Media> medias) {
        this.medias = medias;
    }

}
