package com.kh.app.member.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.app.member.dao.MemberDao;
import com.kh.app.member.vo.MemberVo;
import com.kh.app.util.JDBCTemplate;

public class MemberService {
	
	// 회원가입
	public int join(MemberVo vo) throws SQLException {
		
		int result = 0;
			
		Connection conn = JDBCTemplate.getConnection();
		
		
		result = new MemberDao().join(conn, vo);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}
		else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
			
	
		return result;
		
	} // join method

	
	// 회원 한명 조회
	public MemberVo selectOneByNo(String no) throws SQLException {

		// Connection
		Connection conn = JDBCTemplate.getConnection();
	
		
		MemberDao dao = new MemberDao();
		MemberVo vo = dao.selectOneByNo(conn, no);
		
		
		// close
		JDBCTemplate.close(conn);
		
		return vo;
	}


	// 회원 정보 수정
	public int edit(MemberVo vo) throws SQLException {

		// Connection
		Connection conn = JDBCTemplate.getConnection();
		
		// SQL
		MemberDao dao = new MemberDao();
		int result = dao.edit(conn, vo); 
		
		// tx || rs
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}
		else {
			JDBCTemplate.rollback(conn);
		}
		
		// close()
		JDBCTemplate.close(conn);
		
		return result;
	}


	public int deleteByNo(String no) throws SQLException {

		// Connection
		Connection conn = JDBCTemplate.getConnection();
		
		// SQL
		MemberDao dao = new MemberDao();
		int result = dao.deleteByNo(conn, no);
		
		
		// tx || rs
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}
		else {
			JDBCTemplate.rollback(conn);
		}
		
		// close()
		JDBCTemplate.close(conn);
		
		return result;
	}


	public MemberVo login(MemberVo vo) throws SQLException {
		
		// Connection
		Connection conn = JDBCTemplate.getConnection();
		
		MemberDao dao = new MemberDao();
		MemberVo loginMember = dao.login(conn, vo);
		
		// close
		JDBCTemplate.close(conn);
		
		
		return loginMember;
	}


	public List<MemberVo> list() throws SQLException {

		Connection conn = JDBCTemplate.getConnection();
		
		String sql = "SELECT * FROM MEMBER";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		List<MemberVo> list = new ArrayList();
		
		while(rs.next()) {
			
			String no = rs.getString("NO");
			String id = rs.getString("ID");
			String pwd = rs.getString("PWD");
			String nick = rs.getString("NICK");
			
			MemberVo vo = new MemberVo();
			vo.setId(id);
			vo.setPwd(pwd);
			vo.setNick(nick);
			vo.setNo(no);
			
			
			list.add(vo);
		}
		
		
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(conn);
		
		
		return list;
	}

	
}
