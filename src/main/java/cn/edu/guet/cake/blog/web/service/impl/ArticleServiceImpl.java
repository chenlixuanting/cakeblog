package cn.edu.guet.cake.blog.web.service.impl;

import cn.edu.guet.cake.blog.web.mapper.ArticleMapper;
import cn.edu.guet.cake.blog.web.pojo.Article;
import cn.edu.guet.cake.blog.web.pojo.ArticleExample;
import cn.edu.guet.cake.blog.web.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public void saveArticle(Article article) throws Exception {
        articleMapper.insert(article);
    }

    @Override
    public Article getArticleById(Integer id) throws Exception {
        return articleMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Article> getAllArticles() throws Exception {
        ArticleExample articleExample = new ArticleExample();
        articleExample.createCriteria().andIdIsNotNull();
        return articleMapper.selectByExample(articleExample);
    }
}
