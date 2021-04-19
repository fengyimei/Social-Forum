package com.baizhi.controller;

import com.baizhi.entity.Comment;
import com.baizhi.entity.OurPost;
import com.baizhi.service.CommentService;
import com.baizhi.service.OurPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller

public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private OurPostService ourPostService;

    @GetMapping("/showComments")
    public String showComments(Model model, @RequestParam(value = "postId") Integer postId,HttpSession httpSession){
        model.addAttribute("ourComment",new Comment());
        List<Comment> templist = commentService.showComments(postId);
        OurPost post= ourPostService.findPost(postId);
        httpSession.setAttribute("postId",postId);
        model.addAttribute("post",post);
        model.addAttribute("comments",templist);
        return "ems/comments";
    }

    @PostMapping("/savecomment")
    public String saveComment(Comment comment, HttpSession httpSession){
        Integer postId=(Integer) httpSession.getAttribute("postId");
        comment.setPostId(postId);
        comment.setAuthor((String) httpSession.getAttribute("username"));
        commentService.saveComment(comment);
        return "redirect:/showComments?postId="+String.valueOf(postId);
    }
}
