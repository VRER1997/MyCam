package View;

import java.awt.Container;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPersistableElement;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import Actions.AdateTimes;
import Actions.AfilmTable;
import Dialog.FilmDetail;
import Dialog.Filmdialog;
import Utils.ShowViewUtils;

import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

public class ShopManager extends ViewPart {

	public static final String ID = "View.ShopManager"; //$NON-NLS-1$
    private Composite composite;
	public ShopManager() {
	}

	/**
	 * Create contents of the view part.
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		final Composite container = new Composite(parent, SWT.NONE);
		container.setBackgroundImage(ResourceManager.getPluginImage("Mycam", "icons/timg.jpg"));
		
		//container.dispose()
		//container.setVisible(visible)
		
		container.setBackgroundMode(SWT.INHERIT_DEFAULT);
		
		
		Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.BOLD));
		lblNewLabel.setBounds(172, 18, 180, 25);
		lblNewLabel.setText("选择您的观影日期：");		
        
		composite = new Composite(container, SWT.BORDER);
		composite.setBackgroundImage(ResourceManager.getPluginImage("Mycam", "icons/13857113_164644350163_2.png"));
		composite.setBounds(0, 66, 1091, 555);
		
		
		final DateTime dateTime = new DateTime(container, SWT.BORDER | SWT.DROP_DOWN);
		dateTime.setBounds(379, 15, 180, 28);
		Button btnNewButton = new Button(container, SWT.NONE);
		btnNewButton.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.BOLD));
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
				   
					//createPartControl(parent1);
					if(!composite.isDisposed()) composite.dispose();
					composite = new Composite(container, SWT.BORDER);
					composite.setBackgroundImage(ResourceManager.getPluginImage("Mycam", "icons/13857113_164644350163_2.png"));
					composite.setBounds(0, 66, 1091, 555);
					int kase = -1;
					int x = 46, y = 39;
					/**
					 * 查询符合条件的影片名
					 */
					List<Map<String, Object>> list = AdateTimes.CheckFilmsBydateForThreeDay(dateTime);
					for (Map<String, Object> map : list) {
						//label = null;
						//label.dispose();
						kase++;
						final String nameString = map.get("fname").toString();
						if(kase > 3) {
							kase -= 4;
							y += 252;
							x = 46;
						}
						//System.out.println(nameString+" "+x+" "+y+" "+kase);
						Label label = new Label(composite, SWT.NONE);
						
						
						//label.setImage(ResourceManager.getPluginImage("Mycam", AfilmTable.getpath(nameString)));
						//System.out.println(nameString);
						label.setImage(ResourceManager.getPluginImage("Mycam", AfilmTable.getpath(nameString)));
						label.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseDown(MouseEvent e) {
								Filmdialog detail = new Filmdialog(new Shell(), SWT.CLOSE);
								detail.open(nameString, dateTime);
							}
						});
						
						//System.out.println(label+"@@@@@@@@@@@@@@@@@");
						label.setBounds(x, y, 154, 205);
						Label label1 = new Label(composite, SWT.NONE | SWT.CENTER);
						label1.setText(nameString);
						label1.setBounds(x, y + 210, 154, 26);
						x += 228;
						
						//label.dispose();
					}
				} catch (PartInitException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(625, 18, 98, 30);
		btnNewButton.setText("查询");
		
		Menu menu = new Menu(container);
		container.setMenu(menu);
		
		MenuItem menuItem = new MenuItem(menu, SWT.NONE);
		menuItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					check();
				} catch (PartInitException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		menuItem.setText("\u5237\u65B0");
		
		MenuItem mntmTest = new MenuItem(menu, SWT.NONE);
		mntmTest.addSelectionListener(new SelectionAdapter() {
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
		mntmTest.setText("test");
		
		
		
		
		createActions();
		initializeToolBar();
		initializeMenu();
	}
    public static void check() throws PartInitException{
    	ShowViewUtils.getIWorkbenchPage().showView(ShopManager.ID);
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
