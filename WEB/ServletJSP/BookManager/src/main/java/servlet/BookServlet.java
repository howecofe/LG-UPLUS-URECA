package servlet;

import dao.BookDao;
import dto.BookDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

// BookServlet 한 개에서 다양한 처리(crud)를 하기 위해 sub url 방식 사용
// ex) /books/list : 목록
//     /books/detail : 상세
@WebServlet(value = "/books/*")
public class BookServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 기능 구현은 이곳에만
        // http://localhost:8080/BookManager/books/list
//        System.out.println(request.getRequestURI()); // /BookManager/books/list
//        System.out.println(request.getContextPath()); // /BookManager

        String job = request.getRequestURI().substring(request.getContextPath().length());
//        System.out.println(job);

        switch (job) {
            case "/books/list" : list(request, response); break;
            case "/books/detail" : detail(request, response); break;
            case "/books/insert" : insert(request, response); break;
            case "/books/update" : update(request, response); break;
            case "/books/delete" : delete(request, response); break;
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookDao bookDao = new BookDao();
        List<BookDto> bookList = bookDao.listBook();
        request.setAttribute("bookList", bookList);
        request.getRequestDispatcher("/book/list.jsp").forward(request, response);
    }
    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookDao bookDao = new BookDao();
        int bookId = Integer.parseInt(request.getParameter("bookId"));
        BookDto bookDto = bookDao.detailBook(bookId);
        request.setAttribute("bookDto", bookDto);
        request.getRequestDispatcher("/book/detailForm.jsp").forward(request, response);
    }
    private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookDao bookDao = new BookDao();
        // form input 태그의 name 속성
        int bookId = Integer.parseInt(request.getParameter("bookId"));
        String bookName = request.getParameter("bookName");
        String publisher = request.getParameter("publisher");
        int price = Integer.parseInt(request.getParameter("price"));

        BookDto bookDto = new BookDto(bookId, bookName,publisher, price);
        int ret = bookDao.insertBook(bookDto);
        request.getRequestDispatcher("/book/insertResult.jsp").forward(request, response);
    }
    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookDao bookDao = new BookDao();
        // form input 태그의 name 속성
        int bookId = Integer.parseInt(request.getParameter("bookId"));
        String bookName = request.getParameter("bookName");
        String publisher = request.getParameter("publisher");
        int price = Integer.parseInt(request.getParameter("price"));

        BookDto bookDto = new BookDto(bookId, bookName,publisher, price);
        int ret = bookDao.updateBook(bookDto);
        request.getRequestDispatcher("/book/updateResult.jsp").forward(request, response);
    }
    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookDao bookDao = new BookDao();
        int bookId = Integer.parseInt(request.getParameter("bookId"));
        int ret = bookDao.deleteBook(bookId);
        request.getRequestDispatcher("/book/deleteResult.jsp").forward(request, response);
    }

    public void destroy() {
    }
}