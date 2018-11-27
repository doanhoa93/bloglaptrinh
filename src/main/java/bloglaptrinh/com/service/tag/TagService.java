package bloglaptrinh.com.service.tag;

import bloglaptrinh.com.domain.Tag;

import java.util.List;

public interface TagService {

    public Tag add(Tag tag);

    public List<Tag> findAll();
}
