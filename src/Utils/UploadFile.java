package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;

import core.Activator;

public class UploadFile {
	
	/**
	 * @描述：用原来用户上传的文件名修改成一个新的文件名
	 * @作者：乐老师
	 * @开发时间： 2013-4-20 上午10:57:01
	 * @方法参数： @param fileName
	 * @方法参数： @return
	 * @方法返回值：String
	 */
	public static String updateName(String fileName){
		String name = "没有名字";
		try{
			if(fileName.equals("") || fileName == null){
				return name;
			}else{
				 String  houzhui = fileName.substring(fileName.lastIndexOf("."));
				 return (int)(Math.random() * 100000) + houzhui;
			}
		}catch(Exception e){
			e.printStackTrace();
			
			return name;
		}
	}
	
	/**
	 * @描述：完成文件上传到upload
	 * @作者：乐老师
	 * @开发时间： 2013-4-20 上午11:10:38
	 * @方法参数： @param file
	 * @方法参数： @param fileName
	 * @方法返回值：void
	 */
	public static void uploadFile(File file,String fileName){
		
		try{
			
			FileInputStream input = new FileInputStream(file);
			
			//String path = ServletActionContext.getRequest().getRealPath("/upload");
			
			/* 获得icons目录的位置 */
			URL url = Activator.getDefault().getBundle().getResource("icons");
			System.out.println("url==="+url);
			String str = "";
			try {
				System.out.println("FileLocator.toFileURL(url).toString():"+FileLocator.toFileURL(url).toString());
				str = FileLocator.toFileURL(url).toString().substring(6);
				System.out.println("str==="+str);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			File file1 = new File(str,fileName);
			
			FileOutputStream out = new FileOutputStream(file1);
			
			byte [] bb = new byte[ (int) file.length()];
			int len = 0;
			while((len = input.read(bb)) > 0){
				out.write(bb,0,len);
			}
			
			out.flush();
			out.close();
			input.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}

}
