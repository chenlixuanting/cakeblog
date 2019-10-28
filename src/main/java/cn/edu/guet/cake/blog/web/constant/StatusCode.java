package cn.edu.guet.cake.blog.web.constant;

import java.io.Serializable;
import java.sql.PreparedStatement;

/**
 * 返回结果状态码实体类
 *
 * @author Administrator
 */
public class StatusCode implements Serializable {

    private static final long serialVersionUID = -1495460256379749629L;

    public static final int OK = 200;
    public static final int ERROR = 201;

    /**
     * 用户名或密码错误
     */
    public static final int LOGINERROR = 202;

    /**
     * 权限不足
     */
    public static final int ACCESSERROR = 203;

    /**
     * 远程调用失败
     */
    public static final int REMOTEERROR = 204;

    /**
     * 重复操作
     */
    public static final int REPEERROR = 205;

    /**
     * 服务器内部错误
     */
    public static final int SERVER_INNER_ERROR = 500;

}
