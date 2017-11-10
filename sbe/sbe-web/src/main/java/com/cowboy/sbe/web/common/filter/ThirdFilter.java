package com.cowboy.sbe.web.common.filter;/**
 * Created by Administrator on 2017/11/10/0010.
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Tangynbo
 * @version 1.0
 * @create 2017-11-10 10:36
 **/
@Slf4j
public class ThirdFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        log.info("----------------------filter:ThirdFilter");
        filterChain.doFilter(httpServletRequest,httpServletResponse);
        log.info("----------------------filter:ThirdFilter............................");
    }
}
