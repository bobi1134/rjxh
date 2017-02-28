package cn.rjxh.dto;

import java.util.Date;

public class News {

	private int id;
	private String title;
	private String content;
	private Date date;
	private String ip;
	private int zan_num;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getZan_num() {
		return zan_num;
	}
	public void setZan_num(int zan_num) {
		this.zan_num = zan_num;
	}
}
