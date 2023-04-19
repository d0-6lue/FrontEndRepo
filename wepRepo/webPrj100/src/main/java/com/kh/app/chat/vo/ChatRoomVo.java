package com.kh.app.chat.vo;

public class ChatRoomVo {

	private String roomNo;
	private String roomName;
	private String roomCurrentPersonnel;
	private String roomTotalPersonnel;
	private String roomParticipant;
	private String roomStatus;
	
	
	public ChatRoomVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChatRoomVo(String roomNo, String roomName, String roomCurrentPersonnel, String roomTotalPersonnel,
			String roomParticipant, String roomStatus) {
		super();
		this.roomNo = roomNo;
		this.roomName = roomName;
		this.roomCurrentPersonnel = roomCurrentPersonnel;
		this.roomTotalPersonnel = roomTotalPersonnel;
		this.roomParticipant = roomParticipant;
		this.roomStatus = roomStatus;
	}


	public String getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public String getRoomCurrentPersonnel() {
		return roomCurrentPersonnel;
	}
	public void setRoomCurrentPersonnel(String roomCurrentPersonnel) {
		this.roomCurrentPersonnel = roomCurrentPersonnel;
	}
	public String getRoomTotalPersonnel() {
		return roomTotalPersonnel;
	}
	public void setRoomTotalPersonnel(String roomTotalPersonnel) {
		this.roomTotalPersonnel = roomTotalPersonnel;
	}
	public String getRoomParticipant() {
		return roomParticipant;
	}
	public void setRoomParticipant(String roomParticipant) {
		this.roomParticipant = roomParticipant;
	}
	public String getRoomStatus() {
		return roomStatus;
	}

	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}

	@Override
	public String toString() {
		return "ChatRoomVo [roomNo=" + roomNo + ", roomName=" + roomName + ", roomCurrentPersonnel="
				+ roomCurrentPersonnel + ", roomTotalPersonnel=" + roomTotalPersonnel + ", roomParticipant="
				+ roomParticipant + ", roomStatus=" + roomStatus + "]";
	}
	
}
