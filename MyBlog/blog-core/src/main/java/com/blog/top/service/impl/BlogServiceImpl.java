package com.blog.top.service.impl;

import com.blog.top.dao.BlogDao;
import com.blog.top.entity.Blog;
import com.blog.top.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("blogService")
public class BlogServiceImpl implements IBlogService {

    @Autowired
    private BlogDao blogDao;

    @Override
    public List<Blog> listBlog() {
        return blogDao.listBlog();
    }
}
