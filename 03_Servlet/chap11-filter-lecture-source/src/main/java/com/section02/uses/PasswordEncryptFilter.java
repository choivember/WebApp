package com.section02.uses;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

@WebServlet("/member/*")
public class PasswordEncryptFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOExeception, ServletException{
        HttpServletRequest hrequest = (HttpServletRequest) request;
        RequestWrapper wrapper = new RequestWrapper(hrequest);

        chain.doFilter(request, response);
    }

    @Override
    public
}
