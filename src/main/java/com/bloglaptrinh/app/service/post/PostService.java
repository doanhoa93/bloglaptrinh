package com.bloglaptrinh.app.service.post;

import com.bloglaptrinh.app.domain.Post;

import java.io.IOException;
import java.net.UnknownHostException;

public interface PostService {

    public Post add(Post post) throws IOException;
}
