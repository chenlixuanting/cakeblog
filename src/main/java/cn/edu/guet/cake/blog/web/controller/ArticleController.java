package cn.edu.guet.cake.blog.web.controller;

import cn.edu.guet.cake.blog.web.constant.Constant;
import cn.edu.guet.cake.blog.web.constant.StatusCode;
import cn.edu.guet.cake.blog.web.custom.CustomLabel;
import cn.edu.guet.cake.blog.web.custom.CustomTopic;
import cn.edu.guet.cake.blog.web.pojo.*;
import cn.edu.guet.cake.blog.web.service.*;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Administrator
 */
@Slf4j
@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private LabelService labelService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private TopicService topicService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private ArticleService articleService;

    /**
     * 通过id获取文章
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getArticle(@PathVariable("id") Integer id, HttpServletRequest request) throws Exception {
        Article article = articleService.getArticleById(id);
        request.setAttribute("article", article);
        return "user/detail";
    }

    /**
     * 发布文章
     *
     * @param article
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public Result addArticle(Article article, HttpSession httpSession) throws Exception {
        Admin admin = (Admin) httpSession.getAttribute(Constant.ADMIN);
        article.setCreatetime(new Date());
        article.setUpdatetime(new Date());
        article.setAuthor(admin.getId());
        articleService.saveArticle(article);
        return Result.successResult(null, "文章发布成功!", StatusCode.OK);
    }

    /**
     * 更新文章
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Result updateArticle(@PathVariable Integer id, Article article) throws Exception {
        Result result = new Result();
        return result;
    }

    /**
     * 删除文章
     *
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result delArticle(@PathVariable Integer id) throws Exception {
        Result result = new Result();
        return result;
    }

    /**
     * 分页获取标签
     *
     * @return
     */
    @RequestMapping(value = "/labels/pages", method = RequestMethod.GET)
    @ResponseBody
    public PageResult getPagesLabels(Params params) throws Exception {
        PageResult pageResult = new PageResult();
        List<CustomLabel> customLabels = new ArrayList<CustomLabel>();
        PageInfo<Label> labelPageInfo = labelService.listLabels(params);
        for (Label label : labelPageInfo.getList()) {
            CustomLabel customLabel = new CustomLabel();
            customLabel.setId(label.getId());
            customLabel.setLabel(label.getLabel());
            Admin admin = adminService.getAdminById(label.getCreator());
            customLabel.setCreatorName(admin.getAccount());
            customLabel.setCreatetime(label.getCreatetime());
            customLabel.setUpdatetime(label.getUpdatetime());
            customLabels.add(customLabel);
        }
        pageResult.setCode(Constant.PAGE_SUCCESS);
        pageResult.setCount(labelPageInfo.getTotal());
        pageResult.setData(customLabels);
        return pageResult;
    }

    /**
     * 通过主键的获取label
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/labels/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result getLabelById(@PathVariable("id") Integer id) throws Exception {
        Label label = labelService.getLabelById(id);
        return Result.successResult(label);
    }

    /**
     * 获取所有labels
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/labels", method = RequestMethod.GET)
    @ResponseBody
    public Result getAllLabels() throws Exception {
        List<Label> labels = labelService.getAllLabels();
        return Result.successResult(labels);
    }

    /**
     * 添加标签
     *
     * @param label
     * @return
     */
    @RequestMapping(value = "/labels", method = RequestMethod.POST)
    @ResponseBody
    public Result addLabel(Label label, HttpSession httpSession) throws Exception {
        Admin admin = (Admin) httpSession.getAttribute(Constant.ADMIN);
        label.setCreator(admin.getId());
        label.setCreatetime(new Date());
        label.setUpdatetime(new Date());
        labelService.saveLabel(label);
        return Result.successResult(null, "添加标签成功!", StatusCode.OK);
    }

    /**
     * 通过主键列删除标签
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/labels/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result delLabel(@PathVariable Integer id) throws Exception {
        return null;
    }

    /**
     * 更新标签
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/labels/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Result updateLabel(@PathVariable Integer id, Label label) throws Exception {
        return null;
    }

    /**
     * 分页获取主题
     *
     * @param params
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/topics/pages", method = RequestMethod.GET)
    @ResponseBody
    public PageResult getTopics(Params params) throws Exception {
        PageResult pageResult = new PageResult();
        List<CustomTopic> customTopics = new ArrayList<CustomTopic>();
        PageInfo<Topic> topicPageInfo = topicService.listTopics(params);
        for (Topic topic : topicPageInfo.getList()) {
            CustomTopic customTopic = new CustomTopic();
            customTopic.setId(topic.getId());
            customTopic.setTopic(topic.getTopic());
            Admin admin = adminService.getAdminById(topic.getCreator());
            customTopic.setCreatorName(admin.getAccount());
            customTopic.setCreatetime(topic.getCreatetime());
            customTopic.setUpdatetime(topic.getUpdatetime());
            customTopics.add(customTopic);
        }
        pageResult.setCode(Constant.PAGE_SUCCESS);
        pageResult.setCount(topicPageInfo.getTotal());
        pageResult.setData(customTopics);
        return pageResult;
    }


    /**
     * 获取所有分类
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/topics", method = RequestMethod.GET)
    @ResponseBody
    public Result getAllTopics() throws Exception {
        List<Topic> topics = topicService.getAllTopics();
        return Result.successResult(topics);
    }

    /**
     * 添加主题
     *
     * @param topic
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/topics", method = RequestMethod.POST)
    @ResponseBody
    public Result addTopic(Topic topic, HttpSession httpSession) throws Exception {
        Admin admin = (Admin) httpSession.getAttribute(Constant.ADMIN);
        topic.setCreator(admin.getId());
        topic.setCreatetime(new Date());
        topic.setUpdatetime(new Date());
        topicService.saveTopic(topic);
        return Result.successResult(null, "添加主题成功!", StatusCode.OK);
    }

    /**
     * 更新主题
     *
     * @param topic
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/topics/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Result updateTopic(@PathVariable Integer id, Topic topic) throws Exception {
        Result result = new Result();
        return result;
    }

    /**
     * 通过主键列删除主题
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/topics/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result delTopic(@PathVariable Integer id) throws Exception {
        Result result = new Result();
        return result;
    }

    /**
     * 分页获取分类
     *
     * @param params
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/types/pages", method = RequestMethod.GET)
    @ResponseBody
    public Result getPagesTypes(Params params) throws Exception {
        Result result = new Result();
        return result;
    }

    /**
     * 通过id获取分类
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/types/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result getTypesById(@PathVariable("id") Integer id) throws Exception {
        Type type = typeService.getTypeById(id);
        return Result.successResult(type);
    }

    /**
     * 获取所有的分类
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/types", method = RequestMethod.GET)
    @ResponseBody
    public Result getAllTypes() throws Exception {
        List<Type> types = typeService.getAllTypes();
        return Result.successResult(types);
    }

    /**
     * 添加分类
     *
     * @param type
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/types", method = RequestMethod.POST)
    @ResponseBody
    public Result addType(Type type, HttpSession httpSession) throws Exception {
        Admin admin = (Admin) httpSession.getAttribute(Constant.ADMIN);
        type.setCreator(admin.getId());
        type.setCreatetime(new Date());
        type.setUpdatetime(new Date());
        typeService.saveType(type);
        return Result.successResult(null, "添加分类成功!", StatusCode.OK);
    }

    /**
     * 通过主键列表删除分类
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/types/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result delType(@PathVariable Integer id) throws Exception {
        Result result = new Result();
        return result;
    }

    /**
     * 更新分类
     *
     * @param type
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/types", method = RequestMethod.PUT)
    @ResponseBody
    public Result updateType(Type type) throws Exception {
        Result result = new Result();
        return result;
    }

}
