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
    List<BookDto> bookList = (List<BookDto>) request.getAttribute("bookList");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>도서 목록</h1>
    <table>
        <thead>
            <tr><th>bookId</th><th>bookName</th><th>publisher</th><th>price</th></tr>
        </thead>
        <tbody>
        <%
            for (BookDto book : bookList) {
        %>
        <tr><td><a href="/BookManager/books/detail?bookId=<%= book.getBookId() %>"><%=book.getBookId()%></a></td>
                <td><%=book.getBookName()%></td>
                <td><%=book.getPublisher()%></td>
                <td><%=book.getPrice()%></td></tr>
        <%
            }
        %>
        </tbody>
    </table>
    <hr>
    <a href="/BookManager/book/insertForm.jsp">등록</a>
</body>
</html>