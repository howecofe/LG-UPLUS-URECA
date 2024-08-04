package com.example.webbasic;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/html")
public class HTMLServlet extends HttpServlet { // Tomcat Container 와의 약속

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=utf-8");

        response.getWriter().append("<html>");
        response.getWriter().append("<head>");
        response.getWriter().append("</head>");
        response.getWriter().append("<body>");
        response.getWriter().append("<h1>이게 뭐하는 짓이냐</h1>");
        // 많은 html code가 java code 안에....
        response.getWriter().append("</body>");
        response.getWriter().append("</html>");

    }
}

// java 코드 안에 html code 넣는 것의 어려움 때문에 나온 것이 Jsp.
// model을 Servlet(controller)이 받아 jsp(view)로 forwarding => mvc