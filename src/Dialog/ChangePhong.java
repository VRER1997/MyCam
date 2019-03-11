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

public class ChangePhong extends Dialog {

	protected Object result;
	protected Shell shell;
	private Text text;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public ChangePhong(Shell parent, int style) {
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
		shell.setSize(450, 335);
		shell.setText("\u4FEE\u6539\u7ED1\u5B9A\u624B\u673A\u53F7\u9875");
		
		Label label = new Label(shell, SWT.NONE);
		label.setText("\u4FEE\u6539\u624B\u673A\u53F7");
		label.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.BOLD));
		label.setBounds(43, 21, 100, 27);
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		label_1.setBounds(30, 21, 7, 27);
		
		Label label_2 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_2.setBounds(30, 65, 384, 2);
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(50, 127, 76, 20);
		lblNewLabel.setText("\u65B0\u624B\u673A\u53F7");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(150, 124, 237, 26);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String nString = text.getText();
				if(nString.length() != 11 || nString.charAt(0) != '1'){
					BoxUtils.showBox("请输入正确的手机号码格式！");
				}else{
					CountDetailss.userfo.setPhonenumber(nString);
					BoxUtils.showBox("绑定手机号修改成功！");
					shell.dispose();
				}
			}
		});
		btnNewButton.setBounds(135, 199, 98, 30);
		btnNewButton.setText("确认");

	}

}
