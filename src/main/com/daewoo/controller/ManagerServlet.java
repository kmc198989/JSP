package main.com.daewoo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/manager.do")
public class ManagerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 필요한 데이터를 가져오는 로직은 여기에 추가

        // JSP 페이지로 데이터 전달
        request.getRequestDispatcher("/memberList.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 필요한 데이터를 가져오는 로직은 여기에 추가

        // JSP 페이지로 데이터 전달
        request.getRequestDispatcher("/askList.jsp").forward(request, response);
    }
}
