	package Dialog;
	
	import java.sql.SQLException;
	import java.util.List;
	import java.util.Map;
	import java.util.jar.Attributes.Name;
	
	import org.eclipse.swt.widgets.DateTime;
	import org.eclipse.swt.widgets.Dialog;
	import org.eclipse.swt.widgets.Display;
	import org.eclipse.swt.widgets.Shell;
	import org.eclipse.swt.widgets.Label;
	import org.eclipse.swt.SWT;
	import org.eclipse.swt.widgets.Group;
	import org.eclipse.wb.swt.SWTResourceManager;
	import org.eclipse.swt.widgets.Text;
	import org.eclipse.wb.swt.ResourceManager;
	import org.eclipse.swt.widgets.Combo;
	import org.eclipse.swt.widgets.Button;
	import org.eclipse.swt.events.SelectionAdapter;
	import org.eclipse.swt.events.SelectionEvent;
	
	import Actions.AfilmTable;
	import Actions.AshopList;
	import Utils.DBUtils;
	
	public class Filmdialog extends Dialog {
	
		protected Object result;
		protected Shell shell;
		private Text text;
		private Text text_1;
		private Text text_2;
		private Text text_3;
		private Text text_4;
		private Text text_5;
		private Text text_6;
		private Text text_7;
	    
		private String fnameString;
		private DateTime dateTime;
		
		private int filmID;
		private String fname;
		private String ftypeString;
		private int ftimelong ;
		private String fdirectorString;
		private String factorString;
		private String  fUptimeDate;
		private String flanguage;
		private String fDowmtimeString;
		private String fbtext;
		/**
		 * Create the dialog.
		 * @param parent
		 * @param style
		 */
		public Filmdialog(Shell parent, int style) {
			super(parent, style);
			setText("SWT Dialog");
		}
	
		/**
		 * Open the dialog.
		 * @return the result
		 */
		public Object open(String d, DateTime dateTime) {
			fnameString = d;
			this.dateTime = dateTime;
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
			shell.setBackgroundImage(ResourceManager.getPluginImage("Mycam", "icons/shoopingDialog.png"));
			shell.setSize(547, 771);
			shell.setText("\u5F71\u7247\u8BE6\u60C5\u9875");
			
			Label lblNewLabel = new Label(shell, SWT.BORDER);
			lblNewLabel.setImage(ResourceManager.getPluginImage("Mycam", AfilmTable.getpath(fnameString)));
			lblNewLabel.setBounds(28, 94, 161, 237);
			
			Group group = new Group(shell, SWT.NONE);
			group.setBounds(225, 46, 251, 62);
			
			Label lblNewLabel_1 = new Label(group, SWT.NONE);
			lblNewLabel_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
			lblNewLabel_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 10, SWT.BOLD));
			lblNewLabel_1.setBounds(22, 19, 219, 33);
			lblNewLabel_1.setText(fnameString);
			
			Label lblNewLabel_2 = new Label(shell, SWT.NONE);
			lblNewLabel_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
			lblNewLabel_2.setBounds(225, 127, 30, 20);
			lblNewLabel_2.setText("首映");
			
			Label lblNewLabel_3 = new Label(shell, SWT.NONE);
			lblNewLabel_3.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
			lblNewLabel_3.setBounds(225, 163, 30, 20);
			lblNewLabel_3.setText("类型");
			
			Label lblNewLabel_4 = new Label(shell, SWT.NONE);
			lblNewLabel_4.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
			lblNewLabel_4.setBounds(225, 200, 30, 20);
			lblNewLabel_4.setText("版本");
			
			Label lblNewLabel_5 = new Label(shell, SWT.NONE);
			lblNewLabel_5.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
			lblNewLabel_5.setBounds(225, 236, 30, 20);
			lblNewLabel_5.setText("语言");
			
			Label lblNewLabel_6 = new Label(shell, SWT.NONE);
			lblNewLabel_6.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
			lblNewLabel_6.setBounds(225, 273, 30, 20);
			lblNewLabel_6.setText("时长");
			
			Label lblNewLabel_7 = new Label(shell, SWT.NONE);
			lblNewLabel_7.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
			lblNewLabel_7.setBounds(225, 311, 30, 20);
			lblNewLabel_7.setText("导演");
			
			Label lblNewLabel_8 = new Label(shell, SWT.NONE);
			lblNewLabel_8.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
			lblNewLabel_8.setBounds(225, 348, 30, 20);
			lblNewLabel_8.setText("主演");
			
			Group group_1 = new Group(shell, SWT.NONE);
			group_1.setText("\u5267\u60C5");
			group_1.setBounds(34, 405, 460, 168);
			
			DBUtils dbUtils = new DBUtils();
			try {
				List<Map<String, Object>> list = dbUtils.query("select * from films where fname ='"+fnameString+"' ");
				for (Map<String, Object> map : list) {
					filmID = Integer.parseInt(map.get("filmID").toString());
					fname = map.get("fname").toString();
					ftypeString = map.get("ftype").toString();
					ftimelong = Integer.parseInt(map.get("ftime").toString());
					fdirectorString = map.get("fdirector").toString();
					factorString = map.get("factors").toString();
					fUptimeDate = map.get("fUpTime").toString();
					flanguage = map.get("flanguage").toString();
					fDowmtimeString = map.get("fDownTime").toString();
					fbtext = map.get("fbrifeText").toString();
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			text_7 = new Text(group_1, SWT.READ_ONLY | SWT.V_SCROLL | SWT.MULTI);
			text_7.setBackground(SWTResourceManager.getColor(255, 255, 255));
			text_7.setForeground(SWTResourceManager.getColor(SWT.COLOR_TITLE_INACTIVE_FOREGROUND));
			text_7.setBounds(10, 25, 444, 133);
			text_7.setText(fbtext);
			
			text = new Text(shell, SWT.READ_ONLY);
			text.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
			text.setBounds(284, 127, 147, 20);
			text.setText(fUptimeDate);
			
			text_1 = new Text(shell, SWT.READ_ONLY);
			text_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
			text_1.setBounds(284, 163, 147, 20);
			text_1.setText(ftypeString);
			
			text_2 = new Text(shell, SWT.READ_ONLY);
			text_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
			text_2.setBounds(284, 200, 147, 20);
			text_2.setText("3D");
			
			text_3 = new Text(shell, SWT.READ_ONLY);
			text_3.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
			text_3.setBounds(284, 236, 147, 20);
			text_3.setText(flanguage);
			
			text_4 = new Text(shell, SWT.READ_ONLY);
			text_4.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
			text_4.setBounds(284, 270, 147, 20);
			text_4.setText(""+ftimelong);
			
			text_5 = new Text(shell, SWT.READ_ONLY);
			text_5.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
			text_5.setBounds(284, 308, 147, 20);
			text_5.setText(fdirectorString);
			
			text_6 = new Text(shell, SWT.READ_ONLY);
			text_6.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
			text_6.setBounds(284, 345, 147, 20);
			text_6.setText(factorString);
			
			Group group_2 = new Group(shell, SWT.NONE);
			group_2.setText("\u4E0A\u6620\u5F71\u9662");
			group_2.setBounds(42, 608, 452, 101);
			
			final Combo combo = new Combo(group_2, SWT.READ_ONLY);
			combo.setBounds(37, 40, 224, 28);
			try {
				getCinnameList(combo, fname);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			Button button = new Button(group_2, SWT.NONE);
			button.setEnabled(true);
			if(combo.getText().equals("") ||combo.getText().equals(null))
				button.setEnabled(false);
			button.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					FilmDetail filmDetail = new FilmDetail(new Shell(), SWT.CLOSE); 
					filmDetail.open(combo.getText(),fname, dateTime);
				}
			});
			button.setBounds(324, 38, 98, 30);
			button.setText("\u9009\u5EA7\u8D2D\u7968");
	
		}
		public static void getCinnameList(Combo combo, String name) throws Exception{
			DBUtils dbUtils = new DBUtils();
			String sql = "SELECT DISTINCT Cinname FROM planset WHERE Filmname = '"+name+"'";
			List<Map<String, Object>> list = dbUtils.query(sql);
			for (Map<String, Object> map : list) {			
				combo.add(map.get("Cinname").toString());
			}
			combo.select(0);
		}
	}
