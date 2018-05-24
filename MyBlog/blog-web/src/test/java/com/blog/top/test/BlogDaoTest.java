package com.blog.top.test;

import com.blog.top.dao.BlogDao;
import com.blog.top.entity.Blog;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BlogDaoTest extends BaseTest {

    @Autowired
    private BlogDao blogDao;

    @Test
    public void listBlog() throws Exception {
        List<Blog> list = blogDao.listBlog();
        for (Blog blog : list) {
            System.out.println("id=" + blog.getId() + ",title=" + blog.getTitle() +
                    ",content=" + blog.getContent() + ",createTime=" + blog.getCreateTime() +
                    ",commentNum=" + blog.getCommentNum() + ",clickNum=" + blog.getClickNum());
        }

    }


}