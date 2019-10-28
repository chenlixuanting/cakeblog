package cn.edu.guet.cake.blog.web.handler;

import cn.edu.guet.cake.blog.web.constant.StatusCode;
import cn.edu.guet.cake.blog.web.pojo.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Administrator
 */
@ControllerAdvice(basePackages = "cn.edu.guet.cake.blog.web.controller")
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result errorResult(Exception e) {
        e.printStackTrace();
        Result result = new Result();
        result.setCode(StatusCode.ERROR);
        result.setFlag(Boolean.FALSE);
        result.setMessage("服务器内部错误!");
        return result;
    }

}
