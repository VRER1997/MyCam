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
				String path = fd.open();//��һ���������  ���ظ���Դ��·��  ---->Դ
				lblNewLabel.setImage(ResourceManager.getImage(path));//��ʾ��ͼƬ
				
				//url uniform resource locator ͳһ��Դ��λ��
				
				URL url = Activator.getDefault().getBundle().getResource("icons");//ͨ��ͬ����Դ��λ���ķ�ʽ����img�ļ� ��ȡ����·��
				
				String target = "";//������Դ
				try {
				String p = FileLocator.toFileURL(url).toString().substring(6);//�Ȱ�urlת�����ļ�url Ȼ��urlת�����ַ���·��  --->Ŀ��  target
				System.out.println(path);//Դ  
				//��ȡ��׺��
				
				int index = path.lastIndexOf(".");//�ҵ�.���һ�γ��ֵ�λ��
				
				String hz = path.substring(index);//���ݵ��λ�ý�ȡ��׺
				
				picname = new Date().getTime()+hz;//��ȡ�ϴ���ͼƬ����
				 
				target = p+new Date().getTime()+hz;
				
				
				System.out.println(p+new Date().getTime()+".jpg");//������target
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				try {
					FileInputStream fis = new FileInputStream(path);//�����ļ������� ָ��Դ(path) ��Դ��ȡ����
					
					FileOutputStream fos = new FileOutputStream(target);//�����ļ������ ָ��Ŀ�꣨target�� ��Ŀ��д������
					
					
					//����������Խ�
					
					
					//����һ���ֽڻ�����
					byte[] by  = new byte[1024];
					
				
					while(true){
						
						int	num = fis.read(by);//��Դ�ж�ȡ���� �洢���ֽڻ�������  ����ȡ�ֽڸ���
//						read�ķ����ڶ�ȡ���ݵ�ʱ�� ���Դ���Ѿ�û�����ݿ��Զ��� ���᷵��-1
						if(num == -1){//���num=-1 break����ѭ��
							break;
						}
						
						
						fos.write(by, 0, num);//���ֽڻ�����������д�뵽target��
						
					}
					
					
					
					
					fis.close();//�ر���Դ
					fos.close();//�ر���Դ
					
					
					
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
