package View;

import java.awt.Container;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.xml.stream.events.StartDocument;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Widget;

import Dialog.DingdanDia;
import Dialog.Login;
import Utils.DBUtils;

import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

public class Myshoppinglist extends ViewPart {

	public static final String ID = "View.Myshoppinglist"; //$NON-NLS-1$
	private Composite container;
    private Label lblNewLabel_6;
    private Label lblNewLabel_5;
	
	private int maxNum;
	private int maxpagesNum;
	private int sstart = 1;
	private Composite composite;
	
	private Link link;
	private Link link_1;
	private Link link_2;
	private Link link_3;
	private Composite composite_1;
	
	public Myshoppinglist() {
	}

	/**
	 * Create contents of the view part.
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		container = new Composite(parent, SWT.NONE);
		container.setBackgroundMode(SWT.INHERIT_DEFAULT);
		container.setBackgroundImage(ResourceManager.getPluginImage("Mycam", "icons/13857113_164644350163_2.png"));
		
		{
			Label label = new Label(container, SWT.NONE);
			label.setText("\u8D2D\u7269\u8F66");
			label.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 14, SWT.BOLD));
			label.setBounds(120, 14, 113, 38);
		}
		{
			Label label = new Label(container, SWT.NONE);
			label.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
			label.setBounds(97, 14, 17, 38);
		}
		{
			Label label = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);
			label.setBounds(65, 58, 979, 2);
		}
		
		composite = new Composite(container, SWT.NONE);
		composite.setLocation(0, 0);
		composite.setSize(1105, 621);
		composite.setBackgroundMode(SWT.INHERIT_DEFAULT);
		composite.setBackgroundImage(ResourceManager.getPluginImage("Mycam", "icons/13857113_164644350163_2.png"));
		
		Menu menu = new Menu(composite);
		composite.setMenu(menu);
		
		MenuItem menuItem = new MenuItem(menu, SWT.NONE);
		menuItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getlist();
			}
		});
		menuItem.setText("\u5237\u65B0");
		
		getlist();			

		createActions();
		initializeToolBar();
		initializeMenu();
	}
	
	public void getlist(){
		
		if(!composite.isDisposed()) composite.dispose();						
		composite = new Composite(container, SWT.NONE);
		composite.setSize(1105, 621);
		composite.setBackgroundMode(SWT.INHERIT_DEFAULT);
		composite.setBackgroundImage(ResourceManager.getPluginImage("Mycam", "icons/13857113_164644350163_2.png"));	
		
		Menu menu = new Menu(composite);
		composite.setMenu(menu);
		
		MenuItem menuItem = new MenuItem(menu, SWT.NONE);
		menuItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getlist();
			}
		});
		menuItem.setText("\u5237\u65B0");
		try {
			/**
			 * 获取购物数据 按订单的生成时间 降序排列;
			 */
			final DBUtils dbUtils = new DBUtils();
			String sql = "select * from shoppinglist where ShoppingBuyer = " +
					"'"+Login.username+"' order by ShoppingTime desc ";
			List<Map<String, Object>> list = dbUtils.query(sql);
			//System.out.println(list);			
			
			int a[] = new int[1000];
			for (int i : a) {
				i = 1;
			}
			String lastString = "2016-12-23";
			int start = -1;
			for (Map<String, Object> map : list) {				
				String dateString = map.get("ShoppingTime").toString();
				//System.out.println("***"+dateString);
				if(dateString.compareTo(lastString) < 0){
					lastString = dateString;
					start++;
					//System.out.println("@@@@"+start);
				}
				if(dateString.compareTo(lastString) == 0){
					a[start]++;
					//System.out.println("^^^"+a[start]);
				}
			}
			a[++start] = 4;
			//System.out.println(a[0]);
			int s = 0;
//			for (int i : a) {
//				System.out.println(i);
//			}
			/**
			 * 计算 分页的 页数  和开始跨度；
			 */
			maxNum = start;
			maxpagesNum = maxNum / 3;
			if(maxNum % 3 > 0) maxpagesNum++;
			
			int kase = 0;
			for(int i = 0; i < list.size(); ){
				
				Map  map = list.get(i);
				String idString  = map.get("ID").toString();
				String Buyer = map.get("ShoppingBuyer").toString();
				final String dddate  = map.get("ShoppingTime").toString();
				String fname  = map.get("ShoppingFilmname").toString();
				String p = map.get("ShopTotalPrice").toString();
				double price = Double.parseDouble(p);
				//String idString  = map.get("ID").toString();
				System.out.println(kase + " " + sstart);
				System.out.println(kase + " @@@@" + start);
				if(kase == start) break;
				System.out.println(kase + " @@@@" + start);
				if(kase >= 3 * (sstart - 1) && kase < 3 * sstart){
					/**
					 *  控制group的上下移动
					 */
					int y = 65 + (kase % 3) * 157;
					
					Group group = new Group(composite, SWT.NONE);
					group.setText("订单生成时间："+ dddate +"  订单编号："+ idString);
					group.setBounds(97, y, 936, 147);
					
					Label label = new Label(group, SWT.BORDER);
					label.setImage(ResourceManager.getPluginImage("Mycam", "ypImg/"+fname+"z.jpg"));
					label.setBounds(27, 26, 98, 111);
					
					Label label_1 = new Label(group,SWT.RIGHT);
					label_1.setBounds(141, 61, 145, 20);
					label_1.setText(fname);
					
					Label lblNewLabel = new Label(group, SWT.NONE);
					lblNewLabel.setBounds(292, 61, 76, 20);
					lblNewLabel.setText("×"+a[s]);
					
					Label label_2 = new Label(group, SWT.SEPARATOR | SWT.VERTICAL);
					label_2.setBounds(412, 17, 2, 111);
					
					Label lblNewLabel_1 = new Label(group, SWT.NONE);
					lblNewLabel_1.setBounds(451, 61, 76, 20);
					lblNewLabel_1.setText(Buyer);
					
					Label label_3 = new Label(group, SWT.SEPARATOR | SWT.VERTICAL);
					label_3.setBounds(559, 17, 2, 111);
					
					Label label_4 = new Label(group, SWT.NONE);
					label_4.setBounds(587, 31, 76, 20);
					label_4.setText("\u603B\u91D1\u989D");
					
					Label lblNewLabel_2 = new Label(group, SWT.NONE);
					lblNewLabel_2.setBounds(629, 61, 76, 20);
					final double f = price * a[s];
					lblNewLabel_2.setText(""+f);
					
					Label label_5 = new Label(group, SWT.SEPARATOR | SWT.VERTICAL);
					label_5.setBounds(729, 17, 2, 111);
					
					/**
					 *    生成当前时间
					 */				
					Date date = new Date();
					DateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
					String formatString = sdFormat.format(date);
					String fbshowString = map.get("fbshow").toString();
					
					
					Label lblNewLabel_3 = new Label(group, SWT.NONE);
					lblNewLabel_3.setBounds(760, 43, 76, 20);
					String string[] = fbshowString.split("-");
					int ff = Integer.parseInt(string[1]);
					if(ff < 10) string[1] = "0"+string[1];
					fbshowString = string[0] +"-"+ string[1] +"-"+ string[2];
					System.out.println(fbshowString);
					System.out.println(formatString);
					if(fbshowString.compareTo(formatString) <= 0){
						lblNewLabel_3.setText("已使用");
					}
					else {
						lblNewLabel_3.setText("未使用");
						Link lblNewLabel_4 = new Link(group, SWT.NONE);
						lblNewLabel_4.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseDown(MouseEvent e) {
								int ret = dbUtils.update("delete  from shoppinglist where ShoppingTime = '"+dddate+"'");
								if(ret > 0) {
									getlist();
								}
							}
						});
						lblNewLabel_4.setBounds(850, 43, 76, 20);
						lblNewLabel_4.setText("退单");
					}
					
					Button btnNewButton = new Button(group, SWT.NONE);
					btnNewButton.addSelectionListener(new SelectionAdapter() {
						@Override
						public void widgetSelected(SelectionEvent e) {
							DingdanDia dia = new DingdanDia(new Shell(), SWT.CLOSE);
							dia.open(dddate, f);
						}
					});
					btnNewButton.setBounds(796, 79, 98, 30);
					btnNewButton.setText("订单详情");
					
					
					Label lblNewLabel_5 = new Label(composite, SWT.NONE);
					lblNewLabel_5.setBounds(97, 530, 171, 20);
					lblNewLabel_5.setText("共查询到"+start+"条记录  共"+maxpagesNum+"页  ");
					
					Label lblNewLabel_6 = new Label(composite, SWT.NONE);
					lblNewLabel_6.setBounds(274, 530, 182, 20);
					lblNewLabel_6.setText("当前为第"+sstart+"页");						
				}				
				
				i += a[s];
				s++;
				kase++;
			}
			
			link = new Link(composite, SWT.NONE);
			link.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					sstart = 1;
					getlist();
				}
			});
			link.setBounds(530, 530, 66, 20);
			link.setText("<a> 首页 </a>");
			
			link_1 = new Link(composite, SWT.NONE);
			link_1.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					sstart--;
					getlist();
				}
			});
			link_1.setBounds(600, 530, 66, 20);
			link_1.setText("<a> 上一页</a>");
			
			
			link_2 = new Link(composite, SWT.NONE);
			link_2.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					sstart++;
					getlist();
				}
			});
			link_2.setBounds(670, 530, 66, 20);
			link_2.setText("<a> 下一页</a>");
			
			link_3 = new Link(composite, SWT.NONE);
			link_3.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					sstart = maxpagesNum;
					getlist();
				}
			});
			link_3.setBounds(740, 530, 66, 20);
			link_3.setText("<a> 尾页</a>");
			
			link.setEnabled(true);
			link_1.setEnabled(true);
			link_2.setEnabled(true);
			link_3.setEnabled(true);
			
			if(sstart == 1){
				link.setEnabled(false);
				link_1.setEnabled(false);
			}
			
			if(sstart == maxpagesNum){
				link_2.setEnabled(false);
				link_3.setEnabled(false);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
