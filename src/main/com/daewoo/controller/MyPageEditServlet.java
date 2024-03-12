package main.com.daewoo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.com.daewoo.dao.MemberDAO;
import main.com.daewoo.dto.MemberDTO;

/**
 * Servlet implementation class MyPageEditServlet
 */
@WebServlet("/mypageEdit.do")
public class MyPageEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageEditServlet() {
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
		request.setCharacterEncoding("utf-8");
		System.out.println("Gggg");
		String id = request.getParameter("id");
		String pass =request.getParameter("pass");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		int code = Integer.parseInt(request.getParameter("code"));		
		MemberDAO mdao = MemberDAO.getInstance();
		MemberDTO mdto = new MemberDTO();
		mdto.setId(id);
		mdto.setPass(pass);
		mdto.setName(name);
		mdto.setPhone(phone);
		mdto.setCode(code);		
		mdao.updateMember(mdto);
		request.getSession().setAttribute("loginUser", mdto);
		response.sendRedirect("main_index.jsp");
	}

}
