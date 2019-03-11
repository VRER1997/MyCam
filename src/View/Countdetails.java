package View;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Button;

public class Countdetails extends ViewPart {

	public static final String ID = "View.Countdetails"; //$NON-NLS-1$
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;

	public Countdetails() {
	}

	/**
	 * Create contents of the view part.
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		{
			Label label = new Label(container, SWT.NONE);
			label.setText("\u8D26\u6237\u4FE1\u606F");
			label.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.BOLD));
			label.setBounds(90, 42, 80, 27);
		}
		{
			Label label = new Label(container, SWT.NONE);
			label.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
			label.setBounds(77, 42, 7, 27);
		}
		
		Label label = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setBounds(75, 85, 406, 2);
		
		Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setText("用户名");
		lblNewLabel.setBounds(94, 117, 76, 20);
		
		Label lblNewLabel_1 = new Label(container, SWT.NONE);
		lblNewLabel_1.setBounds(90, 330, 76, 20);
		lblNewLabel_1.setText("密码");
		
		Label lblNewLabel_2 = new Label(container, SWT.NONE);
		lblNewLabel_2.setBounds(90, 388, 76, 20);
		lblNewLabel_2.setText("绑定手机号");
		
		Label lblNewLabel_3 = new Label(container, SWT.NONE);
		lblNewLabel_3.setBounds(90, 438, 76, 20);
		lblNewLabel_3.setText("绑定邮箱");
		
		text = new Text(container, SWT.BORDER);
		text.setBounds(189, 114, 187, 26);
		
		text_1 = new Text(container, SWT.BORDER);
		text_1.setBounds(184, 330, 187, 26);
		
		text_2 = new Text(container, SWT.BORDER);
		text_2.setBounds(184, 388, 187, 26);
		
		text_3 = new Text(container, SWT.BORDER);
		text_3.setBounds(184, 432, 187, 26);
		
		Link link = new Link(container, SWT.NONE);
		link.setBounds(411, 330, 66, 20);
		link.setText("<a>修改密码</a>");
		
		Link link_1 = new Link(container, 0);
		link_1.setText("<a>修改绑定手机号</a>");
		link_1.setBounds(411, 388, 105, 20);
		
		Link link_2 = new Link(container, 0);
		link_2.setText("<a>修改绑定邮箱</a>");
		link_2.setBounds(411, 432, 105, 20);
		
		Label label_1 = new Label(container, SWT.NONE);
		label_1.setBounds(94, 214, 76, 20);
		label_1.setText("\u5934\u50CF");
		
		Label label_2 = new Label(container, SWT.BORDER);
		label_2.setBounds(188, 169, 115, 122);
		
		Button btnNewButton = new Button(container, SWT.NONE);
		btnNewButton.setBounds(339, 214, 98, 30);
		btnNewButton.setText("选择");
		
		Label label_3 = new Label(container, SWT.NONE);
		label_3.setBounds(90, 492, 76, 20);
		label_3.setText("\u4F1A\u5458\u60C5\u51B5");
		
		Button button = new Button(container, SWT.RADIO);
		button.setBounds(188, 492, 119, 20);
		button.setText("\u662F");
		
		Button button_1 = new Button(container, SWT.RADIO);
		button_1.setBounds(188, 535, 54, 20);
		button_1.setText("\u5426");
		
		Button btnNewButton_1 = new Button(container, SWT.NONE);
		btnNewButton_1.setBounds(188, 572, 98, 30);
		btnNewButton_1.setText("升级为会员");
		
		Label label_4 = new Label(container, SWT.NONE);
		label_4.setBounds(248, 535, 213, 20);
		label_4.setText("\u4F1A\u5458\u5373\u53EF\u4EAB\u53D7\u8D2D\u7968\u516B\u6298\u4F18\u60E0");
		
		Button btnNewButton_2 = new Button(container, SWT.NONE);
		btnNewButton_2.setBounds(163, 643, 213, 30);
		btnNewButton_2.setText("保存信息");

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
