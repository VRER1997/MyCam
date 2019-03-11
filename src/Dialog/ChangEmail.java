package Dialog;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import Utils.BoxUtils;
import Utils.SignUpShowUtils;

public class ChangEmail extends Dialog {

	protected Object result;
	protected Shell shell;
	private Text text;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public ChangEmail(Shell parent, int style) {
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
		shell.setSize(450, 300);
		shell.setText("\u4FEE\u6539\u90AE\u7BB1\u9875");
		
		Label label = new Label(shell, SWT.NONE);
		label.setText("\u65B0\u90AE\u7BB1\u53F7");
		label.setBounds(46, 104, 76, 20);
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		label_1.setBounds(33, 21, 7, 27);
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setText("\u4FEE\u6539\u90AE\u7BB1");
		label_2.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.BOLD));
		label_2.setBounds(46, 21, 100, 27);
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(153, 101, 237, 26);
		
		Button button = new Button(shell, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String s[] = {"qq.com","163.com","126.com","139.com","sina.com","139.com"
					    ,"hotmail.com","sohu.com","gmail.com"};
			int p = 0, q = 0;
			for(int i = 0; i < text.getText().length(); i++){
				if(text.getText().charAt(i) == '@'){
					p++;
				}
			}
			if(p == 1){
				 String string[] = text.getText().split("@");
				 for(int i = 0; i < s.length; i++){
					 if(string[1].equals(s[i])){
						 q = 1;
					 }
				 }
			}
			if(p == 1 && q == 1){
				BoxUtils.showBox("邮箱 修改成功！！");
				CountDetailss.userfo.setEmail(text.getText());
				shell.dispose();
			}else{
				BoxUtils.showBox("请输入正确的邮箱格式！");
			}
			}
		});
		button.setText("\u786E\u8BA4");
		button.setBounds(139, 181, 98, 30);
		
		Label label_3 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_3.setBounds(33, 54, 377, 2);

	}

}
