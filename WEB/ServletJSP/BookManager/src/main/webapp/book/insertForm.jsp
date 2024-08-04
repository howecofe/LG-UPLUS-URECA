<%@ page import="dto.BookDto" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: greta
  Date: 8/2/24
  Time: 11:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>도서 등록</h1>
    <form action="/BookManager/books/insert" method="post">
        <input type="text" name="bookId" />
        <input type="text" name="bookName" />
        <input type="text" name="publisher" />
        <input type="text" name="price" />
        <button type="submit">등록</button>
    </form>
</body>
</html>