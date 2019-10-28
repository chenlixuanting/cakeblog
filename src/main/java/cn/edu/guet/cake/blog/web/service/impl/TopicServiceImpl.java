package cn.edu.guet.cake.blog.web.service.impl;

import cn.edu.guet.cake.blog.web.mapper.TopicMapper;
import cn.edu.guet.cake.blog.web.pojo.*;
import cn.edu.guet.cake.blog.web.service.TopicService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 */
@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicMapper topicMapper;

    /**
     * 分页获取文章主题
     *
     * @param params
     * @return
     * @throws Exception
     */
    @Override
    public PageInfo<Topic> listTopics(Params params) throws Exception {
        PageHelper.startPage(params.getPage(), params.getLimit());
        TopicExample topicExample = new TopicExample();
        topicExample.createCriteria().andIdIsNotNull();
        List<Topic> topics = topicMapper.selectByExample(topicExample);
        PageInfo<Topic> pageInfo = new PageInfo<Topic>(topics);
        return pageInfo;
    }

    /**
     * 新增文章主题
     *
     * @param topic
     * @throws Exception
     */
    @Override
    public void saveTopic(Topic topic) throws Exception {
        topicMapper.insert(topic);
    }

    /**
     * 获取所有主题
     *
     * @return
     * @throws Exception
     */
    @Override
    public List<Topic> getAllTopics() throws Exception {
        TopicExample topicExample = new TopicExample();
        topicExample.createCriteria().andIdIsNotNull();
        return topicMapper.selectByExample(topicExample);
    }

}
