package Utils;

import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

public class BoxUtils {
	
	public static void showBox(String message){
		MessageBox mb = new MessageBox(new Shell());
		mb.setText("ϵͳ��Ϣ");
		mb.setMessage(message);
		mb.open();	
	}

}
