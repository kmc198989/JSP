package com.daewoo.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utill.DBManager;


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
            if (rs.next()) {
                isSuccess = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, rs);
        }

        return isSuccess;
    }
}
