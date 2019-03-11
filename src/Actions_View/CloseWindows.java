package Actions_View;

import org.eclipse.jface.action.Action;
import org.eclipse.ui.PlatformUI;

import core.Activator;

public class CloseWindows extends Action {
	
	public CloseWindows(){
		setImageDescriptor(Activator.getImageDescriptor("icons/88-16.png"));
		setText(" ÍË³ö");
	}

	@Override
	public void run() {
		PlatformUI.getWorkbench().close();
	}
	
	

}
