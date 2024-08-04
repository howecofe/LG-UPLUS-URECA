package servlet;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
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
@WebServlet(value = "/books-ajax/*")
public class BookServletAjax extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 기능 구현은 이곳에만
        // http://localhost:8080/BookManager/books/list
//        System.out.println(request.getRequestURI()); // /BookManager/books/list
//        System.out.println(request.getContextPath()); // /BookManager

        String job = request.getRequestURI().substring(request.getContextPath().length());
//        System.out.println(job);

        switch (job) {
            case "/books-ajax/list" : list(request, response); break;
            case "/books-ajax/detail" : detail(request, response); break;
            case "/books-ajax/insert" : insert(request, response); break;
            case "/books-ajax/update" : update(request, response); break;
            case "/books-ajax/delete" : delete(request, response); break;
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json; charset=utf-8");

        BookDao bookDao = new BookDao();
        List<BookDto> bookList = bookDao.listBook();

        Gson gson = new Gson();
        String jsonStr = gson.toJson(bookList);
        System.out.println(jsonStr);

        response.getWriter().write(jsonStr); // 데이터를 resppnse에 추가
    }
    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json; charset=utf-8");

        BookDao bookDao = new BookDao();
        int bookId = Integer.parseInt(request.getParameter("bookId"));
        BookDto bookDto = bookDao.detailBook(bookId);

        Gson gson = new Gson();
        String jsonStr = gson.toJson(bookDto);
        System.out.println(jsonStr);

        response.getWriter().write(jsonStr);
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

        Gson gson = new Gson();
        JsonObject jsonObject = new JsonObject();

        if (ret == 1) { // 성공
            jsonObject.addProperty("result", "success");
        } else { // 실패
            jsonObject.addProperty("result", "fail");
        }

        String jsonStr = gson.toJson(jsonObject);
        System.out.println(jsonStr);
        response.getWriter().write(jsonStr);
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

        Gson gson = new Gson();
        JsonObject jsonObject = new JsonObject();

        if (ret == 1) { // 성공
            jsonObject.addProperty("result", "success");
        } else { // 실패
            jsonObject.addProperty("result", "fail");
        }

        String jsonStr = gson.toJson(jsonObject);
        System.out.println(jsonStr);
        response.getWriter().write(jsonStr);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookDao bookDao = new BookDao();
        int bookId = Integer.parseInt(request.getParameter("bookId"));
        int ret = bookDao.deleteBook(bookId);

        Gson gson = new Gson();
        JsonObject jsonObject = new JsonObject();

        if (ret == 1) { // 성공
            jsonObject.addProperty("result", "success");
        } else { // 실패
            jsonObject.addProperty("result", "fail");
        }

        String jsonStr = gson.toJson(jsonObject);
        response.getWriter().write(jsonStr);
    }

    public void destroy() {
    }
}