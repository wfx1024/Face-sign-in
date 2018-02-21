package cn.wfx.main;

import javax.servlet.http.HttpSession;

/**
 * 将上传进度放到session里
 * @author WFX
 *
 */
public class ProgressListener implements org.apache.commons.fileupload.ProgressListener{
	private HttpSession httpSession  = null;

	public ProgressListener() {
	}
	public ProgressListener(HttpSession session) {
		this.httpSession = session;
	}
    /** 
     * pBytesRead: 已读取的字节数 
     * pContentLength: 所有上传文件的字节数 
     * pItems: 所有上传文件的个数 
     */ 
	public void update(long pBytesRead, long pContentLength, int pItems) {
		int percent = Math.round(((float)pBytesRead/pContentLength)*100); 
		httpSession.setAttribute("percent", percent);	//将上传进度放到session里
	}
}
