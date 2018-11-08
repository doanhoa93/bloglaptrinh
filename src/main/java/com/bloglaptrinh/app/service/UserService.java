package com.bloglaptrinh.app.service;

import com.bloglaptrinh.app.domain.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {

    public User add(User user);

    public User getByEmail(String email);

    public List<User> getUsers(int pageNumber, int pageSize);
}
