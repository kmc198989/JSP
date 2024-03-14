package main.com.daewoo.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import main.com.daewoo.dto.*;

import util.DBManager;

public class AskDAO {
	// 싱글톤 패턴
	private AskDAO() {

	}

	private static AskDAO instance = new AskDAO();

	public static AskDAO getInstance() {
		return instance;
	}

	public List<AskVO> selectAllAsks() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from ask order by a_post_num";
		List<AskVO> list = new ArrayList<AskVO>();
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				AskVO vo = new AskVO();
				vo.setCode(rs.getInt("code"));
				vo.setA_title(rs.getString("a_title"));
				vo.setA_post(rs.getString("a_post"));
				vo.setA_post_num(rs.getInt("a_post_num"));
				vo.setA_check(rs.getString("a_check"));
				vo.setA_post_date(rs.getDate("a_post_date"));
				vo.setA_comment(rs.getString("a_comment"));
				vo.setA_comment_date(rs.getDate("a_comment_date"));
				vo.setUserid(rs.getString("userid"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	// 문의 메서드
	public List<AskVO> selectAskByCode(String code) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<AskVO> askList = new ArrayList<>();
		String sql = "select * from ask where a_post_num=?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				AskVO vo = new AskVO();
				vo.setCode(rs.getInt("code"));
				vo.setA_title(rs.getString("a_title"));
				vo.setA_post(rs.getString("a_post"));
				vo.setA_post_date(rs.getDate("a_post_date"));
				vo.setA_post_num(rs.getInt("a_post_num"));
				vo.setA_comment(rs.getString("a_comment"));
				vo.setA_comment_date(rs.getDate("a_comment_date"));
				vo.setA_comment_num(rs.getInt("a_comment_num"));
				vo.setUserid(rs.getString("userid"));
				
				askList.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return askList;

	}
	
	
	// commentAsk 메서드 추가
	public void commentAsk(AskVO avo) {
	    Connection conn = null;
	    PreparedStatement pstmt = null;

	    String sql = "update ask set a_comment = ?, a_check = ?, a_comment_date = ? where a_post_num = ?";

	    try {
	        conn = DBManager.getConnection();
	        pstmt = conn.prepareStatement(sql);	        
            String now = LocalDate.now().toString();
	        pstmt.setString(1, avo.getA_comment());
	        pstmt.setString(2, "o");
	        pstmt.setString(3, now);
	        pstmt.setInt(4, avo.getA_post_num());
	        pstmt.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        DBManager.close(conn, pstmt);
	    }
	}
	
	public List<AskVO> getCommentsByAskCode(String code) {
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    List<AskVO> commentList = new ArrayList<>();

	    try {
	        conn = DBManager.getConnection();
	        String sql = "select * from ask where code=?";
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, code);
	        rs = pstmt.executeQuery();

	        while (rs.next()) {
	            AskVO vo = new AskVO();
	            vo.setCode(rs.getInt("code"));
				vo.setA_title(rs.getString("a_title"));
				vo.setA_post(rs.getString("a_post"));
				vo.setA_post_date(rs.getDate("a_post_date"));
				vo.setA_post_num(rs.getInt("a_post_num"));
				vo.setA_comment(rs.getString("a_comment"));
				vo.setA_comment_date(rs.getDate("a_comment_date"));
				vo.setA_comment_num(rs.getInt("a_comment_num"));
				vo.setUserid(rs.getString("userid"));
	            commentList.add(vo);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        DBManager.close(conn, pstmt, rs);
	    }

	    return commentList;
	}
	
    public List<AskVO> getAllPosts(int code) {
        List<AskVO> posts = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DBManager.getConnection();
            String query = "SELECT A_POST, A_POST_NUM, A_POST_DATE,A_Title FROM ask where code = ? order by a_post_num desc";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, code);
            rs = stmt.executeQuery();
            while (rs.next()) {
            	AskVO post = new AskVO();
                post.setA_post(rs.getString("A_POST"));
                post.setA_post_num(rs.getInt("A_POST_NUM"));
                post.setA_post_date(rs.getDate("A_POST_DATE"));
                post.setA_title(rs.getString("A_title"));
                posts.add(post);
            }
	    } catch (Exception e) {
	        e.printStackTrace();
        } finally {
            DBManager.close(conn, stmt, rs);
        }
        return posts;
    }
    
    // 댓글 정보를 조회하여 리스트로 반환하는 메서드
    public List<AskVO> getAllComments() {
        List<AskVO> comments = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DBManager.getConnection();
            String query = "SELECT A_COMMENT, A_COMMENT_NUM, A_COMMENT_DATE FROM ask";
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();
            while (rs.next()) {
            	AskVO comment = new AskVO();
                comment.setA_comment(rs.getString("A_COMMENT"));
                comment.setA_comment_num(rs.getInt("A_COMMENT_NUM"));
                comment.setA_comment_date(rs.getDate("A_COMMENT_DATE"));
                comments.add(comment);
            }
	    } catch (Exception e) {
	        e.printStackTrace();
        } finally {
            DBManager.close(conn, stmt, rs);
        }
        return comments;
    }
    public void addAsk(AskVO askDTO) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            conn = DBManager.getConnection();
            String sql = "INSERT INTO ask (A_Title, A_post ,code,userid, a_post_date) VALUES (?,?,?,?,?)";
            String now = LocalDate.now().toString();            
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, askDTO.getA_title());
            pstmt.setString(2, askDTO.getA_post());
            pstmt.setInt(3, askDTO.getCode());
            pstmt.setString(4, askDTO.getUserid());
            pstmt.setString(5, now);
            
            
            
            int result = pstmt.executeUpdate();
            if (result == 1) {
                System.out.println("문의가 성공적으로 추가되었습니다.");
            } else {
                System.out.println("문의 추가에 실패했습니다.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt);
        }
    }

    public List<AskVO> getInquiriesByUserId(String userId) {
        List<AskVO> inquiries = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DBManager.getConnection();
            String query = "SELECT * FROM ask WHERE userid = ? ";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, userId);
            rs = pstmt.executeQuery();
            while (rs.next()) {
            	AskVO inquiry = new AskVO();
                inquiry.setA_post_num(rs.getInt("A_POST_NUM"));
                inquiry.setA_title(rs.getString("A_TITLE"));
                inquiry.setA_post_date(rs.getDate("A_POST_DATE"));
                // 필요한 컬럼 추가
                inquiries.add(inquiry);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, rs);
        }
        return inquiries;
    }
    
    public boolean updateInquiry(AskVO updatedInquiry) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        boolean isSuccess = false;

        try {
            conn = DBManager.getConnection();
            String sql = "UPDATE ask SET POST_NUM =?, A_TITLE = ? WHERE A_POST_DATE = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, updatedInquiry.getA_title());
            pstmt.setString(2, updatedInquiry.getA_comment());
            pstmt.setInt(3, updatedInquiry.getA_post_num());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                isSuccess = true; // 문의 내역 업데이트가 성공한 경우에만 isSuccess를 true로 설정
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt);
        }

        return isSuccess;
    }

}