package com.kh.app.common.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCTemplate {
	
	
	public static Connection getConnection() {
		
		Connection conn = null;
		
		try {
			
			String driver = "oracle.jdbc.dirver.OracleDriver";
			String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			String dbID = "C##SEMI";
			String dbPw = "1234";
			
			Class.forName(driver);
			conn = DriverManager.getConnection(dbUrl, dbID, dbPw);
			conn.setAutoCommit(false);
			
		} catch (Exception e) {
			System.out.println("[ERROR] JDBCTemplate.getConnection");
			System.out.println("DB 연결중 예외 발생..");
			e.printStackTrace();
		}
		
		return conn;	
	} // getConnection
	
	
	public static void commit(Connection conn) {
		try {
			
			if( conn != null && !conn.isClosed() ) {
				conn.commit();
			}
			
		} catch (Exception e) {
			System.out.println("[ERROR] JDBCTemplate.commit");
			System.out.println("DB 커밋중 예외 발생..");
			e.printStackTrace();
		}
	} // commit
	
	
	public static void rollback(Connection conn) {
		try {
			
			if( conn != null && !conn.isClosed() ) {
				conn.rollback();
			}
			
		} catch (Exception e) {
			System.out.println("[ERROR] JDBCTemplate.rollback");
			System.out.println("DB 롤백중 예외 발생..");
			e.printStackTrace();
		}
	} // rollback

	
	public static void close(Connection conn) {
		try {
			
			if( conn != null && !conn.isClosed() ) {
				conn.close();
			}
			
		} catch (Exception e) {
			System.out.println("[ERROR] JDBCTemplate.close");
			System.out.println("DB close(Connection conn)중 예외 발생..");
			e.printStackTrace();
		}
	} // close(Connection conn)
	
	
	public static void close(Statement stmt) {
		try {
			
			if( stmt != null && !stmt.isClosed() ) {
				stmt.close();
			}
			
		} catch (Exception e) {
			System.out.println("[ERROR] JDBCTemplate.close");
			System.out.println("DB close(Statement stmt)중 예외 발생..");
			e.printStackTrace();
		}
	} // close(Statement stmt)
	
	
	public static void close(ResultSet rs) {
		try {
			
			if( rs != null && !rs.isClosed() ) {
				rs.close();
			}
			
		} catch (Exception e) {
			System.out.println("[ERROR] JDBCTemplate.close");
			System.out.println("DB close(ResultSet rs)중 예외 발생..");
			e.printStackTrace();
		}
	} // close(ResultSet rs)
	
	
}
