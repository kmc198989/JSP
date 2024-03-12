package main.com.daewoo.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.com.daewoo.dto.MemberDTO;
import util.DBManager;



public class MemberDAO {
	private MemberDAO() {
		
	}
	private static MemberDAO instance = new MemberDAO();
	
	public static MemberDAO getInstance() {
		return instance;
	}
	
    public boolean login(String id, String pass) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean isSuccess = false;

        try {
            conn = DBManager.getConnection();
            String sql = "SELECT * FROM member WHERE id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            //pstmt.setString(2, pass);

            rs = pstmt.executeQuery();
            // 결과가 존재하면 로그인 성공으로 처리
            while (rs.next()) {
				if(pass.equals(rs.getString("pass"))) {
					isSuccess = true;
				} else {
					isSuccess = false;
				}
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, rs);
        }

        return isSuccess;
    }
    
    public MemberDTO loadMember(String id) {
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	MemberDTO mdto = new MemberDTO();
    	String sql = "SELECT * FROM member WHERE id = ?";
    	try { 
    		conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
            	mdto.setCode(rs.getInt("code"));
            	mdto.setId(rs.getString("id"));
            	mdto.setPass(rs.getString("pass"));
            	mdto.setName(rs.getString("name"));
            	mdto.setPhone(rs.getString("phone"));
            	mdto.setJoin_date(rs.getString("join_date"));
            }
    	} catch (Exception e) {
    		e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
    	return mdto;
    }
    
    public List<MemberDTO> selectAllMembers(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from member order by code";
		List <MemberDTO> list = new ArrayList<MemberDTO>();
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberDTO vo = new MemberDTO();
				vo.setCode(rs.getInt("code"));
				vo.setId(rs.getString("id"));
				vo.setPass(rs.getString("pass"));
				vo.setName(rs.getString("name"));
				vo.setPhone(rs.getString("phone"));
				vo.setJoin_date(rs.getString("join_date"));
				list.add(vo);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	// 회원 수정 메소드
	public MemberDTO selectMemberbyCode(String code) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberDTO vo = null;
		String sql = "select * from member where code=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo = new MemberDTO();
				vo.setCode(rs.getInt("code"));
				vo.setId(rs.getString("id"));
				vo.setPass(rs.getString("pass"));
				vo.setName(rs.getString("name"));
				vo.setPhone(rs.getString("phone"));
				vo.setJoin_date(rs.getString("join_date"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return vo;
	}
	
	// update 메소드
	public void updateMember(MemberDTO vo) {
	    String sql = "update member set id=?, pass=?, name=?, phone=? where code=?";
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    try {
	        conn = DBManager.getConnection();
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, vo.getId());
	        pstmt.setString(2, vo.getPass());
	        pstmt.setString(3, vo.getName());
	        pstmt.setString(4, vo.getPhone());
	        pstmt.setInt(5, vo.getCode()); // 수정된 부분
	        pstmt.executeUpdate(); // 추가된 부분
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        DBManager.close(conn, pstmt);
	    }
	}
	
    public boolean updateUserInfo(MemberDTO updatedUserInfo) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        boolean isSuccess = false;

        try {
            conn = DBManager.getConnection();
            String sql = "UPDATE member SET name = ?, phone = ?, pass = ? WHERE id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, updatedUserInfo.getName());
            pstmt.setString(2, updatedUserInfo.getPhone());
            pstmt.setString(3, updatedUserInfo.getPass());
            pstmt.setString(4, updatedUserInfo.getId());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                isSuccess = true; // 개인 정보 업데이트가 성공한 경우에만 isSuccess를 true로 설정
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt);
        }

        return isSuccess;
    }
}
