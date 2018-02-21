package cn.wfx.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBUtil {
	private static Connection con= null;
	private static PreparedStatement pst = null;
	private static ResultSet resultSet = null;
	
	public static Connection getCon(){
		try {
			if (con == null||con.isClosed()) {
				try {
					/*Properties properties = new Properties();
					properties.load(new FileReader("binjdbc.properties"));*/
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection("url","用户", 
							"密码");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}  catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	/**
	 * delete,update,insert
	 * @param sql
	 * @return 操作的条数
	 */
	public static int exeUpdate(String sql){
		int temp = 0;
		try {
			if (con == null||con.isClosed()) {
				con = getCon();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pst = con.prepareStatement(sql);
			temp = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pst.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return temp;
	}

	/**
	 * select 
	 * @param sql
	 * @return ResultSet 结果集方便操作
	 */
	public static ResultSet exeQuery(String sql) {
		try {
			if (con == null||con.isClosed()) {
				con = getCon();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pst = con.prepareStatement(sql);
			resultSet = pst.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultSet;
	}

	public static void close(Object o){
		if (o instanceof Connection) {
			try {
				((Connection) o).close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if (o instanceof PreparedStatement) {
			try {
				((PreparedStatement) o).close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if (o instanceof ResultSet) {
			try {
				((ResultSet) o).close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if (o instanceof Statement) {
			try {
				((Statement) o).close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
