package cn.edu.guet.cake.blog.web.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 分页数据返回结果实体类
 *
 * @author Administrator
 */
@Data
public class PageResult implements Serializable{

    private static final long serialVersionUID = 5993231543474313388L;

    /**
     * 0--成功
     * 1--失败
     */
    private Integer code;
    private String msg;
    private Long count;
    private Object data;

}