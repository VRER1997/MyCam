package Dialog;

import java.sql.SQLException;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import Utils.BoxUtils;
import View.YPmanager;
import View.YYmanager;

import Actions.AcinRooms;
import Actions.Afilms;

public class DelCin extends Dialog {

	protected Object result;
	protected Shell shell;
	private Text text;

	private TableItem t1;
	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public DelCin(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open(TableItem tableItem) {
		t1 = tableItem;
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
		shell.setSize(564, 497);
		shell.setText("\u5220\u9664\u5F71\u9662\u4FE1\u606F");
		
		String string = "亲爱的用户：\n"+
                        "  您确定要删除一下信息吗？\n"+
                        "  影院名称: "+t1.getText(0)+"\n"+
                        "  影厅编号：  "+t1.getText(1)+"\n"+
                        "  影厅类型：  "+t1.getText(2)+"\n"+
                        "  最大容客量："+t1.getText(3)+"\n";

		text = new Text(shell, SWT.BORDER | SWT.READ_ONLY | SWT.MULTI);
		text.setBounds(68, 51, 388, 260);
		text.setText(string);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int ret = AcinRooms.deletecinrooms(Integer.parseInt(t1.getText(1)));
				if(ret > 0){
					BoxUtils.showBox("删除成功");
					shell.dispose();
					try {
						YYmanager.getlist();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else{
					BoxUtils.showBox("删除失败");
					shell.dispose();
				}
			}
		});
		btnNewButton.setBounds(68, 344, 98, 30);
		btnNewButton.setText("确定");
		
		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
			}
		});
		btnNewButton_1.setBounds(358, 344, 98, 30);
		btnNewButton_1.setText("取消");

	}
}
