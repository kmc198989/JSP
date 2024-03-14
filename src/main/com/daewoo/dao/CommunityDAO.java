package main.com.daewoo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import util.DBManager;
import main.com.daewoo.dto.CommunityDTO;

public class CommunityDAO {
    // 게시글 정보를 조회하여 리스트로 반환하는 메서드
    public List<CommunityDTO> getAllPosts(int code) {
        List<CommunityDTO> posts = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        System.out.println("getAllPosts" + code);
        try {
            conn = DBManager.getConnection();
            String query = "SELECT * FROM comu where code = ?";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, code);
            rs = stmt.executeQuery();
            while (rs.next()) {
                CommunityDTO post = new CommunityDTO();
                post.setC_post_num(rs.getInt("C_POST_NUM"));
                post.setC_post(rs.getString("C_POST"));
                post.setC_post_date(rs.getString("C_POST_DATE"));
                post.setC_title(rs.getString("C_TITlE"));
                post.setC_comment(rs.getString("c_comment"));
                post.setC_comment_num(rs.getInt("c_comment_num"));
                post.setC_comment_date(rs.getString("c_comment_date"));
                posts.add(post);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBManager.close(conn, stmt, rs);
        }
        return posts;
    }

    // 특정 게시글에 대한 댓글 수를 반환하는 메서드
    private int getCommentCount(int postNum) {
        int commentCount = 0;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DBManager.getConnection();
            String query = "SELECT COUNT(*) AS count FROM comments WHERE post_num = ?";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, postNum);
            rs = stmt.executeQuery();
            if (rs.next()) {
                commentCount = rs.getInt("count");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBManager.close(conn, stmt, rs);
        }
        return commentCount;
    }
}
