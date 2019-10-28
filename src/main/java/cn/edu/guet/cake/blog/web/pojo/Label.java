package cn.edu.guet.cake.blog.web.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author Administrator
 */
@Data
public class Label {

    public Integer id;

    public String label;

    public Integer creator;

    public Date createtime;

    public Date updatetime;

}