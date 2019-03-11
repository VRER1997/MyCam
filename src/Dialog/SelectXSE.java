package Dialog;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;

import Utils.DBUtils;
import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.wb.swt.SWTResourceManager;

public class SelectXSE extends Dialog {

	protected Object result;
	protected Shell shell;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public SelectXSE(Shell parent, int style) {
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
		shell.setBackgroundImage(ResourceManager.getPluginImage("Mycam", "icons/101530k2xwxbxht4u7hn4u.jpg.thumb.jpg"));
		shell.setSize(550, 389);
		shell.setText("\u67E5\u8BE2\u6307\u5B9A\u5E74\u4EFD\u7684\u9500\u552E\u989D\u53CA\u5176\u5404\u6708\u4EFD\u6BD4\u4F8B");
		
		Label label = new Label(shell, SWT.NONE);
		label.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.BOLD));
		label.setBounds(199, 135, 43, 27);
		label.setText("\u6708\u4EFD");
		
		final Combo combo = new Combo(shell, SWT.NONE);
		combo.setBounds(279, 134, 64, 21);
		combo.add(""+2016);
		combo.select(0);
		
		Button button = new Button(shell, SWT.NONE);
		button.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 10, SWT.BOLD));
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					getsh(combo);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(199, 215, 144, 30);
		button.setText("\u67E5\u8BE2");

	}
	void getsh(Combo combo) throws SQLException{
		DBUtils dbUtils = new DBUtils();
		int a[] = new int[12];
		for (int i : a) {
			i = 0;
		}
		String sql = "select sum(ShopTotalPrice) from shoppinglist where date >= '"+combo.getText()+"-01-01"+"' and date < '"+combo.getText()+"2016-12-31"+"'";
		for(int i = 0; i < 12; i++){
		String f = "-", g = "-";
		if(i < 10) {
			f += '0';
			g += '0';
		}
		f += ""+i;
		int m = i + 1;
		g += ""+ m;
		String sql1 = "select sum(ShopTotalPrice) from shoppinglist where date >= '"+combo.getText()+f+"-01"+"' " +
		" and date < '"+combo.getText()+g+"-01"+"'";
		a[i] = dbUtils.check(sql1); 
		}
		int n = dbUtils.check(sql);
//		
//		for (int i : a) {
//			System.out.println(i);
//		}
		
		
		//Ĭ�ϵı�ͼ���ݼ�
		DefaultPieDataset dpd = new DefaultPieDataset();
		
		//�������ݼ�һ����ΪString�ζ�̬���ö�����ΪdoubleΪվ��ͼ�ı���Ϊ����
		//dpd.setValue(combo.getText()+"ȫ�����۶�",n);
		for(int i = 1; i <= 12; i++){
			dpd.setValue("��"+i+"�·����۶�",(double) a[i-1]);
		}
		 
	
		//����char������ʾ��5������һΪ������ʾ�ı����Ϊ��ʵ��ͼ������
		//��δ֪��Ϊ��괥��ͼƬ���Ƿ�������ʾ	
		//��λURL��Ҫ�Ĳ������ͼ���Ƿ���������
		JFreeChart jc = ChartFactory.createPieChart3D(combo.getText()+"�����۶�",dpd,true,true,true);
				
		//jcΪһ��������ͼ��
		ChartFrame cf = new ChartFrame(combo.getText()+"�����۶�",jc);
		PiePlot3D plot = (PiePlot3D) jc.getPlot();
		plot.setForegroundAlpha(0.5f);
		
		cf.pack();
		
		cf.setVisible(true);
		
	}
}
