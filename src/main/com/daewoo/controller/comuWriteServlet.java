package main.com.daewoo.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.com.daewoo.dao.*;
import main.com.daewoo.dto.*;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import main.com.daewoo.dao.ComuDAO;
import main.com.daewoo.dto.ComuVO;

/**
 * Servlet implementation class comuWriteServlet
 */
@WebServlet("/comuWrite.do")
public class comuWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public comuWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 RequestDispatcher rd = request.getRequestDispatcher("comu/comuWrite.jsp");
	      rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");
	      ServletContext context = getServletContext();
	      String path = context.getRealPath("/upload");
	      System.out.println("11");
	      File uploadDir = new File(path);
	        if (!uploadDir.exists()) {
	            uploadDir.mkdirs();
	        }
	        
	      String encType = "UTF-8";
	      int sizeLimit = 20 * 1024 * 1024;
	      
	      MultipartRequest multi = new MultipartRequest(
	            request, 
	            path,
	            sizeLimit,
	            encType,
	            new DefaultFileRenamePolicy()
	            );
	      int code = 1;
	      String c_title = multi.getParameter("c_title");
	      String c_post = multi.getParameter("c_post");
	      String c_post_date = multi.getParameter("c_post_date");
	      
	      
	      ComuVO cvo = new ComuVO();
	      cvo.setC_title(c_title);
	      cvo.setC_post(c_post);
	      cvo.setC_post_date(c_post_date);
	      cvo.setCode(code);
	     
	      
	      ComuDAO cdao = ComuDAO.getInstance();
	      cdao.insertComu(cvo);
		 
	      
	      response.sendRedirect("comuList.do");
	      
	}

}
