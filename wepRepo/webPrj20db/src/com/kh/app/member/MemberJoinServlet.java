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

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/WEB-INF/views/member/joinForm.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");
		String memberId = req.getParameter("memberId");
		String memberPwd = req.getParameter("memberPwd");
		String memberNick = req.getParameter("memberNick");
		
		int result = 0;
		
		try {
			
			String sql = "INSERT INTO MEMBER(ID, PWD, NICK) VALUES(?, ?, ?)";
			Connection conn = JDBCTemplate.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPwd);
			pstmt.setString(3, memberNick);
			result = pstmt.executeUpdate();
			
			if(result == 1) {
				JDBCTemplate.commit(conn);
			}
			else {
				JDBCTemplate.rollback(conn);
			}
			
			JDBCTemplate.close(conn);
			JDBCTemplate.close(pstmt);
			
		}catch(Exception e) {
			System.out.println("[error] 회원가입 중 예외 발생");
			e.printStackTrace();
		}
		
		
		req.setAttribute("resultMsg", ( (result == 1)? "성공" : "실패" ) );
		req.getRequestDispatcher("/WEB-INF/views/common/result.jsp").forward(req, resp);			
		
	}
	
}
