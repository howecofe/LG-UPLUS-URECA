<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: greta
  Date: 8/1/24
  Time: 3:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%
    List<String> strList = (List<String>) request.getAttribute("strList"); // 내장객체 request
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>String List</h1>
    <%
        for (String str : strList) {
    %>
        <h4><%=str%></h4>
    <%
        }
    %>
</body>
</html>
