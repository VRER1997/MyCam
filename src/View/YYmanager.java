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

import Test.addCINTest;
import Utils.DBUtils;

import Dialog.AddCin;
import Dialog.DelCin;
import Dialog.EditCin;

import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;

public class YYmanager extends ViewPart {

	public static final String ID = "View.YYmanager"; //$NON-NLS-1$
	private static Table table;

	public YYmanager() {
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
		container.setLayout(null);
		
		table = new Table(container, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBackgroundImage(ResourceManager.getPluginImage("Mycam", "icons/13857113_164644350163_2.png"));
		table.setBounds(177, 115, 472, 225);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tableColumn = new TableColumn(table, SWT.NONE);
		tableColumn.setWidth(169);
		tableColumn.setText("影院名称");
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(72);
		tblclmnNewColumn.setText("放映厅号");
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_1.setWidth(111);
		tblclmnNewColumn_1.setText("影厅类型");
		
		TableColumn tblclmnNewColumn_2 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_2.setWidth(102);
		tblclmnNewColumn_2.setText("最大容客量");
		
		Menu menu = new Menu(table);
		table.setMenu(menu);
		
		MenuItem menuItem = new MenuItem(menu, SWT.NONE);
		menuItem.setText("\u5237\u65B0\u4FE1\u606F");
		
		MenuItem menuItem_1 = new MenuItem(menu, SWT.NONE);
		menuItem_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				AddCin addCin = new AddCin(new Shell(), SWT.CLOSE);
				addCin.open();
			}
		});
		menuItem_1.setText("\u6DFB\u52A0\u5F71\u9662\u4FE1\u606F");
		
		MenuItem menuItem_3 = new MenuItem(menu, SWT.NONE);
		menuItem_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				TableItem tableItem = table.getItem(table.getSelectionIndex());
				EditCin editCin = new EditCin(new Shell(), SWT.CLOSE);
				editCin.open(tableItem);
			}
		});
		menuItem_3.setText("\u7F16\u8F91\u5F71\u9662\u4FE1\u606F");
		
		MenuItem menuItem_4 = new MenuItem(menu, SWT.NONE);
		menuItem_4.setText("\u67E5\u627E\u5F71\u9662\u4FE1\u606F");
		
		MenuItem menuItem_2 = new MenuItem(menu, SWT.NONE);
		menuItem_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				TableItem tableItem = table.getItem(table.getSelectionIndex());
				DelCin delCin = new DelCin( new Shell(), SWT.CLOSE);
				delCin.open(tableItem);
			}
		});
		menuItem_2.setText("\u5220\u9664\u5F71\u9662\u4FE1\u606F");
		
		MenuItem mntmTest = new MenuItem(menu, SWT.NONE);
		mntmTest.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				addCINTest.main(null);
			}
		});
		mntmTest.setText("Test");
		
		Label label = new Label(container, SWT.NONE);
		label.setText("\u5F71\u9662\u7BA1\u7406");
		label.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.BOLD));
		label.setBounds(93, 37, 80, 27);
		
		Label label_1 = new Label(container, SWT.NONE);
		label_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		label_1.setBounds(80, 37, 7, 27);
		
		Label label_2 = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_2.setBounds(86, 70, 715, 2);
		
		try {
			getlist();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		createActions();
		initializeToolBar();
		initializeMenu();
	}
    public static void getlist() throws SQLException{
    	
    	/**
    	 * 更新数据
    	 */
    	table.removeAll();
    	DBUtils dbUtils = new DBUtils();
    	List<Map<String, Object>> list = dbUtils.query("select * from cinrooms");
    	for (Map<String, Object> map : list) {
    		TableItem tableItem = new TableItem(table, SWT.NONE);
    		tableItem.setText(0, map.get("Roomname").toString());
    		tableItem.setText(1, map.get("RoomID").toString());
    		tableItem.setText(2, map.get("rtype").toString());
    		tableItem.setText(3, map.get("maxNum").toString());
		}
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
