package com.tota.datadict.filter;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@Order(2)
@WebFilter(urlPatterns = "/datadict/*", filterName = "LoginFilter")
public class LoginFilter implements Filter {

    private static Logger logger= LoggerFactory.getLogger(LoginFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        if (needLogin(request)) {
            // 需要登录则跳转到登录Controller
            PrintWriter writer=response.getWriter();
            JSONObject json=new JSONObject();
            json.put("errCode","99");
            json.put("errDesc","未登录或登陆过期，请重新登陆");
            writer.write(json.toJSONString());
            logger.info("未登录或登陆过期，请重新登陆");
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }

    private boolean needLogin(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        if (StringUtils.isNotEmpty(username)) {
            return false;
        }
        return true;
    }
}
