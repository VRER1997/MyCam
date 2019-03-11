package Dialog;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;

import Utils.DBUtils;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.wb.swt.SWTResourceManager;

public class SelectSZL extends Dialog {

	protected Object result;
	protected Shell shell;

	private int n;
	private int m;
	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public SelectSZL(Shell parent, int style) {
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
		shell.setBackgroundImage(ResourceManager.getPluginImage("Mycam", "icons/101613so88oflr6e7laaeb.jpg.thumb.jpg"));
		shell.setImage(ResourceManager.getPluginImage("Mycam", "icons/101613so88oflr6e7laaeb.jpg.thumb.jpg"));
		shell.setSize(609, 411);
		shell.setText("\u67E5\u8BE2\u6307\u5B9A\u6708\u4EFD\u9662\u7EBF\u7684\u552E\u5EA7\u7387");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 10, SWT.BOLD));
		lblNewLabel.setBounds(145, 88, 76, 20);
		lblNewLabel.setText("月份");
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 10, SWT.BOLD));
		lblNewLabel_1.setBounds(145, 136, 76, 20);
		lblNewLabel_1.setText("影院名称");
		
		Label lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 10, SWT.BOLD));
		lblNewLabel_2.setBounds(145, 186, 76, 28);
		lblNewLabel_2.setText("影厅编号");
		
		final Combo combo = new Combo(shell, SWT.NONE);
		combo.setBounds(260, 80, 65, 28);
		combo.add("");
		for(int i = 0; i < 10; i++){
			combo.add(""+"0"+i);
		}
		combo.add(""+10);
		combo.add(""+11);
		combo.add(""+12);
		combo.select(0);
		
		final Combo combo_1 = new Combo(shell, SWT.NONE);
		combo_1.setBounds(260, 128, 172, 28);
		try {
			DBUtils dbUtils = new DBUtils();
			List<Map<String, Object>> list = dbUtils.query("select distinct Roomname from cinrooms");
			combo_1.add("");
			for (Map<String, Object> map : list) {
				combo_1.add(map.get("Roomname").toString());
			}
			combo_1.select(0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		final Combo combo_2 = new Combo(shell, SWT.NONE);
		combo_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(!combo_1.getText().equals("")){
					try {
						combo_2.removeAll();
						DBUtils dbUtils = new DBUtils();
						List<Map<String, Object>> list = dbUtils.query("select distinct RoomID from cinrooms where Roomname = '"+combo_1.getText()+"'");
						combo_2.add("");
						for (Map<String, Object> map : list) {
							combo_2.add(map.get("RoomID").toString());
						}
						combo_2.select(0);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		combo_2.setBounds(260, 178, 65, 28);	
		
		
		Button button = new Button(shell, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int s = Integer.parseInt(combo.getText())+1;
				StringBuilder stringBuffer = new StringBuilder();
				stringBuffer.append("select * from shoppinglist where 1 = 1");
				if(!combo.getText().equals("")) stringBuffer.append(" and date >= '"+"2016-"+combo.getText()+"-01"+"' and " +
						" date <= '"+"2016-0"+s+"-01"+"'");
				if(!combo_1.getText().equals("")) stringBuffer.append("and cinname = '"+combo_1.getText()+"'");
				if(!combo_2.getText().equals("")) stringBuffer.append("and roomID = "+Integer.parseInt(combo_2.getText())+"");
				//System.out.println(stringBuffer.toString());
				DBUtils dbUtils = new DBUtils();
				try {
					List<Map<String, Object>> list = dbUtils.query(stringBuffer.toString());
					List<String> list1 = new ArrayList<String>();
					for (Map<String, Object> map : list) {
						String string = map.get("fbshow").toString();						
						int p = 1;
						for (String str : list1) {
							if(str.equals(string)) p = 0;
						}
						if(p == 0) continue;
						list1.add(string);
					}
					n = list.size();
					m = list1.size();
					//System.out.println(n + ", " + m);
					
					//默认的饼图数据集
					DefaultPieDataset dpd = new DefaultPieDataset();
					
					//设置数据集一参数为String课动态设置二参数为double为站饼图的比例为多少
					dpd.setValue("已售座位",n);
					dpd.setValue("待售座位",m*100 - n);
					 
				
					//基于char工厂显示有5个参数一为设置显示的标题二为现实的图形数据
					//三未知四为鼠标触碰图片是是否会产生提示	
					//五位URL最要的参数点击图标是否会产生连接
					String stringBuilder = new String();
					stringBuilder = ""+combo.getText()+"月份";
					if(!combo_1.getText().equals("")) stringBuilder += combo_1.getText();
					if(!combo_2.getText().equals("")) stringBuilder += combo_2.getText()+"号放映厅";
					stringBuilder += "上座率";
					JFreeChart jc = ChartFactory.createPieChart3D(stringBuilder,dpd,true,true,true);
							
					//jc为一个看到的图表
					ChartFrame cf = new ChartFrame(stringBuilder,jc);
					PiePlot3D plot = (PiePlot3D) jc.getPlot();
					plot.setForegroundAlpha(0.5f);
					cf.pack();
					
					cf.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		button.setBounds(202, 248, 151, 30);
		button.setText("\u67E5\u8BE2");

	}
}
