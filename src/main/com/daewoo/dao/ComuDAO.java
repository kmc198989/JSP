package main.com.daewoo.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import main.com.daewoo.dao.*;
import main.com.daewoo.dto.ComuVO;
import util.DBManager;
	
public class ComuDAO {
	public ComuDAO() {
	
	}

		private static ComuDAO instance = new ComuDAO();

		public static ComuDAO getInstance() {
			return instance;
		}

		//게시글 리스트 출력 메소드
		public List<ComuVO> selectAllComu() {
			// list 순서도 있고 값도 중복 가능,  컬렉션 종류(list, set, map)
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			String sql = "select * from comu order by c_post_num";
			List<ComuVO> list = new ArrayList<ComuVO>();
			try {
				conn = DBManager.getConnection(); // DB 접속
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					ComuVO cvo = new ComuVO();
					cvo.setUserid(rs.getString("userid"));
					cvo.setC_title(rs.getString("c_title"));
					cvo.setC_post(rs.getString("c_post"));
					cvo.setC_post_num(rs.getInt("c_post_num"));
					cvo.setC_post_date(rs.getString("c_post_date"));
					
					list.add(cvo);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
			return list;
		}

		// 게시글 쓰기 메서드
		public void insertComu(ComuVO cvo) {
			Connection conn = null;
			PreparedStatement pstmt = null;

			String sql = "insert into comu(c_title, c_post, c_post_date, code, userid) values(?,?,?,?,?)";
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				//동적바인딩 값 지정
				pstmt.setString(1, cvo.getC_title());
				pstmt.setString(2, cvo.getC_post());
				pstmt.setString(3, cvo.getC_post_date());
				pstmt.setInt(4, cvo.getCode());
				pstmt.setString(5, cvo.getUserid());
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}
		
		//게시글 수정 메소드
		public ComuVO selectComuByCode(String code) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			ComuVO cvo = null;
			String sql = "select * from comu where c_post_num=?";
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				//System.out.println(code);
				pstmt.setString(1, code);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					cvo = new ComuVO();
					cvo.setC_title(rs.getString("c_title"));
					cvo.setC_post(rs.getString("c_post"));
					cvo.setC_post_num(rs.getInt("c_post_num"));
					cvo.setC_post_date(rs.getString("c_post_date"));
					
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				DBManager.close(conn, pstmt, rs);
			}
			return cvo;
		}
		
		//update 메소드
		public void updateComu(ComuVO cvo) {
			String sql = "update comu set c_title=?, c_post=?, c_post_date=? where c_post_num=?";
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, cvo.getC_title());
				pstmt.setString(2, cvo.getC_post());
				pstmt.setString(3, cvo.getC_post_date());
				pstmt.setInt(4, cvo.getC_post_num());
				
				pstmt.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();		
			}finally {
				DBManager.close(conn, pstmt);
			}
		}
		
		//게시글 삭제 메소드
		public boolean deleteComu(String code) {
			String sql = "delete from comu where c_post_num=?";
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, code);
				int rowsAffected = pstmt.executeUpdate();
				
				return rowsAffected > 0;// 삭제된 행이 하나 이상이면 성공으로 간주
			}catch (Exception e) {
				e.printStackTrace();
				return false;//예외 발생 시 삭제 실패로 간주
			}finally {
				DBManager.close(conn, pstmt);
			}
		}
	}





