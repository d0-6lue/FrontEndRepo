package com.kh.app.chat.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.app.chat.service.*;
import com.kh.app.chat.vo.ChatVo;

@WebServlet("/chat/room")
public class ChatRoomDetailController extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/chat/chat-room.jsp").forward(req, resp);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		String roomNo = req.getParameter("roomNo");
//		
//		ChatService cs = new ChatService();
//		List<ChatVo> chatList = cs.loadChatList(roomNo);
//		
//		System.out.println(chatList);
//		
//		Gson gson = new Gson();
//		String resultJson = gson.toJson(chatList);
//		
//		PrintWriter out = resp.getWriter();
//		out.write(resultJson);

		
		
		BufferedReader r = req.getReader();

		StringBuilder sb = new StringBuilder();
		String s = "";
		while((s = r.readLine()) != null) {
			sb.append(s);
		}
		
		String str = sb.toString(); 
		
		System.out.println(str);
		
		Gson gson = new Gson();
		Map<String, String> map = gson.fromJson(str, Map.class);
		
		System.out.println(map);
		System.out.println(String.valueOf(map.get("roomNo")));
		String roomNo = String.valueOf(map.get("roomNo"));
		
		ChatService cs = new ChatService();
		List<ChatVo> chatList = cs.loadChatList(roomNo);
		
		System.out.println(chatList);

		
		String resultJson = gson.toJson(chatList);
		
		PrintWriter out = resp.getWriter();
		out.write(resultJson);
		
	}
	
}
