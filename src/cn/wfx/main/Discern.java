package cn.wfx.main;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.baidu.aip.face.AipFace;

public class Discern {

	public static double getResult(){
		String base_path = "/mnt/database/"+ ReceiveInf.getNum()+".jpg";   
		
		//d:/database/"+ ReceiveInf.getNum()+".jpg----windows
		
		
		File file = RecentFiles.file;
		AipFace face = new AipFace("�˴�", "��ο�", "�ٶȿ������ĵ�");
		if (file.exists()) {
			return faceRecognize(face, file.getPath(), base_path);
		}else {
			return 0;
		}
	}

	public static double faceRecognize(AipFace client,String path1,String path2) {
		// ����Ϊ����ͼƬ·
		String imagePath1 = path1;
		String imagePath2 = path2;
		ArrayList<String> pathArray = new ArrayList<String>();
		pathArray.add(imagePath1);
		pathArray.add(imagePath2);
		JSONObject response = client.match(pathArray, new HashMap<String, String>());
		JSONObject jsonObject = null;
		try {
			JSONArray jsonArray =  response.getJSONArray("result");
			jsonObject = (JSONObject) jsonArray.get(0);
		} catch (JSONException e) {
			System.out.println("ͼƬ���⣡");
			e.printStackTrace();
		}
		System.out.println("���ƶȣ�"+jsonObject.get("score"));
		System.out.println(response.toString());
		if (jsonObject.get("score") instanceof Double) {
			return (double) jsonObject.get("score");
		}else {
			return (int) jsonObject.get("score");
		}
	}

}
