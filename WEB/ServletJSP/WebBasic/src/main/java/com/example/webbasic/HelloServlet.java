package com.example.webbasic;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

//@WebServlet(name = "HelloServlet", value = "/HelloServlet")
@WebServlet("/hello")
public class HelloServlet extends HttpServlet { // Tomcat Container 와의 약속

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("Get Request");

        // 사용자가 get 파라미터 username=홍길동
        String username = request.getParameter("username");
        System.out.println("username: " + username);

        String address = request.getParameter("address");
        System.out.println("address: " + address);

        response.setContentType("text/html; charset=utf-8"); // 인코딩
        response.getWriter().append(
                "<html><body><h1> hello, " + username + "! 당신의 주소는 " + address + " </h1></body></html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 사용자가 get 파라미터 username=홍길동
        String username = request.getParameter("username");
        System.out.println("username: " + username);

        String address = request.getParameter("address");
        System.out.println("address: " + address);

        response.setContentType("text/html; charset=utf-8"); // 인코딩
        response.getWriter().append(
                "<html><body><h1> hello, " + username + "! 당신의 주소는 " + address + " </h1></body></html>");
    }

    public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("Put Request");
    }

    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("Delete Request");
    }

    public void destroy() {
    }
}