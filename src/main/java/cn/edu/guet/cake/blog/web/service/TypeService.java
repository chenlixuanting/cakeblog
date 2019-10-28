package cn.edu.guet.cake.blog.web.service;

import cn.edu.guet.cake.blog.web.pojo.Type;

import java.util.List;

/**
 * @author Administrator
 */
public interface TypeService {

    Type getTypeById(Integer id) throws Exception;

    List<Type> getAllTypes() throws Exception;

    void saveType(Type type) throws Exception;

}
