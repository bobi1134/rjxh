package cn.rjxh.dto;

import java.util.List;


public class Contact {

	private int id;
	private String category;
	ContactSub contactSub;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public ContactSub getContactSub() {
		return contactSub;
	}
	public void setContactSub(ContactSub contactSub) {
		this.contactSub = contactSub;
	}
}
