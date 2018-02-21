package cn.wfx.main;

import java.sql.ResultSet;
import java.sql.SQLException;

import cn.wfx.Util.DBUtil;

/**
 * ���ݿ����ݴ���
 * @author WFX
 *
 */
public class Count_Time {	

	/**
	 * ͳ�ƶ�����ûǩ��
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
	 * �жϽ����Ƿ�ǩ����1 true �� 0 false
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
	 * ǩ����������1��
	 * 
	 */
	public static void increaseCount_Time(){
		if (Count_Time.getThis_Time()==0) {
			DBUtil.exeUpdate("update counttime set time=time+1 where id ="+ReceiveInf.getNum());
			DBUtil.exeUpdate("update counttime set this_time=1 where id ="+ReceiveInf.getNum());
		}
	}

}
