package main.com.daewoo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.com.daewoo.dao.AskDAO;
import main.com.daewoo.dto.AskVO;
import main.com.daewoo.dto.AskVO;
import main.com.daewoo.dto.MemberDTO;

/**
 * Servlet implementation class inqServlet
 */
@WebServlet("/inquiry.do")
public class inqServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public inqServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 세션에서 사용자 아이디 가져오기
        String userId = (String) request.getSession().getAttribute("id");
        
        // 사용자의 이전 문의 내역 불러오기
        AskDAO adao = AskDAO.getInstance();
        List<AskVO> previousInquiries = adao.getInquiriesByUserId(userId);
        
        // 얻어온 이전 문의 내역을 request에 저장하여 JSP로 전달
        request.setAttribute("previousInquiries", previousInquiries);
        
        // JSP 페이지로 포워딩
        RequestDispatcher rd = request.getRequestDispatcher("inq.jsp");
       rd.forward(request, response);
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 사용자가 입력한 문의 내용 가져오기
    	 request.setCharacterEncoding("UTF-8");
        String title = request.getParameter("a_title");
        String post= request.getParameter("a_post");
        
        // 사용자 ID 가져오기
        HttpSession session = request.getSession();
        MemberDTO mdto = (MemberDTO)session.getAttribute("loginUser");        
        String userId = mdto.getId();
        int code = mdto.getCode();

        
        
        // 사용자가 입력한 내용을 DTO에 저장
        AskVO askDTO = new AskVO();
        askDTO.setA_title(title);
        askDTO.setA_post(post);
        askDTO.setUserid(userId);
        askDTO.setCode(code);
        
        // DAO를 사용하여 문의 내용 업데이트
        AskDAO adao = AskDAO.getInstance();
        adao.addAsk(askDTO);
        
        // 문의 내용이 업데이트되면 다시 문의 페이지로 이동
        response.sendRedirect("mypage.jsp");
    }
}

