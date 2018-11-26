package com.bloglaptrinh.app.repository;

import com.bloglaptrinh.app.domain.Post;
import com.bloglaptrinh.app.model.PostSearchRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostRepositoryCustom {

    void lock(long id);

    Page<Post> search(PostSearchRequest request, Pageable pageable);
}
