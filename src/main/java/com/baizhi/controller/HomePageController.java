package com.baizhi.controller;

import com.baizhi.entity.Attitude;
import com.baizhi.entity.ForwardPost;
import com.baizhi.entity.OurPost;
import com.baizhi.service.AttitudeService;
import com.baizhi.service.OurPostService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Controller

public class HomePageController {

    @Autowired
    private OurPostService ourPostService;

    @Autowired
    private AttitudeService attitudeService;

    @GetMapping("/International")
    public String toInternational(Model model1, HttpSession httpSession, Model model3, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        model1.addAttribute("ourPost",new OurPost());
        model1.addAttribute("Attitude",new Attitude());
        PageHelper.startPage(pageNum,8);
        List<OurPost> curPostList=ourPostService.findIntertionalPosts();
        HashMap<String,String>attitude_transform=new HashMap<>();
        attitude_transform.put("like","赞");
        attitude_transform.put("pleasure","开心");
        attitude_transform.put("sorrow","悲伤");
        attitude_transform.put("anger","生气");
        attitude_transform.put("surprise","惊讶");
        for (OurPost ourPost : curPostList) {
            System.out.println(ourPost);
            Integer pid=ourPost.getId();
            String  username= (String) httpSession.getAttribute("username");
            Attitude tempAttitude = attitudeService.findAttitude(pid, username);
            if(tempAttitude!=null){
                ourPost.setHas_selected(attitude_transform.get(tempAttitude.getThought()));
            }
            Integer fid=ourPost.getFid();
            if(fid!=null){
                OurPost curPost = ourPostService.findPost(fid);
                ForwardPost forwardPost = new ForwardPost(curPost.getId(),curPost.getAuthor(),curPost.getContent(),ourPost.getKind());
                ourPost.setForwardPost(forwardPost);
            }
        }
        //model2.addAttribute("postList",curPostList);
        PageInfo<OurPost> pageInfo = new PageInfo<OurPost>(curPostList);
        pageInfo.setPageNum(pageNum);
        model3.addAttribute("pageInfo",pageInfo);
        httpSession.setAttribute("kind","International"); //在session中添加分区信息
        return "ems/emplist.html";
    }

    @GetMapping("/Policy")
    public String toPolicy(Model model1, HttpSession httpSession, Model model3, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        model1.addAttribute("ourPost",new OurPost());
        model1.addAttribute("Attitude",new Attitude());
        PageHelper.startPage(pageNum,8);
        List<OurPost> curPostList=ourPostService.findPolicyPosts();
        HashMap<String,String>attitude_transform=new HashMap<>();
        attitude_transform.put("like","赞");
        attitude_transform.put("pleasure","开心");
        attitude_transform.put("sorrow","悲伤");
        attitude_transform.put("anger","生气");
        attitude_transform.put("surprise","惊讶");
        for (OurPost ourPost : curPostList) {
            Integer pid=ourPost.getId();
            String  username= (String) httpSession.getAttribute("username");
            Attitude tempAttitude = attitudeService.findAttitude(pid, username);
            if(tempAttitude!=null){
                ourPost.setHas_selected(attitude_transform.get(tempAttitude.getThought()));
            }
        }
        //model2.addAttribute("postList",curPostList);
        PageInfo<OurPost> pageInfo = new PageInfo<OurPost>(curPostList);
        pageInfo.setPageNum(pageNum);
        model3.addAttribute("pageInfo",pageInfo);
        httpSession.setAttribute("kind","Policy");

        return "ems/emplist.html";
    }

    @GetMapping("/Society")
    public String toSociety(Model model1, HttpSession httpSession, Model model3, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        model1.addAttribute("ourPost",new OurPost());
        model1.addAttribute("Attitude",new Attitude());
        PageHelper.startPage(pageNum,8);
        List<OurPost> curPostList=ourPostService.findSocietyPosts();
        HashMap<String,String>attitude_transform=new HashMap<>();
        attitude_transform.put("like","赞");
        attitude_transform.put("pleasure","开心");
        attitude_transform.put("sorrow","悲伤");
        attitude_transform.put("anger","生气");
        attitude_transform.put("surprise","惊讶");
        for (OurPost ourPost : curPostList) {
            Integer pid=ourPost.getId();
            String  username= (String) httpSession.getAttribute("username");
            Attitude tempAttitude = attitudeService.findAttitude(pid, username);
            if(tempAttitude!=null){
                ourPost.setHas_selected(attitude_transform.get(tempAttitude.getThought()));
            }
        }
        //model2.addAttribute("postList",curPostList);
        PageInfo<OurPost> pageInfo = new PageInfo<OurPost>(curPostList);
        pageInfo.setPageNum(pageNum);
        model3.addAttribute("pageInfo",pageInfo);

        httpSession.setAttribute("kind","Society");
        return "ems/emplist.html";
    }


//    @GetMapping("/Policy")
//    public String toPolicy(){
//        return "ems/contact.html";
//    }
//
//    @GetMapping("/Society")
//    public String toSociety(){ return "ems/contact.html";}
}
