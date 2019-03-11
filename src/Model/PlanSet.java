package Model;

public class PlanSet {
	  private String cinname;
	  private int RoomID;
	  private String stime;
	  private String etime;
	  private String film;
	  private double normalPrice;
	  private double vipPrice;
	  
	  public PlanSet(){}
	  public PlanSet(String cinname, int roomID, String stime, String etime,
			String film, double normalPrice, double vipPrice) {
		super();
		this.cinname = cinname;
		RoomID = roomID;
		this.stime = stime;
		this.etime = etime;
		this.film = film;
		this.normalPrice = normalPrice;
		this.vipPrice = vipPrice;
	}
	public String getCinname() {
		return cinname;
	}
	public void setCinname(String cinname) {
		this.cinname = cinname;
	}
	public int getCurnum() {
		return Curnum;
	}
	public void setCurnum(int curnum) {
		Curnum = curnum;
	}
	private int Curnum;
	public int getRoomID() {
		return RoomID;
	}
	public void setRoomID(int roomID) {
		RoomID = roomID;
	}
	public String getStime() {
		return stime;
	}
	public void setStime(String stime) {
		this.stime = stime;
	}
	public String getEtime() {
		return etime;
	}
	public void setEtime(String etime) {
		this.etime = etime;
	}
	public String getFilm() {
		return film;
	}
	public void setFilm(String film) {
		this.film = film;
	}
	public double getNormalPrice() {
		return normalPrice;
	}
	public void setNormalPrice(double normalPrice) {
		this.normalPrice = normalPrice;
	}
	public double getVipPrice() {
		return vipPrice;
	}
	public void setVipPrice(double vipPrice) {
		this.vipPrice = vipPrice;
	}
	@Override
	public String toString() {
		return ""+cinname+ RoomID+stime+etime+film+normalPrice+vipPrice;
	}
	   

}
