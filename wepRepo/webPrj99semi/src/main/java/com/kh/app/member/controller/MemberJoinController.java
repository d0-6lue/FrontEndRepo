package com.kh.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;
import com.kh.app.util.FileUploader;

@MultipartConfig(
			maxFileSize = 1024 * 1024 * 50,
			maxRequestSize = 1024 * 1024 * 50 * 5
		)
@WebServlet("/member/join")
public class MemberJoinController extends HttpServlet {

	// 회원가입 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/WEB-INF/views/member/joinForm.jsp").forward(req, resp);
	
	}
	
	
	// 회원가입 처리
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			String memberId = req.getParameter("memberId");
			String memberPwd = req.getParameter("memberPwd");
			String memberNick = req.getParameter("memberNick");
			String[] hobbyArr = req.getParameterValues("hobby");
			String hobby = "";
			if(hobbyArr != null) {
				hobby = String.join(",", hobbyArr);				
			}
			
			Part f = req.getPart("memberProfile");
			String path = req.getServletContext().getRealPath("/static/img/");
			String changeName = FileUploader.upload(f, path);
			
			
			MemberVo vo = new MemberVo();
			vo.setId(memberId);
			vo.setPwd(memberPwd);
			vo.setNick(memberNick);
			vo.setHobby(hobby);
			vo.setProfile(changeName);
			
			MemberService ms =  new MemberService();
			int result = ms.join(vo);
			
			if(result == 1) {
				String root = req.getContextPath();
				req.getSession().setAttribute("alertMsg", "회원가입 성공!");
				resp.sendRedirect( root + "/home" );
			}
			else {
				throw new Exception("MemberJoinController.doPost  :  회원가입 result != 1");
			}
			
		} catch (Exception e) {
			System.out.println("[error] 회원가입 중 문제 발생");
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "회원가입 실패..");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
		}
		
	}
	
}
