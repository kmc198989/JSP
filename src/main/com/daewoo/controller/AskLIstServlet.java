package main.com.daewoo.controller;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.com.daewoo.dao.AskDAO;
import main.com.daewoo.dao.MemberDAO;
import main.com.daewoo.dto.AskVO;
import main.com.daewoo.dto.MemberDTO;


/**
 * Servlet implementation class askLIstServlet
 */
@WebServlet("/askList.do")
public class AskLIstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AskLIstServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    // AskDAO를 사용하여 askList 조회
	    AskDAO askDAO = AskDAO.getInstance();
	    List<AskVO> askList = askDAO.selectAllAsks();
	    request.setAttribute("askList", askList);

	    // MemberDAO를 사용하여 memberList 조회
	    MemberDAO memberDAO = MemberDAO.getInstance();
	    List<MemberDTO> memberList = memberDAO.selectAllMembers();
	    request.setAttribute("memberList", memberList);

	    // askList.jsp로 포워딩
	    RequestDispatcher rd = request.getRequestDispatcher("ask/askList.jsp");
	    rd.forward(request, response);
	}

	



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}