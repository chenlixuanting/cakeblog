package cn.edu.guet.cake.blog.web.pojo;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 评论
 *
 * @author Administrator
 */
@Data
public class Comment implements Serializable {

    private static final long serialVersionUID = -6947380793318530364L;

    private String id;
    private String nickname;
    private String email;
    private String website;
    private String content;

    private Timestamp createTime;
    private Timestamp updateTime;

}
