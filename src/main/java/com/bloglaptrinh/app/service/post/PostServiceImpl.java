package com.bloglaptrinh.app.service.post;

import com.bloglaptrinh.app.common.constant.Constants;
import com.bloglaptrinh.app.domain.Post;
import com.bloglaptrinh.app.elasticsearch.ElasticsearchProvider;
import com.bloglaptrinh.app.elasticsearch.model.PostSearch;
import com.bloglaptrinh.app.model.PostSearchRequest;
import com.bloglaptrinh.app.repository.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service
@Transactional(rollbackFor = Exception.class)
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    private static final Logger logger = LoggerFactory.getLogger(PostServiceImpl.class);

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    @Transactional(readOnly = false)
    public Post add(Post post) throws IOException {
        post = postRepository.save(post);
        if(post.getId() != null){
            //ElasticsearchProvider baseDemo = new ElasticsearchProvider();
            PostSearch postSearch = new PostSearch();
            //baseDemo.create(post, Constants.INDEX.POST);
        }
        return post;
    }

    @Override
    public Page<Post> getPosts(PostSearchRequest request, Pageable pageable) {
        return postRepository.search(request, pageable);
    }
}
