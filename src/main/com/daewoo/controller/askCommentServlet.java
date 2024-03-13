package main.com.daewoo.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.com.daewoo.dao.AskDAO;
import main.com.daewoo.dto.AskVO;

/**
 * Servlet implementation class askCommentServlet
 */
@WebServlet("/askComment.do")
public class askCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public askCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String a_post_num = request.getParameter("a_post_num");
        AskDAO adao = AskDAO.getInstance();
        
        // AskDAO의 selectAskByCode 메서드를 호출하여 AskVO 리스트를 받아옴
        List<AskVO> askList = adao.selectAskByCode(a_post_num);

        // askList가 비어있지 않다면, 첫 번째 AskVO 객체를 가져와서 사용
        AskVO avo = askList.isEmpty() ? null : askList.get(0);

        // 답변 내용을 가져와서 request에 추가
        List<AskVO> commentList = adao.getCommentsByAskCode(a_post_num);
        request.setAttribute("ask", avo);
        request.setAttribute("commentList", commentList);

        // JSP 페이지로 포워딩
        RequestDispatcher rd = request.getRequestDispatcher("ask/askComment.jsp");
        rd.forward(request, response);
    }




	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        // 폼에서 전송된 파라미터 받아오기
        int code = Integer.parseInt(request.getParameter("code"));
        String a_title = request.getParameter("a_title");
        String a_post = request.getParameter("a_post");
        int a_post_num = Integer.parseInt(request.getParameter("a_post_num"));
        String a_comment = request.getParameter("a_comment");
        int a_comment_num = Integer.parseInt(request.getParameter("a_comment_num"));
        String a_check = request.getParameter("a_check");
        String a_post_date = request.getParameter("a_post_date");
        String a_comment_date = request.getParameter("a_comment_date");

        // AskVO 객체 생성 및 값 설정
        AskVO avo = new AskVO();
        avo.setCode(code);
        avo.setA_title(a_title);
        avo.setA_post(a_post);
        avo.setA_post_num(a_post_num);
        avo.setA_comment(a_comment);
        avo.setA_comment_num(a_comment_num);
        avo.setA_check(a_check);

        // SimpleDateFormat을 사용하여 문자열을 날짜로 변환
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date postDate = dateFormat.parse(a_post_date);
            Date commentDate = dateFormat.parse(a_comment_date);
            avo.setA_post_date(postDate);
            avo.setA_comment_date(commentDate);
        } catch (ParseException e) {
            e.printStackTrace();
            // 날짜 형식이 잘못된 경우에 대한 예외 처리
        }

        // AskDAO의 commentAsk 메서드 호출
        AskDAO adao = AskDAO.getInstance();
        adao.commentAsk(avo);

        // 리다이렉트
        response.sendRedirect("askList.do");
    }



}
