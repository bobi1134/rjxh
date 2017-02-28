package cn.rjxh.utils.imgsrc;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ImgSrc {
    public static final Pattern PATTERN = Pattern.compile("<img\\s+(?:[^>]*)src\\s*=\\s*([^>]+)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);  
    public static List<String> getImgSrc(String html){   
        Matcher matcher = PATTERN.matcher(html);   
        List<String> list = new ArrayList<String>();   
        while(matcher.find()){   
            String group = matcher.group(1);
            if(group == null){   
                continue;   
            }   
            //   这里可能还需要更复杂的判断,用以处理src="...."内的一些转义符   
            if (group.startsWith("'")){   
                list.add(group.substring(1,   group.indexOf("'",   1)));   
            } else if(group.startsWith("\"")){   
                list.add(group.substring(1,   group.indexOf("\"",   1)));   
            } else{   
                list.add(group.split("\\s")[0]);  
            }   
        }   
        return list;   
    }
    
    public static void main(String[] args){   
        String   html   =   "<p>内容<img src='/rjxh/rx/images/AllUpdateImages/20160417/1460875881951016708.jpg' title='1460875881951016708.jpg' alt='logo.jpg'/></p><p>内容<img src='/rjxh/rx/images/AllUpdateImages/20160417/1460875881951016708.jpg' title='1460875881951016708.jpg' alt='logo.jpg'/></p><p>内容<img src='/rjxh/rx/images/AllUpdateImages/20160417/1460875881951016708.jpg' title='1460875881951016708.jpg' alt='logo.jpg'/></p>";
        //System.out.println(getImgSrc(html));   
        List<String> srcs = getImgSrc(html);
        for (String s : srcs) {
        	System.out.println(s.substring(s.length()-23, s.length()));
		}
    }  

}