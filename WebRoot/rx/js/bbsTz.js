var hfUserId = 0;
$("#main1 .tz .remark_area .hf").click(function(){
	$(this).parent().parent().find(".add-sub-remark").slideDown();
	$(this).parent().find(".sq").show();
	$(this).parent().find(".hf").hide();
	$(this).parent().siblings().find(".sq").hide();
	$(this).parent().siblings().find(".hf").show();
	$(this).parent().parent().siblings().find(".add-sub-remark").slideUp();
	$(this).parent().parent().siblings().find(".sq").hide();
	$(this).parent().parent().siblings().find(".hf").show();
	var text = $(this).parent().find(".needAnswer").text();
	text = "回复【"+text+"】";
	$(this).parent().parent().find(".add-sub-remark .remark").attr("placeholder", text);
	hfUserId = $(this).parent().find(".hfUserId").text();
	//alert(hfUserId);
});
$("#main1 .tz .remark_area .sq").click(function(){
	$(this).parent().parent().find(".add-sub-remark").slideUp();
	$(this).parent().find(".sq").hide();
	$(this).parent().find(".hf").show();
});
var flag = 1;
$("#main1 .tz .add-remark .addBQ").click(function(){
	if(flag==1){
		$("#main1 .tz .add-remark .biaoqing").slideDown();
		flag = 0;
	}else{
		$("#main1 .tz .add-remark .biaoqing").slideUp();
		flag = 1;
	}
});
/*** 点击表情添加到评论框中 start **/
$("#main1 .tz .add-remark .biaoqing .face_ul > li").click(function(){
	var nowindex = $('.face_ul>li').index(this)+1;
	if (nowindex < 10) {
		nowindex = "0"+nowindex;
	}
	$("#main1 .tz .add-remark .remark").append(
			"<img src='"+path+"/rx/images/face/"+nowindex+".gif' width='18' height='18'/>"
	);
});
/*** end点击表情添加到评论框中 **/

/*** 点击一级评论按钮 start ***/
$("#addRemarkBtn").click(function(){
	//赋值到input
	$("#remarkContent").val($("#remarkContent_jy").html());
	var remark = document.getElementById("remarkContent_jy").innerHTML;
	if(remark == ""){
		alert("评论不能为空！");
	}else{
		$("#addRemarkForm").submit();
	}
});
/*** end 点击一级评论按钮 ***/

/*** 点击二级评论按钮 start ***/
$("#main1	.tz .remark_area .add-sub-remark .addBtn").click(function(){
	var remarkId = $(this).parent().parent().parent().find(".remarkId").text();
	var subRemarkCoent = $(this).parent().find(".remark").val();
	var appendLocation = $(this).parent().parent();
	var remarkLocation = $(this).parent().find(".remark");
	
	if(subRemarkCoent==""){
		alert("回复不能为空！");
	}else{
		//异步
		$.ajax({
			type : "post",
			url : path+"/bbs/addSubRemark.do?hfUserId="+hfUserId+"&remarkId="+remarkId,
			dataType : "json",
			data : $(this).parent().parent().find(".addSubRemarkForm").serialize(),
			success : function(json){	
				if(json.tcFlag != ""){
					//alert(json.tcFlag);
				}
				if(json.loginFlag != ""){
					alert(json.loginFlag);
					window.location = path+"/user/loginpage.do";
				}
				
				appendLocation.before(
					"<div>"+
    					"<span class='hfUserId' style='display:none'><s:property value='userId'/></span>"+
    					"【"+name+"】"+
    					"回复【"+json.name+"】："+subRemarkCoent+
    					"<a href='javacript:void(0);' class='hf'>回复</a>"+
    					"<a href='javacript:void(0);' class='sq'>收起</a>"+
    				"</div>"
				);
				remarkLocation.val("");
			},
			error : function(){
				alert("回复失败，请稍后再试！");
			}
		});
	}
});
/*** end 点击二级评论按钮 ***/




