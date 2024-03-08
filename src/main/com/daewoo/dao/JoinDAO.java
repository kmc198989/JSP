
package com.daewoo.dao;
//회원 가입 DAO

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.daewoo.dto.MemberDTO;


public class JoinDAO {
	private JoinDAO() {
		
	}
	public static JoinDAO instance = new JoinDAO();
	
	public static JoinDAO getInstance() {
		return instance;
	}
	
	public Connection getConnection() throws Exception{
		Connection conn = null;
		Context init = new InitialContext();
		Context envContext =(Context)init.lookup("java:/comp/env");
		DataSource ds =(DataSource)envContext.lookup("jdbc/money");
		conn = ds.getConnection();
		return conn;
	}
	
	//사용자 인증 하는 메소드
	public int userCheck(String id, String pass) {
		int result = 1;
		String sql ="select pass from member where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("pass")!=null && 
						rs.getString("pass").equals(pass)) {
					        result = 1; //아이디와 패스워드 일치
				}
				else {
					result = 0; //아이디는 일치하지만 패스워드가 불일치 할때
				}
			}else {
				result = -1; //아이디가 존재하지 않을때
			}
			
		}catch (Exception e) {
		     e.printStackTrace();
		}finally {
			try {
				if(rs != null)
					rs.close();
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close();
			}catch (Exception e) {
				
			}
		}
		return result;
	}
	//아이디로 회원 정보 가져오는 메소드
	
	public MemberDTO getMember(String id) {
		MemberDTO mdto =null;
		String sql= "select * from member where id =?";
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		try{
			conn = getConnection(); //DBCP 에 접속
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				mdto = new MemberDTO();
				mdto.setCode(rs.getInt("code"));
				mdto.setId(rs.getString("id"));
				mdto.setPass(rs.getString("pass"));
				mdto.setName(rs.getString("name"));
				mdto.setPhone(rs.getString("phone"));
				mdto.setJoin_date(rs.getString("join_date"));
				
				
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try{
				if(rs != null)
				rs.close();
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close();
			}catch (Exception e) {
				
			}
				
			
		}
		return mdto;
	}
	
	public int confirmID(String id) {
		int result = 1;
		String sql = "select id from member where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				result = 1; //존재하는 아이디가 있음
			}else {
				result = -1; //사용 가능한 아이디
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null)
					rs.close();
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close();
			}catch (Exception e) {
				
			}
		}
		return result;
	}
	
	public int insertMember(MemberDTO mdto) {
		int result = -1;
		String sql ="insert into member name(id,pass,name,phone,join_date) values(?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mdto.getId());
			pstmt.setString(2, mdto.getPass());
			pstmt.setString(3, mdto.getName());
			pstmt.setString(4, mdto.getPhone());
			pstmt.setString(5, mdto.getJoin_date());
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close();
			}catch (Exception e) {
				
			}
		}
		return result;
	}

}

