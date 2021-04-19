package com.baizhi.service;

import com.baizhi.entity.User;
import org.springframework.validation.BindingResult;

import javax.validation.Valid;

public interface UserService {
    void register(User user);
    User login(String username, String password);
}
