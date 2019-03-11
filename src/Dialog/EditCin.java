package Dialog;

import java.sql.SQLException;

import javax.swing.text.rtf.RTFEditorKit;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import Actions.AcinRooms;
import Model.CinRooms;
import Utils.BoxUtils;
import View.YYmanager;

public class EditCin extends Dialog {

	protected Object result;
	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;

	private TableItem t1;
	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public EditCin(Shell parent, int style) {
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
		shell.setSize(504, 435);
		shell.setText("\u7F16\u8F91\u5F71\u9662\u4FE1\u606F\u9875");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(76, 46, 76, 20);
		lblNewLabel.setText("影院名称");
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setBounds(76, 104, 76, 20);
		lblNewLabel_1.setText("影厅编号");
		
		Label lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setBounds(76, 164, 76, 20);
		lblNewLabel_2.setText("影厅类型");
		
		Label lblNewLabel_3 = new Label(shell, SWT.NONE);
		lblNewLabel_3.setBounds(76, 221, 117, 20);
		lblNewLabel_3.setText("影厅最大容客量");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(205, 46, 171, 26);
		text.setText(t1.getText(0));
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(205, 104, 76, 26);
		text_1.setText(""+ t1.getText(1));
		
		final Combo combo = new Combo(shell, SWT.NONE);
		combo.setBounds(205, 164, 92, 28);
		combo.add("普通");
		combo.add("3D");
		combo.add("IMAX");
		String string = t1.getText(2);
		int id = 0;
		if(string.equals("普通")) id = 0;
		else if(string.equals("3D")) id = 1;
		else id = 2;
		
		combo.select(id);
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(205, 215, 73, 26);
		text_2.setText(""+t1.getText(3));
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				CinRooms cinRooms = new CinRooms(text.getText(),Integer.parseInt(text_1.getText()),
						combo.getText(),Integer.parseInt(text_2.getText()));
				int ret = AcinRooms.editcinrooms(cinRooms);
				if(ret > 0){
					BoxUtils.showBox("添加成功！");
					shell.dispose();
					try {
						YYmanager.getlist();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else{
					BoxUtils.showBox("添加失败！");
					shell.dispose();
				}
			}
		});
		btnNewButton.setBounds(65, 324, 98, 30);
		btnNewButton.setText("确认");
		
		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
			}
		});
		btnNewButton_1.setBounds(278, 324, 98, 30);
		btnNewButton_1.setText("取消");
		
		Button btnNewButton_2 = new Button(shell, SWT.NONE);
		btnNewButton_2.setBounds(176, 273, 98, 30);
		btnNewButton_2.setText("重置");

	}
}
