package View;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import Test.DatetimesTest;
import Utils.BoxUtils;
import Utils.DBUtils;

import Actions.AplanSet;
import Dialog.AddPlan;
import Dialog.DelPlan;
import Dialog.EditPlan;

import org.eclipse.swt.widgets.TableItem;
import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;

public class PlanManager extends ViewPart {

	public static final String ID = "View.PlanManager"; //$NON-NLS-1$
	private static Table table;

	public PlanManager() {
	}

	/**
	 * Create contents of the view part.
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setBackgroundMode(SWT.INHERIT_DEFAULT);
		container.setBackgroundImage(ResourceManager.getPluginImage("Mycam", "icons/13857113_164644350163_2.png"));
		
		table = new Table(container, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBackgroundImage(ResourceManager.getPluginImage("Mycam", "icons/13857113_164644350163_2.png"));
		table.setBounds(137, 127, 828, 316);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tableColumn = new TableColumn(table, SWT.NONE);
		tableColumn.setText("\u8BA1\u5212\u7F16\u53F7");
		tableColumn.setWidth(77);
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(126);
		tblclmnNewColumn.setText("影院名称");
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_1.setWidth(74);
		tblclmnNewColumn_1.setText("影厅编号");
		
		TableColumn tableColumn_1 = new TableColumn(table, SWT.NONE);
		tableColumn_1.setWidth(132);
		tableColumn_1.setText("\u5F71\u7247");
		
		TableColumn tblclmnNewColumn_2 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_2.setWidth(127);
		tblclmnNewColumn_2.setText("开场时间");
		
		TableColumn tblclmnNewColumn_3 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_3.setWidth(127);
		tblclmnNewColumn_3.setText("结束时间");
		
		TableColumn tblclmnNewColumn_4 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_4.setWidth(75);
		tblclmnNewColumn_4.setText("正常票价");
		
		TableColumn tblclmnNewColumn_5 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_5.setWidth(74);
		tblclmnNewColumn_5.setText("会员票价");
		
		Menu menu = new Menu(table);
		table.setMenu(menu);
		
		MenuItem mntmNewItem = new MenuItem(menu, SWT.NONE);
		mntmNewItem.setText("刷新");
		
		MenuItem mntmNewItem_1 = new MenuItem(menu, SWT.NONE);
		mntmNewItem_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				AddPlan addPlan = new AddPlan(new Shell(), SWT.CLOSE);
				addPlan.open();
			}
		});
		mntmNewItem_1.setText("添加计划");
		
		MenuItem mntmNewItem_2 = new MenuItem(menu, SWT.NONE);
		mntmNewItem_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				TableItem tableItem = table.getItem(table.getSelectionIndex());
				EditPlan editPlan = new EditPlan(new Shell(), SWT.CLOSE);
				editPlan.open(tableItem);
			}
		});
		mntmNewItem_2.setText("编辑计划");
		
		MenuItem mntmNewItem_3 = new MenuItem(menu, SWT.NONE);
		mntmNewItem_3.setText("查找计划");
		
		MenuItem mntmNewItem_4 = new MenuItem(menu, SWT.NONE);
		mntmNewItem_4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				TableItem tableItem = table.getItem(table.getSelectionIndex());
				DelPlan delPlan  = new DelPlan(new Shell(), SWT.CLOSE);
				delPlan.open(tableItem);
			}
		});
		mntmNewItem_4.setText("删除计划");
		
		MenuItem mntmTest = new MenuItem(menu, SWT.NONE);
		mntmTest.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				DatetimesTest.main(null);
			}
		});
		mntmTest.setText("Test");
		
		Label label = new Label(container, SWT.NONE);
		label.setText("\u4E0A\u6620\u8BA1\u5212\u7BA1\u7406");
		label.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.BOLD));
		label.setBounds(114, 36, 155, 27);
		
		Label label_1 = new Label(container, SWT.NONE);
		label_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		label_1.setBounds(101, 36, 7, 27);
		
		Label label_2 = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_2.setBounds(102, 75, 905, 2);
		
		try {
			getlist();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
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
	public static void getlist() throws Exception{
		table.removeAll();
		DBUtils dbUtils = new DBUtils();
		String sql = "select * from planset";
		List<Map<String, Object>> list = dbUtils.query(sql);
		for (Map<String, Object> map : list) {
			TableItem tableItem = new TableItem(table, SWT.NONE);
			tableItem.setText(0, map.get("ID").toString());
			tableItem.setText(1, map.get("Cinname").toString());
			tableItem.setText(2, map.get("RoomID").toString());
			tableItem.setText(3, map.get("Filmname").toString());
			tableItem.setText(4, map.get("Stime").toString());
			tableItem.setText(5, map.get("Etime").toString());
			tableItem.setText(6, map.get("NormalPrice").toString());
			tableItem.setText(7, map.get("VipPrice").toString());
			//tableItem.setText(8, map.get("CurNum").toString());
		}
	}
}
