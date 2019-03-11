package Dialog;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.xml.stream.events.StartDocument;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import Utils.DBUtils;
import org.eclipse.swt.widgets.Link;
import org.eclipse.wb.swt.ResourceManager;

public class SelectMC extends Dialog {

	protected Object result;
	protected Shell shell;
	private static Table table;
	
	private Link link_1;
	private Link link_2;
	private Link link_3;
	private Link link;
	
	private Label lblNewLabel_2;
	private Label lblNewLabel_3;
	
    private int maxNum;
    private int maxPages;
    private int row = 9;
    private int start = 1;
	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public SelectMC(Shell parent, int style) {
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
		shell.setBackgroundMode(SWT.INHERIT_DEFAULT);
		shell.setBackgroundImage(ResourceManager.getPluginImage("Mycam", "icons/Login.png"));
		shell.setText("\u6307\u5B9A\u65F6\u95F4\u7684\u9500\u552E\u660E\u7EC6");
		shell.setSize(1003, 560);
		
		final DateTime dateTime = new DateTime(shell, SWT.BORDER | SWT.DROP_DOWN);
		dateTime.setBounds(241, 48, 165, 28);
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(127, 48, 76, 20);
		lblNewLabel.setText("起始时间");
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setBounds(127, 109, 76, 20);
		lblNewLabel_1.setText("终止时间");
		
		final DateTime dateTime_1 = new DateTime(shell, SWT.BORDER | SWT.DROP_DOWN);
		dateTime_1.setBounds(241, 109, 165, 28);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					getlist(dateTime, dateTime_1);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(509, 73, 98, 30);
		btnNewButton.setText("查询");
		
		Group group = new Group(shell, SWT.NONE);
		group.setText("\u67E5\u8BE2\u7ED3\u679C");
		group.setBounds(74, 161, 898, 354);
		
		table = new Table(group, SWT.BORDER | SWT.FULL_SELECTION);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setBounds(38, 37, 817, 254);
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("购买者");
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_1.setWidth(100);
		tblclmnNewColumn_1.setText("购买时间");
		
		TableColumn tblclmnNewColumn_2 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_2.setWidth(135);
		tblclmnNewColumn_2.setText("购买电影");
		
		TableColumn tblclmnNewColumn_3 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_3.setWidth(100);
		tblclmnNewColumn_3.setText("影院名称");
		
		TableColumn tblclmnNewColumn_4 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_4.setWidth(76);
		tblclmnNewColumn_4.setText("影厅编号");
		
		TableColumn tblclmnNewColumn_5 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_5.setWidth(44);
		tblclmnNewColumn_5.setText("行号");
		
		TableColumn tblclmnNewColumn_6 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_6.setWidth(50);
		tblclmnNewColumn_6.setText("列号");
		
		TableColumn tblclmnNewColumn_7 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_7.setWidth(135);
		tblclmnNewColumn_7.setText("开场时间");
		
		TableColumn tblclmnNewColumn_8 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_8.setWidth(65);
		tblclmnNewColumn_8.setText("价格");
		
		lblNewLabel_2 = new Label(group, SWT.NONE);
		lblNewLabel_2.setBounds(38, 300, 200, 20);
		
		lblNewLabel_3 = new Label(group, SWT.NONE);
		lblNewLabel_3.setBounds(244, 300, 128, 20);
		
		link = new Link(group, SWT.NONE);
		link.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				start = 1;
				try {
					getlist(dateTime,dateTime_1);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		link.setBounds(398, 300, 66, 20);
		link.setText("<a>首页</a>");
		
		link_1 = new Link(group, SWT.NONE);
		link_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				start--;
				try {
					getlist(dateTime,dateTime_1);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		link_1.setBounds(491, 300, 66, 20);
		link_1.setText("<a>上一页</a>");
		
		link_2 = new Link(group, SWT.NONE);
		link_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				start++;
				try {
					getlist(dateTime,dateTime_1);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		link_2.setBounds(599, 300, 66, 20);
		link_2.setText("<a>下一页</a>");
		
		link_3 = new Link(group, SWT.NONE);
		link_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				start = maxPages;
				try {
					getlist(dateTime,dateTime_1);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		link_3.setBounds(698, 300, 66, 20);
		link_3.setText("<a>尾页</a>");

	}
	void getlist(DateTime dateTime, DateTime dateTime2) throws SQLException{
		table.removeAll();
		int y = dateTime.getYear();
		int m = dateTime.getMonth() + 1;
		int da = dateTime.getDay();
		String string = ""+y+"-";
		if(m < 10) string += "0";
		string += ""+m+"-";
		if(da < 10) string += "0";
		string += ""+ da;
		//System.out.println(string);
		
		int y1 = dateTime2.getYear();
		int m1 = dateTime2.getMonth() + 1;
		int da1 = dateTime2.getDay();
		String string1 = ""+y1+"-";
		if(m1 < 10) string1 += "0";
		string1 += ""+m1+"-";
		if(da1 < 10) string1 += "0";
		string1 += ""+ da1;
		//System.out.println(string1);
		
		DBUtils dbUtils = new DBUtils();
		maxNum = dbUtils.query("select * from shoppinglist where date >= '"+string+"' and date <= '"+string1+"'").size();
		maxPages = maxNum / 9;
		if(maxNum % 9 > 0) maxPages++;
		String sql = "select * from shoppinglist where date >= '"+string+"' and date <= '"+string1+"' " +
				"limit "+(start - 1) * row+", "+row+"";
		List<Map<String, Object>> list = dbUtils.query(sql);
		for (Map<String, Object> map : list) {
//			String date[] = map.get("ShoppingTime").toString().split(" ");
//			if(date[0].compareTo(string) >= 0 && date[0].compareTo(string1) <= 0){
			TableItem tableItem = new TableItem(table, SWT.NONE);
			tableItem.setText(0, map.get("ShoppingBuyer").toString());
			tableItem.setText(1, map.get("ShoppingTime").toString());
			tableItem.setText(2, map.get("ShoppingFilmname").toString());
			tableItem.setText(3, map.get("cinname").toString());
			tableItem.setText(4, map.get("roomID").toString());
			tableItem.setText(5, map.get("hang").toString());
			tableItem.setText(6, map.get("lie").toString());
			tableItem.setText(7, map.get("fbshow").toString());
			tableItem.setText(8, map.get("ShopTotalPrice").toString());
			
			
			link.setEnabled(true);
			link_1.setEnabled(true);
			link_2.setEnabled(true);
			link_3.setEnabled(true);
			
			if(start == 1){
				link.setEnabled(false);
				link_1.setEnabled(false);
			}
			if(start == maxPages){
				link_2.setEnabled(false);
				link_3.setEnabled(false);
			}
			
			lblNewLabel_2.setText("共查询到"+maxNum+"条记录  共"+maxPages+"页");
			lblNewLabel_3.setText("当前第"+start+"页");
//			}
		}
	}
}
