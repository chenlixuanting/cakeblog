package cn.edu.guet.cake.blog.web.mapper;

import cn.edu.guet.cake.blog.web.pojo.Link;

public interface LinkMapper {

    int insert(Link record);

    Link selectByPrimaryKey(Integer id);

}
