package cn.rjxh.utils.page.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class PagerTag extends SimpleTagSupport {
	private static final String TAG = "{0}";
	private int pageIndex;
	private int pageSize;
	private int recordCount;
	private String submitUrl;
	private int totalSize;
	@Override
	public void doTag() throws JspException, IOException {
		StringBuilder res = new StringBuilder();
		StringBuilder str = new StringBuilder();
		/** 添加css */
		str.append("<div class='quotes'>");
		if (recordCount > 0){
			totalSize = (recordCount % pageSize == 0) 
					    ? recordCount / pageSize 
						: (recordCount / pageSize) + 1;
			if (pageIndex == 1){ 
				str.append("<span class='disabled'> <  Prev</span>");
				calcPage(str);
				if (pageIndex == totalSize){ 
					str.append("<span class='disabled'>Next  > </span>");
				}else{
					String tempUrl = submitUrl.replace(TAG, String.valueOf(pageIndex + 1));
					str.append("<a href='"+tempUrl+"'>Next  > </a>");
				}
				
			}else if (pageIndex == totalSize){ 
				String tempUrl = submitUrl.replace(TAG, String.valueOf(pageIndex - 1));
				str.append("<a href='"+tempUrl+"'> <  Prev</a>");
				calcPage(str);
				str.append("<span class='disabled'>Next  > </span>");
			}else{ 
				String tempUrl = submitUrl.replace(TAG, String.valueOf(pageIndex - 1));
				str.append("<a href='"+tempUrl+"'> <  Prev</a>");
				calcPage(str);
				tempUrl = submitUrl.replace(TAG, String.valueOf(pageIndex + 1));
				str.append("<a href='"+tempUrl+"'>Next  > </a>");
			}
			//int startNum = (this.pageIndex - 1) * this.pageSize + 1;
			//int endNum = (this.pageIndex == totalSize) ? this.recordCount : this.pageIndex * this.pageSize;
			res.append(str.toString());
			res.append("<script type='text/javascript'>");
			res.append("function jump_page_fn(){");
			res.append("var page_num = document.getElementById('jump_page_num').value;");
			res.append("var submitUrl = '" + submitUrl +"';");
			res.append("if (isNaN(page_num) || page_num < 1 || page_num > "+ totalSize +"){");
			res.append("   alert('请输入1-"+ totalSize +"之间的页码！');");
			res.append("}else{");
			res.append("   document.location = submitUrl.replace('"+ TAG +"', page_num)");
			res.append("}");
			res.append("}");
			res.append("</script>");
		}else{ 
//			res.append("<table align='center' style='font-size:14px;'><tr>")
//			   .append("<td>总共<span class='current'>0</font>条记录，当前显示0-0条记录。</td>")
//			   .append("</tr></table>");
		}
		res.append("</div>");
		this.getJspContext().getOut().println(res.toString());
	}

	private void calcPage(StringBuilder str) {
		if (totalSize <= 10){
			for (int i = 1; i <= totalSize; i++){
				if (i == pageIndex){ 
					str.append("<span class='current'>"+ i +"</span>");
				}else{
					String tempUrl = submitUrl.replace(TAG, String.valueOf(i));
					str.append("<a href='"+ tempUrl +"'>"+ i +"</a>");
				}
			}
		}else{
			if (pageIndex - 8 < 0){ 
				for (int i = 1; i <= 8; i++){
					if (i == pageIndex){ 
						str.append("<span class='current'>"+ i +"</span>");
					}else{
						String tempUrl = submitUrl.replace(TAG, String.valueOf(i));
						str.append("<a href='"+ tempUrl +"'>"+ i +"</a>");
					}
				}
				String tempUrl = submitUrl.replace(TAG, String.valueOf(totalSize));
				str.append("...")
				   .append("<a href='"+tempUrl+"'>"+totalSize+"</a>");
			}
			else if (pageIndex + 8 > totalSize){ 
				String tempUrl = submitUrl.replace(TAG, String.valueOf(1));
				str.append("<a href='"+ tempUrl +"'>1</a>").append("...");
				for (int i = totalSize - 8; i <= totalSize; i++){
					if (i == pageIndex){
						str.append("<span class='current'>"+ i +"</span>");
					}else{
						tempUrl = submitUrl.replace(TAG, String.valueOf(i));
						str.append("<a href='"+ tempUrl +"'>"+ i +"</a>");
					}
				}
			}
			else{ 
				String tempUrl = submitUrl.replace(TAG, String.valueOf(1));
				str.append("<a href='"+ tempUrl +"'>1</a>").append("...");
				
				for (int i = pageIndex - 4; i <= pageIndex + 4; i++){
					if (i == pageIndex){ 
						str.append("<span class='current'>"+ i +"</span>");
					}else{
						tempUrl = submitUrl.replace(TAG, String.valueOf(i));
						str.append("<a href='"+ tempUrl +"'>"+ i +"</a>");
					}
				}
				
				tempUrl = submitUrl.replace(TAG, String.valueOf(totalSize));
				str.append("...").append("<a href='"+tempUrl+"'>"+totalSize+"</a>");
			}
		}
	}


	/** setter and getter method */
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}
	public String getSubmitUrl() {
		return submitUrl;
	}
	public void setSubmitUrl(String submitUrl) {
		this.submitUrl = submitUrl;
	}
}
