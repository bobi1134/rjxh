package cn.rjxh.dto;

import java.util.Date;
import java.util.List;

public class Remark {

	private int id;
	private String content;
	private Date date;
	private List<SubRemark> subRemarks;
	private User user;
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
	public List<SubRemark> getSubRemarks() {
		return subRemarks;
	}
	public void setSubRemarks(List<SubRemark> subRemarks) {
		this.subRemarks = subRemarks;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
}
