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
		String sql = "select in_out, amount, TO_CHAR(in_date, 'YYYY-MM-DD') as \"in_date\", content, payment, monthly, coment from cashbook where code = ?";
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
			    cdto.setIn_date(rs.getString("in_date"));
			    cdto.setContent(rs.getString("content"));
			    cdto.setPayment(rs.getString("payment"));
			    cdto.setMonthly(rs.getString("monthly"));
			    cdto.setComent(rs.getString("coment"));
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
					mdto.setColor("#80CEE1");
				} else {
					mdto.setTitle(rs.getString("in_out") + " -" + rs.getString("title"));
					mdto.setStart(rs.getString("start"));
					mdto.setColor("#FF968A");
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
	
	public int ListAdd(CashBookDTO cdto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into cashbook name(code, in_out, in_date, amount, content, payment) values(?,?,?,?,?,?)";
		int result = -1;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cdto.getCode());
			pstmt.setString(2, cdto.getIn_out());
			pstmt.setString(3, cdto.getIn_date());
			pstmt.setInt(4, cdto.getAmount());
			pstmt.setString(5, cdto.getContent());
			pstmt.setString(6, cdto.getPayment());
			result = pstmt.executeUpdate();			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}
	
	
	
	
	
}
