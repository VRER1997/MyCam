package Actions;

import Model.CinRooms;
import Utils.DBUtils;

public class AcinRooms {
	
	/**
	 * ӰԺ��Ϣ����ɾ�Ĳ�
	 * @param c
	 * @return
	 */
	
	public static int  addcinrooms(CinRooms c){		
		DBUtils dbUtils = new DBUtils();
		String sql = "INSERT INTO cinrooms VALUES ('"+c.getRoomname()+"',"+c.getRoomID()+",'"+c.getRtype()+"'," +
				""+c.getMaxNum()+")";
		int ret = dbUtils.update(sql);
		return ret;
	}
	
	public static int  editcinrooms(CinRooms c){
		DBUtils dbUtils = new DBUtils();
		String sql = "update cinrooms set Roomname = '"+c.getRoomname()+"',RoomID = "+c.getRoomID()+",rtype = '"+c.getRtype()+"',"+
				"maxNum = "+c.getMaxNum()+" where RoomID = "+c.getRoomID()+"";
		int ret = dbUtils.update(sql);
		return ret;
	}
	public static void UpdatecinRooom(){}
	public static int  deletecinrooms(int ID){
		DBUtils dbUtils = new DBUtils();
		String sql = "delete from cinrooms where RoomID = "+ID+"";
		int ret = dbUtils.update(sql);
		return ret;
	}

}
