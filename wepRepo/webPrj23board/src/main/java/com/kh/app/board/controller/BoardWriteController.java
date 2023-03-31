package com.kh.app.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.member.vo.MemberVo;

@WebServlet("/board/write")
public class BoardWriteController extends HttpServlet {
	
	// 게시글 작성 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/WEB-INF/views/board/write.jsp").forward(req, resp);
		
	}	
	
	
	
	// 게시글 작성 동작 
	// INSERT INTO BOARD (NO, TITLE, CONTENT, WRITER_NO) VALUES(SEQ_BOARD_NO.NEXTVAL, ?, ?, ?)
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			// 데이터 받기
			req.setCharacterEncoding("UTF-8");
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			MemberVo loginMember = (MemberVo)req.getSession().getAttribute("loginMember");
			String memberNo = loginMember.getNo();
			
			
			// 객체화(?)
			BoardVo boardVo = new BoardVo();
			boardVo.setTitle(title);
			boardVo.setContent(content);
			boardVo.setWriterNo(memberNo);
			
			
			// 서비스 로직 // 서비스 레이어
			BoardService bs = new BoardService();
			int result = bs.boardWrite(boardVo);
			
			
			// 화면 출력
			if(result == 1) {
				req.getSession().setAttribute("alertMsg", "게시글 작성 성공.");
				resp.sendRedirect("/app23");
			}
			else {
				throw new Exception("[error] 실행 결과가 1이 아님");
			}
		
			
		} catch (Exception e) {
			System.out.println("[error] 게시글 작성 중 예외 발생");
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "글 작성 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}
		
		
	}
	
}
