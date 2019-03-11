package Actions;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

import Model.ShoppingList;
import Utils.DBUtils;

public class AshopList {
	/**
	 * 购物记录的操作
	 * @param s
	 * @return
	 */
	
	public static int addShop(ShoppingList s){
		DBUtils dbUtils = new DBUtils();
		String sql = "insert into shoppinglist values ("+s.getID()+",'"+s.getBuyerString()+"', '"+s.getBuyDateString()+"', '"+s.getFnameString()+"'," +
				"'"+s.getCinnameString()+"', "+s.getRoomIDString()+", "+s.getH()+", "+s.getL()+",'"+s.getFbeginTime()+"', "+s.getPrice()+",'"+s.getDateString()+"')";
		int ret = dbUtils.update(sql);
		return ret;
	}
	
	

}
