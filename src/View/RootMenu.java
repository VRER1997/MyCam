package View;

import java.sql.SQLException;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import Dialog.CountDetailss;
import Utils.ShowViewUtils;


public class RootMenu extends ViewPart {

	public static final String ID = "View.RootMenu"; //$NON-NLS-1$
    
	private String nameString;
	/**
	 * @wbp.parser.constructor
	 */
	public RootMenu() {
	}
	public RootMenu(String name) {
		nameString = name;
	}
	/**
	 * Create contents of the view part.
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(null);
		
		Button button = new Button(container, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
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
		button.setBounds(53, 127, 98, 30);
		button.setText("\u5F71\u7247\u7BA1\u7406");
		{
			Button btnNewButton = new Button(container, SWT.NONE);
			btnNewButton.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					try {
						ShowViewUtils.getIWorkbenchPage().showView(YYmanager.ID);
					} catch (PartInitException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			btnNewButton.setBounds(53, 59, 98, 30);
			btnNewButton.setText("影院管理");
		}
		
		Button btnNewButton_1 = new Button(container, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					ShowViewUtils.getIWorkbenchPage().showView(PlanManager.ID);
				} catch (PartInitException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(53, 213, 98, 30);
		btnNewButton_1.setText("上映计划");
		
		Button btnNewButton_2 = new Button(container, SWT.NONE);
		btnNewButton_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					ShowViewUtils.getIWorkbenchPage().showView(ShopManager.ID);
				} catch (PartInitException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(53, 270, 98, 30);
		btnNewButton_2.setText("购票");
		
		Button btnNewButton_3 = new Button(container, SWT.NONE);
		btnNewButton_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {				
				CountDetailss countDetailss = new CountDetailss(new Shell(), SWT.CLOSE);
		        countDetailss.open();
			}
		});
		btnNewButton_3.setBounds(53, 316, 98, 30);
		btnNewButton_3.setText("账号管理：");
		
		Button button_1 = new Button(container, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					ShowViewUtils.getIWorkbenchPage().showView(ShangchuanTest.ID);
				} catch (PartInitException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_1.setBounds(53, 366, 98, 30);
		button_1.setText("\u4E0A\u4F20\u6D4B\u8BD5");
		
		Button btnLabelTest = new Button(container, SWT.NONE);
		btnLabelTest.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					ShowViewUtils.getIWorkbenchPage().showView(Test.ID);
				} catch (PartInitException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnLabelTest.setBounds(53, 486, 98, 30);
		btnLabelTest.setText("label Test");
		
		Button button_2 = new Button(container, SWT.NONE);
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
			}
		});
		button_2.setBounds(53, 425, 98, 30);
		button_2.setText("\u67E5\u8BE2");

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
