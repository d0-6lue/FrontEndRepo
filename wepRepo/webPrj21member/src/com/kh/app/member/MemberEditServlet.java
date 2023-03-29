package com.kh.app.member;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.util.JDBCTemplate;

@WebServlet("/member/edit")
public class MemberEditServlet extends HttpServlet {

	// 회원 정보 페이지 ( db에서 select )
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 데이터 꺼내기
//		String memberId = req.getParameter("id");
		String memberId = (String) req.getSession().getAttribute("id");
		
	
		
		// 서비스 로직
		ResultSet rs = null;
		MemberVo loginMember = null;
		
		try {
			
			String sql = "SELECT * FROM MEMBER WHERE ID = ?";
			Connection conn = JDBCTemplate.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			rs = pstmt.executeQuery();
			
			
			if(rs.next()) {
				String dbId = rs.getString("ID");
				String dbPwd = rs.getString("PWD");
				String dbNick = rs.getString("NICK");
				
				loginMember = new MemberVo();
				loginMember.setMemberId(dbId);
				loginMember.setMemberPwd(dbPwd);
				loginMember.setMemberNick(dbNick);
			}
			
			
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(conn);
		
		} catch(Exception e) {
			System.out.println("[error] 마이페이지 화면 조회 중 예외 발생..");
			e.printStackTrace();
		}
		
		// 화면
		if(loginMember != null) {
			req.setAttribute("loginMember", loginMember);
			req.getRequestDispatcher("/WEB-INF/views/member/edit.jsp").forward(req, resp);
		}
		else {
			req.getRequestDispatcher("").forward(req, resp);
		}
		
	
	}
	
	// 회원 정보 수정 ( db에서 update )
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String memberId = req.getParameter("memberId");
		String newPwd = req.getParameter("memberPwd");
		String newNick = req.getParameter("memberNick");
		
		int result = 0;
		
		try {
		
			String sql = "update member set pwd=?, nick=? where id = ?";
			Connection conn = JDBCTemplate.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, newPwd);
			pstmt.setString(1, newNick);
			pstmt.setString(2, memberId);
			result = pstmt.executeUpdate();
			
			
			if(result  == 1) {
				JDBCTemplate.commit(conn);
			}
			else {
				JDBCTemplate.rollback(conn);
			}

			
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(conn);
			
			
		}catch(Exception e) {
			System.out.println("[error] 정보 수정 중 예외 발생");
			e.printStackTrace();
		}
		
		
		if(result == 1) {
			req.setAttribute("msg", "수정 성공 !!!");
			req.getRequestDispatcher("/WEB-INF/views/common/result.jsp").forward(req, resp);
		}
		else {
			req.setAttribute("msg", "수정 실패 !!!");
			req.getRequestDispatcher("/WEB-INF/views/common/result.jsp").forward(req, resp);
		}
		
		
	}
	
}
