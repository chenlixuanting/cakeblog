package cn.edu.guet.cake.blog.web.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author Administrator
 */
@Data
public class Picture {

    private Integer id;

    private String localpath;

    private Date createtime;

    private Date updatetime;

}