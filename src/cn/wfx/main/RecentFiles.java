package cn.wfx.main;

import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * 获取客户端上传的Servlet
 * 文件写入地址："d:/"
 * @author WFX
 *
 */
public class RecentFiles extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static File file = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
		String path = "/mnt/everyday";			//d:/everyday/----windows

		servletFileUpload.setProgressListener(new ProgressListener(request.getSession()));
		try {
			@SuppressWarnings("unchecked")
			List<FileItem> list = servletFileUpload.parseRequest(request);
			for(FileItem fileItem :list){
				if (null != fileItem.getName() && fileItem.getName().trim() != "") {
					//System.out.println("fileItem name  "+fileItem.getContentType());
					file = new File(path+ReceiveInf.getNum()+dualName(fileItem.getName()));
					fileItem.write(file);
				}

				//上传识别
				if (Discern.getResult()>85.0) {
					Count_Time.increaseCount_Time();
					//response.sendRedirect("success.jsp");
					request.getRequestDispatcher("success.jsp").forward(request, response);
				}else {
					//response.sendRedirect("false.jsp");	
					request.getRequestDispatcher("false.jsp").forward(request, response);
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

	public static String dualName(String str){
		str = str.substring(str.lastIndexOf("."), str.length());
		return str;
	}



}
