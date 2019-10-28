package cn.edu.guet.cake.blog.web.service;

import cn.edu.guet.cake.blog.web.pojo.Label;
import cn.edu.guet.cake.blog.web.pojo.Params;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author Administrator
 */
public interface LabelService {

    /**
     * 获得所有文章标签
     *
     * @param params
     * @return
     * @throws Exception
     */
    PageInfo<Label> listLabels(Params params) throws Exception;

    /**
     * 新增文章标签
     *
     * @param label
     * @throws Exception
     */
    void saveLabel(Label label) throws Exception;

    /**
     * 通过id获取label
     * @param id
     * @return
     * @throws Exception
     */
    Label getLabelById(Integer id) throws Exception;


    /**
     * 获取所有的label
     * @return
     * @throws Exception
     */
    List<Label> getAllLabels()throws Exception;

}
