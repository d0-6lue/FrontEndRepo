package com.kh.app.chat.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.kh.app.chat.dao.ChatDao;
import com.kh.app.chat.vo.ChatRoomVo;
import com.kh.app.chat.vo.ChatVo;
import com.kh.app.util.JDBCTemplate;

public class ChatService {

	public List<ChatRoomVo> loadChatRooms() {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ChatDao dao = new ChatDao();
		List<ChatRoomVo> voList = dao.loadChatRooms(conn);
		
		JDBCTemplate.close(conn);
		
		return voList;
	}

	public List<ChatVo> loadChatList(String roomNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ChatDao dao = new ChatDao();
		List<ChatVo> voList = dao.loadChatList(conn, roomNo);
		
		JDBCTemplate.close(conn);
		
		return voList;
	}

}
