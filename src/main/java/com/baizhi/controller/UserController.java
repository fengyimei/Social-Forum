package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@Validated

@RequestMapping("/user")
public class UserController {
      @Autowired
      private UserService userService;

      @PostMapping("/login")
      public String login(String username, String password, RedirectAttributes redirectAttributes, HttpSession httpSession){
          User user=userService.login(username,password);
          if(user!=null){
              String cur_username=user.getUsername();
              String cur_realname=user.getRealname();
              httpSession.setAttribute("username",cur_username);
              httpSession.setAttribute("realname",cur_realname);
              httpSession.removeAttribute("msg2");
              //System.out.println("当前登录用户为:"+cur_username);
              return "redirect:/International";
          }else{
              redirectAttributes.addFlashAttribute("msg","用户名或密码错误");
              return "redirect:/index";
          }
      }

     @PostMapping("/register")
      public String register(@Valid User user, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

          System.out.println(user.getUsername().length());
          System.out.println(bindingResult);
          if (!StringUtils.isEmpty(user.getUsername())) {
              userService.register(user);
              return "redirect:/index";

          }
          //System.out.println(bindingResult.getFieldError().getDefaultMessage());
          redirectAttributes.addFlashAttribute("msg","有信息未填写");
          return "redirect:/register";
      }
}
