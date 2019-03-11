package Dialog;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.swing.Box;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.NewWizardAction;

import Model.Userfo;
import Utils.BoxUtils;
import Utils.DBUtils;

import core.Activator;

public class CountDetailss extends Dialog {

	protected Object result;
	protected Shell shell;
	private Text text_4;
	private Text text_5;
	private Text text_6;
	private Text text_7;

	public static  List<Map<String, Object>> list;
	public static Userfo userfo = new Userfo();
	public static  String pname = Login.username;
	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public CountDetailss(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shell.open();
		shell.layout();
		Display display = getParent().getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shell = new Shell(getParent(), getStyle());
		shell.setSize(559, 711);
		shell.setText("\u8D26\u6237\u4FE1\u606F");
		try {
			DBUtils dbUtils = new DBUtils();
			String sql = "select * from userfo where usernames = '"+Login.username+"'";
			list = dbUtils.query(sql);
			
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		Label label = new Label(shell, SWT.NONE);
		label.setText("\u8D26\u6237\u4FE1\u606F");
		label.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.BOLD));
		label.setBounds(73, 30, 80, 27);
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		label_1.setBounds(60, 30, 7, 27);
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setText("\u7528\u6237\u540D");
		label_2.setBounds(64, 89, 76, 20);
		
		text_4 = new Text(shell, SWT.BORDER | SWT.READ_ONLY);
		text_4.setBounds(159, 86, 187, 26);
		text_4.setText(list.get(0).get("usernames").toString());
		
		Label label_3 = new Label(shell, SWT.NONE);
		label_3.setText("\u5934\u50CF");
		label_3.setBounds(64, 186, 76, 20);
		
		final Label label_4 = new Label(shell, SWT.BORDER);		
		label_4.setBounds(158, 141, 130, 122);
		
		String pnameString = list.get(0).get("headpicture").toString();
		userfo.setHeadpicture(pnameString);
		if(!pnameString.equals("")){
			label_4.setImage(ResourceManager.getPluginImage("Mycam", "Img/"+pnameString+""));
		}
		
		Button button = new Button(shell, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				FileDialog fd = new FileDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),SWT.NONE);
				String path = fd.open();//打开一个浏览界面  返回该资源的路径  ---->源
				label_4.setImage(ResourceManager.getImage(path));//显示该图片
				
				//url uniform resource locator 统一资源定位器
				
				URL url = Activator.getDefault().getBundle().getResource("Img");//通过同意资源定位器的方式访问img文件 获取它的路径
				
				if(!path.equals(null)){
			int index = path.lastIndexOf("\\");//找到.最后一次出现的位置
			
			String hz = path.substring(index+1);//根据点的位置截取后缀
			userfo.setHeadpicture(hz);
			
			
//			picname = new Date().getTime()+hz;//获取上传的图片名字
//			 
//			target = p+new Date().getTime()+hz;
//			
			//System.out.println(hz);
			}//System.out.println(p+new Date().getTime()+".jpg");//真正的target		
				
//				try {
//					FileInputStream fis = new FileInputStream(path);//创建文件输入流 指向源(path) 从源拉取数据
//					
//					FileOutputStream fos = new FileOutputStream(target);//创建文件输出流 指向目标（target） 向目标写入数据
//					
//					
//					//输入输出流对接				
//					//创建一个字节缓冲区
//					byte[] by  = new byte[1024];			
//				
//					while(true){
//						
//						int	num = fis.read(by);//从源中读取数据 存储在字节缓冲区中  并获取字节个数
////						read的方法在读取数据的时候 如果源中已经没有数据可以读了 它会返回-1
//						if(num == -1){//如果num=-1 break跳出循环
//							break;
//						}						
//						
//						fos.write(by, 0, num);//把字节缓冲区的数据写入到target中						
//					}			
//					
//					fis.close();//关闭资源
//					fos.close();//关闭资源			
//					
//					
//				} catch (Exception e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}			
			}
		});
		button.setText("\u9009\u62E9");
		button.setBounds(309, 186, 98, 30);
		
		Label label_5 = new Label(shell, SWT.NONE);
		label_5.setText("\u5BC6\u7801");
		label_5.setBounds(60, 302, 76, 20);
		
		text_5 = new Text(shell, SWT.BORDER | SWT.READ_ONLY);
		text_5.setBounds(154, 302, 187, 26);
		text_5.setText(list.get(0).get("passwords").toString());
		
		Link link = new Link(shell, 0);
		link.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ChangePass changePass = new ChangePass(new Shell(), SWT.CLOSE);
				changePass.open();
				text_5.setText(userfo.getPassword());
			}
		});
		link.setText("<a>\u4FEE\u6539\u5BC6\u7801</a>");
		link.setBounds(381, 302, 66, 20);
		
		Label label_6 = new Label(shell, SWT.NONE);
		label_6.setText("\u7ED1\u5B9A\u624B\u673A\u53F7");
		label_6.setBounds(60, 360, 76, 20);
		
		text_6 = new Text(shell, SWT.BORDER | SWT.READ_ONLY);
		text_6.setBounds(154, 360, 187, 26);
		text_6.setText(list.get(0).get("phoneNumber").toString());
		
		Link link_1 = new Link(shell, 0);
		link_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ChangePhong changePhong = new ChangePhong(new Shell(), SWT.CLOSE);
				changePhong.open();
				text_6.setText(userfo.getPhonenumber());
			}
		});
		link_1.setText("<a>\u4FEE\u6539\u7ED1\u5B9A\u624B\u673A\u53F7</a>");
		link_1.setBounds(381, 360, 105, 20);
		
		Link link_2 = new Link(shell, 0);
		link_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ChangEmail changEmail = new ChangEmail(new Shell(), SWT.CLOSE);
				changEmail.open();
				text_7.setText(userfo.getEmail());
			}
		});
		link_2.setText("<a>\u4FEE\u6539\u7ED1\u5B9A\u90AE\u7BB1</a>");
		link_2.setBounds(381, 404, 105, 20);
		
		text_7 = new Text(shell, SWT.BORDER | SWT.READ_ONLY);
		text_7.setBounds(154, 404, 187, 26);
		text_7.setText(list.get(0).get("email").toString());
		
		Label label_7 = new Label(shell, SWT.NONE);
		label_7.setText("\u7ED1\u5B9A\u90AE\u7BB1");
		label_7.setBounds(60, 410, 76, 20);
		
		Label label_8 = new Label(shell, SWT.NONE);
		label_8.setText("\u4F1A\u5458\u60C5\u51B5");
		label_8.setBounds(60, 464, 76, 20);
		
		boolean b = (Boolean) list.get(0).get("is_VIP");
		userfo.setIs_VIP(b);
		Button button_1 = new Button(shell, SWT.RADIO);
		button_1.setText("\u662F");
		button_1.setBounds(158, 464, 119, 20);		
		
		Button button_2 = new Button(shell, SWT.RADIO);
		button_2.setText("\u5426");
		button_2.setBounds(158, 507, 54, 20);
		
		Label label_9 = new Label(shell, SWT.NONE);
		label_9.setText("\u4F1A\u5458\u5373\u53EF\u4EAB\u53D7\u8D2D\u7968\u516B\u6298\u4F18\u60E0");
		label_9.setBounds(218, 507, 213, 20);
		
		Button button_3 = new Button(shell, SWT.NONE);
		button_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				UpToVIP upToVIP = new UpToVIP(new Shell(), SWT.CLOSE);
				upToVIP.open();
			}
		});
		button_3.setText("\u5347\u7EA7\u4E3A\u4F1A\u5458");
		button_3.setBounds(158, 544, 98, 30);

		button_1.setEnabled(true);
		button_2.setEnabled(true);
		button_3.setEnabled(true);
		if(b){
			button_1.setSelection(true);
			button_2.setEnabled(false);
			button_3.setEnabled(false);
		}else {
			button_1.setEnabled(false);
			button_2.setSelection(true);
		}
		
		
		Button button_4 = new Button(shell, SWT.NONE);
		button_4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				DBUtils dbUtils = new DBUtils();
				String sql = "update userfo set passwords = '"+text_5.getText()+"',phoneNumber = '"+text_6.getText()+"', " +
						"email = '"+text_7.getText()+"', headpicture = '"+userfo.getHeadpicture()+"' where usernames = '"+pname+"'";
				int ret = dbUtils.update(sql);
				if(ret > 0){
					BoxUtils.showBox("账号信息保存成功！！！");
					shell.dispose();
				}else {
					BoxUtils.showBox("保存失败！");
				}
			}
		});
		button_4.setText("\u4FDD\u5B58\u4FE1\u606F");
		button_4.setBounds(166, 615, 213, 30);
		
		Label label_10 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_10.setBounds(60, 63, 426, 2);
		
		
		


	}

}
