<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Session Objecgt Handling</h1>

<form action="session" method="post">
    <table>
        <tr>
            <td>firstName : </td>
            <td><input type="text" name="firstName"</td>
        </tr>
        <tr>
            <td>lastName : </td>
            <td><button type="submit">lastName</button></td>
        </tr>
        <tr>
            <td colspan="2">
                <button type="submit">Send</button>
            </td>
        </tr>
    </table>
</form>

<hr>
<a href="delete">session 데이터 삭제</a>
</body>
</html>