<%@ page import="dto.BookDto" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: greta
  Date: 8/2/24
  Time: 11:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    BookDto bookDto = (BookDto) request.getAttribute("bookDto");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>도서 수정</h1>
    <form action="/BookManager/books/update">
        <input type="text" name="bookId" value="<%= bookDto.getBookId() %>" />
        <input type="text" name="bookName" value="<%= bookDto.getBookName() %>" />
        <input type="text" name="publisher" value="<%= bookDto.getPublisher() %>" />
        <input type="text" name="price" value="<%= bookDto.getPrice() %>" />
        <button type="submit">수정</button>
    </form>
    <hr>
    <a href="/BookManager/books/delete?bookId=<%= bookDto.getBookId() %>">삭제</a>
</body>
</html>