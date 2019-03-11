package Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import Utils.DBUtils;

public class checkFilmTest {
	
	public static void main(String[] args) throws SQLException {
		String date = "2015-5-25";
		DBUtils dbUtils = new DBUtils();
		String sql = "SELECT fname FROM films WHERE fUpTime <= '"+date+"' AND fDownTime >= '"+date+"'";
		List<Map<String, Object>> list = dbUtils.query(sql);
		for (Map<String, Object> map : list) {
		    System.out.println(map.get("fname").toString());
		}
	}

}
