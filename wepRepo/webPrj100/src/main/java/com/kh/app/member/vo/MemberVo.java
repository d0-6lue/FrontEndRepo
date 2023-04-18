package com.kh.app.member.vo;

public class MemberVo {
	
	private String no;
	private String id;
	private String pwd;
	private String nick;
	private String email;
	private String phone;
	private String profile;
	
	
	public MemberVo() {
		super();
	}
	
	public MemberVo(String no, String id, String pwd, String nick, String email, String phone, String profile) {
		super();
		this.no = no;
		this.id = id;
		this.pwd = pwd;
		this.nick = nick;
		this.email = email;
		this.phone = phone;
		this.profile = profile;
	}
	
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	
	@Override
	public String toString() {
		return "MemberVo [no=" + no + ", id=" + id + ", pwd=" + pwd + ", nick=" + nick + ", email=" + email + ", phone="
				+ phone + ", profile=" + profile + "]";
	}
	
}
