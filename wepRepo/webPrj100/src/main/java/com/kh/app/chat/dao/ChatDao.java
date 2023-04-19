package com.kh.app.chat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

import com.kh.app.chat.vo.ChatRoomVo;
import com.kh.app.chat.vo.ChatVo;
import com.kh.app.util.JDBCTemplate;

public class ChatDao {

	public List<ChatRoomVo> loadChatRooms(Connection conn) {
		
		List<ChatRoomVo> voList = new ArrayList<>();
		
		String sql = "SELECT * FROM CHATROOM WHERE ROOM_STATUS = 1";
		
		try(
				PreparedStatement pstmt = conn.prepareStatement(sql);
				
				ResultSet rs = pstmt.executeQuery();
				)
		{
			
			while(rs.next()) {
				ChatRoomVo vo = new ChatRoomVo();
				
				vo.setRoomNo(rs.getString("ROOM_NO"));
				vo.setRoomName(rs.getString("ROOM_NAME"));
				vo.setRoomCurrentPersonnel(rs.getString("ROOM_CURRENT_PERSONNEL"));
				vo.setRoomTotalPersonnel(rs.getString("ROOM_TOTAL_PERSONNEL"));
				vo.setRoomParticipant(rs.getString("ROOM_PARTICIPANT"));
				vo.setRoomStatus(rs.getString("ROOM_STATUS"));
				
				voList.add(vo);
			}
			
		} catch (Exception e) {
			System.out.println("[error] ChatDao.loadChatRooms() 중 문제 발생");
			e.printStackTrace();
		}
		
		
		
		return voList;
	}

	public List<ChatVo> loadChatList(Connection conn, String roomNo) {

		List<ChatVo> voList = new ArrayList<>();
		
		String sql = "SELECT * FROM CHAT_ARCHIVE WHERE ROOM_NO = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, roomNo);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ChatVo vo = new ChatVo();
				
				vo.setRoomNo(roomNo);
				vo.setChatContent(rs.getString("CONTENT"));
				vo.setChatSender(rs.getString("SENDER"));
				
				voList.add(vo);
			}
			
		} catch (Exception e) {
			System.out.println("[error] ChatDao.loadChatList() 중 문제 발생");
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		
		
		
		return voList;
	}

	
}
