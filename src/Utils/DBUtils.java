package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.DateTime;



public class DBUtils {

	private static final String URL="jdbc:mysql://127.0.0.1:3306/Mycam";
	private static final String USER="root";
	private static final String PASSWORD="1a";
	private static Connection connection;
	private Statement statement;
	private ResultSet rs;
	/**
	 * 链接数据库
	 */
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int update(String sql){
		try {
			statement = connection.createStatement();
			int result = statement.executeUpdate(sql);
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	public int check(String sql) throws SQLException{
		statement = connection.createStatement();
		rs = statement.executeQuery(sql);
		int f =0;
		while(rs.next()){			
			f = rs.getInt(1);
		}
		return f;
	}
	
	public List<Map<String, Object>> query(String sql) throws SQLException{
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		
		statement = connection.createStatement();
		rs = statement.executeQuery(sql);
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
	/**
	 * 获取链接对象
	 * @return
	 */
	public Connection getcConnection(){
		return connection;
	}
}