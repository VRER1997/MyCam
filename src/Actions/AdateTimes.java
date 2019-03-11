package Actions;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.xml.soap.Text;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;

import Model.DataTimes;
import Test.DatetimesTest;
import Utils.DBUtils;

public class AdateTimes {
	
	/**
	 * 关于datetimes类的增删改查
	 */
	
	private static int md[] = {31,28,31,30,31,30,31,31,30,31,30,31};
	
	public static DataTimes AddDate(DataTimes d, int timelong ){
		DataTimes d1 = new DataTimes(0, 0, 0, 0, 0);
		int m = timelong % 60;
		int h = timelong / 60;
		d1.setMinute((d.getMinute() + m) % 60);		
		int chrry = (d.getMinute() + m) / 60;
		d1.setHour(d.getHour() + h + chrry);
		if(d1.getHour() >= 24){   
			d1.setHour((d.getHour() + h + chrry)%24);			
		}
		chrry = (d.getHour() + h + chrry) / 24;
		//if(is_prime(d.getYear())) md[1]++;
		if(chrry > 0){
			d1.setDay((d.getDay() + 1)%md[d.getMonth()]);			
			d1.setMonth((d.getMonth()+1+(d.getDay() + 1)/md[d.getMonth()])%12);			
			d1.setYear(d.getYear()+(d.getMonth()+1+(d.getDay() + 1)/md[d.getMonth()])/12);
		}else{
			d1.setDay(d.getDay());
			d1.setMonth(d.getMonth());
			d1.setYear(d.getYear());
		}
		return d1;
	}
	
    public static boolean is_prime(int i){
    	if(i % 4 == 0 && i % 100 != 0) return true;
    	if(i % 400 == 0) return true;
    	return false;
    }
    
    public static int getTimelong(String name) throws Exception{
    	DBUtils dbUtils = new DBUtils();
    	String sql = "SELECT ftime FROM films WHERE fname = '"+name+"'";
    	List<Map<String, Object>> list = dbUtils.query(sql);
    	int ret = 0;
    	for (Map<String, Object> map : list) {
			ret = Integer.parseInt((String) map.get("ftime"));
		}
		return ret;		    	
    }
    public static boolean Is_detry(DataTimes d,DataTimes d1,String ciname , int ID) throws SQLException{

    	boolean is_ok = true;
    	DBUtils dbUtils = new DBUtils();
    	String sql = "select Stime,Etime from planset where Cinname = '"+ciname+"' AND RoomID = "+ID+"";
    	List<Map<String, Object>> list = dbUtils.query(sql);
    	for (Map<String, Object> map : list) {
			if(DataTimes.equals(d, map.get("Stime").toString()) >= 0 && DataTimes.equals(d, map.get("Etime").toString()) <= 0)
				is_ok = false;
			if(DataTimes.equals(d1, map.get("Stime").toString()) >= 0 && DataTimes.equals(d1, map.get("Etime").toString()) <= 0)
				is_ok = false;
		}
    	return is_ok;
    }
    public static void CheckFilmsBydate(DateTime d, Combo combo) throws Exception{
		int y = d.getYear();
		int m = d.getMonth() + 1;
		int da = d.getDay();
		String date = ""+y+"-"+m+"-"+da;
		DBUtils dbUtils = new DBUtils();
		String sql = "SELECT fname FROM films WHERE fUpTime <= '"+date+"' AND fDownTime >= '"+date+"'";
		List<Map<String, Object>> list = dbUtils.query(sql);
		for (Map<String, Object> map : list) {
			combo.add(map.get("fname").toString());
		}
	}
    
    public static List<Map<String, Object>> CheckFilmsBydateForThreeDay(DateTime d) throws Exception{
		int y = d.getYear();
		int m = d.getMonth() + 1;
		int da = d.getDay();
		String date = ""+y+"-"+m+"-"+da;
		DBUtils dbUtils = new DBUtils();
		String sql = "SELECT distinct fname FROM films WHERE (fUpTime <= '"+date+"' AND fDownTime >= '"+date+"') or" +
				"(fUpTime <= '"+AdateTimes.dateAddOne(d,1)+"' AND fDownTime >= '"+AdateTimes.dateAddOne(d,1)+"')" +
						" or (fUpTime <= '"+AdateTimes.dateAddOne(d,2)+"' AND fDownTime >= '"+AdateTimes.dateAddOne(d,2)+"')";
		List<Map<String, Object>> list = dbUtils.query(sql);
		return list;
//		for (Map<String, Object> map : list) {
//			combo.add(map.get("fname").toString());
//		}
	}
    
    @SuppressWarnings("null")
	public static String dateAddOne(DateTime d, int i){
    	DataTimes d1 = new DataTimes(0, 0, 0, 0, 0);
    	d1.setDay((d.getDay() + i)%md[d.getMonth()]);			
		d1.setMonth((d.getMonth()+1+(d.getDay() + i)/md[d.getMonth()])%12);			
		d1.setYear(d.getYear()+(d.getMonth()+1+(d.getDay() + i)/md[d.getMonth()])/12);
		return ""+d1.getYear()+"-"+d1.getMonth()+"-"+d1.getDay();
    }
	public static void getCinnameForthreeDay(DateTime d, Combo combo, String name) throws Exception{
			int y = d.getYear();
			int m = d.getMonth() + 1;
			int da = d.getDay();
			String date = ""+y+"-"+m+"-"+da;
			DBUtils dbUtils = new DBUtils();
			String sql = "SELECT distinct b.Cinname FROM films as a,planset as b WHERE (a.fUpTime <= '"+date+"' AND a.fDownTime >= '"+date+"') or" +
					"(a.fUpTime <= '"+AdateTimes.dateAddOne(d,1)+"' AND a.fDownTime >= '"+AdateTimes.dateAddOne(d,1)+"')" +
							" or (a.fUpTime <= '"+AdateTimes.dateAddOne(d,2)+"' AND a.fDownTime >= '"+AdateTimes.dateAddOne(d,2)+"')" +
									"AND a.fname = '"+name+"'";
			List<Map<String, Object>> list = dbUtils.query(sql);
			for (Map<String, Object> map : list) {
				combo.add(map.get("Cinname").toString());
			}
		
	}
	public static List<Map<String, Object>> getStimeForthreeDay(DateTime d, Combo combo, String name,String cin) throws Exception{
		int y = d.getYear();
		int m = d.getMonth() + 1;
		int da = d.getDay();
		String date = ""+y+"-"+m+"-"+da;
		DBUtils dbUtils = new DBUtils();
		String sql = "SELECT distinct b.Stime FROM films as a,planset as b WHERE a.fname = b.Filmname and ((a.fUpTime <= '"+date+"' AND a.fDownTime >= '"+date+"') or" +
				"(a.fUpTime <= '"+AdateTimes.dateAddOne(d,1)+"' AND a.fDownTime >= '"+AdateTimes.dateAddOne(d,1)+"')" +
						" or (a.fUpTime <= '"+AdateTimes.dateAddOne(d,2)+"' AND a.fDownTime >= '"+AdateTimes.dateAddOne(d,2)+"'))" +
								"AND a.fname = '"+name+"' AND b.Cinname = '"+cin+"' order by b.RoomID";
		List<Map<String, Object>> list = dbUtils.query(sql);
		return list;
//		for (Map<String, Object> map : list) {
//			combo.add(map.get("RoomID").toString());
//		}
//	
}
	
	public static List<Map<String, Object>> getRoomIDByStime(String name,String cin, String dateString) throws Exception{
		DBUtils dbUtils = new DBUtils();
		String sql = "SELECT distinct RoomID, Etime, NormalPrice  FROM planset  WHERE Filmname = '"+name+"' AND Cinname = '"+cin+"' and Stime = '"+dateString+"'";
		List<Map<String, Object>> list = dbUtils.query(sql);
		return list;
//		for (Map<String, Object> map : list) {
//			combo.add(map.get("RoomID").toString());
//		}
//	
	}
	
	public static List<Map<String, Object>> getcheckfordate(DateTime d) throws SQLException{
		int y = d.getYear();
		int m = d.getMonth() + 1;
		int da = d.getDay();
		String date = ""+y+"-"+m+"-"+da;
		DBUtils dbUtils = new DBUtils();
		String sql = "select * from shoppinglist where '"+date+"' < fbshow and '"+AdateTimes.dateAddOne(d, 1)+"' > fbshow";
		List<Map<String, Object>> list = dbUtils.query(sql);
		return list;
		
	}
}
