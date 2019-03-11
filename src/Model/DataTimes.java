package Model;

import java.sql.Date;

import org.eclipse.swt.widgets.DateTime;

public class DataTimes {
	
	private int year;
	private int month;
	private int day;
	private int hour;
	private int minute;
	public DataTimes(int year, int month, int day, int hour, int minute) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.minute = minute;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
	@Override
	public String toString() {
		if(minute < 10) return year + "-" + month + "-" + day + " " + hour + ":"+ "0"+minute; 
		return year + "-" + month + "-" + day + " " + hour + ":"+ minute;
	}
	
	public static int equals(DataTimes d, String s){
		String [] strings = s.split(" ");
		String [] astring = strings[0].split("-");
		String [] bstring = strings[1].split(":");
		if(Integer.parseInt(astring[0]) != d.getYear()) return d.getYear() - Integer.parseInt(astring[0]);
		if(Integer.parseInt(astring[1]) != d.getMonth()) return d.getMonth() - Integer.parseInt(astring[1]);
		if(Integer.parseInt(astring[2]) != d.getDay()) return d.getDay() - Integer.parseInt(astring[2]);
		if(Integer.parseInt(bstring[0]) != d.getHour()) return d.getHour() - Integer.parseInt(bstring[0]);
		if(Integer.parseInt(bstring[1]) != d.getMinute()) return d.getMinute() - Integer.parseInt(bstring[1]);
		return 0;
	}
	

}
