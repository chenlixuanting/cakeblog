package cn.edu.guet.cake.blog.web.service;

import cn.edu.guet.cake.blog.web.pojo.Article;

import java.util.List;

/**
 * @author Administrator
 */
public interface ArticleService {

    void saveArticle(Article article) throws Exception;

    Article getArticleById(Integer id) throws Exception;

    List<Article> getAllArticles() throws Exception;

}
