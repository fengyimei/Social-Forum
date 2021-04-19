package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Attitude {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //主键

    private Integer pid;  //对应帖子的主键

    private String username;  //态度对应的用户

    private String realname;  //用户的真实姓名

    private String thought;  //对应的态度
}
