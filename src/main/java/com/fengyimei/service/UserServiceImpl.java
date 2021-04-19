package com.fengyimei.service;

import com.fengyimei.dao.UserDao;
import com.fengyimei.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public User login(String username,String password){
        return userDao.login(username,password);
    }

    @Override
    public void register(User user) {
       //user.setId(UUID.randomUUID().toString());
       System.out.println(user);

       userDao.save(user);
    }
}
