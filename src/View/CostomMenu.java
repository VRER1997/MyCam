package View;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

import Dialog.CountDetailss;
import Utils.ShowViewUtils;

public class CostomMenu extends ViewPart {

	public static final String ID = "View.CostomMenu"; //$NON-NLS-1$

	public CostomMenu() {
	}

	/**
	 * Create contents of the view part.
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		
		Label label = new Label(container, SWT.NONE);
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				try {
					ShowViewUtils.getIWorkbenchPage().showView(ShopManager.ID);
				} catch (PartInitException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		label.setImage(ResourceManager.getPluginImage("Mycam", "icons/247-128.png"));
		label.setBounds(30, 46, 128, 127);
		{
			Label label_1 = new Label(container, SWT.NONE);
			label_1.setAlignment(SWT.CENTER);
			label_1.setBounds(56, 179, 76, 20);
			label_1.setText("\u8D2D\u7968");
		}
		{
			Label label_1 = new Label(container, SWT.NONE);
			label_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseDown(MouseEvent e) {
					try {
						ShowViewUtils.getIWorkbenchPage().showView(Myshoppinglist.ID);
					} catch (PartInitException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			label_1.setImage(ResourceManager.getPluginImage("Mycam", "icons/shopping_cart_shop_online-128.png"));
			label_1.setBounds(30, 212, 128, 127);
		}
		{
			Label label_1 = new Label(container, SWT.NONE);
			label_1.setText("\u6211\u7684\u8D2D\u7269\u8F66");
			label_1.setAlignment(SWT.CENTER);
			label_1.setBounds(56, 345, 76, 20);
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
