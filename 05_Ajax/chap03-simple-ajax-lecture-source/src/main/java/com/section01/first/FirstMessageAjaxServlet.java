package com.section01.first;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/first/message")
public class FirstMessageAjaxServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = request.getParameter("message");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.print("message GET!" + message);
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = request.getParameter("message");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.print("message POST!" + message);
        out.flush();
        out.close();
    }
}
