package Utils;

import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.ResourceManager;

public class SignUpShowUtils {
	
	public static void showCorrect(Label l1, Label l2, Label l3){
		l1.setImage(ResourceManager.getPluginImage("Mycam", "icons/\u6B63\u786E.PNG"));
		l2.setText("");
		l3.setText("");
	}
	public static void showErrort(Label l1, Label l2, String s,Label l3){
		l1.setImage(ResourceManager.getPluginImage("Mycam", "icons/\u8B66\u544A.PNG"));
		l2.setText(s);
		l3.setText("");
	}
}
