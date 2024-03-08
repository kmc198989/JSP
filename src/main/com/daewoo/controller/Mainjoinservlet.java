package main.com.daewoo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.com.daewoo.dao.JoinDAO;
import main.com.daewoo.dto.MemberDTO;

/**
 * Servlet implementation class Mainjoinservlet
 */
@WebServlet("/mainjoin.do")
public class Mainjoinservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Mainjoinservlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("main_join.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String join_date = request.getParameter("join_date");
		
		MemberDTO mdto = new MemberDTO();
		mdto.setId(id);
		mdto.setPass(pass);
		mdto.setName(name);
		mdto.setPhone(phone);
		mdto.setJoin_date(join_date);
		
		JoinDAO jdao = JoinDAO.getInstance();
		int result = jdao.insertMember(mdto);
		
		HttpSession session = request.getSession();
		if(result == 1) {
			session.setAttribute("id", mdto.getId());
			request.setAttribute("message", "회원가입에 성공 하였습니다.");
			
		}else {
			request.setAttribute("message", "회원가입에 실패하였습니다.");
		}
		RequestDispatcher rd = request.getRequestDispatcher("main_index.jsp");
		rd.forward(request, response);
	}

}
