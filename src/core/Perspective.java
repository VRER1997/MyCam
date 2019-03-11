package core;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;


import Dialog.Login;
import View.CostomMenu;
import View.RootMemus;
import View.RootMenu;
import View.Welcome;

public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		layout.setEditorAreaVisible(false);
		
//		layout.addView(CostomMenu.ID, IPageLayout.LEFT, 0.13f, layout.getEditorArea());
//		layout.addView(Welcome.ID, IPageLayout.RIGHT, 0.87f, layout.getEditorArea());
		
		if(Login.is_root){
			layout.addView(RootMemus.ID, IPageLayout.LEFT, 0.13f, layout.getEditorArea());
			layout.addView(Welcome.ID, IPageLayout.RIGHT, 0.87f, layout.getEditorArea());
		}else {
			layout.addView(CostomMenu.ID, IPageLayout.LEFT, 0.13f, layout.getEditorArea());
			layout.addView(Welcome.ID, IPageLayout.RIGHT, 0.87f, layout.getEditorArea());
		}
		
	}
}
