package core;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;

import Actions_View.CloseWindows;
import Actions_View.OpenPersonal;

public class ApplicationActionBarAdvisor extends ActionBarAdvisor {

	private OpenPersonal act1;
	private CloseWindows act2;
    public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
        super(configurer);
    }

    protected void makeActions(IWorkbenchWindow window) {
    	act1 = new OpenPersonal(window);
    	act2 = new CloseWindows();
    }

    protected void fillMenuBar(IMenuManager menuBar) {
    	IMenuManager imm = new MenuManager("个人中心");
    	imm.add(act1);
    	imm.add(act2);
    	menuBar.add(imm);
    }
    
}
