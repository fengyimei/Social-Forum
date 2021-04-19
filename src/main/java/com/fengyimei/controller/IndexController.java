package com.fengyimei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
