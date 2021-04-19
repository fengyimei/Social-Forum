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

public class OurPost {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String  author;
    private String  realname;
    private String content;
    private String has_selected;  //已经选择的态度
    private Integer kind;   //帖子所属分区
    private Integer fid;   //转发原贴对应的id
    private ForwardPost forwardPost; //是否是转发贴

}
