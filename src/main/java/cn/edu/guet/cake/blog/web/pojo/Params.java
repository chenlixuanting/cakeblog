package cn.edu.guet.cake.blog.web.pojo;

import lombok.Data;

/**
 * 前台传回的分页参数
 *
 * @author Administrator
 */
@Data
public class Params {

    private Integer page = 0;
    private Integer limit = 10;

}
