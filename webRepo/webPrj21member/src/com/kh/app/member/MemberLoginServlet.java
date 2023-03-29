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
		
		String inputId = req.getParameter("memberId");
		String inputPwd = req.getParameter("memberPwd");
		
		MemberVo vo = new MemberVo();
		vo.setMemberId(inputId);
		vo.setMemberPwd(inputPwd);
		
		MemberVo loginMember = null;
		
		try {
			
			String sql = "SELECT * FROM MEMBER WHERE ID = ? AND PWD = ?";
			Connection conn = JDBCTemplate.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMemberId());
			pstmt.setString(2, vo.getMemberPwd());
			ResultSet rs = pstmt.executeQuery();
		
			// tx || rs->obj
			if(rs.next()) {
				String dbId = rs.getString("ID");
				String dbPwd = rs.getString("PWD");
				String dbNick = rs.getString("NICK");
				
				loginMember = new MemberVo();
				loginMember.setMemberId(dbId);
				loginMember.setMemberPwd(dbPwd);
				loginMember.setMemberNick(dbNick);
			}
			
			
			// close()
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(conn);
			
		} catch(Exception e) {
			System.out.println("[error] 로그인 중 예외 발생");
			e.printStackTrace();
		}
		
		
		if(loginMember != null) {
			
			HttpSession session = req.getSession();
			session.setAttribute("nick", loginMember.getMemberNick());
			session.setAttribute("id", loginMember.getMemberId());
			
			resp.sendRedirect("/app21/");
//			req.getRequestDispatcher("/WEB-INF/views/home.jsp");
		}
		else {
			
		}
		
	}
	
}
