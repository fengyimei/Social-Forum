package com.fengyimei.controller;

import com.fengyimei.entity.OurPost;
import com.fengyimei.service.OurPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller

public class PostController {
    @Autowired
    private OurPostService ourPostService;

    @PostMapping("/savepost")
    public String savePost(HttpServletRequest httpServletRequest, Model model, @Valid @ModelAttribute("ourPost") OurPost ourpost){
        ourPostService.savePost(ourpost,httpServletRequest);
        //Integer kindn=(String)httpServletRequest.getSession().getAttribute("kind");
        String kind=(String)httpServletRequest.getSession().getAttribute("kind");
        return "redirect:/"+kind;
    }

    @GetMapping("/forwardPost")
    public String forwardPost(HttpServletRequest httpServletRequest, @RequestParam(value = "postId")Integer postId) {
        OurPost temppost = ourPostService.findPost(postId);
        OurPost ourPost = new OurPost();
        Integer bid=0;
        if (temppost.getFid() == null) {
            ourPost.setFid(postId);
            bid=postId;
        }
        else {
            ourPost.setFid(temppost.getFid());
            bid=temppost.getFid();
        }
        if(bid!=postId)
            temppost = ourPostService.findPost(bid);
        String fstring = "转发了"+temppost.getAuthor()+"的帖子"+'\n'+temppost.getContent();
        ourPost.setContent(fstring);
        ourPostService.savePost(ourPost, httpServletRequest);
        //ourPost.setForwardPost(forwardPost);
        String kind = (String) httpServletRequest.getSession().getAttribute("kind");
        return "redirect:/" + kind;
    }
}
