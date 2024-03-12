package main.com.daewoo.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.com.daewoo.dto.MemberDTO;
import util.DBManager;



public class MemberDAO {

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
}
