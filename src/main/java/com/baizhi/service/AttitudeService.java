package com.baizhi.service;


import com.baizhi.dao.AttitudeDao;
import com.baizhi.entity.Attitude;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AttitudeService {
    @Autowired
    private AttitudeDao attitudeDao;

    public void saveAttitude(Attitude attitude){
        attitudeDao.saveAttitude(attitude);
    }

    public Attitude findAttitude(Integer pid,String username){
        return attitudeDao.findAttitude(pid,username);
    }
}
