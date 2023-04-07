package com.kh.app.member.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.kh.app.member.dao.MemberDao;
import com.kh.app.member.vo.MemberVo;
import com.kh.app.util.JDBCTemplate;

public class MemberService {

	public int join(MemberVo vo) {
		
		int result = 0;
		
		Connection conn = null;
		try {
			
			conn = JDBCTemplate.getConnection();
			
			MemberDao dao =  new MemberDao();
			result = dao.join(conn, vo);
			
			if(result == 1) {
				JDBCTemplate.commit(conn);
			}
			else {
				JDBCTemplate.rollback(conn);
			}
			
		} catch (Exception e) {
			System.out.println("[error] MemberService.join 처리 중 문제 발생");
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);			
		}
		
		return result;
		
	}

	public MemberVo login(MemberVo vo) {

		MemberVo loginMember = null;
		
		Connection conn = null;
		try {
			
			conn = JDBCTemplate.getConnection();
			
			MemberDao dao = new MemberDao();
			loginMember = dao.login(conn, vo);
			
		}catch (Exception e) {
			System.out.println("[error] MemberService.login 처리 중 문제 발생");
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		
		System.out.println("serviec : " + loginMember);
		return loginMember;
	}

}
