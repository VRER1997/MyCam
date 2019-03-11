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
	 * @��������ԭ���û��ϴ����ļ����޸ĳ�һ���µ��ļ���
	 * @���ߣ�����ʦ
	 * @����ʱ�䣺 2013-4-20 ����10:57:01
	 * @���������� @param fileName
	 * @���������� @return
	 * @��������ֵ��String
	 */
	public static String updateName(String fileName){
		String name = "û������";
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
	 * @����������ļ��ϴ���upload
	 * @���ߣ�����ʦ
	 * @����ʱ�䣺 2013-4-20 ����11:10:38
	 * @���������� @param file
	 * @���������� @param fileName
	 * @��������ֵ��void
	 */
	public static void uploadFile(File file,String fileName){
		
		try{
			
			FileInputStream input = new FileInputStream(file);
			
			//String path = ServletActionContext.getRequest().getRealPath("/upload");
			
			/* ���iconsĿ¼��λ�� */
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
