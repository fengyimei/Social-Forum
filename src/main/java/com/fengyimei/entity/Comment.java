package com.fengyimei.entity;

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
public class Comment {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String  author;
    private String content;
    private Integer postId;  //所属帖子id
}
