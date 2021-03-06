package com.fengyimei.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message="用户名不能为空")
    private String username;

    @NotEmpty(message="真实姓名不能为空")
    private String realname;

    @NotEmpty(message ="密码不能为空")
    private String password;

    private String sex;

    private String birth;

    private String city;

    private String ability; //建设能力评估

    private String method;  //提高板块活跃度的方法

    private String interest; //感兴趣话题列表
}
