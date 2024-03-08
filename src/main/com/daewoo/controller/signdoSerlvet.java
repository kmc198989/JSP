package main.com.daewoo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.com.daewoo.dao.MemberDAO;

@WebServlet("/sign.do")
public class signdoSerlvet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public signdoSerlvet() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("username"); // 아이디 파라미터
        String pass = request.getParameter("password"); // 비밀번호 파라미터
        
        MemberDAO memberDAO = new MemberDAO();
        boolean isSuccess = memberDAO.login(id, pass); // DAO를 사용하여 로그인 시도
        
        if (isSuccess) {
            // 로그인 성공 시
            request.setAttribute("name", id); // 세션에 아이디 저장
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
        } else {
            // 로그인 실패 시 
            request.setAttribute("message","아이디 또는 비밀번호가 올바르지 않습니다.");
            RequestDispatcher rd = request.getRequestDispatcher("loginform.jsp");
            rd.forward(request, response);
        }
    }
}
