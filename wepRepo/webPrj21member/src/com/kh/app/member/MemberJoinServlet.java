package com.kh.app.member;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.util.JDBCTemplate;

@WebServlet("/member/join")
public class MemberJoinServlet extends HttpServlet {

	// 회원가입 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/WEB-INF/views/member/joinForm.jsp").forward(req, resp);
	
	}
	
	// 회원가입
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 데이터 꺼내기
		String inputId = req.getParameter("memberId");
		String inputPwd = req.getParameter("memberPwd");
		String inputNick = req.getParameter("memberNick");
	
		
		// 데이터 뭉치기
		MemberVo vo = new MemberVo();
		vo.setMemberId(inputId);
		vo.setMemberPwd(inputPwd);
		vo.setMemberNick(inputNick);
		
		int result = 0;
		
		// 서비스 로직
		try {
			
			Connection conn = JDBCTemplate.getConnection();
			
			String sql = "INSERT INTO MEMBER(ID, PWD, NICK) VALUES( ? ,? ,? )";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString( 1, vo.getMemberId() );
			pstmt.setString( 2, vo.getMemberPwd() );
			pstmt.setString( 3, vo.getMemberNick() );
			result = pstmt.executeUpdate();
			
			// tx , rollback
			if(result == 1) {
				JDBCTemplate.commit(conn);
			}
			else {
				JDBCTemplate.rollback(conn);
			}
			
			// close
			JDBCTemplate.close(conn);
			JDBCTemplate.close(pstmt);
			
		} catch(Exception e) {
			System.out.println("[error] 회원가입 중 예외 발생");
			e.printStackTrace();
		}
		
		
		// 화면
		if(result == 1) {
			req.setAttribute("msg", "회원가입 성공!");
		}
		else {
			req.setAttribute("msg", "회원가입 실패..");
		}
		req.getRequestDispatcher("/WEB-INF/views/common/result.jsp").forward(req, resp);
		
	}
	
}
