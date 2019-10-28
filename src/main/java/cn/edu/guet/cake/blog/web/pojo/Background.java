package cn.edu.guet.cake.blog.web.pojo;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author Administrator
 */
@Data
public class Background implements Serializable{

    private static final long serialVersionUID = 2483455001915890961L;

    private Picture header;
    private Picture footer;
    private Boolean status;

    private Timestamp createTime;
    private Timestamp updateTime;

}
