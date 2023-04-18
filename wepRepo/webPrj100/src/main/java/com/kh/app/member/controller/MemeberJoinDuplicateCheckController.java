package com.kh.app.member.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/member/check")
public class MemeberJoinDuplicateCheckController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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
		System.out.println(String.valueOf(map.get("memberID")));
		
		
		

		
		int result = 1;
		
		String resultJson = gson.toJson(result);
		
		PrintWriter out = resp.getWriter();
		out.write(resultJson);
		
	}
	
}
