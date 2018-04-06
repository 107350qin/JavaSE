package func;

/**
 * 密码账号为一个对象，调用verify方法验证，若有此账号且密码正确则返回true，否则返回false
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//注意连接数据库的操作http://blog.csdn.net/fanjianwucmx/article/details/54882044
public class Verify {
	private String acount;
	private String password;

	public Verify(String acount, String password) {
		super();
		this.acount = acount;
		this.password = password;
	}

	public boolean verify() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bms", "root", "root");
			String sql = "select user_name,user_password from user;";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			String a = null;
			String b = null;
			while (rs.next()) {
				a = rs.getString("user_name");
				b = rs.getString("user_password");

				if (acount.equals(a) && password.equals(b)) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
