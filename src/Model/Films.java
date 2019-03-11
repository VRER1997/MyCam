package Model;

import java.sql.Date;

public class Films {
	
	private int filmID;
	private String fnameString;
	private String ftypeString;
	private int ftimelong ;
	private String fdirectorString;
	private String factorString;
	private String  fUptimeDate;
	private String flanguage;
	private String fDownDate;
	private String fbtextString;
	
	public Films (){}
	
	
	public Films(int filmID, String fnameString, String ftypeString,
			int ftimelong, String fdirectorString, String factorString,
			String fUptimeDate, String flanguage, String fDownDate,
			String fbtextString) {
		super();
		this.filmID = filmID;
		this.fnameString = fnameString;
		this.ftypeString = ftypeString;
		this.ftimelong = ftimelong;
		this.fdirectorString = fdirectorString;
		this.factorString = factorString;
		this.fUptimeDate = fUptimeDate;
		this.flanguage = flanguage;
		this.fDownDate = fDownDate;
		this.fbtextString = fbtextString;
	}


	public String getFlanguage() {
		return flanguage;
	}
	public void setFlanguage(String flanguage) {
		this.flanguage = flanguage;
	}
	public int getFilmID() {
		return filmID;
	}
	public void setFilmID(int filmID) {
		this.filmID = filmID;
	}
	public String getFnameString() {
		return fnameString;
	}
	public void setFnameString(String fnameString) {
		this.fnameString = fnameString;
	}
	public String getFtypeString() {
		return ftypeString;
	}
	public void setFtypeString(String ftypeString) {
		this.ftypeString = ftypeString;
	}
	public int getFtimelong() {
		return ftimelong;
	}
	public void setFtimelong(int ftimelong) {
		this.ftimelong = ftimelong;
	}
	public String getFdirectorString() {
		return fdirectorString;
	}
	public void setFdirectorString(String fdirectorString) {
		this.fdirectorString = fdirectorString;
	}
	public String getFactorString() {
		return factorString;
	}
	public void setFactorString(String factorString) {
		this.factorString = factorString;
	}
	public String getfUptimeDate() {
		return fUptimeDate;
	}
	public void setfUptimeDate(String fUptimeDate) {
		 this.fUptimeDate = fUptimeDate;
	}


	public String getfDownDate() {
		return fDownDate;
	}


	public void setfDownDate(String fDownDate) {
		this.fDownDate = fDownDate;
	}


	public String getFbtextString() {
		return fbtextString;
	}
	
	public void setFbtextString(String fbtextString) {
		this.fbtextString = fbtextString;
	}
	
	

}
