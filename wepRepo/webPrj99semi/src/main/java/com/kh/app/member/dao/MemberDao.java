package com.kh.app.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.kh.app.member.vo.MemberVo;
import com.kh.app.util.JDBCTemplate;

public class MemberDao {

	public int join(Connection conn, MemberVo vo) {

		int result = 0;
		
		PreparedStatement pstmt = null;
		try {

			String sql = "INSERT INTO MEMBER(NO, ID, PWD, NICK, HOBBY, PROFILE) VALUES(SEQ_MEMBER_NO.NEXTVAL, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getNick());
			pstmt.setString(4, vo.getHobby());			
			pstmt.setString(5, vo.getProfile());
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("[error] MemberDao.join 처리 중 문제 발생");
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);			
		}
		
		return result;
		
	}

	public MemberVo login(Connection conn, MemberVo vo) {
		
		MemberVo loginMember = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			
			String sql = "SELECT * FROM MEMBER WHERE ID = ? AND PWD = ? AND STATUS = 'O'";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				String no = rs.getString("NO");
				String id = rs.getString("ID");
				String pwd = rs.getString("PWD");
				String nick = rs.getString("NICK");
				String profile = rs.getString("PROFILE");
				String hobby = rs.getString("HOBBY");
				String status = rs.getString("STATUS");
				String enroll_date = rs.getString("ENROLL_DATE");
				String modify_date = rs.getString("MODIFY_DATE");
				
				loginMember = new MemberVo();
				loginMember.setNo(no);
				loginMember.setId(id);
				loginMember.setPwd(pwd);
				loginMember.setNick(nick);
				loginMember.setProfile(profile);
				loginMember.setHobby(hobby);
				loginMember.setStatus(status);
				loginMember.setEnrollDate(enroll_date);
				loginMember.setModifyDate(modify_date);
				
			}
			
		} catch (Exception e) {
			System.out.println("[error] MemberDao.login 처리 중 문제 발생");
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		System.out.println("dao : " + loginMember);
		return loginMember;
	}

}
