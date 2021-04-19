package com.fengyimei.dao;

import com.fengyimei.entity.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentDao {

    //查找对应id帖子的所有评论
    public List<Comment> showComments(Integer postId);

    //将评论保存
    public void saveComment(Comment comment);
}
