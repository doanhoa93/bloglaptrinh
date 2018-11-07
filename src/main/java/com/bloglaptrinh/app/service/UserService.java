package com.bloglaptrinh.app.service;

import com.bloglaptrinh.app.model.User;
import org.springframework.data.domain.Page;

public interface UserService {

    public User add(User user);

    public User getByEmail(String email);

    public Page<User> getUsers(int pageNumber, int pageSize);
}
