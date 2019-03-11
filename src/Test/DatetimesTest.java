package Test;

import Actions.AdateTimes;
import Model.DataTimes;

public class DatetimesTest {
	
	public static void main(String[] args) {
		DataTimes d1 = null;
		DataTimes d = new DataTimes(2016, 3, 1, 23, 00);
//		d1 = AdateTimes.AddDate(d, 114);
//		System.out.println(d1.toString());
		
//		try {
//			int ret = AdateTimes.getTimelong("¡¶Ä£·ÂÓÎÏ·¡·");
//			System.out.println(ret);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		System.out.println(DataTimes.equals(d, "2016-3-1 23:00"));
		
		
	}
  
}
