package cn.rjxh.dto;

import java.util.Date;

public class SubRemark {

	private int id;
	private String content;
	private Date date;
	private User user;
	private String remarkUser;
	private int remarkUserId;
	private int userId;
	
	/*** setter and getter method ***/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getRemarkUser() {
		return remarkUser;
	}
	public void setRemarkUser(String remarkUser) {
		this.remarkUser = remarkUser;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getRemarkUserId() {
		return remarkUserId;
	}
	public void setRemarkUserId(int remarkUserId) {
		this.remarkUserId = remarkUserId;
	}
}
