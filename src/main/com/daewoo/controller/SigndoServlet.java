package main.com.daewoo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.com.daewoo.dao.MemberDAO;
import main.com.daewoo.dto.MemberDTO;

/**
 * Servlet implementation class Signdoservlet
 */
@WebServlet("/sign.do")
public class SigndoServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SigndoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      response.getWriter().append("Served at: ").append(request.getContextPath());
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String id = request.getParameter("id");
         String pass = request.getParameter("pass");
         
         MemberDAO memberDAO = new MemberDAO();
         boolean isSuccess = memberDAO.login(id, pass);         
         
         if (isSuccess) {
        	 MemberDTO mdto = memberDAO.loadMember(id);
        	 HttpSession session = request.getSession();
             session.setAttribute("success", "로그인 성공!");
             session.setAttribute("loginUser", mdto); 
             RequestDispatcher rd = request.getRequestDispatcher("main_index.jsp");
             rd.forward(request, response);
         } else {
             request.setAttribute("message", "아이디 또는 비밀번호가 올바르지 않습니다.");
             RequestDispatcher rd = request.getRequestDispatcher("main_index.jsp");
             rd.forward(request, response);
         }
     }

   }
