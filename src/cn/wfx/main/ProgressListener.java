package cn.wfx.main;

import javax.servlet.http.HttpSession;

/**
 * ���ϴ����ȷŵ�session��
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
     * pBytesRead: �Ѷ�ȡ���ֽ��� 
     * pContentLength: �����ϴ��ļ����ֽ��� 
     * pItems: �����ϴ��ļ��ĸ��� 
     */ 
	public void update(long pBytesRead, long pContentLength, int pItems) {
		int percent = Math.round(((float)pBytesRead/pContentLength)*100); 
		httpSession.setAttribute("percent", percent);	//���ϴ����ȷŵ�session��
	}
}
