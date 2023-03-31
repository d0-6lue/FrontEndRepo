package com.kh.app.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.app.member.vo.MemberVo;
import com.kh.app.util.JDBCTemplate;

public class MemberDao {
	
	// 회원가입 
	public int join(Connection conn, MemberVo vo) throws SQLException {
		
		int result = 0;
		
		String sql = "INSERT INTO MEMBER(NO, ID, PWD, NICK) VALUES( SEQ_MEMBER_NO.NEXTVAL, ? , ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getId());
		pstmt.setString(2, vo.getPwd());
		pstmt.setString(3, vo.getNick());
		result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
				
	} // 

	
	// 회원 한명 조회
	public MemberVo selectOneByNo(Connection conn, String no) throws SQLException {

		// SQL
		String sql = "SELECT * FROM MEMBER WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		ResultSet rs = pstmt.executeQuery();
		
		// tx || rs
		MemberVo vo = null;
		if(rs.next()) {
			String id = rs.getString("ID");
			String pwd =rs.getString("PWD");
			String nick = rs.getString("NICK");
			
			vo = new MemberVo();
			vo.setId(id);
			vo.setPwd(pwd);
			vo.setNick(nick);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return vo;
	}


	public int edit(Connection conn, MemberVo vo) throws SQLException {

		String sql = "UPDATE MEMBER SET PWD = ?, NICK = ? WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getPwd());
		pstmt.setString(2, vo.getNick());
		pstmt.setString(3, vo.getNo());
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
	}


	public int deleteByNo(Connection conn, String no) throws SQLException {


		String sql = "DELETE MEMBER WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		int result = pstmt.executeUpdate();
	
		JDBCTemplate.close(pstmt);
	
		return result;
	}


	public MemberVo login(Connection conn, MemberVo vo) throws SQLException {

		// SQL
		String sql = "SELECT * FROM MEMBER WHERE ID=? AND PWD=? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getId());
		pstmt.setString(2, vo.getPwd());
		ResultSet rs = pstmt.executeQuery();
		
		// tx || rs->obj
		MemberVo loginMember = null;
		if(rs.next()) {
			String no = rs.getString("NO");
			String id = rs.getString("ID");
			String pwd = rs.getString("PWD");
			String nick = rs.getString("NICK");
			
			loginMember = new MemberVo();
			loginMember.setNo(no);
			loginMember.setId(id);
			loginMember.setPwd(pwd);
			loginMember.setNick(nick);
			
		}

		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
	
		return loginMember;
		
	}
	

}
