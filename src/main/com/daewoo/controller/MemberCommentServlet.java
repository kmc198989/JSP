package main.com.daewoo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.com.daewoo.dao.ComuDAO;
import main.com.daewoo.dto.ComuVO;


/**
 * Servlet implementation class memberCommentServlet
 */
@WebServlet("/memberComment.do")
public class MemberCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");        
        int memberCode = Integer.parseInt(code);
        String id = request.getParameter("id");
        
        // ComuDAO 인스턴스 생성
        ComuDAO comuDAO = ComuDAO.getInstance();
        
        // 회원 code를 기반으로 해당 회원이 작성한 댓글 목록을 가져오는 메서드 호출
        List<ComuVO> comuList = comuDAO.getCommentsByCode(memberCode);
        
        // comuList를 이용하여 필요한 작업 수행
        
        request.setAttribute("comuList", comuList);
        request.setAttribute("id", id);        
        request.getRequestDispatcher("member/memberComment.jsp").forward(request, response);
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
