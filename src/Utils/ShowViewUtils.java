package Utils;

import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

public class ShowViewUtils {
	
	public static IWorkbenchPage getIWorkbenchPage(){
		
		return PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
	}

}
