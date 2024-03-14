package main.com.daewoo.controller;

import java.io.IOException;


import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.com.daewoo.dao.*;
import main.com.daewoo.dto.*;

import main.com.daewoo.dao.ComuDAO;
import main.com.daewoo.dto.ComuVO;
import util.DBManager;

/**
 * Servlet implementation class comuDeleteServlet
 */
@WebServlet("/comuDelete.do")
public class ComuDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ComuDeleteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String code = request.getParameter("code");
		ComuDAO cdao = ComuDAO.getInstance();
		boolean success = cdao.deleteComu(code);
	
	if(success) {
		response.sendRedirect("comuList.do");//삭제 성공 시
	}else
	response.setContentType("text/html");
    response.getWriter().println("<script>alert('삭제 실패'); window.location.href='comuList.do';</script>");

		/*ComuVO cvo = cdao.selectComuByCode(code);
		request.setAttribute("comu", cvo);
		RequestDispatcher rd = request.getRequestDispatcher("comu/comuList.jsp");
		rd.forward(request, response);*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	/*String code = request.getParameter("code");
	ComuDAO cdao = ComuDAO.getInstance();*/
		doGet(request, response);
	
		}
}

