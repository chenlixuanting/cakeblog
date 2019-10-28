package cn.edu.guet.cake.blog.web.service;

import cn.edu.guet.cake.blog.web.pojo.Params;
import cn.edu.guet.cake.blog.web.pojo.Topic;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author Administrator
 */
public interface TopicService {

    /**
     * 分页获取文章主题
     *
     * @param params
     * @return
     * @throws Exception
     */
    PageInfo<Topic> listTopics(Params params) throws Exception;

    /**
     * 新增文章标主题
     *
     * @param topic
     * @throws Exception
     */
    void saveTopic(Topic topic) throws Exception;

    /**
     * 获取所有的主题
     *
     * @return
     * @throws Exception
     */
    List<Topic> getAllTopics() throws Exception;

}
