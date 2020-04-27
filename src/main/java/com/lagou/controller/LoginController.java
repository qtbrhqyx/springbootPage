package com.lagou.controller;

import com.lagou.mapper.ArticleMapper;
import com.lagou.pojo.Article;
import com.lagou.pojo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Calendar;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    private ArticleMapper articleMapper;
    @RequestMapping("/toLoginPage")
    public String toLoginPage(Model model){

        model.addAttribute("currentYear", Calendar.getInstance().get(Calendar.YEAR));
        return "login";
    }

    @RequestMapping("/index")
    public String index(Model model,int pageNo,int pageSize){
        List<Article> articles = articleMapper.selectAllArticle(pageSize,(pageNo-1)*pageSize);
        int count = articleMapper.count();
        PageResult<List<Article>> pageResult = new PageResult();
        pageResult.pageNo=pageNo;
        pageResult.pageSize=pageSize;
        pageResult.count = count;
        pageResult.model = articles;
        model.addAttribute("pageResult",pageResult);
        return "index";
    }


}
