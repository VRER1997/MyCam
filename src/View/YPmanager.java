package View;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableCursor;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.part.ViewPart;

import Model.Films;
import Utils.DBUtils;

import Dialog.AddFilm;
import Dialog.DelFilm;
import Dialog.EditFilm;
import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;

public class YPmanager extends ViewPart {

	public static final String ID = "View.YPmanager"; //$NON-NLS-1$
	private static Table table;

	public YPmanager() {
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
		
		Label label = new Label(container, SWT.NONE);
		label.setText("\u5F71\u7247\u7BA1\u7406");
		label.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.BOLD));
		label.setBounds(56, 34, 80, 27);
		
		Label label_1 = new Label(container, SWT.NONE);
		label_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		label_1.setBounds(43, 34, 7, 27);
		
		Label label_2 = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_2.setBounds(43, 69, 1009, 2);
		
		table = new Table(container, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBackgroundImage(ResourceManager.getPluginImage("Mycam", "icons/13857113_164644350163_2.png"));
		table.setBounds(56, 113, 976, 256);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(72);
		tblclmnNewColumn.setText("影片编号");
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_1.setWidth(131);
		tblclmnNewColumn_1.setText("片名");
		
		TableColumn tblclmnNewColumn_2 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_2.setWidth(77);
		tblclmnNewColumn_2.setText("影片类型");
		
		TableColumn tblclmnNewColumn_3 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_3.setWidth(48);
		tblclmnNewColumn_3.setText("语言");
		
		TableColumn tblclmnNewColumn_4 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_4.setWidth(48);
		tblclmnNewColumn_4.setText("片长");
		
		TableColumn tblclmnNewColumn_5 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_5.setWidth(104);
		tblclmnNewColumn_5.setText("导演");
		
		TableColumn tblclmnNewColumn_6 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_6.setWidth(110);
		tblclmnNewColumn_6.setText("主演");
		
		TableColumn tblclmnNewColumn_7 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_7.setWidth(117);
		tblclmnNewColumn_7.setText("上映时间");
		
		TableColumn tblclmnNewColumn_8 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_8.setWidth(119);
		tblclmnNewColumn_8.setText("下线时间");
		
		TableColumn tblclmnNewColumn_9 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_9.setWidth(133);
		tblclmnNewColumn_9.setText("影片简介");
		
		Menu menu = new Menu(table);
		table.setMenu(menu);
		
		MenuItem menuItem_4 = new MenuItem(menu, SWT.NONE);
		menuItem_4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					getList();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		menuItem_4.setText("\u5237\u65B0");
		
		MenuItem menuItem = new MenuItem(menu, SWT.NONE);
		menuItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				AddFilm addFilm = new AddFilm(new Shell(), SWT.CLOSE);
				addFilm.open();
			}
		});
		menuItem.setText("\u6DFB\u52A0\u5F71\u7247");
		
		MenuItem menuItem_1 = new MenuItem(menu, SWT.NONE);
		menuItem_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				TableItem tableItem = table.getItem(table.getSelectionIndex());
				EditFilm editFilm = new EditFilm(new Shell(), SWT.CLOSE);
				editFilm.open(tableItem);
			}
		});
		menuItem_1.setText("\u7F16\u8F91\u5F71\u7247");
		
		MenuItem menuItem_2 = new MenuItem(menu, SWT.NONE);
		menuItem_2.setText("\u67E5\u627E\u5F71\u7247");
		
		MenuItem menuItem_3 = new MenuItem(menu, SWT.NONE);
		menuItem_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				TableItem tableItem = table.getItem(table.getSelectionIndex());
				DelFilm delFilm = new DelFilm(new Shell(), SWT.CLOSE);
				delFilm.open(tableItem);
			}
		});
		menuItem_3.setText("\u5220\u9664\u5F71\u7247");

		createActions();
		initializeToolBar();
		initializeMenu();
	}
public static void  getList() throws SQLException{
		
	    /**
	     * 更新数据
	     */
	    table.removeAll();	
		DBUtils  db = new DBUtils();	
		
		List<Map<String,Object>> list = db.query("SELECT * FROM films order by filmID");
		
		for(Map<String,Object> map : list){
			
			TableItem tableItem = new TableItem(table, SWT.NONE);
			tableItem.setText(0,map.get("filmID").toString());
			tableItem.setText(1,map.get("fname").toString());
			tableItem.setText(2,map.get("ftype").toString());
			tableItem.setText(3,map.get("flanguage").toString());
			tableItem.setText(4,map.get("ftime").toString());
			tableItem.setText(5,map.get("fdirector").toString());
			tableItem.setText(6,map.get("factors").toString());
			tableItem.setText(7,map.get("fUpTime").toString());
			tableItem.setText(8,map.get("fDownTime").toString());
			tableItem.setText(9,map.get("fbrifeText").toString());
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
