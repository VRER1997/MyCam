package Dialog;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;


import javax.print.attribute.standard.Media;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.events.TraverseEvent;

import Model.Userfo;
import Utils.BoxUtils;
import Utils.DBUtils;
import Utils.SignUpShowUtils;

import Actions.Auserfo;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

class bb{
	public bb(){
		for(int i = 0; i < 6; i++){
			b[i] = false; 
		}
	}
	public boolean b[] = new boolean[6];
}
public class SignUp extends Dialog {

	protected Object result;
	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text txtqqcom;
	private Text text_4;
	private Text text_5;
	private Text text_6;
	private Text text_7;
	
	private boolean is_v;
	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public SignUp(Shell parent, int style) {		
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
		shell.setSize(497, 673);
		shell.setText("\u8D26\u53F7\u6CE8\u518C");
		
		final bb bb1 = new bb();
		Label label = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setBounds(22, 55, 414, 2);
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.BOLD));
		lblNewLabel.setText("\u6CE8\u518C\u8D26\u53F7");
		lblNewLabel.setBounds(36, 22, 80, 27);
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		label_1.setBounds(23, 22, 7, 27);
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 11, SWT.NORMAL));
		lblNewLabel_1.setBounds(51, 80, 62, 20);
		lblNewLabel_1.setText("*\u7528\u6237\u540D");
		
		Label lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 11, SWT.NORMAL));
		lblNewLabel_2.setBounds(66, 150, 50, 27);
		lblNewLabel_2.setText("*\u5BC6\u7801");
		
		Label lblNewLabel_3 = new Label(shell, SWT.NONE);
		lblNewLabel_3.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 11, SWT.NORMAL));
		lblNewLabel_3.setBounds(22, 231, 91, 20);
		lblNewLabel_3.setText("*\u786E\u8BA4\u5BC6\u7801");
		
		Label lblNewLabel_5 = new Label(shell, SWT.NONE);
		lblNewLabel_5.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 11, SWT.NORMAL));
		lblNewLabel_5.setBounds(77, 281, 36, 20);
		lblNewLabel_5.setText("邮箱");
		
		Label lblNewLabel_6 = new Label(shell, SWT.NONE);
		lblNewLabel_6.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 11, SWT.NORMAL));
		lblNewLabel_6.setBounds(39, 344, 77, 20);
		lblNewLabel_6.setText("手机号码");
		
		final Label lblNewLabel_7 = new Label(shell, SWT.NONE);		
		lblNewLabel_7.setImage(ResourceManager.getPluginImage("Mycam", "icons/\u6CE8\u518C\u6309\u94AE.PNG"));
		lblNewLabel_7.setBounds(36, 532, 382, 60);
		
		final Button btnCheckButton = new Button(shell, SWT.CHECK);
		bb1.b[5] = true;
		btnCheckButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(btnCheckButton.getSelection()){
					lblNewLabel_7.setImage(ResourceManager.getPluginImage("Mycam", "icons/\u6CE8\u518C\u6309\u94AE.PNG"));
				}else {
					lblNewLabel_7.setImage(ResourceManager.getPluginImage("Mycam", "icons/未选中注册按钮.PNG"));
				}
				bb1.b[5] = btnCheckButton.getSelection();
				System.out.println(bb1.b[5]);
			}
		});
		btnCheckButton.setBounds(77, 506, 294, 20);
		btnCheckButton.setText("\u6211\u5DF2\u9605\u8BFB\u5E76\u540C\u610F\u76F8\u5173\u670D\u52A1\u6761\u6B3E\u548C\u9690\u79C1\u653F\u7B56");
		btnCheckButton.setSelection(true);
		
		final Label lblNewLabel_4 = new Label(shell, SWT.NONE);
		lblNewLabel_4.setBounds(124, 110, 25, 27);
		
		final Label label_2 = new Label(shell, SWT.NONE);		
		label_2.setBounds(353, 80, 25, 27);
		
		final Label lblNewLabel_8 = new Label(shell, SWT.NONE);
		lblNewLabel_8.setBounds(155, 116, 281, 20);
		text = new Text(shell, SWT.BORDER);
		text.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lblNewLabel_4.setEnabled(true);
				lblNewLabel_4.setImage(ResourceManager.getPluginImage("Mycam", "icons/\u8B66\u544A.PNG"));
				lblNewLabel_8.setText("4~6个字符，不能以数字开头");
			}
			@Override
			public void focusLost(FocusEvent e) {
				bb1.b[0] = false;
				String string = text.getText();
				if(!(string.equals("") || string.equals(" "))) {
				if(string.charAt(0) > '0' && string.charAt(0) < '9'){
					lblNewLabel_4.setImage(ResourceManager.getPluginImage("Mycam", "icons/\u8B66\u544A.PNG"));
					lblNewLabel_8.setText("不能以数字开头");
					label_2.setText("");
				}else if(string.length() < 4){
					lblNewLabel_4.setImage(ResourceManager.getPluginImage("Mycam", "icons/\u8B66\u544A.PNG"));
					lblNewLabel_8.setText("用户名太短");
					label_2.setText("");
				}else if(string.length() > 16){
					lblNewLabel_4.setImage(ResourceManager.getPluginImage("Mycam", "icons/\u8B66\u544A.PNG"));
					lblNewLabel_8.setText("用户名太长");
					label_2.setText("");
				}else {
					
					try {
						DBUtils dbUtils = new DBUtils();
						List<Map<String,Object>> list = dbUtils.query("select * from userfo where usernames = '"+text.getText()+"' ");
						if(list.size() > 0){
							lblNewLabel_4.setImage(ResourceManager.getPluginImage("Mycam", "icons/\u8B66\u544A.PNG"));
							lblNewLabel_8.setText("对不起，该用户名已存在");
							label_2.setText("");
						}else {
						    label_2.setImage(ResourceManager.getPluginImage("Mycam", "icons/\u6B63\u786E.PNG"));
						    lblNewLabel_4.setImage(ResourceManager.getPluginImage("Mycam", "icons/White.jpg"));
						    lblNewLabel_8.setText("");
						    bb1.b[0] = true;
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}									
				}
				}else {
					lblNewLabel_4.setImage(ResourceManager.getPluginImage("Mycam", "icons/\u8B66\u544A.PNG"));
					lblNewLabel_8.setText("4~6个字符，不能以数字开头");
				}
			}
		});
		text.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		text.setBounds(119, 75, 223, 35);
		
		final Label label_3 = new Label(shell, SWT.NONE);
		label_3.setBounds(353, 146, 25, 27);
		
		final Label label_4 = new Label(shell, SWT.NONE);
		label_4.setBounds(384, 153, 76, 20);
		text_1 = new Text(shell, SWT.BORDER | SWT.PASSWORD);
		
		text_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				bb1.b[1] = false;
				String string = text_1.getText();
				if(string.equals("")){
					label_3.setImage(ResourceManager.getPluginImage("Mycam", "icons/\u8B66\u544A.PNG"));
					label_4.setText("不能为空");
				}else {
					label_3.setImage(ResourceManager.getPluginImage("Mycam", "icons/\u6B63\u786E.PNG"));
					label_4.setText("");
					bb1.b[1] = true;
				}	
			}
		});
//		text_1.addTraverseListener(new TraverseListener() {
//			public void keyTraversed(TraverseEvent arg0) {
//				System.out.println(123);
//			}
//		});
		text_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				text_5.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
				text_6.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
				text_7.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
				int s = Auserfo.getscore(text_1.getText());
				if (s == 0) {
					text_5.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
					text_6.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
					text_7.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
				}else if(s < 500){				
					text_5.setBackground(SWTResourceManager.getColor(255, 99, 71));		
					text_6.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
					text_7.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
				}else if (s < 1500) {
					text_5.setBackground(SWTResourceManager.getColor(218, 165, 32));
					text_6.setBackground(SWTResourceManager.getColor(218, 165, 32));
					text_7.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
				}else {
					text_5.setBackground(SWTResourceManager.getColor(50, 205, 50));
					text_6.setBackground(SWTResourceManager.getColor(50, 205, 50));
					text_7.setBackground(SWTResourceManager.getColor(50, 205, 50));
				}
			
		  }
		});
		text_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		text_1.setBounds(119, 138, 223, 35);
		
		final Label label_5 = new Label(shell, SWT.NONE);
		label_5.setBounds(353, 224, 25, 27);
		
		final Label label_6 = new Label(shell, SWT.NONE);
		label_6.setBounds(384, 231, 97, 20);		
		
		text_2 = new Text(shell, SWT.BORDER | SWT.PASSWORD);
		text_2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				bb1.b[2] = false;
				if(text_1.getText().equals(text_2.getText())){
					label_5.setImage(ResourceManager.getPluginImage("Mycam", "icons/\u6B63\u786E.PNG"));
					label_6.setText("");
					bb1.b[2] = true;
				}else{
					label_5.setImage(ResourceManager.getPluginImage("Mycam", "icons/\u8B66\u544A.PNG"));
					label_6.setText("与密码不一致");
				}
			}
		});
		text_2.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		text_2.setBounds(122, 221, 223, 35);

		final Label label_7 = new Label(shell, SWT.NONE);
		label_7.setBounds(119, 313, 25, 21);
		
		final Label label_8 = new Label(shell, SWT.NONE);
		label_8.setBounds(150, 313, 281, 20);

		final Label label_9 = new Label(shell, SWT.NONE);
		label_9.setBounds(353, 281, 25, 27);
		
	
		txtqqcom = new Text(shell, SWT.BORDER);
		txtqqcom.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				bb1.b[3] = false;
				String s[] = {"qq.com","163.com","126.com","139.com","sina.com","139.com"
						    ,"hotmail.com","sohu.com","gmail.com"};
				int p = 0, q = 0;
				for(int i = 0; i < txtqqcom.getText().length(); i++){
					if(txtqqcom.getText().charAt(i) == '@'){
						p++;
					}
				}
				if(p == 1){
					 String string[] = txtqqcom.getText().split("@");
					 for(int i = 0; i < s.length; i++){
						 if(string[1].equals(s[i])){
							 q = 1;
						 }
					 }
				}
				if(p == 1 && q == 1){
					SignUpShowUtils.showCorrect(label_9, label_8,label_7);
					label_7.setText("");
					bb1.b[3] = true;
				}else{
					SignUpShowUtils.showErrort(label_7, label_8, "请输入正确的邮箱格式",label_9);
					label_9.setText("");
				}
			}
		});
		txtqqcom.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		txtqqcom.setBounds(124, 276, 223, 35);
		
		final Label label_10 = new Label(shell, SWT.NONE);
		label_10.setBounds(119, 386, 25, 21);
		
		final Label label_11 = new Label(shell, SWT.NONE);
		label_11.setBounds(155, 386, 276, 20);
		
		final Label label_12 = new Label(shell, SWT.NONE);
		label_12.setBounds(353, 354, 25, 27);
		
		text_4 = new Text(shell, SWT.BORDER);
		text_4.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				bb1.b[4] = false;
				String  string = text_4.getText();
				int p = 1;
				if(string.length() != 11) p = 0;
				for(int i = 0; i < string.length(); i++){
					if(string.charAt(i) < '0' || string.charAt(i) > '9') p = 0;
				}
				if(p == 0){
					SignUpShowUtils.showErrort(label_10, label_11, "请输入正确的手机号码格式",label_12);
				}else {
					SignUpShowUtils.showCorrect(label_12, label_11,label_10);
					bb1.b[4] = true;
				}
			}
		});
		text_4.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		text_4.setBounds(122, 339, 223, 35);
		
		text_5 = new Text(shell, SWT.BORDER | SWT.READ_ONLY | SWT.CENTER);		
		text_5.setForeground(SWTResourceManager.getColor(0, 0, 0));
		text_5.setText("\u5F31");
		text_5.setBounds(122, 177, 67, 22);
		
		text_6 = new Text(shell, SWT.BORDER | SWT.READ_ONLY | SWT.CENTER);		
		text_6.setText("\u4E2D");
		text_6.setBounds(195, 177, 77, 22);
		text_6.setForeground(SWTResourceManager.getColor(0, 0, 0));
		
		text_7 = new Text(shell, SWT.BORDER | SWT.READ_ONLY | SWT.CENTER);
		text_7.setForeground(SWTResourceManager.getColor(0, 0, 0));
		text_7.setText("\u5F3A");
		text_7.setBounds(278, 177, 67, 22);		
		
		Label label_13 = new Label(shell, SWT.RIGHT);
		label_13.setText("\u6CE8\u518C\u4E3A");
		label_13.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 11, SWT.NORMAL));
		label_13.setBounds(39, 423, 77, 20);
		
		is_v = false;
		Button btnRadioButton = new Button(shell, SWT.RADIO);
		btnRadioButton.setBounds(124, 426, 119, 20);
		btnRadioButton.setText("\u7528\u6237");
		
		final Button btnRadioButton_1 = new Button(shell, SWT.RADIO);
		btnRadioButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(btnRadioButton_1.getSelection()) is_v = true;
			}
		});
		btnRadioButton_1.setBounds(124, 468, 119, 20);
		btnRadioButton_1.setText("\u5F71\u9662\u7BA1\u7406\u5458");
		
		
		lblNewLabel_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				int ok = 1;
				for(int i = 0; i < 3; i++){
					if(bb1.b[i] == false) ok = 1;
				}
				if(!(txtqqcom.getText().equals("") || bb1.b[3]) ) ok = 0;
				if(!(text_4.getText().equals("") || bb1.b[4]) ) ok = 0;
				if(!bb1.b[5]) ok = 0;
//				System.out.println(ok);
//				for(int i = 0; i < 6; i++){
//					System.out.println(bb1.b[i]);
//				}
				if(ok == 1){
					Userfo userfo = new Userfo(text.getText(), text_1.getText(), txtqqcom.getText(), text_4.getText(), is_v);
					try {
						int ret = Auserfo.addUser(userfo);
						if(ret > 0){
							BoxUtils.showBox("注册成功");
							shell.dispose();
						}else {
							BoxUtils.showBox("注册失败");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		
	
	}
}
