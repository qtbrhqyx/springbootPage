package com.lagou.mapper;

import com.lagou.pojo.Article;

import java.util.List;


public interface ArticleMapper {

    //根据id查询对应的文章
    public Article selectArticle(Integer id);

    public List<Article> selectAllArticle(int limit, int offset);

    public int count();



}
