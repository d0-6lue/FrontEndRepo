package com.kh.app.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.board.vo.BoardVo;
import com.kh.app.board.service.BoardService;

@WebServlet("/board/detail")
public class BoardDetailController extends HttpServlet {

	// 상세조회 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			// 데이터 꺼내기
			String boardNo = req.getParameter("no");
		
			
			
			// 서비스
			BoardService bs = new BoardService();
			BoardVo boardVo = bs.selectOneByNo(boardNo);
			
			// 화면
			if(boardVo != null) {
				req.setAttribute("boardVo", boardVo);
				req.getRequestDispatcher("/WEB-INF/views/board/detail.jsp").forward(req, resp);
			}
			else {
				throw new Exception();
			}
			
		} catch (Exception e) {
			System.out.println("[error] 게시글 상세 조회 중 예외 발생");
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "게시글 상세 조회 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}
		
		
	}
	
	
}
