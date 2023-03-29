package com.kh.app.member;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.app.util.JDBCTemplate;

@WebServlet("/member/delete")
public class MemberDeleteServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		String memberId = req.getParameter("id");
		String memberId = (String)req.getSession().getAttribute("id");
		
		int result = 0;
		
		try {
			String sql = "DELETE FROM MEMBER WHERE ID = ?";
			Connection conn = JDBCTemplate.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			result = pstmt.executeUpdate();
			
			// tx || rs
			if(result == 1) {
				JDBCTemplate.commit(conn);
			}
			else {
				JDBCTemplate.rollback(conn);
			}
			
			// close
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(conn);
			
		} catch(Exception e) {
			System.out.println("[error] 로그아웃 중 예외 발생");
			e.printStackTrace();
		}
		
		if(result == 1) {
			req.getSession().invalidate();
			resp.sendRedirect("/app21");
		}
		else {
			resp.sendRedirect("/app21/error");
		}
	}
	
}
