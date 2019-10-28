package cn.edu.guet.cake.blog.web.service.impl;

import cn.edu.guet.cake.blog.web.mapper.TypeMapper;
import cn.edu.guet.cake.blog.web.pojo.Type;
import cn.edu.guet.cake.blog.web.pojo.TypeExample;
import cn.edu.guet.cake.blog.web.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 */
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeMapper typeMapper;

    @Override
    public Type getTypeById(Integer id) throws Exception {
        return typeMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Type> getAllTypes() throws Exception {
        TypeExample typeExample = new TypeExample();
        typeExample.createCriteria().andIdIsNotNull();
        return typeMapper.selectByExample(typeExample);
    }

    @Override
    public void saveType(Type type) throws Exception {
        typeMapper.insert(type);
    }
}
