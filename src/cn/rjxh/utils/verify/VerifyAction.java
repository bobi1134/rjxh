package cn.rjxh.utils.verify;

import javax.servlet.http.*;

import java.awt.*;
import java.awt.image.*;
import java.util.*;

import javax.imageio.*;

import org.apache.struts2.ServletActionContext;

import cn.rjxh.utils.consts.WebConstant;

import com.opensymphony.xwork2.Action;

/**
 * 图形验证码
 * @author LXH
 */
public class VerifyAction
{
	
	/** 定义图形验证码中绘制字符的字体 **/
	private final Font myFoot = new Font("Arial Black", Font.PLAIN, 18);
	/** 定义验证码的大小 **/
	private final int IMG_WIDTH = 55;
	private final int IMG_HEIGHT = 20;

	/** 定义一个随机得到颜色的方法 **/
	private Color getRandColor(int endc, int beginc) 
	{
		Random random = new Random();
		endc = (endc > 255) ? 255 : endc;
		beginc = (beginc > 255) ? 255 : beginc;
		/** 设置颜色的RGB值 **/
		int r = endc + random.nextInt(beginc - endc);
		int g = endc + random.nextInt(beginc - endc);
		int b = endc + random.nextInt(beginc - endc);
		/** 返回随机颜色 **/
		return new Color(r, g, b);
	}

	public String execute() throws Exception
	{
		HttpServletResponse response = ServletActionContext.getResponse();
		/** 设置禁示缓存 **/
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg; charset=utf-8");
		/** 创建图象缓存对象 **/
		BufferedImage image = new BufferedImage(IMG_WIDTH, IMG_HEIGHT,
				BufferedImage.TYPE_INT_RGB);
		/** 得到画笔对象 **/
		Graphics g = image.getGraphics();
		Random random = new Random();
		g.setColor(getRandColor(200, 250));
		/** 填充背景颜色 **/
		g.fillRect(1, 1, IMG_WIDTH - 1, IMG_HEIGHT - 1);
		/** 为图形验证码绘制边框 **/
		g.setColor(getRandColor(180, 200));
		g.drawRect(0, 0, IMG_WIDTH - 1, IMG_HEIGHT - 1);
		/** 生成随机干扰线 **/
		g.setColor(getRandColor(160, 200));
		for (int i = 0; i < 80; i++) 
		{
			int x = random.nextInt(IMG_WIDTH - 1);
			int y = random.nextInt(IMG_HEIGHT - 1);
			int x1 = random.nextInt(6) + 1;
			int y1 = random.nextInt(12) + 1;
			g.drawLine(x, y, x + x1, y + y1);
		}
		/** 生成随机干扰线 **/
		g.setColor(getRandColor(160, 200));
		for (int i = 0; i < 80; i++) 
		{
			int x = random.nextInt(IMG_WIDTH - 1);
			int y = random.nextInt(IMG_HEIGHT - 1);
			int x1 = random.nextInt(12) + 1;
			int y1 = random.nextInt(6) + 1;
			g.drawLine(x, y, x - x1, y - y1);
		}
		/** 设置绘制字符的字体 **/
		g.setFont(myFoot);
		/** 用来保存随机生成的字符 **/
		String result = "";
		for (int i = 0; i < 4; i++) 
		{
			String temp = getRandString();
			result += temp;
			/** 获取随机颜色 **/
			g.setColor(new Color(20 + random.nextInt(110), 20 + random
					.nextInt(110), 20 + random.nextInt(110)));
			g.drawString(temp, 12 * i + 4, 16);
		}
		/** 获取HttpSession **/
		HttpSession session = ServletActionContext.getRequest().getSession(true);
		/** 把随机字符串放入session中 **/
		session.setAttribute(WebConstant.VERIFY_CODE, result);
		g.dispose();
		/** 向输出流中输出图片 **/
		ImageIO.write(image, "JPEG", response.getOutputStream());
		return Action.NONE;
	}

	/** 定义获得随机字符串的方法 **/
	private String getRandString() 
	{
		/** 定义生成一个0,1,2的随机数字 **/
		int rand = (int) Math.round(Math.random() * 2);
		long temp = 0;
		switch (rand) 
		{
			/** 生成大写字母: 暂去除 **/
			case 3:
				temp = Math.round(Math.random() * 25 + 65);
				return String.valueOf((char) temp);
				/** 生成小写字母 **/
			case 4:
				temp = Math.round(Math.random() * 25 + 97);
				return String.valueOf((char) temp);
				/** 生成数字 **/
			default:
				temp = Math.round(Math.random() * 9);
				return String.valueOf(temp);
		}
	}
}