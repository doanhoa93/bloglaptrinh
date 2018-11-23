package com.bloglaptrinh.app.service.tag;

import com.bloglaptrinh.app.domain.Tag;

import java.util.List;

public interface TagService {

    public Tag add(Tag tag);

    public List<Tag> findAll();
}
