package cn.edu.guet.cake.blog.web.controller;

import cn.edu.guet.cake.blog.web.custom.CustomArticle;
import cn.edu.guet.cake.blog.web.pojo.Article;
import cn.edu.guet.cake.blog.web.service.ArticleService;
import cn.edu.guet.cake.blog.web.service.PictureService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 */
@Controller
public class BlogController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private PictureService pictureService;

    /**
     * 跳转到首页
     *
     * @return
     */
    @RequestMapping({"/", "/index", "/index.html"})
    public String blogIndex(HttpServletRequest request) throws Exception {
        List<Article> articles = articleService.getAllArticles();
        List<CustomArticle> customArticles = new ArrayList<CustomArticle>();
        for (Article article : articles) {
            CustomArticle customArticle = new CustomArticle();
            customArticle.setUpdatetime(article.getUpdatetime());
            customArticle.setTitle(article.getTitle());
            customArticle.setId(article.getId());
            customArticle.setSummary(article.getSummary());
            customArticle.setItemPictureUrl(pictureService.getPictureById(article.getItemPicture()).getLocalpath());
            customArticles.add(customArticle);
        }
        request.setAttribute("articles", JSONObject.toJSON(customArticles));
        return "user/index";
    }

    /**
     * 友情链接
     *
     * @return
     */
    @RequestMapping("/link")
    public String link() {
        return "user/link";
    }

    /**
     * 博文归档
     *
     * @return
     */
    @RequestMapping("/archive")
    public String archive() {
        return "user/archive";
    }

    /**
     * 留言簿
     *
     * @return
     */
    @RequestMapping("/guest-book")
    public String guestBook() {
        return "user/guest-book";
    }

    /**
     * 搜索
     *
     * @return
     */
    @RequestMapping("/search")
    public String search() {
        return "user/search";
    }

    /**
     * 时间轴
     *
     * @return
     */
    @RequestMapping("/update")
    public String timeAxis() {
        return "user/update";
    }

}
