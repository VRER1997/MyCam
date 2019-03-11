package Dialog;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

import Actions.AdateTimes;
import Actions.AfilmTable;
import Actions.AshopList;
import Actions.Auserfo;
import Model.ShoppingList;
import Model.Userfo;
import Test.checkFilmTest;
import Utils.BoxUtils;
import Utils.DBUtils;
import Utils.ShowViewUtils;
import View.Welcome;

import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;

public class FilmDetail extends Dialog {

	protected Object result;
	protected Shell shell;
	private String cinnameString;
    private String fnameString;
    private DateTime d1;
    
    private int [][] HadBuyPoint = new int[12][12];
    private Text text;
    private Text text_1;
    private Text text_2;
    private Text text_3;
    private Text text_4;
    private Text text_5;
    private Text text_6;
    private Text text_7;
    private List<Map<String, Object>> list1;
    
	private Text text_8;
	private int nprice;
	private Text text_9;
	private String formatString;
	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public FilmDetail(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open(String cinnString, String nameString, DateTime dateTime) {
		this.cinnameString = cinnString;
		this.fnameString = nameString;
		d1 = dateTime;
		createContents();
		shell.open();
		shell.layout();
		Display display = getParent().getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shell = new Shell(getParent(), getStyle());
		shell.setBackgroundMode(SWT.INHERIT_DEFAULT);
		shell.setBackgroundImage(ResourceManager.getPluginImage("Mycam", "icons/timg.jpg"));
		shell.setSize(1140, 683);
		shell.setText("\u9009\u5EA7\u9875");
		shell.setLayout(null);
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 10, SWT.BOLD));
		lblNewLabel.setBounds(117, 29, 76, 20);
		lblNewLabel.setText("可选座位");
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 10, SWT.BOLD));
		lblNewLabel_1.setBounds(296, 29, 76, 20);
		lblNewLabel_1.setText("已售座位");
		
		Label lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 10, SWT.BOLD));
		lblNewLabel_2.setBounds(503, 29, 76, 20);
		lblNewLabel_2.setText("已选座位");
		
		Label lblNewLabel_3 = new Label(shell, SWT.NONE);		
		lblNewLabel_3.setImage(ResourceManager.getPluginImage("Mycam", "icons/可选座位.PNG"));
		lblNewLabel_3.setBounds(85, 29, 26, 25);
		
		Label label = new Label(shell, SWT.NONE);
		label.setImage(ResourceManager.getPluginImage("Mycam", "icons/已售座位.PNG"));
		label.setBounds(260, 29, 26, 20);
		
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setImage(ResourceManager.getPluginImage("Mycam", "icons/已选座位.PNG"));
		label_1.setBounds(473, 29, 24, 20);
		
		final Group group = new Group(shell, SWT.NONE);
		group.setBackgroundMode(SWT.INHERIT_DEFAULT);
		group.setText("座位图");
		group.setBounds(70, 92, 572, 462);
		
		Label lblNewLabel_4 = new Label(group, SWT.NONE);
		lblNewLabel_4.setImage(ResourceManager.getPluginImage("Mycam", "icons/银幕.png"));
		lblNewLabel_4.setBounds(225, 25, 130, 20);
		
		Group group_1 = new Group(shell, SWT.NONE);
		group_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 10, SWT.BOLD));
		group_1.setText("订单页");
		group_1.setBounds(749, 29, 375, 597);
		
		Label lblNewLabel_5 = new Label(group_1, SWT.NONE);
		lblNewLabel_5.setBounds(58, 39, 76, 20);
		lblNewLabel_5.setText("影院名称：");
		
		Label lblNewLabel_6 = new Label(group_1, SWT.NONE);
		lblNewLabel_6.setBounds(58, 79, 76, 20);
		lblNewLabel_6.setText("电影名称：");
		
		Label lblNewLabel_7 = new Label(group_1, SWT.NONE);
		lblNewLabel_7.setBounds(58, 122, 76, 20);
		lblNewLabel_7.setText("开场时间：");
		
		Label lblNewLabel_8 = new Label(group_1, SWT.NONE);
		lblNewLabel_8.setBounds(58, 162, 76, 20);
		lblNewLabel_8.setText("影厅编号：");
		
		Label lblNewLabel_9 = new Label(group_1, SWT.NONE);
		lblNewLabel_9.setBounds(58, 203, 76, 20);
		lblNewLabel_9.setText("结束时间：");
		
		Label lblNewLabel_10 = new Label(group_1, SWT.NONE);
		lblNewLabel_10.setBounds(58, 249, 76, 20);
		lblNewLabel_10.setText("座位号：");
		
		Label lblNewLabel_11 = new Label(group_1, SWT.NONE);
		lblNewLabel_11.setBounds(57, 500, 76, 20);
		lblNewLabel_11.setText("小计：");
		
		text = new Text(group_1, SWT.BORDER);
		text.setBounds(156, 36, 169, 26);
		text.setText(cinnameString);
		
		text_1 = new Text(group_1, SWT.BORDER);
		text_1.setBounds(156, 76, 169, 26);
		text_1.setText(fnameString);
		
		text_2 = new Text(group_1, SWT.BORDER);
		text_2.setBounds(156, 200, 169, 26);
		text_8 = new Text(group_1, SWT.BORDER);
		text_8.setBounds(156, 429, 73, 26);
		
		final Combo combo_1 = new Combo(group_1, SWT.NONE);			
		combo_1.setBounds(156, 159, 61, 28);
		
	
			final Combo combo = new Combo(group_1, SWT.NONE);
		    try {
			List<Map<String, Object>> list = AdateTimes.getStimeForthreeDay(d1, combo, fnameString, cinnameString);
			for (Map<String, Object> map : list) {
				combo.add(map.get("Stime").toString());
			}
			combo.select(0);
			combo.setBounds(156, 119, 169, 28);
			} catch (Exception e1) {
						// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
			combo.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					try {
						list1 = AdateTimes.getRoomIDByStime(fnameString, cinnameString, combo.getText());
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					for (Map<String, Object> map : list1) {
						combo_1.add(map.get("RoomID").toString());
						text_2.setText(map.get("Etime").toString());
						text_8.setText(map.get("NormalPrice").toString());
						nprice = Integer.parseInt(map.get("NormalPrice").toString());
					}
					combo_1.select(0);
				}
			});
	   combo_1.addSelectionListener(new SelectionAdapter() {
	   @Override
	   public void widgetSelected(SelectionEvent e) {
		         for(int i = 0; i < 10; i++){
		        	 for(int j =0 ; j < 10; j++){
		        		 HadBuyPoint[i][j] = 0; 
		        	 }
		         }
				 try {
					DBUtils dbUtils = new DBUtils();
					String sql = "select hang,lie from shoppinglist where fbshow = '"+combo.getText()+"' and ShoppingFilmname = '"+text_1.getText()+"'and " +
					 		"cinname =  '"+text.getText()+"'and roomID = "+Integer.parseInt(combo_1.getText())+" ";
					 List<Map<String, Object>> list2 = dbUtils.query(sql);
					 System.out.println(list2.size());
					 for (Map<String, Object> map : list2) {
						int q = Integer.parseInt(map.get("hang").toString());
						int w = Integer.parseInt(map.get("lie").toString());
						HadBuyPoint[q][w] = 1; 						
						System.out.println(map.get("hang").toString() + " " + map.get("lie").toString());
					}					 
					 int x = 50, y = 100;
						for(int i = 0; i < 10; i++){
							for(int j = 0; j < 10; j++){
								final int q = i + 1;
								final int w = j + 1;
								int x1 = x + 50 * j;
								int y1 = y + 30 * i;
								final Label label1 = new Label(group, SWT.NONE);
								if(HadBuyPoint[i][j]== 0 ){
									label1.setImage(ResourceManager.getPluginImage("Mycam", "icons/可选座位.PNG"));
								}else{
									label1.setImage(ResourceManager.getPluginImage("Mycam", "icons/已售座位.PNG"));
								}
								label1.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseDown(MouseEvent e) {
										if(label1.getImage().equals(ResourceManager.getPluginImage("Mycam", "icons/已选座位.PNG"))){
											label1.setImage(ResourceManager.getPluginImage("Mycam", "icons/可选座位.PNG"));
											if(!text_6.getText().equals("")){
												text_6.setText("");
												text_7.setText(""+nprice * 3);
											}else if(!text_5.getText().equals("")){
												text_5.setText("");
												text_7.setText(""+nprice * 2);
											}else if(!text_4.getText().equals("")){
												text_4.setText("");
												text_7.setText(""+nprice * 1);
											}else{
												text_3.setText("");
												text_7.setText(""+nprice * 0);
											}
										}else{
											label1.setImage(ResourceManager.getPluginImage("Mycam", "icons/已选座位.PNG"));
											if(text_3.getText().equals("")){
												text_3.setText("第"+q+"排 第"+w+"列");
												text_7.setText(""+nprice * 1);
											}else if(text_4.getText().equals("")){
												text_4.setText("第"+q+"排 第"+w+"列");
												text_7.setText(""+nprice * 2);
											}else if(text_5.getText().equals("")){
												text_5.setText("第"+q+"排 第"+w+"列");
												text_7.setText(""+nprice * 3);
											}else if(text_6.getText().equals("")){
												text_6.setText("第"+q+"排 第"+w+"列");
												text_7.setText(""+nprice * 4);
											}else{
												BoxUtils.showBox("对不起，一个用户最多只能购买四张电影票！！！");
												label1.setImage(ResourceManager.getPluginImage("Mycam", "icons/可选座位.PNG"));
											}
										}									    
									}
								});
								label1.setBounds(x1, y1, 26, 25);
							}
						}
						
					 
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
	  
		text_3 = new Text(group_1, SWT.BORDER);
		text_3.setBounds(156, 246, 117, 26);
		
		text_4 = new Text(group_1, SWT.BORDER);
		text_4.setBounds(156, 287, 117, 26);
		
		text_5 = new Text(group_1, SWT.BORDER);
		text_5.setBounds(156, 334, 117, 26);
		
		text_6 = new Text(group_1, SWT.BORDER);
		text_6.setBounds(156, 382, 117, 26);		
		
		text_7 = new Text(group_1, SWT.BORDER);
		text_7.setBounds(156, 497, 73, 26);
		
		Button btnNewButton = new Button(group_1, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {		

			@Override
			public void widgetSelected(SelectionEvent e) {
				double p = 0;
				boolean f = (Boolean) Welcome.list.get(0).get("is_VIP");
				//System.out.println(f);
				if(f){
					p = Integer.parseInt(text_8.getText()) * 0.8;
				}else {
					p =  Integer.parseInt(text_8.getText());
				}
				String string[] = {text_3.getText(), text_4.getText(), text_5.getText(), text_6.getText()};
				int kase = 0;
				int rs = 0;
				for(int i = 0; i < 4; i++){
					if(string[i].equals("") || string[i].equals(null)) continue;
					rs++;
					int h = string[i].charAt(1) - '1';
					int l = string[i].charAt(5) - '1';
					Date date = new Date();
					DateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
					formatString = sdFormat.format(date);
					
					Date date1 = new Date();
					DateFormat sdFormat1 = new SimpleDateFormat("yyyy-MM-dd");
					String formatString1 = sdFormat1.format(date1);
					Map<String, Object> map = Welcome.list.get(0);
					ShoppingList shoppingList = new ShoppingList(map.get("usernames").toString(),formatString,text_1.getText(),
						text.getText(), Integer.parseInt(combo_1.getText()),h,l, combo.getText(), p,formatString1);
			        int ret = AshopList.addShop(shoppingList);
			        if(ret > 0) kase ++;
			        
			        
				}
				if(kase ==  rs ){
					BoxUtils.showBox("购买成功！");
					shell.dispose();
				}else{
					BoxUtils.showBox("购买失败！");
				}
			}
		});
		btnNewButton.setBounds(57, 540, 98, 30);
		btnNewButton.setText("提交订单");
		
		Button btnNewButton_1 = new Button(group_1, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
			}
		});
		btnNewButton_1.setBounds(244, 540, 98, 30);
		btnNewButton_1.setText("取消订单");
		
		Label lblNewLabel_12 = new Label(group_1, SWT.NONE);
		lblNewLabel_12.setBounds(57, 463, 76, 20);
		lblNewLabel_12.setText("优惠：");
		
		Label lblNewLabel_13 = new Label(group_1, SWT.NONE);
		lblNewLabel_13.setBounds(58, 429, 76, 20);
		lblNewLabel_13.setText("正常票价：");	
		
		final Label label_2 = new Label(group_1, SWT.NONE);
		label_2.setBounds(237, 463, 128, 20);
		
		text_9 = new Text(group_1, SWT.BORDER);
		text_9.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				
				label_2.setText("\u8F93\u5165\u4F1A\u5458\u53F7\u4EAB\u4F18\u60E0");
			}
			@Override
			public void focusLost(FocusEvent e) {
				System.out.println(Welcome.list.get(0).get("code").toString());
				if(text_9.getText().equals(Welcome.list.get(0).get("code").toString())){
					//System.out.println(123);
					text_7.setText(""+Integer.parseInt(text_7.getText())*0.8);
				}else {
					BoxUtils.showBox("对不起，会员号不正确");
				}
			}
		});
		text_9.setBounds(156, 461, 73, 26);
		System.out.println( Welcome.list.get(0));
		boolean b = (Boolean) Welcome.list.get(0).get("is_VIP");
		System.out.println(b);
		if(!b){
			text_9.setEnabled(false);
		}else {
			text_9.setEnabled(true);
		}
	}
}
