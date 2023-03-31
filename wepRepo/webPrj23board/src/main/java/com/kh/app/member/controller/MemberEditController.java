package com.kh.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

@WebServlet("/member/edit")
public class MemberEditController extends HttpServlet {

	// 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			MemberVo loginMember = (MemberVo)req.getSession().getAttribute("loginMember");
			String no = loginMember.getNo();
			
			
			MemberService ms = new MemberService();
			MemberVo dbMember = ms.selectOneByNo(no);
			
			
			req.setAttribute("dbMember", dbMember);
			req.getRequestDispatcher("/WEB-INF/views/member/editForm.jsp").forward(req, resp);
		
		} catch (Exception e) {
			System.out.println("[error] 마이페이지 화면 조회 중 예외 발생");
			e.printStackTrace();
		}
		
	}
	
	
	// 회원정보 수정 동작
	// UPDATE MEMBER SET PWD =? , NICK = ? WHERE NO = ?
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			// 데이터 준비
			req.setCharacterEncoding("UTF-8");
			String memberId = req.getParameter("memberId");
			String newPwd = req.getParameter("memberPwd");
			String newNick = req.getParameter("memberNick");
			
			MemberVo loginMember = (MemberVo)req.getSession().getAttribute("loginMember");
			String memberNo = loginMember.getNo();
		
			//
			MemberVo vo = new MemberVo();
			vo.setId(memberId);
			vo.setNo(memberNo);
			vo.setPwd(newPwd);
			vo.setNick(newNick);
			
			
			// 서비스 로직
			MemberService ms = new MemberService();
			int result = ms.edit(vo);
			
			// 화면
			req.getSession().setAttribute("loginMember", vo);
			resp.sendRedirect("/app23");
			
		} catch (Exception e) {
			System.out.println("[error] 회원 정보 수정 중 예외 발생");
		}
		
		
	}
	
}
