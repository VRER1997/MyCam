package Dialog;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;

import Utils.DBUtils;
import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class DingdanDia extends Dialog {

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
	private Text text_8;
	private Text text_9;
	private Text text_10;

	private String dateString;
	private String id;
	private String buyer;
	private String fname;
	private String cinname;
	private String roomIDString;
	private int hang[] = new int[15];
	private int lie[] = new int[15];
	private String fb;
	private double price;
	
	private List<Map<String, Object>> list;
	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public DingdanDia(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open(String d, double f) {
		price = f;
		dateString = d;
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
		shell.setBackgroundImage(ResourceManager.getPluginImage("Mycam", "icons/100059809.jpg"));
		shell.setSize(507, 674);
		shell.setText("\u8BA2\u5355\u8BE6\u60C5\u9875");
		
		Label label = new Label(shell, SWT.NONE);
		label.setText("\u8BA2\u5355\u8BE6\u60C5\u9875");
		label.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 14, SWT.BOLD));
		label.setBounds(78, 23, 113, 38);
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		label_1.setBounds(55, 23, 17, 38);
		
		Label label_2 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_2.setBounds(55, 67, 416, 9);
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(78, 104, 76, 20);
		lblNewLabel.setText("电影名称");
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setBounds(78, 190, 76, 20);
		lblNewLabel_1.setText("影院名称");
		
		Label lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setBounds(78, 235, 76, 20);
		lblNewLabel_2.setText("影厅编号");
		
		Label lblNewLabel_3 = new Label(shell, SWT.NONE);
		lblNewLabel_3.setBounds(78, 486, 76, 20);
		lblNewLabel_3.setText("购买者");
		
		Label lblNewLabel_4 = new Label(shell, SWT.NONE);
		lblNewLabel_4.setBounds(78, 277, 76, 20);
		lblNewLabel_4.setText("坐位号");
		
		Label lblNewLabel_5 = new Label(shell, SWT.NONE);
		lblNewLabel_5.setBounds(78, 446, 76, 20);
		lblNewLabel_5.setText("合计");
		
		Label lblNewLabel_6 = new Label(shell, SWT.NONE);
		lblNewLabel_6.setBounds(78, 147, 76, 20);
		lblNewLabel_6.setText("开场时间");
		
		DBUtils dbUtils = new DBUtils();
		try {
			list = dbUtils.query("select * from shoppinglist where ShoppingTime = '"+dateString+"'");
			id = list.get(list.size()-1).get("ID").toString();
			buyer = list.get(0).get("ShoppingBuyer").toString();
			fname = list.get(0).get("ShoppingFilmname").toString();
			cinname = list.get(0).get("cinname").toString();
			roomIDString = list.get(0).get("roomID").toString();			
			fb = list.get(0).get("fbshow").toString();
			
			for(int i = 0; i < list.size(); i++){
				hang[i] = Integer.parseInt(list.get(i).get("hang").toString()) +1;
				lie[i] = Integer.parseInt(list.get(i).get("lie").toString()) +1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		text = new Text(shell, SWT.BORDER | SWT.READ_ONLY);
		text.setBounds(185, 101, 187, 26);
		text.setText(fname);
		
		text_1 = new Text(shell, SWT.BORDER | SWT.READ_ONLY);
		text_1.setBounds(185, 141, 187, 26);
		text_1.setText(fb);
		
		text_2 = new Text(shell, SWT.BORDER | SWT.READ_ONLY);
		text_2.setBounds(185, 184, 187, 26);
		text_2.setText(cinname);
		
		text_3 = new Text(shell, SWT.BORDER | SWT.READ_ONLY);
		text_3.setBounds(185, 229, 73, 26);
		text_3.setText(roomIDString);
		
		text_4 = new Text(shell, SWT.BORDER | SWT.READ_ONLY);
		text_4.setBounds(185, 271, 187, 26);
		if(list.size() >= 1)
			text_4.setText("第"+hang[0]+"行 第"+lie[0]+"列");
		
		text_5 = new Text(shell, SWT.BORDER | SWT.READ_ONLY);
		text_5.setBounds(185, 314, 187, 26);
		if(list.size() >= 2)
			text_5.setText("第"+hang[1]+"行 第"+lie[1]+"列");
		
		text_6 = new Text(shell, SWT.BORDER | SWT.READ_ONLY);
		text_6.setBounds(185, 354, 187, 26);
		if(list.size() >= 3)
			text_6.setText("第"+hang[2]+"行 第"+lie[2]+"列");
		
		text_7 = new Text(shell, SWT.BORDER | SWT.READ_ONLY);
		text_7.setBounds(185, 396, 187, 26);
		if(list.size() >= 4)
			text_7.setText("第"+hang[3]+"行 第"+lie[3]+"列");
		
		text_8 = new Text(shell, SWT.BORDER | SWT.READ_ONLY);
		text_8.setBounds(185, 440, 73, 26);
		text_8.setText(""+price);
		
		text_9 = new Text(shell, SWT.BORDER | SWT.READ_ONLY);
		text_9.setBounds(185, 480, 131, 26);
		text_9.setText(buyer);
		
		Button button = new Button(shell, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
			}
		});
		button.setBounds(185, 557, 161, 43);
		button.setText("\u6211\u77E5\u9053\u4E86");
		
		Label lblNewLabel_7 = new Label(shell, SWT.NONE);
		lblNewLabel_7.setBounds(208, 41, 54, 20);
		lblNewLabel_7.setText("订单号");
		
		text_10 = new Text(shell, SWT.BORDER | SWT.READ_ONLY);
		text_10.setBounds(268, 41, 95, 26);
        text_10.setText(id);
	}
}
