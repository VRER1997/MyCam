package View;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Date;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;


import org.eclipse.swt.widgets.Label;

import core.Activator;

public class ShangchuanTest extends ViewPart {

	public static final String ID = "View.ShangchuanTest"; //$NON-NLS-1$
    String picname;
    Label lblNewLabel;
	public ShangchuanTest() {
	}

	/**
	 * Create contents of the view part.
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		
		lblNewLabel = new Label(container, SWT.BORDER);
		lblNewLabel.setBounds(118, 89, 161, 216);
		
		Button button = new Button(container, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				
				FileDialog fd = new FileDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),SWT.NONE);
				String path = fd.open();//打开一个浏览界面  返回该资源的路径  ---->源
				lblNewLabel.setImage(ResourceManager.getImage(path));//显示该图片
				
				//url uniform resource locator 统一资源定位器
				
				URL url = Activator.getDefault().getBundle().getResource("icons");//通过同意资源定位器的方式访问img文件 获取它的路径
				
				String target = "";//真正的源
				try {
				String p = FileLocator.toFileURL(url).toString().substring(6);//先把url转化成文件url 然后。url转化成字符串路径  --->目标  target
				System.out.println(path);//源  
				//截取后缀名
				
				int index = path.lastIndexOf(".");//找到.最后一次出现的位置
				
				String hz = path.substring(index);//根据点的位置截取后缀
				
				picname = new Date().getTime()+hz;//获取上传的图片名字
				 
				target = p+new Date().getTime()+hz;
				
				
				System.out.println(p+new Date().getTime()+".jpg");//真正的target
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				try {
					FileInputStream fis = new FileInputStream(path);//创建文件输入流 指向源(path) 从源拉取数据
					
					FileOutputStream fos = new FileOutputStream(target);//创建文件输出流 指向目标（target） 向目标写入数据
					
					
					//输入输出流对接
					
					
					//创建一个字节缓冲区
					byte[] by  = new byte[1024];
					
				
					while(true){
						
						int	num = fis.read(by);//从源中读取数据 存储在字节缓冲区中  并获取字节个数
//						read的方法在读取数据的时候 如果源中已经没有数据可以读了 它会返回-1
						if(num == -1){//如果num=-1 break跳出循环
							break;
						}
						
						
						fos.write(by, 0, num);//把字节缓冲区的数据写入到target中
						
					}
					
					
					
					
					fis.close();//关闭资源
					fos.close();//关闭资源
					
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
	
				
			
			}
		});
		button.setBounds(147, 329, 98, 30);
		button.setText("\u4E0A\u4F20");
		
		

		createActions();
		initializeToolBar();
		initializeMenu();
	}

	/**
	 * Create the actions.
	 */
	private void createActions() {
		// Create the actions
	}

	/**
	 * Initialize the toolbar.
	 */
	private void initializeToolBar() {
		IToolBarManager toolbarManager = getViewSite().getActionBars()
				.getToolBarManager();
	}

	/**
	 * Initialize the menu.
	 */
	private void initializeMenu() {
		IMenuManager menuManager = getViewSite().getActionBars()
				.getMenuManager();
	}

	@Override
	public void setFocus() {
		// Set the focus
	}
}
