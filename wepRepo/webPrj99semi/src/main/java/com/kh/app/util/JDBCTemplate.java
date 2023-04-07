package com.kh.app.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCTemplate {

	public static Connection getConnection() {
		
		Connection conn = null;
		
		try {

			String driver = "oracle.jdbc.driver.OracleDriver";
			String db_url = "jdbc:oracle:thin:@localhost:1521:xe";
			String db_id = "C##SEMI";
			String db_pw = "1234";
			
			Class.forName(driver);
			conn = DriverManager.getConnection(db_url, db_id, db_pw);
			
			conn.setAutoCommit(false);
			
		} catch (Exception e) {
			System.out.println("[error] getConnection 중 문제 발생");
			e.printStackTrace();
		}
		
		return conn;
		
	} // getConnection
	
	public static void commit(Connection conn) {
		try {
			
			if(conn != null && !conn.isClosed()) {
				conn.commit();
			}
			
		} catch (Exception e) {
			System.out.println("[error] commit 중 문제 발생");
			e.printStackTrace();
		}
	} // commit
	
	
	public static void rollback(Connection conn) {
		try {
			
			if(conn != null && !conn.isClosed()) {
				conn.rollback();
			}
			
		} catch (Exception e) {
			System.out.println("[error] rollback 중 문제 발생");
			e.printStackTrace();
		}
	} // rollback
	
	
	public static void close(Connection conn) {
		try {
			
			if(conn != null && !conn.isClosed()) {
				conn.close();
			}
			
		} catch (Exception e) {
			System.out.println("[error] close 중 문제 발생");
			e.printStackTrace();
		}
	} // close
	
	
	public static void close(Statement stmt) {
		try {
			
			if(stmt != null && !stmt.isClosed()) {
				stmt.close();
			}
			
		} catch (Exception e) {
			System.out.println("[error] close 중 문제 발생");
			e.printStackTrace();
		}
	} // close
	
	
	public static void close(ResultSet rs) {
		try {
			
			if(rs != null && !rs.isClosed()) {
				rs.close();
			}
			
		} catch (Exception e) {
			System.out.println("[error] close 중 문제 발생");
			e.printStackTrace();
		}
	} // close
	
}
