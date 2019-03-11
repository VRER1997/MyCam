package Dialog;

import javax.swing.Box;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import Utils.BoxUtils;
import Utils.DBUtils;
import Utils.ShowViewUtils;

public class UpToVIP extends Dialog {

	protected Object result;
	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;
	private int ok;
	private int kase;
	

	
	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public UpToVIP(Shell parent, int style) {
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
		shell.setSize(819, 525);
		shell.setText("\u5347\u7EA7\u4F1A\u5458\u9875");
		
		Label label = new Label(shell, SWT.NONE);
		label.setText("\u4EB2\u7231\u7684");
		label.setBounds(81, 33, 45, 20);
		
		Link link = new Link(shell, SWT.NONE);
		link.setBounds(132, 33, 66, 20);
		link.setText("<a>"+CountDetailss.pname+"</a>");
		
		Label lblmycam = new Label(shell, SWT.NONE);
		lblmycam.setBounds(216, 33, 486, 20);
		lblmycam.setText("\u611F\u8C22\u60A8\u9009\u62E9\u6210\u4E3AMycam\u7684\u4F1A\u5458\uFF0C\u5B8C\u6210\u4EE5\u4E0B\u7684\u6B65\u9AA4\uFF0C\u5373\u53EF\u6210\u4E3A\u6211\u4EEC\u4E07\u5343\u4F1A\u5458\u4E2D\u7684\u4E00\u5458\uFF0C\u5C0A\u4EAB\u8D2D\u7968\u516B\u6298\u7684\u4F18\u539A\u5F85\u9047");
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setBounds(132, 126, 76, 20);
		label_1.setText("\u4ED8\u6B3E\u65B9\u5F0F");
		
		final Button button = new Button(shell, SWT.RADIO);		
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(button.getSelection()){
					text.setEnabled(true);
					text_1.setEnabled(false);
				}
			}
		});
		button.setBounds(228, 126, 66, 20);
		button.setText("\u652F\u4ED8\u5B9D");
		button.setSelection(true);
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(410, 123, 183, 26);
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setBounds(328, 126, 76, 20);
		label_2.setText("\u652F\u4ED8\u5B9D\u8D26\u53F7");
		
		final Button button_1 = new Button(shell, SWT.RADIO);	
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(button_1.getSelection()){
				    text_1.setEnabled(true);
					text.setEnabled(false);
				}
			}
		});
		button_1.setBounds(228, 167, 76, 20);
		button_1.setText("\u94F6\u884C\u5361");
		
		Label label_3 = new Label(shell, SWT.NONE);
		label_3.setBounds(328, 167, 76, 20);
		label_3.setText("\u94F6\u884C\u5361\u8D26\u53F7");
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(410, 161, 183, 26);
		ok = 0;
		Button button_2 = new Button(shell, SWT.NONE);
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				BoxUtils.showBox("付款成功！！！请点击下方按钮获取会员卡号！");
				ok = 1;
			}
		});
		button_2.setBounds(352, 222, 98, 30);
		button_2.setText("\u4ED8\u6B3E");
		
		final Button button_3 = new Button(shell, SWT.NONE);
		
		button_3.setBounds(206, 342, 98, 30);
		button_3.setText("\u83B7\u53D6\u4F1A\u5458\u53F7");
		kase = 1;
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(328, 346, 183, 26);
		button_3.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if(ok == 1 && kase == 1){
					int c = (int)(Math.random() * 1000) + 1;
					text_2.setText(""+c);
					kase = 0;
				}else if(kase == 0){
					button_3.setEnabled(false);
				}				
				else {
					BoxUtils.showBox("请先完成付款！！！");
				}
			}
		});
		
		
		Label label_4 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_4.setBounds(81, 95, 643, 2);
		
		Label label_5 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_5.setBounds(81, 296, 643, 2);
		
		Label label_6 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_6.setBounds(81, 414, 643, 2);
		
		Label label_7 = new Label(shell, SWT.NONE);
		label_7.setText("\u4E2D\u7684\u4E00\u5458\uFF0C\u5C0A\u4EAB\u8D2D\u7968\u516B\u6298\u7684\u4F18\u539A\u5F85\u9047");
		label_7.setBounds(81, 59, 621, 20);
		
		Button button_4 = new Button(shell, SWT.NONE);
		button_4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(!text_2.getText().equals(null)){
					DBUtils dbUtils = new DBUtils();
					String sqlString = "update userfo set code = "+Integer.parseInt(text_2.getText())+", is_VIP = "+true+" where usernames = '"+CountDetailss.pname+"'";
					dbUtils.update(sqlString);
					shell.dispose();
				}
				
			}
		});
		button_4.setBounds(352, 434, 98, 30);
		button_4.setText("\u5B8C\u6210");

	}
}
