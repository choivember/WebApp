package com.el.controller;

import com.el.model.dto.MemberDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class TestTwoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MemberDTO member = new MemberDTO("홍길동", 18, "010-1234-5678", "hgd@sahmyook.com");

        request.setAttribute("member", member);

        RequestDispatcher view = request.getRequestDispatcher("views/el/testEl2.jsp");

    }

}
