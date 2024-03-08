package main.com.daewoo.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.com.daewoo.dao.CashBookDAO;
import main.com.daewoo.dto.CashBookDTO;
import util.DBManager;

/**
 * Servlet implementation class cashBookServlet
 */
@WebServlet("/cashbook.do")
public class cashBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cashBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("cashBook.jsp");
		rd.forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int code = Integer.parseInt(request.getParameter("code"));
		System.out.println(request.getParameter("code"));
		CashBookDAO cdao = CashBookDAO.getInstance();
		ArrayList<CashBookDTO> al = new ArrayList<CashBookDTO>();
		al = cdao.searchAllList(code);
		request.setAttribute("listall", al);
		RequestDispatcher rd = request.getRequestDispatcher("cashBook.jsp");
		rd.forward(request, response);
	
	}

}
