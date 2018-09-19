package com.tota.datadict.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class BaseController {

    protected final Logger LOG = LoggerFactory.getLogger(this.getClass());

    protected HttpServletRequest getHttpServletRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes())
                .getRequest();
        return request;
    }

    protected HttpSession getSession() {
        HttpServletRequest request = getHttpServletRequest();
        return request.getSession();
    }

    protected void setSessionAttribute(String key, Object value) {
        HttpSession httpSession = getSession();
        httpSession.setAttribute(key, value);
    }

    protected Object getSessionAttribute(String key) {
        HttpSession httpSession = getSession();
        return httpSession.getAttribute(key);
    }

}
