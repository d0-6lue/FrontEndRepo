package com.kh.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.kh.app.member.vo.MemberVo;
import com.kh.app.utill.FileUploader;

@MultipartConfig(
			maxFileSize = 1024 * 1024 * 50,
			maxRequestSize = 1024 * 1024 * 50 * 5
		)
@WebServlet("/member/join")
public class MemberJoinController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/member/join-page.jsp").forward(req, resp);
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String memberId = req.getParameter("memberId");
		String memberPwd = req.getParameter("memberPwd1");
		String memberNick = req.getParameter("memberNick");
		String memberEmail = req.getParameter("memberNick");
		String memberPhone = req.getParameter("memberPhone");
		
		//https://seokr.tistory.com/610
		
		Part f = req.getPart("memberProfile");
		String path = req.getServletContext().getRealPath("/static/img/memberProfile/");
		String chageName = FileUploader.upload(f, path);
		
		MemberVo vo = new MemberVo();
	}
}
