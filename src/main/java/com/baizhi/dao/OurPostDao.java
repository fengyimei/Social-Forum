package com.baizhi.dao;

import com.baizhi.entity.OurPost;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Service;

import java.util.List;

//帖子数据库类
@Service
public interface OurPostDao {

    //保存帖子操作
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    public void savePost(OurPost ourPost);

    //显示所有国际关系板块的帖子
    public List<OurPost> findInternationalPosts();

    //显示所有政策方针板块的帖子
    public List<OurPost> findPolicyPosts();

    //显示所有社会事件板块的帖子
    public List<OurPost> findSocietyPosts();

    //根据id查找帖子内容
    public OurPost findPost(Integer id);
}
