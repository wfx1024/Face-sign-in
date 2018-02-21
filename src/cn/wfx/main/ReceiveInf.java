package cn.wfx.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReceiveInf extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String num ;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		num = request.getParameter("num");
	}
	public static String getNum(){
		return num;
	}
}
