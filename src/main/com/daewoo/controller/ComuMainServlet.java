package main.com.daewoo.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import main.com.daewoo.dao.ComuDAO;
import main.com.daewoo.dto.ComuVO;

/**
 * Servlet implementation class comuUpdateServlet
 */
@WebServlet("/comuMain.do")
public class ComuMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComuMainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		ComuDAO cdao = ComuDAO.getInstance();
		ComuVO cvo = cdao.selectComuByCode(code);
		
		request.setAttribute("comu", cvo);
		RequestDispatcher rd = request.getRequestDispatcher("comu/comuMain.jsp");
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
	        
		//System.out.println(path);
		String encType = "UTF-8";
		int sizeLimit = 20 * 1024 * 1024;
		
		MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, encType, new DefaultFileRenamePolicy());
		
		String c_title = multi.getParameter("c_title");
		String c_post = multi.getParameter("c_post");
		int c_post_num = Integer.parseInt(multi.getParameter("c_post_num"));
		String c_post_date_str = multi.getParameter("c_post_date");
        Date c_post_date = Date.valueOf(c_post_date_str);
			
		
		ComuVO cvo = new ComuVO();
		cvo.setC_title(c_title);
		cvo.setC_post(c_post);
		cvo.setC_post_num(c_post_num);
		cvo.setC_post_date(c_post_date);
		
		
		ComuDAO cdao = ComuDAO.getInstance();
		cdao.updateComu(cvo);
		
		response.sendRedirect("comuList.do");
	
	}

}
