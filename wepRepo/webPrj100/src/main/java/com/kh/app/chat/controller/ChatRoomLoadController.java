package com.kh.app.chat.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.app.chat.service.ChatService;
import com.kh.app.chat.vo.ChatRoomVo;


@WebServlet("/chat/loadchatroom")
public class ChatRoomLoadController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		ChatService cs = new ChatService();
		List<ChatRoomVo> list = cs.loadChatRooms();
	
		
		Gson gson = new Gson();
		String resultJson = gson.toJson(list);
		
		PrintWriter out = resp.getWriter();
		out.write(resultJson);
	}
	
}
