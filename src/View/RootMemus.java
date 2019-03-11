package View;

import java.sql.SQLException;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

import Utils.ShowViewUtils;

public class RootMemus extends ViewPart {

	public static final String ID = "View.RootMemus"; //$NON-NLS-1$

	public RootMemus() {
	}

	/**
	 * Create contents of the view part.
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		{
			Label label = new Label(container, SWT.NONE);
			label.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseDown(MouseEvent e) {
					try {
						ShowViewUtils.getIWorkbenchPage().showView(YYmanager.ID);
					} catch (PartInitException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			label.setImage(ResourceManager.getPluginImage("Mycam", "icons/1-17-128.png"));
			label.setBounds(20, 10, 128, 128);
		}
		{
			Label label = new Label(container, SWT.NONE);
			label.setBounds(55, 136, 76, 20);
			label.setText("\u5F71\u9662\u7BA1\u7406");
		}
		{
			Label label = new Label(container, SWT.NONE);
			label.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseDown(MouseEvent e) {
					try {
						ShowViewUtils.getIWorkbenchPage().showView(YPmanager.ID);
						YPmanager.getList();
					} catch (PartInitException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			label.setImage(ResourceManager.getPluginImage("Mycam", "icons/03_-_Film_slate-128.png"));
			label.setBounds(20, 155, 128, 128);
		}
		{
			Label label = new Label(container, SWT.NONE);
			label.setText("\u5F71\u7247\u7BA1\u7406");
			label.setBounds(55, 289, 76, 20);
		}
		{
			Label label = new Label(container, SWT.NONE);
			label.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseDown(MouseEvent e) {
					try {
						ShowViewUtils.getIWorkbenchPage().showView(PlanManager.ID);
					} catch (PartInitException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			label.setImage(ResourceManager.getPluginImage("Mycam", "icons/schedule_clock-128.png"));
			label.setBounds(20, 310, 128, 128);
		}
		{
			Label label = new Label(container, SWT.NONE);
			label.setText("\u4E0A\u6620\u8BA1\u5212\u7BA1\u7406");
			label.setBounds(41, 433, 90, 20);
		}
		{
			Label label = new Label(container, SWT.NONE);
			label.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseDown(MouseEvent e) {
					try {
						ShowViewUtils.getIWorkbenchPage().showView(SelectForDate.ID);
					} catch (PartInitException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			label.setImage(ResourceManager.getPluginImage("Mycam", "icons/search_data-128.png"));
			label.setBounds(20, 459, 128, 128);
		}
		{
			Label label = new Label(container, SWT.NONE);
			label.setAlignment(SWT.CENTER);
			label.setText("\u67E5\u8BE2");
			label.setBounds(41, 588, 90, 20);
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
