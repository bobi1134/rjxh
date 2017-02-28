package cn.rjxh.utils.imgsrc;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
public class AllFilesName {
	
	 public static List<String> showAllFiles(File dir) throws Exception{
		 List<String> list = new ArrayList<String>();  
		 File[] fs = dir.listFiles();
		 for(int i=0; i<fs.length; i++){
			 //System.out.println(fs[i].getAbsolutePath());
			 	if(fs[i].isDirectory()){
			 		try{
			 			File[] files = fs[i].listFiles();
			 			for (int j = 0; j < files.length; j++) {
			 				System.out.println(files[i].getAbsolutePath());
			 				System.out.println(files[i].getName());
			 				list.add(files[i].getName());
						}
			 			showAllFiles(fs[i]);
			 		}catch(Exception e){}
			 	}
		 }
		 return list;
	 }
	 
	 
	 public static void main(String[] args) throws Exception {
		 //递归显示C盘下所有文件夹及其中文件
		 File root = new File("e:\\Test");
		 List<String> imgs = showAllFiles(root);
		 for (String s : imgs) {
			System.out.println(s);
		}
	 }
}