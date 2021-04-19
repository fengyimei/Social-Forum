package com.baizhi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

   @GetMapping("/index")
   public String toIndex(){
       return "ems/login.html";
   }
   @GetMapping("/register")
    public String toRegister(){
       return "ems/regist.html";
   }


}
