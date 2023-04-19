package com.kh.app.chat.vo;

public class ChatVo {
	
	private String roomNo;
	private String chatContent;
	private String chatSender;

	public ChatVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ChatVo(String roomNo, String chatContent, String chatSender) {
		super();
		this.roomNo = roomNo;
		this.chatContent = chatContent;
		this.chatSender = chatSender;
	}
	
	public String getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	public String getChatContent() {
		return chatContent;
	}
	public void setChatContent(String chatContent) {
		this.chatContent = chatContent;
	}
	public String getChatSender() {
		return chatSender;
	}
	public void setChatSender(String chatSender) {
		this.chatSender = chatSender;
	}
	
	@Override
	public String toString() {
		return "ChatVo [roomNo=" + roomNo + ", chatContent=" + chatContent + ", chatSender=" + chatSender + "]";
	}

}
