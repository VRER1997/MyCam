package Test;

import Actions.Auserfo;

public class ScoreTest {
	
	public static void main(String[] args) {
		Auserfo.getscore("123");
		Auserfo.getscore("1216778435");
		Auserfo.getscore("123.abc");
		Auserfo.getscore("123.ASDF");
		Auserfo.getscore("123.adfg");
		Auserfo.getscore("123123");
		Auserfo.getscore("123qerskALDKJ");
		Auserfo.getscore("123sdf...");
	}

}
