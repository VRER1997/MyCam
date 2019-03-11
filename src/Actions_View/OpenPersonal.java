package Actions_View;

import org.eclipse.jface.action.Action;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;

import core.Activator;


import Dialog.CountDetailss;
import Dialog.Countdetailssss;
import Dialog.Login;

public class OpenPersonal extends Action{

    private IWorkbenchWindow window;
	
	public OpenPersonal(IWorkbenchWindow window){
		this.window = window;
		setImageDescriptor(Activator.getImageDescriptor("icons/Personal.png"));
		setText("’Àªßπ‹¿Ì");
	}
	@Override
	public void run() {
		if(!Login.is_root){
			CountDetailss countDetailss = new CountDetailss(new Shell(), SWT.CLOSE);
			countDetailss.open();
		}else {
			Countdetailssss countDetailss = new Countdetailssss(new Shell(), SWT.CLOSE);
			countDetailss.open();
		}
	}
	

}
