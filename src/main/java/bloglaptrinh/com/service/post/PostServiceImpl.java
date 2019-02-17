package bloglaptrinh.com.service.post;

import bloglaptrinh.com.common.exception.CoreException;
import bloglaptrinh.com.domain.Post;
import bloglaptrinh.com.model.PostSearchRequest;
import bloglaptrinh.com.repository.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
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
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public Post add(Post post) {
        if(checkDuplicateCode(post.getCode())){
            throw new CoreException("Duplicate code!", HttpStatus.BAD_REQUEST);
        }
        post = postRepository.save(post);
        return post;
    }

    public boolean checkDuplicateCode(String code){
        return postRepository.findOneByCode(code) == null ? false : true;
    }

    @Override
    public Page<Post> getPosts(PostSearchRequest request, Pageable pageable) {
        Page<Post> page = new PageImpl<>(postRepository.findAll());
        return page;
        //return postRepository.search(request, pageable);
    }

    @Override
    public Post getPostById(Long id) {
        return postRepository.findById(id).get();
    }

    @Override
    public Post getPostByCode(String code) {
        return postRepository.findOneByCode(code);
    }
}
