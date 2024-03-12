package main.com.daewoo.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.com.daewoo.dao.CashBookDAO;
import main.com.daewoo.dto.CashBookDTO;
import main.com.daewoo.dto.MemberDTO;
import main.com.daewoo.dto.MyDTO;

/**
 * Servlet implementation class cashListAddServlet
 */
@WebServlet("/cashListAdd.do")
public class cashListAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cashListAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		CashBookDTO cdto = new CashBookDTO();
		ArrayList<MyDTO> list = new ArrayList<MyDTO>();

		HttpSession session = request.getSession();
	    MemberDTO loginUser = (MemberDTO) session.getAttribute("loginUser");
	    
		System.out.println("Received code: " + loginUser.getCode());
		int code = loginUser.getCode();
		String in_out = request.getParameter("in_out");
		String in_date = request.getParameter("in_date");
		int amount = Integer.parseInt(request.getParameter("amount"));
		String content = request.getParameter("content");
		String payment = request.getParameter("payment");
		CashBookDAO cdao = CashBookDAO.getInstance();
		cdto.setCode(code);
		cdto.setIn_out(in_out);
		cdto.setIn_date(in_date);
		cdto.setAmount(amount);
		cdto.setContent(content);
		cdto.setPayment(payment);
		int result = 0;
		result = cdao.ListAdd(cdto);
		
		if (result == 1) {
			request.setAttribute("message", "등록되었습니다.");
			ArrayList<CashBookDTO> al = new ArrayList<CashBookDTO>();
			al = cdao.searchAllList(code);
			request.getSession().setAttribute("al", al);
		} else {
			request.setAttribute("message", "Error");
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("main_index.jsp");
		rd.forward(request, response);
	}

}
