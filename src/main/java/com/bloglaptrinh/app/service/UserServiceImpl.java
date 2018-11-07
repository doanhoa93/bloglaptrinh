package com.bloglaptrinh.app.service;

import com.bloglaptrinh.app.model.User;
import com.bloglaptrinh.app.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional(rollbackFor=Exception.class)
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository= userRepository;
    }

    @Override
    @Transactional(readOnly=false)
    public User add(User user) {
        try {
            return userRepository.save(user);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.findOneByEmail(email);
    }

    @Override
    public Page<User> getUsers(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber - 1, pageSize);
        Specification<User> specification = new Specification<User>() {
            List<Predicate> predicates = new ArrayList<>();
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {

                return cb.and(predicates.toArray(new Predicate[0]));
            }

        };
        return userRepository.findAll(specification, pageRequest);
    }
}