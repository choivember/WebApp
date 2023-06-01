package com.section02.uses;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class EncodingFilter extends HttpServlet {

    @Override
    protected void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    protected void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request =
    }
}
