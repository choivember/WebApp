<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h2>c:url 태그 : 링크 설정 정보를 별도로 지정할 때 사용하는 태그</h2>
<c:url var="fmtLink" value="testJstlCoreResult.jsp">
    <c:param name="num" value="77"></c:param>
</c:url>

<h2>날짜와 시간에 제공되는 포맷 적용</h2>
[default] : <fmt:formatDate value="${ today }" type="both" dateStyle="default" timeStyle="default"/> <br>
[short] : <fmt:formatDate value="${ today }" type="both" dateStyle="short" timeStyle="short"/> <br>
[medium] : <fmt:formatDate value="${ today }" type="both" dateStyle="medium" timeStyle="medium"/> <br>
[long] : <fmt:formatDate value="${ today }" type="both" dateStyle="long" timeStyle="long"/> <br>
[full] : <fmt:formatDate value="${ today }" type="both" dateStyle="full" timeStyle="full"/> <br>



</body>
</html>
