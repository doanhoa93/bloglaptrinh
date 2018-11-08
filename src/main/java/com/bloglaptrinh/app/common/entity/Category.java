package com.bloglaptrinh.app.common.entity;

import com.bloglaptrinh.app.common.utils.JsonConverter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class Category extends JsonConverter<Category> implements Serializable ,Comparable<Category> {

	private long id;


	private String code;

	private String language;

	private String name;

	private String description;

	private int lft;

	private int rgt;

	private LocalDateTime createdAt = LocalDateTime.now();

	private String createdBy;

    private LocalDateTime updatedAt = LocalDateTime.now();

	private String updatedBy;

	private Category parent;

	private List<Category> children;

	private SortedSet<Post> posts = new TreeSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getLft() {
		return lft;
	}

	public void setLft(int lft) {
		this.lft = lft;
	}

	public int getRgt() {
		return rgt;
	}

	public void setRgt(int rgt) {
		this.rgt = rgt;
	}

	public Category getParent() {
		return parent;
	}

	public void setParent(Category parent) {
		this.parent = parent;
	}

	public List<Category> getChildren() {
		return children;
	}

	public void setChildren(List<Category> children) {
		this.children = children;
	}

	public SortedSet<Post> getPosts() {
		return posts;
	}

	public void setPosts(SortedSet<Post> posts) {
		this.posts = posts;
	}


    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Override
	public String toString() {
		return getName();
	}

	@Override
	public int compareTo(Category category) {
		int lftDiff = getLft() - category.getLft();
		if (lftDiff != 0) {
			return lftDiff;
		}
		return (int) (category.getId() - getId());
	}
}
