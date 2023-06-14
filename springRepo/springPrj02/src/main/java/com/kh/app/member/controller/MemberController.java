package com.kh.app.member.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.app.member.vo.MemberVo;

@Controller
public class MemberController {

	// 회원가입 화면
//	@RequestMapping(value="member/join", method=RequestMethod.GET)
	@GetMapping("member/join")
	public String joinGet() {
		return "member/join";
	}
	
	// 회원가입 처리
//	@RequestMapping(value="member/join", method=RequestMethod.POST)
	@PostMapping("member/join")
	public String joinPost(
			@RequestParam(required=true) String nick) {
		
		
		System.out.println(nick);
		
		return "redirect:/";
	}
	/* @ModelAttribute 알아보기
	 * @RequestParam 의 속성 알아보기
	 * 예)
	 * @RequestParam(required=true|false)  	: 필수여부
	 * @RequestParam(defaultValue="") 		: 기본값
	 * 
	public String joinPost(@RequestParam List<String> num) { .. }
	
	public String joinPost(@RequestParam Map<String, String> map) { .. }
	*/
} // class MemberController
