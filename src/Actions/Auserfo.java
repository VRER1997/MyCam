package Actions;

import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import Model.Userfo;
import Utils.DBUtils;

public class Auserfo {
	
	/**
	 * 用户信息的操作
	 */
	private static DBUtils dbUtils;
	public static int addUser(Userfo userfo) throws SQLException{	
		boolean f = userfo.isIs_root();
		dbUtils = new DBUtils();
		String sql = "insert into userfo"+
		"(usernames, passwords, email, phoneNumber ,is_root, is_VIP, is_SignIn, code, headpicture)"+
		"values"+
		"('"+userfo.getUsername()+"','"+userfo.getPassword()+"','"+userfo.getEmail()+"','"+userfo.getPhonenumber()+"',"+f+",false,false,"+0+",'"+""+"')";
		int ret = dbUtils.update(sql);
		return ret;
	}
	public static int addUserforroot(Userfo userfo) throws SQLException{		
		dbUtils = new DBUtils();
		String sql = "insert into userfo"+
		"(usernames, passwords, email, phoneNumber ,is_root, is_VIP, is_SignIn)"+
		"values"+
		"('"+userfo.getUsername()+"','"+userfo.getPassword()+"','"+userfo.getEmail()+"','"+userfo.getPhonenumber()+"',false,true,false)";
		int ret = dbUtils.update(sql);
		return ret;
	}
//	public void editUser(Userfo userfo){
//		dbUtils = new DBUtils();
//		String sql = ""
//			+"update userfo "+
//			"set username = ?, password= ?, is_root= ?, is_VIP= ?, is_SignIn= ?"+
//			"where ID = ?";
//		
//	}
	public static List<Map<String, Object>> Login(String s1, String s2) throws SQLException{
		dbUtils = new DBUtils();
		String sql = "select * from userfo where usernames = ? and passwords = ?";
		PreparedStatement preparedStatement = dbUtils.getcConnection().prepareStatement(sql);
		preparedStatement.setString(1, s1);
		preparedStatement.setString(2, s2);
		ResultSet rs = (ResultSet) preparedStatement.executeQuery();	    	
		
        List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();		
		ResultSetMetaData rsmd = rs.getMetaData();		
		int cnt = rsmd.getColumnCount();		
		while(rs.next()){
			Map<String, Object> map = new HashMap<String, Object>();
			for(int i = 1; i <= cnt; i++){
				String columnnameString = rsmd.getColumnName(i);
			    Object columnvalue = rs.getObject(i);
			    map.put(columnnameString, columnvalue);
			}
			list.add(map);
		}		
		return list;
	}
	public void deleteUser(){}	
	
    public static int getscore(String string){
    	int score = 0;
		String s = string;
		int n = string.length();
		for(int i = 1; i < n - 1; i++){
			if(s.charAt(i+1) - s.charAt(i) == s.charAt(i)- s.charAt(i-1)){
				score += 1;
			}else{
				score += 3;
			}
		}
		for(int i = 0; i < n; i++){					
			if((s.charAt(i) > '0'  && s.charAt(i) < '9')){
				score *= 1.5;
			}
			if((s.charAt(i) > 'a'  && s.charAt(i) < 'z')){
				score *= 2;
			}
			if((s.charAt(i) > 'A'  && s.charAt(i) < 'Z')){
				score *= 2.5;
			}
			if((s.charAt(i) < '0' || s.charAt(i) > '9') && (s.charAt(i) < 'A' || s.charAt(i) > 'Z') &&
					(s.charAt(i) < 'a' || s.charAt(i) > 'z')){
				score += 20;
			}
		}
//		System.out.println(score);
		return score;
    }
}
