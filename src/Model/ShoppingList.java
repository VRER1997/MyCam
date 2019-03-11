package Model;

public class ShoppingList {
	
	private int ID;
	private String buyerString;
	private String buyDateString;
	private String fnameString;
	private String cinnameString;
	private int roomIDString;
	private int h;
	private int l;
	private String fbeginTime;
	private double price;
	private String dateString;
	
	public ShoppingList(){}
	public ShoppingList(String buyerString, String buyDateString,
			String fnameString, String cinnameString, int roomIDString, int h,
			int l, String fbeginTime, double price, String dateString) {
		super();
		this.buyerString = buyerString;
		this.buyDateString = buyDateString;
		this.fnameString = fnameString;
		this.cinnameString = cinnameString;
		this.roomIDString = roomIDString;
		this.h = h;
		this.l = l;
		this.fbeginTime = fbeginTime;
		this.price = price;
		this.dateString = dateString;
	}




	public String getDateString() {
		return dateString;
	}




	public void setDateString(String dateString) {
		this.dateString = dateString;
	}




	public void setPrice(double price) {
		this.price = price;
	}




	public String getCinnameString() {
		return cinnameString;
	}

	public void setCinnameString(String cinnameString) {
		this.cinnameString = cinnameString;
	}

	public int getRoomIDString() {
		return roomIDString;
	}

	public void setRoomIDString(int roomIDString) {
		this.roomIDString = roomIDString;
	}

	public String getFbeginTime() {
		return fbeginTime;
	}

	public void setFbeginTime(String fbeginTime) {
		this.fbeginTime = fbeginTime;
	}

	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getBuyerString() {
		return buyerString;
	}
	public void setBuyerString(String buyerString) {
		this.buyerString = buyerString;
	}
	public String getBuyDateString() {
		return buyDateString;
	}
	public void setBuyDateString(String buyDateString) {
		this.buyDateString = buyDateString;
	}
	public String getFnameString() {
		return fnameString;
	}
	public void setFnameString(String fnameString) {
		this.fnameString = fnameString;
	}
	public int getH() {
		return h;
	}
	public void setH(int h) {
		this.h = h;
	}
	public int getL() {
		return l;
	}
	public void setL(int l) {
		this.l = l;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	

}
