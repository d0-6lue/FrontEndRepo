package com.kh.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

@WebServlet("/member/login")
public class MemberLoginController extends HttpServlet {

	// 로그인 처리
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			String memberId = req.getParameter("memberId");
			String memberPwd = req.getParameter("memberPwd");
			
			MemberVo vo = new MemberVo();
			vo.setId(memberId);
			vo.setPwd(memberPwd);
			
			System.out.println("controller : " +  vo);
			
			MemberService ms = new MemberService();
			MemberVo loginMember = ms.login(vo);
			System.out.println("controller : " + loginMember);
			if( loginMember != null ) {
				req.getSession().setAttribute("loginMember", loginMember);
				String root = req.getContextPath();
				resp.sendRedirect(root + "/home");
			}
			else {
				throw new Exception("로그인 실패");
			}
			
		} catch (Exception e) {
			System.out.println("[error] MemberLoginController.doPost  :  로그인 중 문제 발생");
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "로그인 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
		}
		
	
	}
	
}
