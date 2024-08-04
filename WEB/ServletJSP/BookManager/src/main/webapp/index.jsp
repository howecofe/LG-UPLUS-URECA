<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
    <h1>도서 관리 프로그램</h1>
    <div><a href="/BookManager/books/list">도서 목록</a></div> <!-- servlet으로 보내서 서버에서 뷰로 포워딩 -> SSR -->
    <div><a href="/BookManager/ajax/books.jsp">도서 목록(Ajax)</a></div> <!-- jsp로 보내서 뷰에서 ajax 비동기로 서버 api 호출 -> 일부만 변경 -> CSR -->
<%--    <div><a href="">고객 목록</a></div>--%>
</body>
</html>