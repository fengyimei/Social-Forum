package com.baizhi.dao;

import com.baizhi.entity.Attitude;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

@Service
public interface AttitudeDao {

    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    public void saveAttitude(Attitude attitude);

    public Attitude findAttitude(@Param("pid")Integer pid,@Param("username")String username);
}
