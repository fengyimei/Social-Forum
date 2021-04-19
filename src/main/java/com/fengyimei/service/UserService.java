package com.fengyimei.service;

import com.fengyimei.entity.User;

public interface UserService {
    void register(User user);
    User login(String username, String password);
}
