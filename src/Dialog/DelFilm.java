package Dialog;

import java.sql.SQLException;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import Utils.BoxUtils;
import View.YPmanager;

import Actions.Afilms;

public class DelFilm extends Dialog {

	protected Object result;
	protected Shell shell;
	private Text text;

	private TableItem t1;
	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public DelFilm(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open(TableItem tableItem) {
		t1 = tableItem;
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
		shell.setSize(564, 497);
		shell.setText("\u5220\u9664\u5F71\u7247\u9875");
		
		String string = "�װ����û���\n"+
                        "  ��ȷ��Ҫɾ��һ����Ϣ��\n"+
                        "  ID:    "+t1.getText(0)+"\n"+
                        "  Ƭ����         "+t1.getText(1)+"\n"+
                        "  ӰƬ���ͣ�  "+t1.getText(2)+"\n"+
                        "  ���ԣ�         "+t1.getText(3)+"\n"+
                        "  Ƭ����         "+t1.getText(4)+"\n"+
                        "  ���ݣ�         "+t1.getText(5)+"\n"+
                        "  ���ݣ�         "+t1.getText(6)+"\n"+
                        "  ��ӳʱ�䣺 "+t1.getText(7)+"\n"+
		                "  ����ʱ�䣺 "+t1.getText(8)+"\n"+
		                "  ��飺         "+t1.getText(9)+"\n";

		text = new Text(shell, SWT.BORDER | SWT.READ_ONLY | SWT.MULTI);
		text.setBounds(68, 51, 388, 260);
		text.setText(string);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int ret = Afilms.deleteFilm(Integer.parseInt(t1.getText(0)));
				if(ret > 0){
					BoxUtils.showBox("ɾ���ɹ�");
					shell.dispose();
					try {
						YPmanager.getList();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else{
					BoxUtils.showBox("ɾ��ʧ��");
					shell.dispose();
				}
			}
		});
		btnNewButton.setBounds(68, 344, 98, 30);
		btnNewButton.setText("ȷ��");
		
		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
			}
		});
		btnNewButton_1.setBounds(358, 344, 98, 30);
		btnNewButton_1.setText("ȡ��");

	}
}
