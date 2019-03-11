package Dialog;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import Actions.AdateTimes;
import Actions.AplanSet;
import Model.DataTimes;
import Model.PlanSet;
import Utils.BoxUtils;
import Utils.DBUtils;
import View.PlanManager;

public class AddPlan extends Dialog {

	protected Object result;
	protected Shell shell;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	
	private DataTimes dataTimes;
	private DataTimes d;
	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public AddPlan(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 * @throws Exception 
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
	 * @throws Exception 
	 */
	private void createContents() {
		shell = new Shell(getParent(), getStyle());
		shell.setSize(558, 550);
		shell.setText("\u589E\u52A0\u4E0A\u6620\u8BA1\u5212");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(73, 51, 76, 20);
		lblNewLabel.setText("影院名称");
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setBounds(73, 108, 76, 20);
		lblNewLabel_1.setText("影厅编号");
		
		Label lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setBounds(73, 164, 76, 20);
		lblNewLabel_2.setText("开场时间");
		
		Label lblNewLabel_3 = new Label(shell, SWT.NONE);
		lblNewLabel_3.setBounds(73, 273, 76, 20);
		lblNewLabel_3.setText("结束时间");
		
		Label lblNewLabel_4 = new Label(shell, SWT.NONE);
		lblNewLabel_4.setBounds(73, 316, 76, 20);
		lblNewLabel_4.setText("正常票价");
		
		Label lblNewLabel_5 = new Label(shell, SWT.NONE);
		lblNewLabel_5.setBounds(73, 368, 76, 20);
		lblNewLabel_5.setText("会员票价");
		
		final Combo combo = new Combo(shell, SWT.NONE);
		combo.setBounds(345, 164, 51, 28);
		for(int i = 0; i < 10; i++)
			combo.add("0"+i);
		for(int i = 10; i < 24; i++)
			combo.add(""+i);
		combo.select(0);
		
		final Combo combo_1 = new Combo(shell, SWT.NONE);
		combo_1.setBounds(431, 164, 51, 28);
		for(int i = 0; i < 10; i++)
			combo_1.add("0"+i);
		for(int i = 10; i < 60; i++)
			combo_1.add(""+i);
		combo_1.select(0);		
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(174, 313, 108, 26);
		
		text_3 = new Text(shell, SWT.BORDER);
		text_3.setBounds(174, 365, 108, 26);
		
		Label label = new Label(shell, SWT.NONE);
		label.setBounds(402, 167, 23, 20);
		label.setText("\u65F6");
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setText("\u5206");
		label_2.setBounds(488, 164, 23, 20);
		
		final Combo combo_3 = new Combo(shell, SWT.NONE);
		combo_3.setBounds(174, 108, 92, 28);
		
		final Combo combo_2 = new Combo(shell, SWT.NONE);
		combo_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				combo_3.removeAll();
				try {
					getroomID(combo_3, combo_2.getText());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		combo_2.setBounds(174, 43, 222, 28);
		try {
			getCinnameList(combo_2);
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		
		Label lblNewLabel_6 = new Label(shell, SWT.NONE);
		lblNewLabel_6.setBounds(73, 223, 76, 20);
		lblNewLabel_6.setText("电影名称");
		
		final DateTime dateTime = new DateTime(shell, SWT.BORDER | SWT.DROP_DOWN);		
		dateTime.setBounds(174, 164, 165, 28);
		
		final Combo combo_4 = new Combo(shell, SWT.NONE);
		
		dateTime.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					combo_4.removeAll();
					AdateTimes.CheckFilmsBydate(dateTime, combo_4);
					combo_4.select(0);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		text_4 = new Text(shell, SWT.BORDER);
		text_4.setBounds(174, 267, 222, 26);
		
		combo_4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					int h = Integer.parseInt(combo.getText());
					int m = Integer.parseInt(combo_1.getText());
//					System.out.println(h+" "+m);
					dataTimes = new DataTimes(dateTime.getYear(), dateTime.getMonth()+1, dateTime.getDay(), 
							h, m);					
					int timelong = AdateTimes.getTimelong(combo_4.getText());
//					System.out.println(timelong);
				    d = AdateTimes.AddDate(dataTimes, timelong);
					text_4.setText(d.toString());
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		combo_4.setBounds(174, 220, 222, 28);		
		
		combo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
			}
		});
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				PlanSet planSet = new PlanSet();
				planSet.setCinname(combo_2.getText());
				planSet.setRoomID(Integer.parseInt(combo_3.getText()));
				planSet.setStime(dataTimes.toString());
				planSet.setFilm(combo_4.getText());
				planSet.setEtime(text_4.getText());
				planSet.setNormalPrice(Double.parseDouble(text_2.getText()));
				planSet.setVipPrice(Double.parseDouble(text_3.getText()));
                try {
					if(AdateTimes.Is_detry(dataTimes, d, planSet.getCinname(), planSet.getRoomID())){
						int ret = AplanSet.addPlan(planSet);
						if(ret > 0){
							BoxUtils.showBox("计划添加成功！！！");
							shell.dispose();
							try {
								PlanManager.getlist();
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}else{
							BoxUtils.showBox("添加失败！！！");
						}
					}else{
						BoxUtils.showBox("对不起，该计划与之前的计划冲突！！！");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(99, 453, 98, 30);
		btnNewButton.setText("确认");
		
		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
			}
		});
		btnNewButton_1.setBounds(327, 453, 98, 30);
		btnNewButton_1.setText("取消");
		
		Button btnNewButton_2 = new Button(shell, SWT.NONE);
		btnNewButton_2.setBounds(219, 398, 98, 30);
		btnNewButton_2.setText("重置");
		
		
		
		
	}
	
	public static void getCinnameList(Combo combo) throws Exception{
		DBUtils dbUtils = new DBUtils();
		String sql = "select distinct Roomname from cinrooms";
		List<Map<String, Object>> list = dbUtils.query(sql);
		for (Map<String, Object> map : list) {			
			combo.add(map.get("Roomname").toString());
		}
		combo.select(0);
	}
	public static void getroomID(Combo combo,String name) throws Exception{
		DBUtils dbUtils = new DBUtils();
		String sql = "select distinct RoomID from cinrooms where Roomname = '"+name+"'";
		List<Map<String, Object>> list = dbUtils.query(sql);
		for (Map<String, Object> map : list) {			
			combo.add(map.get("RoomID").toString());
		}
		combo.select(0);
	}
}
