package func;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Get {
	static Connection conn = null;
	static PreparedStatement ps = null;
	

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bms", "root", "root");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 查询结果集
	public static ResultSet get(String sql) {
		ResultSet rs =null;
		try {
			ps = conn.prepareStatement(sql);
			rs= ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public static int excute(String sql) {
		int rs=0;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}


}
