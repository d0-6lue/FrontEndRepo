package com.kh.app.member.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;
import com.kh.app.util.JDBCTemplate;

@WebServlet("/member/join")
public class MemberJoinController extends HttpServlet {
	
	// 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/WEB-INF/views/member/joinForm.jsp").forward(req, resp);
	
	}
	
	
	// 처리
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			req.setCharacterEncoding("UTF-8");
			String inputId = req.getParameter("memberId");
			String inputPwd = req.getParameter("memberPwd");
			String inputNick = req.getParameter("memberNick");
			
		
			MemberVo vo = new MemberVo();
			vo.setId(inputId);
			vo.setPwd(inputPwd);
			vo.setNick(inputNick);
			
			
			// 서비스 로직
			int result = new MemberService().join(vo);
			
			
			if(result == 1) {
				req.setAttribute("msg", "회원가입 성공 !!");
			}
			else {
//				req.setAttribute("msg", "회원가입 실패 ..");
				throw new Exception("[ERROR] 회원가입 실패");
			}
			
			
			req.getRequestDispatcher("/WEB-INF/views/common/result.jsp").forward(req, resp);
		
		} catch(Exception e) {
			System.out.println("[error] 회원가입 진행 중 예외 발생 ..");
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "회원가입 진행 중 문제 발생");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
		
		
	}
	
}
