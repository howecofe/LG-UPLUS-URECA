package com.example.webbasic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/mvc")
public class MVCServlet extends HttpServlet { // Tomcat Container 와의 약속

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String job = request.getParameter("job");
        // switch()
        // job 목록
        List<String> strList = getList(); // model

        // request에 model을 담는다.
        request.setAttribute("strList", strList);

        // forwarding
        request.getRequestDispatcher("mvc.jsp").forward(request, response);

    }

    private List<String> getList() {
        List<String> strList = List.of("Java", "Servlet", "JSP");
        return strList;
    }
}