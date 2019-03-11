package View;

import java.awt.Dialog;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.wb.swt.ResourceManager;

import Utils.DBUtils;
import Dialog.Login;


public class Welcome extends ViewPart {

	public static final String ID = "View.Welcome"; //$NON-NLS-1$
	public static  List<Map<String, Object>> list;
	public Welcome() {
	}

	/**
	 * Create contents of the view part.
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setBackgroundImage(ResourceManager.getPluginImage("Mycam", "icons/timg1.jpg"));
		container.setLayout(null);
        
		/**
		 * 获取登录者的账号信息
		 */
		try {
			DBUtils dbUtils = new DBUtils();
			String sql = "select * from userfo where usernames = '"+Login.username+"'";
			list = dbUtils.query(sql);
			
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
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
}
