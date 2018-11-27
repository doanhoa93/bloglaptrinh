package bloglaptrinh.com.repository;

import bloglaptrinh.com.domain.Post;
import bloglaptrinh.com.model.PostSearchRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostRepositoryCustom {

    void lock(long id);

    Page<Post> search(PostSearchRequest request, Pageable pageable);
}
