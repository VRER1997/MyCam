package View;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

import Dialog.SelectMC;
import Dialog.SelectMZLtop_5;
import Dialog.SelectSZL;
import Dialog.SelectXSE;
import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.wb.swt.SWTResourceManager;

public class SelectForDate extends ViewPart {

	public static final String ID = "View.SelectForDate"; //$NON-NLS-1$

	public SelectForDate() {
	}

	/**
	 * Create contents of the view part.
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 11, SWT.BOLD));
		container.setBackgroundMode(SWT.INHERIT_DEFAULT);
		container.setBackgroundImage(ResourceManager.getPluginImage("Mycam", "icons/13857113_164644350163_2.png"));
		
		Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setImage(ResourceManager.getPluginImage("Mycam", "icons/document-circle-blue-128.png"));
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				SelectMC selectMC = new SelectMC(new Shell(), SWT.CLOSE);
				selectMC.open();
			}
		});
		lblNewLabel.setBounds(356, 107, 129, 128);
		
		Label lblNewLabel_1 = new Label(container, SWT.NONE);
		lblNewLabel_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 10, SWT.BOLD));
		lblNewLabel_1.setBounds(346, 241, 153, 20);
		lblNewLabel_1.setText("\u67E5\u8BE2\u65F6\u95F4\u6BB5\u9500\u552E\u660E\u7EC6");
		
		Label label = new Label(container, SWT.NONE);
		label.setImage(ResourceManager.getPluginImage("Mycam", "icons/pie-chart.png"));
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				SelectSZL selectSZL = new SelectSZL(new Shell(), SWT.CLOSE);
				selectSZL.open();
			}
		});
		label.setBounds(572, 105, 129, 119);
		
		Label label_1 = new Label(container, SWT.NONE);
		label_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 10, SWT.BOLD));
		label_1.setText("\u67E5\u8BE2\u6307\u5B9A\u6708\u5F71\u5385\u7684\u4E0A\u5EA7\u7387");
		label_1.setBounds(568, 241, 187, 20);
		
		Label label_2 = new Label(container, SWT.NONE);
		label_2.setImage(ResourceManager.getPluginImage("Mycam", "icons/analytics-circle-blue-128.png"));
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				SelectMZLtop_5 selectMZLtop_5 = new SelectMZLtop_5(new Shell(), SWT.CLOSE);
				selectMZLtop_5.open();
			}
		});
		label_2.setBounds(365, 297, 134, 130);
		
		Label label_3 = new Label(container, SWT.NONE);
		label_3.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 10, SWT.BOLD));
		label_3.setText("\u67E5\u8BE2\u65F6\u95F4\u6BB5\u5356\u5EA7\u7387\u524D\u4E94");
		label_3.setBounds(346, 431, 170, 20);
		
		Label label_4 = new Label(container, SWT.NONE);
		label_4.setImage(ResourceManager.getPluginImage("Mycam", "icons/chart-6-128.png"));
		label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				SelectXSE selectXSE = new SelectXSE(new Shell(), SWT.CLOSE);
				selectXSE.open();
			}
		});
		label_4.setBounds(593, 297, 129, 130);
		
		Label label_5 = new Label(container, SWT.NONE);
		label_5.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 10, SWT.BOLD));
		label_5.setText("\u67E5\u8BE2\u6307\u5B9A\u6708\u4EFD\u9500\u552E\u989D\u53CA\u5360\u5168\u5E74\u7684\u6BD4\u4F8B\r\n\r\n");
		label_5.setBounds(549, 433, 272, 27);
		
		Label label_6 = new Label(container, SWT.NONE);
		label_6.setText("\u67E5\u8BE2\u529F\u80FD");
		label_6.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 14, SWT.BOLD));
		label_6.setBounds(191, 34, 113, 38);
		
		Label label_7 = new Label(container, SWT.NONE);
		label_7.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		label_7.setBounds(168, 34, 17, 38);
		
		Label label_8 = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_8.setBounds(181, 78, 791, 2);
		
		Label lblNewLabel_2 = new Label(container, SWT.NONE);
		lblNewLabel_2.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 11, SWT.BOLD));
		lblNewLabel_2.setBounds(462, 505, 187, 27);
		lblNewLabel_2.setText("\u66F4\u591A\u529F\u80FD \u656C\u8BF7\u671F\u5F85...");

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
