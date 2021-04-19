package com.baizhi.service;

import com.baizhi.dao.CommentDao;
import com.baizhi.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
@Transactional
public class CommentService {

    @Autowired
    private CommentDao commentDao;

    public List<Comment> showComments(Integer postId){
        return commentDao.showComments(postId);
    }

    public void saveComment(Comment comment){
        commentDao.saveComment(comment);
    }
}
