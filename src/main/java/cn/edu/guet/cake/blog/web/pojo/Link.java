package cn.edu.guet.cake.blog.web.pojo;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 友情链接
 *
 * @author Administrator
 */
@Data
public class Link implements Serializable {

    private static final long serialVersionUID = -3815608986900383268L;

    private String id;
    private String url;
    private Picture photo;
    private Admin creator;

    private Timestamp createTime;
    private Timestamp updateTime;

}
