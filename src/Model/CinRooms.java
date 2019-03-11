package Model;

public class CinRooms {
   private String roomname; 
   private int RoomID;
   private String rtype;
   private int maxNum;

   
   public CinRooms(){}
   public CinRooms(String roomname, int roomID,String rtype, int maxnum){
	   this.roomname = roomname;
	   this.RoomID = roomID;
	   this.rtype = rtype;
	   this.maxNum = maxnum;
   }
   
public int getRoomID() {
	return RoomID;
}
public void setRoomID(int roomID) {
	RoomID = roomID;
}
public String getRoomname() {
	return roomname;
}
public void setRoomname(String roomname) {
	this.roomname = roomname;
}
public String getRtype() {
	return rtype;
}
public void setRtype(String rtype) {
	this.rtype = rtype;
}
public int getMaxNum() {
	return maxNum;
}
public void setMaxNum(int maxNum) {
	this.maxNum = maxNum;
}
   
}
