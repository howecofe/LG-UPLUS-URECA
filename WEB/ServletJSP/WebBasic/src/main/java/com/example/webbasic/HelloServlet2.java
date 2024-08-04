package com.example.webbasic;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/hello2")
public class HelloServlet2 extends HttpServlet { // Tomcat Container 와의 약속

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("Get Request 2");
        response.getWriter().append("<html><body><h1> hello 2 GET </h1></body></html>");
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

    public void destroy() {
    }
}