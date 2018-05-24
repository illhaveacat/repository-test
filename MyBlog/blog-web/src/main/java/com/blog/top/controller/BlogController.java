package com.blog.top.controller;


import com.blog.top.entity.Blog;
import com.blog.top.service.IBlogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("blog")
public class BlogController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlogController.class);

    @Autowired
    IBlogService blogService;

    @RequestMapping(value = "/homePage", method = RequestMethod.GET)
    public void homePage(HttpServletRequest request, HttpServletResponse response) {
        List<Blog> list = blogService.listBlog();
        for (Blog blog : list) {
            LOGGER.info("id=" + blog.getId()+",title=" + blog.getTitle() +
                    ",content=" + blog.getContent() +",createTime=" + blog.getCreateTime() +
                    ",commentNum=" + blog.getCommentNum() +",clickNum=" + blog.getClickNum());
        }
    }

}
