package Dialog;

import java.sql.Date;
import java.sql.SQLException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import Actions.Afilms;
import Model.Films;
import Utils.BoxUtils;
import View.YPmanager;

public class EditFilm extends Dialog {

	protected Object result;
	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_5;
	
	private int filmID;
	private String fnameString;
	private String ftypeString;
	private int ftimelong ;
	private String fdirectorString;
	private String factorString;
	private String  fUptimeDate;
	private String flanguage;
	private String fDowmtimeString;
	private String fbtext;
	private Text text_6;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public EditFilm(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open(TableItem tableItem) {
		filmID = Integer.parseInt(tableItem.getText(0));
		fnameString = tableItem.getText(1);
		ftypeString = tableItem.getText(2);
		flanguage = tableItem.getText(3);
		ftimelong = Integer.parseInt(tableItem.getText(4));
		fdirectorString = tableItem.getText(5);
		factorString = tableItem.getText(6);
		fUptimeDate = tableItem.getText(7);
		fDowmtimeString = tableItem.getText(8);
		fbtext = tableItem.getText(9);
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
		shell.setSize(630, 725);
		shell.setText("\u7F16\u8F91\u5F71\u7247\u4FE1\u606F\u9875");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.BOLD));
		lblNewLabel.setBounds(76, 122, 92, 33);
		lblNewLabel.setText("影片编号");
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.BOLD));
		lblNewLabel_1.setBounds(76, 76, 55, 33);
		lblNewLabel_1.setText("片名");
		
		Label lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.BOLD));
		lblNewLabel_2.setBounds(76, 174, 92, 27);
		lblNewLabel_2.setText("影片类型");
		
		Label lblNewLabel_3 = new Label(shell, SWT.NONE);
		lblNewLabel_3.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.BOLD));
		lblNewLabel_3.setBounds(304, 122, 62, 33);
		lblNewLabel_3.setText("语言");
		
		Label lblNewLabel_4 = new Label(shell, SWT.NONE);
		lblNewLabel_4.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.BOLD));
		lblNewLabel_4.setBounds(304, 174, 55, 27);
		lblNewLabel_4.setText("片长");
		
		Label lblNewLabel_5 = new Label(shell, SWT.NONE);
		lblNewLabel_5.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.BOLD));
		lblNewLabel_5.setBounds(76, 345, 62, 27);
		lblNewLabel_5.setText("导演");
		
		Label lblNewLabel_6 = new Label(shell, SWT.NONE);
		lblNewLabel_6.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.BOLD));
		lblNewLabel_6.setBounds(76, 405, 55, 33);
		lblNewLabel_6.setText("主演");
		
		Label lblNewLabel_7 = new Label(shell, SWT.NONE);
		lblNewLabel_7.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.BOLD));
		lblNewLabel_7.setBounds(76, 235, 92, 27);
		lblNewLabel_7.setText("上映时间");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(188, 76, 281, 27);
		text.setText(fnameString);
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(188, 122, 73, 26);
		text_1.setText(""+filmID);		
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(188, 175, 110, 26);
		text_2.setText(ftypeString);
		
		text_3 = new Text(shell, SWT.BORDER);
		text_3.setBounds(377, 176, 92, 26);
		text_3.setText(""+ftimelong);

		final DateTime dateTime = new DateTime(shell, SWT.DROP_DOWN);
		dateTime.setBounds(188, 235, 195, 28);
		String [] strings = fUptimeDate.split("-");
		dateTime.setYear(Integer.parseInt(strings[0]));
		dateTime.setMonth(Integer.parseInt(strings[1])-1);
		dateTime.setDay(Integer.parseInt(strings[2]));
		
		final DateTime dateTime_1 = new DateTime(shell, SWT.BORDER | SWT.DROP_DOWN);
		dateTime_1.setBounds(188, 295, 195, 28);
		String [] strings_1 = fDowmtimeString.split("-");
		dateTime_1.setYear(Integer.parseInt(strings_1[0]));
		dateTime_1.setMonth(Integer.parseInt(strings_1[1])-1);
		dateTime_1.setDay(Integer.parseInt(strings_1[2]));
		
		Label lblNewLabel_8 = new Label(shell, SWT.NONE);
		lblNewLabel_8.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.BOLD));
		lblNewLabel_8.setBounds(76, 458, 92, 27);
		lblNewLabel_8.setText("简介：");
		
		text_6 = new Text(shell, SWT.BORDER | SWT.V_SCROLL | SWT.MULTI);
		text_6.setBounds(76, 491, 397, 99);
		text_6.setText(fbtext);

		text_4 = new Text(shell, SWT.BORDER);
		text_4.setBounds(188, 347, 195, 26);
		text_4.setText(fdirectorString);
		
		text_5 = new Text(shell, SWT.BORDER);
		text_5.setBounds(188, 407, 195, 26);
		text_5.setText(factorString);
		text_5.getText();
		final Combo combo = new Combo(shell, SWT.READ_ONLY);
		combo.setBounds(372, 124, 92, 28);
		combo.add("中文");
		combo.add("英文");
		combo.add("其他的语种");
		final int id;
		if(flanguage.equals("中文")) id = 0;
		else if(flanguage.equals("英文")) id = 1;
		else id = 2;
		combo.select(id);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String lo = combo.getText();
				int n = dateTime.getMonth()+1;
				int m = dateTime_1.getMonth()+1;
				String d = dateTime.getYear() + "-" + n+ "-" + dateTime.getDay();
				String d1 = dateTime_1.getYear() + "-" + m + "-" + dateTime_1.getDay();
				Films films = new Films(Integer.parseInt(text_1.getText()),text.getText().trim(),text_2.getText().trim(),Integer.parseInt(text_3.getText()),
				               text_4.getText().trim(),text_5.getText().trim(),d,lo,d1,text_6.getText());
				int ret = Afilms.editFilm(films);
				if(ret > 0){
					BoxUtils.showBox("编辑成功");
					shell.dispose();
					try {
						YPmanager.getList();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else{
					BoxUtils.showBox("编辑失败");
					shell.dispose();
				}
			}
		});
		btnNewButton.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 9, SWT.BOLD));
		btnNewButton.setBounds(82, 650, 98, 30);
		btnNewButton.setText("确认");
		
		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
			}
		});
		btnNewButton_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 9, SWT.BOLD));
		btnNewButton_1.setBounds(377, 650, 98, 30);
		btnNewButton_1.setText("取消");
		
		Button btnNewButton_2 = new Button(shell, SWT.NONE);
		btnNewButton_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				text.setText(fnameString);
				text_1.setText(""+filmID);
				text_3.setText(""+ftimelong);
				text_4.setText(fdirectorString);
				text_5.setText(factorString);
				
				int f = 0;
				if(flanguage.equals("中文")) f = 0;
				else if(flanguage.equals("英文")) f = 1;
				else f = 2;
				combo.select(f);
				
				String [] strings = fUptimeDate.split("-");
				dateTime.setYear(Integer.parseInt(strings[0]));
				dateTime.setMonth(Integer.parseInt(strings[1])-1);
				dateTime.setDay(Integer.parseInt(strings[2]));
			}
		});
		btnNewButton_2.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 9, SWT.BOLD));
		btnNewButton_2.setBounds(228, 613, 98, 30);
		btnNewButton_2.setText("重置");
		
		Label label = new Label(shell, SWT.NONE);
		label.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.BOLD));
		label.setBounds(76, 290, 92, 33);
		label.setText("下线时间：");
		
		
	}
}
