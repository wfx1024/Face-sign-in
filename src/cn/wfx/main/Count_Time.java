package cn.wfx.main;

import java.sql.ResultSet;
import java.sql.SQLException;

import cn.wfx.Util.DBUtil;

/**
 * 数据库数据处理
 * @author WFX
 *
 */
public class Count_Time {	

	/**
	 * 统计多少人没签到
	 * @return temp
	 */
	public static int count_This_Time(){
		int temp = 0;
		ResultSet resultSet = DBUtil.exeQuery("select count(*) from counttime where this_time="+0);
		try {
			resultSet.next();
			temp = resultSet.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return temp;	
	}
	
	/**
	 * 判断今天是否签到，1 true ， 0 false
	 * @return temp
	 */
	private static int getThis_Time(){
		int temp = 0;
		ResultSet resultSet = DBUtil.exeQuery("select this_time from counttime where id ="+ReceiveInf.getNum());
		try {
			resultSet.next();
			temp = resultSet.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return temp;		
	}
	@SuppressWarnings("unused")
	private static int getCount_Time(){
		int temp = 0;
		ResultSet resultSet = DBUtil.exeQuery("select time from counttime where id ="+ReceiveInf.getNum());
		try {
			resultSet.next();
			temp = resultSet.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				resultSet.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return temp;
	}

	/**
	 * 签到次数自增1，
	 * 
	 */
	public static void increaseCount_Time(){
		if (Count_Time.getThis_Time()==0) {
			DBUtil.exeUpdate("update counttime set time=time+1 where id ="+ReceiveInf.getNum());
			DBUtil.exeUpdate("update counttime set this_time=1 where id ="+ReceiveInf.getNum());
		}
	}

}
