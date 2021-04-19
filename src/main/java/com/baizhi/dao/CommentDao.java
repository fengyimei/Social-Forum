package com.baizhi.dao;

import com.baizhi.entity.Comment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
public interface CommentDao {

    //查找对应id帖子的所有评论
    public List<Comment> showComments(Integer postId);

    //将评论保存
    public void saveComment(Comment comment);
}
