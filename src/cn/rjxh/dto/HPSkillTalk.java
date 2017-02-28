package cn.rjxh.dto;

import java.util.List;

public class HPSkillTalk {

	private int id;
	private String title;
	private String image;
	private String category;
	private List<String> category_sub;
	private int category_sub_size;
	
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public List<String> getCategory_sub() {
		return category_sub;
	}
	public void setCategory_sub(List<String> category_sub) {
		this.category_sub = category_sub;
	}
	public int getCategory_sub_size() {
		return category_sub_size;
	}
	public void setCategory_sub_size(int category_sub_size) {
		this.category_sub_size = category_sub_size;
	}
}
