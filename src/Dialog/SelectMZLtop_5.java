package Dialog;

import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;

import Utils.DBUtils;
import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.wb.swt.SWTResourceManager;

public class SelectMZLtop_5 extends Dialog {

	protected Object result;
	protected Shell shell;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public SelectMZLtop_5(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
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
		shell.setBackgroundImage(ResourceManager.getPluginImage("Mycam", "icons/101523jzspx11iw424h4iw.jpg.thumb.jpg"));
		shell.setSize(604, 411);
		shell.setText("\u67E5\u8BE2\u6307\u5B9A\u65F6\u95F4\u6BB5\u5356\u5EA7\u7387\u524D\u4E94\u7684\u5F71\u7247");
		
		Label label = new Label(shell, SWT.NONE);
		label.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 10, SWT.BOLD));
		label.setText("\u8D77\u59CB\u65F6\u95F4");
		label.setBounds(140, 79, 76, 20);
		
		final DateTime dateTime = new DateTime(shell, SWT.BORDER | SWT.DROP_DOWN);
		dateTime.setBounds(254, 79, 165, 28);
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 10, SWT.BOLD));
		label_1.setText("\u7EC8\u6B62\u65F6\u95F4");
		label_1.setBounds(140, 140, 76, 20);
		
		final DateTime dateTime_1 = new DateTime(shell, SWT.BORDER | SWT.DROP_DOWN);
		dateTime_1.setBounds(254, 140, 165, 28);
		
		Button button = new Button(shell, SWT.NONE);
		button.setBackgroundImage(ResourceManager.getPluginImage("Mycam", "icons/Login.jpg"));
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				try {
					getlist(dateTime, dateTime_1);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setText("\u67E5\u8BE2");
		button.setBounds(196, 229, 174, 30);

	}
	
	void getlist(DateTime dateTime, DateTime dateTime2) throws SQLException{
		
		int y = dateTime.getYear();
		int m = dateTime.getMonth() + 1;
		int da = dateTime.getDay();
		String string = ""+y+"-";
		if(m < 10) string += "0";
		string += ""+m+"-";
		if(da < 10) string += "0";
		string += ""+ da;
		//System.out.println(string);
		
		int y1 = dateTime2.getYear();
		int m1 = dateTime2.getMonth() + 1;
		int da1 = dateTime2.getDay();
		String string1 = ""+y1+"-";
		if(m1 < 10) string1 += "0";
		string1 += ""+m1+"-";
		if(da1 < 10) string1 += "0";
		string1 += ""+ da1;
		//System.out.println(string1);
		
		DBUtils dbUtils = new DBUtils();
		String sql = "select * from shoppinglist where date >= '"+string+"' and date <= '"+string1+"'";
		List<Map<String, Object>> list = dbUtils.query(sql);
		int a[] = new int[1000];	
		for (int i : a) {
			i = 0;
		}
	    List<String> list1 = new ArrayList<String>();
	    list1.clear();
		for (Map<String, Object> map : list) {
		     String string2 = map.get("ShoppingFilmname").toString();
		     int p = 0;
		     for (int i = 0; i < list1.size(); i++) {
				if(list1.get(i).equals(string2)){
					p = 1;
					a[i]++;
				}
			}
		     
		     if(p == 0) {
		    	 list1.add(string2);
		    	 a[list1.size()-1] = 1;
		     }		  
		}
		
		
		DefaultCategoryDataset  dg = new DefaultCategoryDataset();
		
		int b[] = new int[100];
		for (int i : b) {
			i = 0;
		}
		//Map<String, Integer> map[] = new Map[5];
		for(int i = 0; i < 5; i++){
			int maxi = 0, max = 0;
		    String s = null;
			for(int j = 0; j < a.length; j++){
				if(a[j] > max && b[j] == 0 ){
					max = a[j];
					maxi = j;
					s = list1.get(j);
				}
			}
			
			b[maxi] = 1;
			System.out.println(a[maxi]+" " + s);
			//map[i].put(s, a[maxi]);
			dg.setValue(a[maxi], s, s);
		}
		
		
	
		JFreeChart jc = ChartFactory.createBarChart3D("hello", "影片售卖情况", "影片售卖数量",
				dg, PlotOrientation.VERTICAL, true, true, false);
		//改变头的内容字体及字体设置
		jc.setTitle(new TextTitle(string+"~"+string1+"影片卖座率前五名",new Font("宋体",Font.BOLD
				+Font.ITALIC,20)));
		//改变中间plot的内容及横纵坐标的字体颜色
		CategoryPlot plot = (CategoryPlot) jc.getPlot();

		CategoryAxis categoryAxis = plot.getDomainAxis();

		categoryAxis.setLabelFont(new Font("微软雅黑", Font.BOLD, 15));
		
		ChartFrame cf = new ChartFrame(string+"~"+string1+"影片卖座率前五名",jc);
		
		cf.pack();
		
		cf.setVisible(true);
	}

}
