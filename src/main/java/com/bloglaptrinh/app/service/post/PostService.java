package com.bloglaptrinh.app.service.post;

import com.bloglaptrinh.app.domain.Post;
import com.bloglaptrinh.app.model.PostSearchRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.IOException;
import java.net.UnknownHostException;

public interface PostService {

    public Post add(Post post) throws IOException;

    public Page<Post> getPosts(PostSearchRequest request, Pageable pageable);
}
