package main.com.daewoo.controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.com.daewoo.dao.MemberDAO;
import main.com.daewoo.dto.MemberDTO;

/**
 * Servlet implementation class memberUpdateServlet
 */
@WebServlet("/memberUpdate.do")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		MemberDAO mdao = MemberDAO.getInstance();
		MemberDTO mvo = mdao.selectMemberbyCode(code);
		
		RequestDispatcher rd = request.getRequestDispatcher("member/memberUpdate.jsp");
		request.setAttribute("member", mvo);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8");

	    // 나머지 코드는 그대로 유지
	    String code = request.getParameter("code");
	    String id = request.getParameter("id");
	    String pass = request.getParameter("pass");
	    String name = request.getParameter("name");
	    String phone = request.getParameter("phone");

	    MemberDTO mvo = new MemberDTO();
	    mvo.setCode(Integer.parseInt(code));
	    mvo.setId(id);
	    mvo.setPass(pass);
	    mvo.setName(name);
	    mvo.setPhone(phone);

	    MemberDAO mdao = MemberDAO.getInstance();
	    mdao.updateMember(mvo);
	    response.sendRedirect("memberList.do");
	}



}
