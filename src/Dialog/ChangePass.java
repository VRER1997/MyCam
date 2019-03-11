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

public class ChangePass extends Dialog {

	protected Object result;
	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public ChangePass(Shell parent, int style) {
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
		shell.setSize(478, 382);
		shell.setText("\u4FEE\u6539\u5BC6\u7801\u9875");
		
		Label label = new Label(shell, SWT.NONE);
		label.setText("\u4FEE\u6539\u5BC6\u7801");
		label.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.BOLD));
		label.setBounds(47, 21, 80, 27);
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		label_1.setBounds(34, 21, 7, 27);
		
		Label label_2 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_2.setBounds(34, 54, 390, 2);
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(34, 89, 76, 20);
		lblNewLabel.setText("原始密码");
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setBounds(34, 142, 76, 20);
		lblNewLabel_1.setText("新密码");
		
		Label lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setBounds(34, 193, 76, 20);
		lblNewLabel_2.setText("确认密码");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(132, 89, 254, 26);
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(132, 136, 254, 26);
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(132, 187, 254, 26);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String nString = text_1.getText();
				String mString = text_2.getText();
				if(text.getText().equals(CountDetailss.list.get(0).get("passwords").toString())){
					
					if(!nString.isEmpty() && mString.equals(nString)){
						CountDetailss.userfo.setPassword(nString);
						BoxUtils.showBox("密码修改成功");
						shell.dispose();
					}
				}else if(!text.getText().equals(CountDetailss.list.get(0).get("passwords").toString())){
					BoxUtils.showBox("对不起，原密码错误!");
				}else {
					BoxUtils.showBox("对不起，确认密码错误!");
				}
			}
		});
		btnNewButton.setBounds(140, 263, 132, 30);
		btnNewButton.setText("确认");

	}
}
