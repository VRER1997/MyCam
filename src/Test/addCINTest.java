package Test;

import Actions.AcinRooms;
import Model.CinRooms;

public class addCINTest {
	
	public static void main(String[] args) {
		CinRooms  cinRooms = new CinRooms("���Ӱ��",13,"IMAX",80);
		AcinRooms.addcinrooms(cinRooms);
	}

}
