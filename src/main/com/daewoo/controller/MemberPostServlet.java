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
 * Servlet implementation class memberPostServlet
 */
@WebServlet("/memberPost.do")
public class MemberPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberPostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 사용자의 code를 얻음
        String code = request.getParameter("code");
        String id = request.getParameter("id");
        int memberCode = Integer.parseInt(code);
        System.out.println(code);
        // ComuDAO를 통해 해당 ID에 해당하는 c_post 불러오기
        ComuDAO comuDAO = ComuDAO.getInstance();
        List<ComuVO> comuList = comuDAO.getPostsByCode(memberCode);

        // 가져온 데이터를 request 속성에 설정
        request.setAttribute("comuList", comuList);
        request.setAttribute("id", id);

        // JSP 페이지로 포워딩
        request.getRequestDispatcher("member/memberPost.jsp").forward(request, response);
    }
    




	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
