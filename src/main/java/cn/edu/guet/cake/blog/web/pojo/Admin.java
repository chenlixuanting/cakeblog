package cn.edu.guet.cake.blog.web.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author Administrator
 */
@Data
public class Admin {

    private Integer id;

    private String account;

    private String password;

    private String username;

    private Integer profile;

    private Date createtime;

    private Date updatetime;

}