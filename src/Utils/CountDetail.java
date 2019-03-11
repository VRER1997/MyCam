package Utils;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;

public class CountDetail extends ViewPart {

	public static final String ID = "Utils.CountDetail"; //$NON-NLS-1$

	public CountDetail() {
	}

	/**
	 * Create contents of the view part.
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		{
			Label lblNewLabel = new Label(container, SWT.NONE);
			lblNewLabel.setBounds(122, 52, 76, 20);
			lblNewLabel.setText("用户名：");
		}
		{
			Label lblNewLabel_1 = new Label(container, SWT.NONE);
			lblNewLabel_1.setBounds(122, 117, 76, 20);
			lblNewLabel_1.setText("昵称：");
		}
		{
			Label lblNewLabel_2 = new Label(container, SWT.NONE);
			lblNewLabel_2.setBounds(122, 182, 76, 20);
			lblNewLabel_2.setText("生日：");
		}
		{
			Label lblNewLabel_3 = new Label(container, SWT.BORDER);
			lblNewLabel_3.setBounds(734, 52, 142, 167);
		}
		{
			Button btnNewButton = new Button(container, SWT.NONE);
			btnNewButton.setBounds(756, 274, 98, 30);
			btnNewButton.setText("上传头像");
		}
		{
			Label lblNewLabel_4 = new Label(container, SWT.NONE);
			lblNewLabel_4.setBounds(122, 242, 76, 20);
			lblNewLabel_4.setText("联系电话：");
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
