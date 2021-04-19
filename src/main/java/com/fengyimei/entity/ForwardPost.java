package com.fengyimei.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class ForwardPost {
    private Integer id;
    private String  author;
    private String content;
    private Integer kind;
}
