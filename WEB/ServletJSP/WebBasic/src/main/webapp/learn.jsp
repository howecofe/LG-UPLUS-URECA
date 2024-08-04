<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: greta
  Date: 8/2/24
  Time: 9:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
jsp 구성요소 4가지
    1. directive <%@ : 설정, import
    2. scriptlet <% java code %>
    3. expression <%= 변수 %> : 변수의 값을 html text로 출력
    4. declaration <%! %> : 변수나 메서드 선언

jsp 내장 객체
    1. request : HttpServletRequest request
    2. session : HttpSession

Servlet은 코드 수정 후 .class 파일을 운영 서버에 배포하면 운영 서버를 restart 해야 하지만
JSP는 운영 서버가 변경된 것을 확인하고 새로 Servlet 코드로 변환, 컴파일까지 모두 처리하므로 별도로 운영 서버를 restart할 필요 없다.

JSP는 보여주는 로직을 담당 <- 코드가 복잡하면 안 된다.
복잡한 JSP라면 분할하고 각각에 대해서 Servlet 에서 분기 처리하도록 구성
--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    boolean result = true;

    if (result) {
%>
        <div>True 입니다.</div>
<%
    } else {
%>
        <div>False 입니다.</div>
<%
    }
%>
<%
    List<String> strList = new ArrayList<>();
    strList.add("Java");
%>
<%
    for (String str : strList) {
%>
        <div><span><%=str %></span></div>
<%
    }
%>
</body>
</html>
