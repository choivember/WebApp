<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1><%= request.getAttribute("name") %>님 환영합니다!</h1>

<h2>jsp:useBean 활용</h2>
<jsp:useBean id="member" class="com.el.model.dto.MemberDTO" scope="page"/>
<jsp:setProperty name="member" property="name" value="홍길동"/>
</body>
</html>
