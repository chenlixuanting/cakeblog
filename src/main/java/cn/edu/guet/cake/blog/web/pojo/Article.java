package cn.edu.guet.cake.blog.web.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Article {

    private Integer id;

    private Integer label;

    private Integer type;

    private Integer topic;

    private Integer author;

    private String title;

    private String summary;

    private Date createtime;

    private Date updatetime;

    private String content;

    private Integer itemPicture;

}