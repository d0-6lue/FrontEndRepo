package com.kh.app.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.app.board.vo.BoardVo;
import com.kh.app.util.JDBCTemplate;

public class BoardDao {

	public int boardWrite(Connection conn, BoardVo boardVo) throws SQLException {

		String sql = "INSERT INTO BOARD (NO, TITLE, CONTENT, WRITER_NO) VALUES(SEQ_BOARD_NO.NEXTVAL, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, boardVo.getTitle());
		pstmt.setString(2, boardVo.getContent());
		pstmt.setString(3, boardVo.getWriterNo());
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
	}

	public List<BoardVo> selectList(Connection conn) throws SQLException {

		String sql = "SELECT BOARD.NO, TITLE, CONTENT, NICK, ENROLL_DATE FROM BOARD JOIN MEMBER ON BOARD.WRITER_NO = MEMBER.NO ORDER BY ENROLL_DATE DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs =pstmt.executeQuery();
		
		
		List<BoardVo> voList = new ArrayList<>();
		while(rs.next()) {
			
			String no = rs.getString("NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String writer = rs.getString("NICK");
			String enrollDate = rs.getString("ENROLL_DATE");
			
			BoardVo vo = new BoardVo();
			vo.setNo(no);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setWriterNick(writer);
			vo.setEnrollDate(enrollDate);
			
			voList.add(vo);
			
		}

		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return voList;
	}

	public BoardVo selectOneByNo(Connection conn, String boardNo) throws SQLException {

		String sql = "SELECT BOARD.NO, TITLE, CONTENT, NICK, ENROLL_DATE FROM BOARD JOIN MEMBER ON BOARD.WRITER_NO = MEMBER.NO WHERE BOARD.NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, boardNo);
		ResultSet rs = pstmt.executeQuery();
		
		BoardVo vo = new BoardVo();
		
		if(rs.next()) {
			
			String no = rs.getString("NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String writer = rs.getString("NICK");
			String enrollDate = rs.getString("ENROLL_DATE");
			
			vo = new BoardVo();
			vo.setNo(no);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setWriterNick(writer);
			vo.setEnrollDate(enrollDate);
			
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return vo;
	}
	
	

}
