package main.com.daewoo.controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.com.daewoo.dao.MemberDAO;
import main.com.daewoo.dto.MemberDTO;

@WebServlet("/modifyUserInfo.do")
public class ModifServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ModifServlet() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();    	
        MemberDAO mdao = MemberDAO.getInstance();
        MemberDTO mdto = new MemberDTO();
        mdto = (MemberDTO) request.getSession().getAttribute("loginUser");
        request.setAttribute("userInfo", mdto);
        RequestDispatcher rd = request.getRequestDispatcher("modif.jsp");
        rd.forward(request, response);    	
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        // 요청 파라미터에서 사용자가 수정한 정보를 가져옵니다.
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");

        // 회원 정보를 업데이트하기 위해 DTO 객체를 생성합니다.
        MemberDTO updatedUserInfo = new MemberDTO();
        updatedUserInfo.setId(id);
        updatedUserInfo.setName(name);
        updatedUserInfo.setPass(password);
        updatedUserInfo.setPhone(phone);

        // 회원 정보 DAO 인스턴스를 생성합니다.
        MemberDAO memberDAO = MemberDAO.getInstance();
        // 사용자 정보를 업데이트하고 결과를 확인합니다.
        boolean isSuccess = memberDAO.updateUserInfo(updatedUserInfo);

        if (isSuccess) {
            // 수정이 성공한 경우, 마이페이지로 리다이렉트합니다.
    		request.getSession().setAttribute("loginUser", updatedUserInfo);   // 세션 업데이트     	
            response.sendRedirect("mypage.jsp");
        } else {
            // 수정에 실패한 경우에 대한 처리를 여기에 추가할 수 있습니다.
            // 예를 들어, 에러 메시지를 표시하거나 다른 페이지로 이동할 수 있습니다.
            // 이 경우, 실패한 이유에 대한 정보를 클라이언트에게 전달해야 합니다.
        }
    }
}
