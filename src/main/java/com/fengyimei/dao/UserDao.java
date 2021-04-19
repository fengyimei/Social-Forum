package com.fengyimei.dao;

import com.fengyimei.entity.User;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

@Service
public interface UserDao {

    public User login(@Param("username")String username,@Param("password")String password);

    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    public void save(User user);
}
