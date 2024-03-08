package main.com.daewoo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

import main.com.daewoo.dao.CashBookDAO;
import main.com.daewoo.dto.MyDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/servlet-url")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CashBookDAO cdao = CashBookDAO.getInstance();
		ArrayList<MyDTO> list = new ArrayList<MyDTO>();
		int code = 1;
				// Integer.parseInt(request.getParameter("code"));
		list = cdao.searchJsonList(code);
		Gson gson = new Gson();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        // ArrayList를 JSON 형식으로 변환
        String json = gson.toJson(list);
        System.out.println("searchJsonList");
        // 클라이언트에게 JSON 데이터 전달
        PrintWriter out = response.getWriter();
        out.print(json);
        out.flush();	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
