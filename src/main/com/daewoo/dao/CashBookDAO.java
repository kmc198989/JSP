package main.com.daewoo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import main.com.daewoo.dto.CashBookDTO;
import main.com.daewoo.dto.MyDTO;
import util.DBManager;

public class CashBookDAO {
	private CashBookDAO() {
		
	}	
	private static CashBookDAO instance = new CashBookDAO();
	
	public static CashBookDAO getInstance() {
		return instance;
	}
	
	public ArrayList<CashBookDTO> searchAllList(int code) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from cashbook where code = ?";
		ArrayList<CashBookDTO> al = new ArrayList<CashBookDTO>();
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, code);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				CashBookDTO cdto = new CashBookDTO();
				cdto.setCode(code);
				cdto.setIn_out(rs.getString("in_out"));
				cdto.setAmount(rs.getInt("amount"));
			    cdto.setIn_date(rs.getInt("in_date"));
			    cdto.setContent(rs.getString("content"));
			    cdto.setPayment(rs.getString("payment"));
			    cdto.setMonthly(rs.getString("monthly"));
			    cdto.setComent(rs.getString("coment"));
			    System.out.println(rs.getString("payment"));
			    al.add(cdto);				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return al;		
	}
	
	public ArrayList<MyDTO> searchJsonList(int code) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT in_out, amount as \"title\", TO_CHAR(in_date, 'YYYY-MM-DD') AS \"start\" FROM cashbook WHERE code = ?";
		ArrayList<MyDTO> al = new ArrayList<MyDTO>();
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, code);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MyDTO mdto = new MyDTO();
				if (rs.getString("in_out").equals("수입")) {
					mdto.setTitle(rs.getString("in_out") + " +" + rs.getString("title"));
					mdto.setStart(rs.getString("start"));
				} else {
					mdto.setTitle(rs.getString("in_out") + " -" + rs.getString("title"));
					mdto.setStart(rs.getString("start"));
				}
			    al.add(mdto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return al;		
	}
	
	
	
	
	
}
