package cn.edu.guet.cake.blog.web.service.impl;

import cn.edu.guet.cake.blog.web.mapper.LabelMapper;
import cn.edu.guet.cake.blog.web.pojo.Label;
import cn.edu.guet.cake.blog.web.pojo.LabelExample;
import cn.edu.guet.cake.blog.web.pojo.Params;
import cn.edu.guet.cake.blog.web.service.LabelService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 */
@Service
public class LabelServiceImpl implements LabelService {

    @Autowired
    private LabelMapper labelMapper;

    /**
     * 获得所有文章标签
     *
     * @return
     */
    @Override
    public PageInfo<Label> listLabels(Params params) throws Exception {
        PageHelper.startPage(params.getPage(), params.getLimit());
        LabelExample labelExample = new LabelExample();
        labelExample.createCriteria().andIdIsNotNull();
        List<Label> labels = labelMapper.selectByExample(labelExample);
        PageInfo<Label> pageInfo = new PageInfo<Label>(labels);
        return pageInfo;
    }

    /**
     * 新增文章标签
     *
     * @param label
     */
    @Override
    public void saveLabel(Label label) throws Exception {
        labelMapper.insert(label);
    }

    /**
     * 通过id获取label
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Label getLabelById(Integer id) throws Exception {
        return labelMapper.selectByPrimaryKey(id);
    }

    /**
     * 获取所有label
     *
     * @return
     * @throws Exception
     */
    @Override
    public List<Label> getAllLabels() throws Exception {
        LabelExample labelExample = new LabelExample();
        labelExample.createCriteria().andIdIsNotNull();
        return labelMapper.selectByExample(labelExample);
    }

}
