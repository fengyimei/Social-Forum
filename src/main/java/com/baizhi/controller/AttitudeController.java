package com.baizhi.controller;

import com.baizhi.entity.Attitude;
import com.baizhi.service.AttitudeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class AttitudeController {

    @Autowired
    private AttitudeService attitudeService;

    @GetMapping("/saveAttitude")
    public String saveAttitude(@RequestParam(value = "postId") Integer postId,@RequestParam(value="thought") String thought,@RequestParam(value="pageNum") Integer pageNum,HttpSession httpSession){
          Attitude attitude=new Attitude();
          attitude.setPid(postId);
          String username= (String) httpSession.getAttribute("username");
          String realname=(String) httpSession.getAttribute("realname");
          attitude.setUsername(username);
          attitude.setThought(thought);
          attitude.setRealname(realname);
          System.out.println(attitude);
          attitudeService.saveAttitude(attitude);
          //Integer kindn=(Integer)httpSession.getAttribute("kind");
          String kind= (String) httpSession.getAttribute("kind");;
          return "redirect:/"+kind+"?pageNum="+String.valueOf(pageNum);
    }

}
