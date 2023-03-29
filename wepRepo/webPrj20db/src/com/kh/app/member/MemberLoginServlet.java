package com.kh.app.member;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.app.util.JDBCTemplate;

@WebServlet("/member/login")
public class MemberLoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/WEB-INF/views/member/loginForm.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String memberId = req.getParameter("memberId");
		String memberPwd = req.getParameter("memberPwd");
	
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<String, String> dbData = null;
		try {
			
			String sql = "SELECT * FROM MEMBER WHERE ID = ? AND PWD = ?";
			conn = JDBCTemplate.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPwd);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String dbId = rs.getString("ID");
				String dbPwd = rs.getString("PWD");
				String dbNick = rs.getString("NICK");
				
				dbData = new HashMap<>();
				dbData.put("dbId", dbId);
				dbData.put("dbPwd", dbPwd);
				dbData.put("dbNick", dbNick);
			}
			
		}catch(Exception e) {
			System.out.println("[error] 로그인 중 예외 발생");
			e.printStackTrace();
		}
		finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(conn);
		}
		
		if(dbData != null) {
//			req.setAttribute("loginMember", dbData);
			HttpSession session = req.getSession();
			session.setAttribute("loginMember", dbData);
//			req.getRequestDispatcher("/index.jsp").forward(req, resp); // 내부에서 전달
			resp.sendRedirect("/app20/home"); // 클라이언트 관점으로 경로. 클라이언트가 직접 접속
		}
		else {
			req.getRequestDispatcher("/WEB-INF/views/common/loginFail.jsp").forward(req, resp);			
		}
		
	}
	
}
