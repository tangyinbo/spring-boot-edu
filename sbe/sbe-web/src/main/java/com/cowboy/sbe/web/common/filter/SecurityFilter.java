package com.cowboy.sbe.web.common.filter;/**
 * Created by Administrator on 2017/11/8/0008.
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.util.Enumeration;

/**
 * 前端请求安全拦截器
 *
 * @author Tangynbo
 * @version 1.0
 * @create 2017-11-08 10:25
 **/
@Slf4j
public class SecurityFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String method = httpServletRequest.getMethod();

        Enumeration<String> headNames = httpServletRequest.getHeaderNames();
        while (headNames.hasMoreElements()) {
            String headName = headNames.nextElement();
            log.info("headName:" + headName + "  value:" + httpServletRequest.getHeader(headName));
        }

        InputStream ins = httpServletRequest.getInputStream();
        int len = httpServletRequest.getContentLength();
        if (len > 0) {
            byte[] bytes = new byte[len];
            ins.read(bytes, 0, len);
            log.info("============>" + new String(bytes, "utf-8"));
        }

        log.info("----------------------filter:SecurityFilter");
        filterChain.doFilter(httpServletRequest, httpServletResponse);
        log.info("----------------------filter:SecurityFilter............................");

    }
}
