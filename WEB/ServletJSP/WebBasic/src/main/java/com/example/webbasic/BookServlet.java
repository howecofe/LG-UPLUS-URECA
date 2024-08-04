package com.example.webbasic;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

// 이 서블릿 하나가 도서 관리에 필요한 등록, 수정, 삭제, 목록, 상세 5가지 기능 => servlet: get, post, put, delete 4가지
// 서블릿 url 1개 (/books) 에 여러 개의 작업을 수행하는 데 불편
// 1. 작업(업무) 구분 파라미터
//      client 는 항상 파라미터로 작업(구분)을 보낸다.
//      servlet 은 그 파라미터로 작업 구분 처리
// 2. 작업(업무) 구분 sub url
//      /books/list
//      /books/detail
//      /books/insert ...
//      @WebServlet("/books/*")

@WebServlet("/books")
//@WebServlet("/books/*")
public class BookServlet extends HttpServlet { // Tomcat Container 와의 약속
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println(request.getRequestURI()); // 넘어오는 url 값을 읽어서 구분처리

//        String job = request.getParameter("job");
//        switch (job) {
//            case "list": list(); break;
//            case "detail": detail(); break;
//            case "insert": insert(); break;
//            case "update": update(); break;
//            case "delete": delete(); break;
//        }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("Post Request 2");
        response.getWriter().append("<html><body><h1> hello 2 POST </h1></body></html>");
    }

    public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("Put Request 2");
    }

    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("Delete Request 2");
    }

    private void list() {
        System.out.println("list");
    }

    private void detail() {
        System.out.println("detail");
    }

    private void insert() {
        System.out.println("insert");
    }

    private void update() {
        System.out.println("update");
    }

    private void delete() {
        System.out.println("delete");
    }
}