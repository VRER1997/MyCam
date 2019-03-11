package Actions;

import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.ResourceManager;

public class AfilmTable {
	
	public static String getpath(String name){
		return "icons/"+name+".jpg";
		//icons/《魔兽》.PNG
	}
	/**
	 * 生成座位图
	 * @param label1
	 */
	public static void getG(final Label label1){
		int x = 115, y = 220;
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				int x1 = x + 50 * j;
				int y1 = y + 30 * i;
				System.out.println(123);			
				label1.setImage(ResourceManager.getPluginImage("Mycam", "icons/可选座位.PNG"));
				label1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseDown(MouseEvent e) {
						if(label1.getImage().equals(ResourceManager.getPluginImage("Mycam", "icons/已选座位.PNG")))
							label1.setImage(ResourceManager.getPluginImage("Mycam", "icons/可选座位.PNG"));
						else
						    label1.setImage(ResourceManager.getPluginImage("Mycam", "icons/已选座位.PNG"));
					}
				});
				label1.setBounds(x1, y1, 26, 25);
			}
		} 
	}

}
