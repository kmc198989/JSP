package main.com.daewoo.controller;

import java.io.File;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.com.daewoo.controller.*;
import main.com.daewoo.dao.ComuDAO;
import main.com.daewoo.dao.MemberDAO;
import main.com.daewoo.dto.*;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class coumListServlet
 */
@WebServlet("/comuList.do")
public class comuListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public comuListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ComuDAO cdao = ComuDAO.getInstance();
		List<ComuVO> comuList = cdao.selectAllComu();
		HttpSession session = request.getSession();

		session.setAttribute("comulist", comuList);
		
		// MemberDAO를 사용하여 memberList 조회
	      MemberDAO memberDAO = MemberDAO.getInstance();

		
		RequestDispatcher rd = request.getRequestDispatcher("main_index.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ServletContext context = getServletContext();
		String path = context.getRealPath("/upload");
		
		 File uploadDir = new File(path);
	        if (!uploadDir.exists()) {
	            uploadDir.mkdirs();
	        }
	        
		String encType = "UTF-8";
		int sizeLimit = 20* 1024 * 1024;
		
		MultipartRequest multi = new MultipartRequest(request, 
				encType, 
				sizeLimit, 
				path,
				new DefaultFileRenamePolicy());
		
		int code = Integer.parseInt(multi.getParameter("code"));
		String c_title = multi.getFilesystemName("c_title");
		String c_post = multi.getParameter("c_post");
		int c_post_num = Integer.parseInt(multi.getParameter("c_post_num"));
		String c_post_date = multi.getParameter("c_post_date");
		
		
		ComuVO cvo = new ComuVO();
		cvo.setCode(code);
		cvo.setC_title(c_title);
		cvo.setC_post(c_post);
		cvo.setC_post_num(c_post_num);
		cvo.setC_post_date(c_post_date);
		
		
		ComuDAO cdao = ComuDAO.getInstance();
		cdao.insertComu(cvo);
		
		response.sendRedirect("comuList.do");
	}

}
