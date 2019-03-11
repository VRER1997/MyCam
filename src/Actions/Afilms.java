package Actions;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import javax.sound.midi.VoiceStatus;

import org.eclipse.swt.widgets.Dialog;

import Model.Films;
import Utils.BoxUtils;
import Utils.DBUtils;

public class Afilms {
	
	/**
	 * 关于影片类型的操作
	 * @param f
	 * @return
	 */
	
	public static int addFilm(Films f){
		DBUtils dbUtils = new DBUtils();
		String sql = "INSERT INTO films VALUES ("+f.getFilmID()+",'"+f.getFnameString()+"','"+f.getFtypeString()+"','"+
		             f.getFlanguage()+"',"+f.getFtimelong()+",'"+f.getFdirectorString()+"','"+f.getFactorString()+"','"+
		             f.getfUptimeDate()+"','"+f.getfDownDate()+"','"+f.getFbtextString()+"')";
		int ret = dbUtils.update(sql);
		return ret;		
	}
	public static int editFilm(Films f){
		DBUtils dbUtils = new DBUtils();
		String sql = "update films set filmID = "+f.getFilmID()+",fname = '"+f.getFnameString()+"',ftype = '"+f.getFtypeString()+"'," +
				"flanguage = '"+ f.getFlanguage()+"',ftime = "+f.getFtimelong()+",fdirector = '"+f.getFdirectorString()+"'," +
						"factors = '"+f.getFactorString()+"',fUpTime = '"+f.getfUptimeDate()+"', fDownTime = '"+f.getfDownDate()+"'," +
								"fbrifeText = '"+f.getFbtextString()+"' "+
								"where filmID =  "+f.getFilmID()+"";
		int ret = dbUtils.update(sql);
		return ret;		
	}
	public static int  deleteFilm(int ID){
		DBUtils dbUtils = new DBUtils();
		String sql = "delete from films where filmID = "+ID+"";
		int ret = dbUtils.update(sql);
		return ret;
	}
	public static int getfilmsNum() throws SQLException{
		DBUtils dbUtils = new DBUtils();
		List<Map<String, Object>> list = dbUtils.query("select * from films");
		return list.size();		
	}
} 
