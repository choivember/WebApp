package com.section01.session;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class SessionHandlerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTR-8");

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        System.out.println(firstName);
        System.out.println(lastName);

        // response.sendRedirect("redirect");

        HttpSession session = request.getSession();
        System.out.println("session default 유지 시간 : " + session.getMaxInactiveInterval());

        session.setMaxInactiveInterval(60 * 10);
        System.out.println("변경 후 session 유지 시간 : " + session.getMaxInactiveInterval());

        System.out.println("[session id] " + session.getId());
        session.setAttribute("firstName", firstName);

        response.sendRedirect("/redirect");
    }
}
