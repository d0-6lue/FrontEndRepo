package com.kh.app.board.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.app.board.dao.BoardDao;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.util.JDBCTemplate;

public class BoardService {
	
	// 게시글 작성
	public int boardWrite(BoardVo boardVo) throws SQLException {
				
		// -복잡한 비지니스 로직
		
		// -Connection
		Connection conn = JDBCTemplate.getConnection();
		
		// -SQL
		BoardDao bd = new BoardDao();
		int result = bd.boardWrite(conn, boardVo);
		
		
		// -tx || rs
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}
		else {
			JDBCTemplate.rollback(conn);
		}
		
		// -close
		JDBCTemplate.close(conn);
				
		return result;
	}

	
	// 게시글 목록 조회
	public List<BoardVo> selectList() throws SQLException {
		
		Connection conn = JDBCTemplate.getConnection();
		
		
		BoardDao dao = new BoardDao();
		List<BoardVo> voList = dao.selectList(conn);
		
		
		JDBCTemplate.close(conn);
		
		
		return voList;
	}

	// 게시글 상세 조회
	public BoardVo selectOneByNo(String boardNo) throws SQLException {
		
		Connection conn = JDBCTemplate.getConnection();
		
		
		BoardDao dao = new BoardDao();
		BoardVo vo = dao.selectOneByNo(conn, boardNo);
		
		
		JDBCTemplate.close(conn);
		
		return vo;
	}

}
