package com.section02.delete;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Enumeration;

public class DeleteSessionDataServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        Enumeration<String> sessionNames = session.getAttributeNames();
        while (sessionNames.hasMoreElements()){
            System.out.println(sessionNames.nextElement());
        }

        /*
        * < session 데이터 삭제 방법 >
        * 1. 설정한 만료시간이 지나면 자동으로 세션이 만료된다.
        * 2. removeAttribute()로 session의 Attribute를 삭제한다.
        * 3. invalidate()를 호출하면 세션의 모든 데이터가 제거된다.*/

        session.removeAttribute("firstName");
        sessionNames = session.getAttributeNames();
        while(sessionNames.hasMoreElements()){
            System.out.println(sessionNames.nextElement());
        }
    }
}
