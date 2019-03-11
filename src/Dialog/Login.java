package Dialog;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.management.relation.Role;
import javax.xml.crypto.dsig.keyinfo.KeyValue;

import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Button;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.keys.Key;

import Actions.Auserfo;
import Model.Userfo;
import Utils.BoxUtils;
import Utils.DBUtils;
import Utils.ShowViewUtils;
import View.RootMenu;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

public class Login extends Dialog {

	protected Object result;
	protected Shell shell;
	private Text text;
	private Text text_1;

	public static Userfo userfo;
	protected Object res;
	public static boolean is_vip;
	public static boolean is_root;
	public static String username;
	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public Login(Shell parent, int style) {
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
		return res;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shell = new Shell(getParent(), SWT.DIALOG_TRIM);
		shell.setSize(529, 325);
		shell.setText("\u767B\u5F55");
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setSize(525, 290);
		composite.setBackgroundMode(SWT.INHERIT_DEFAULT);
		composite.setBackgroundImage(ResourceManager.getPluginImage("Mycam", "icons/13857113_164644350163_2.png"));
		composite.setLayout(null);
		
		final Label label = new Label(composite, SWT.BORDER);
		label.setImage(ResourceManager.getPluginImage("Mycam", "icons/yh (2).png"));
		label.setBounds(40, 50, 130, 130);
		
		text = new Text(composite, SWT.BORDER);
		text.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_DARK_SHADOW));
		text.setText("用户名");
		text.addFocusListener(new FocusAdapter() {
			private List<Map<String, Object>> list;
			@Override
			public void focusLost(FocusEvent e) {
				if(text.getText().equals(""))
				text.setText("用户名");
				else {
					try {
						DBUtils dbUtils = new DBUtils();
						String sql = "select * from userfo where usernames = '"+text.getText()+"'";
						list = dbUtils.query(sql);
						if(list.size() == 0) BoxUtils.showBox("对不起，用户名不存在！");
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					if(!text.getText().equals(null) && list.size() > 0){
						String string = list.get(0).get("headpicture").toString();
						if(!string.equals("")){
							label.setImage(ResourceManager.getPluginImage("Mycam", "Img/"+string+""));
						}
					}				
				}
				}
			@Override
			public void focusGained(FocusEvent e) {
				if(text.getText().equals("用户名"))
				text.setText("");
			}
		});
		text.setBounds(181, 65, 221, 26);
		
		text_1 = new Text(composite, SWT.BORDER | SWT.PASSWORD);
		text_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_DARK_SHADOW));
//		text_1.setText("密码");
//		text_1.addFocusListener(new FocusAdapter() {
//			@Override
//			public void focusLost(FocusEvent e) {
//				if(text_1.getText().equals(""))
//				text_1.setText("密码");
//			}
//			@Override
//			public void focusGained(FocusEvent e) {
//				if(text_1.getText().equals("密码"))
//				text_1.setText("");
//			}
//		});
		text_1.setBounds(181, 131, 221, 26);
		
		Link link = new Link(composite, 0);
		link.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				SignUp signUp = new SignUp(new Shell(), SWT.CLOSE);
				signUp.open();
			}
		});
		link.setText("<a>\u6CE8\u518C\u8D26\u53F7</a>");
		link.setBounds(408, 71, 66, 20);
		
		Link link_1 = new Link(composite, 0);
		link_1.setText("<a>\u627E\u56DE\u5BC6\u7801</a>");
		link_1.setBounds(408, 137, 66, 20);
		
		Button button = new Button(composite, SWT.NONE);
//		button.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyPressed(KeyEvent e) {
//				if(e.keyCode == SWT.CR){
//					
//				}
//			}
//		});
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					List<Map<String, Object>> list = Auserfo.Login(text.getText().trim(), text_1.getText().trim());
					if(list.size() > 0){						
						is_vip = (Boolean) list.get(0).get("is_VIP");
						is_root = (Boolean) list.get(0).get("is_root");
						username = list.get(0).get("usernames").toString();
						res = "登录成功";
						shell.dispose();
					}else {
						BoxUtils.showBox("对不起，用户名不存在或密码错误！");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setImage(ResourceManager.getPluginImage("Mycam", "icons/\u6355\u83B72.PNG"));
		button.setBounds(163, 207, 221, 30);

	}

}
