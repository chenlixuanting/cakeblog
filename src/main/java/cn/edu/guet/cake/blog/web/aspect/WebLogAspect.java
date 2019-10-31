package cn.edu.guet.cake.blog.web.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @author Administrator
 */

@Slf4j
@Aspect
@Component
public class WebLogAspect {

    /**
     * 切面范围:cn.edu.guet.controller包下所有类的所有方法
     */
    @Pointcut("execution(public * cn.edu.guet.cake.blog.web.controller.*.*(..))")
    public void webLog() {
    }

    @Before(value = "webLog()")
    public void doBefore(JoinPoint joinPoint) {
        //接收到请求，记录请求内容,日志记录一般存到redies或者mongoDB，如果日志很大，还会进行云备份至少存储半年
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //记录下请求内容
        log.info("URL:" + request.getRequestURL().toString());
        log.info("HTTP_METHOD:" + request.getMethod());
        log.info("IP:" + request.getRemoteAddr());
        Enumeration<String> enu = request.getParameterNames();
        while (enu.hasMoreElements()) {
            String name = enu.nextElement();
            //如果不使用slf4j直接使用log4j，将不能使用统配符 例如:name:{}
            log.info("name:{},value:{}", name, request.getParameter(name));
        }
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) {
        //处理完成请求，返回内容
        log.info("RESPONSE:" + ret);
    }

}
