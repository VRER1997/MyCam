package Actions;

import java.util.List;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

import Model.PlanSet;
import Utils.DBUtils;

public class AplanSet {
	
	/**
	 * 上映计划的操作
	 * @param plan
	 * @return
	 */
	
	public static int addPlan(PlanSet plan){
		DBUtils dbUtils = new DBUtils();
		String sql = "INSERT INTO planset (Cinname, RoomID,Filmname, Stime,Etime,NormalPrice,VipPrice,CurNum) VALUES " +
				"('"+plan.getCinname()+"',"+plan.getRoomID()+",'"+plan.getFilm()+"','"+plan.getStime()+"'," +
				"'"+plan.getEtime()+"',"+plan.getNormalPrice()+","+plan.getVipPrice()+", 0)";
		int ret = dbUtils.update(sql);
		return ret;
	}
	public static int  deletePlan(int ID){
		DBUtils dbUtils = new DBUtils();
		String sql = "delete from planset where ID = "+ID+"";
		int ret = dbUtils.update(sql);
		return ret;
	}
    public static int editPlan(PlanSet plan,int id){
    	DBUtils dbUtils = new DBUtils();
		String sql = "update planset set Cinname = '"+plan.getCinname()+"', RoomID = "+plan.getRoomID()+",Filmname = '"+plan.getFilm()+"', " +
				"Stime = '"+plan.getStime()+"', Etime = '"+plan.getEtime()+"',NormalPrice = "+plan.getNormalPrice()+",VipPrice = "+plan.getVipPrice()+"," +
						"CurNum = 0 where ID = "+id+"";
		int ret = dbUtils.update(sql);
		return ret;	
    }
}
