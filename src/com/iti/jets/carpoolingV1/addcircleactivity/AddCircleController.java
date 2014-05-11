package com.iti.jets.carpoolingV1.addcircleactivity;

import org.json.JSONException;
import org.json.JSONObject;

import com.iti.jets.carpoolingV1.common.ImageHandler;
import com.iti.jets.carpoolingV1.common.ImageLoadingUtils;
import com.iti.jets.carpoolingV1.editprofileactivity.EditProfileActivity;
import com.iti.jets.carpoolingV1.httphandler.AddCircleServiceHandler;
import com.iti.jets.carpoolingV1.httphandler.EditProfileServiceHandler;
import com.iti.jets.carpoolingV1.httphandler.HttpHandlerUtil;

import android.graphics.Bitmap;
import android.util.Log;


public class AddCircleController {

	private ImageLoadingUtils utils;
	private String imageStr = "EMPTY";
	private AddCircleActivity addCircleActObj;
	private ImageHandler imgHandler;
	private Bitmap bmpScaled;
	private String imageString;
	private AddCircleServiceHandler addCircleHanlerObject;
	private String uri = HttpHandlerUtil.SERVER_URL + HttpHandlerUtil.ADD_CIRCLE_SERVICE_URL;
	
	public AddCircleController() {
		// TODO Auto-generated constructor stub
		addCircleActObj = new AddCircleActivity();
		imgHandler = new ImageHandler();
	}
	public AddCircleController(AddCircleActivity obj)
	{
		addCircleActObj = obj;
		imgHandler = new ImageHandler();
	}
	
	public void setArguments(String circleName, Bitmap imgBitmap,
			String filePath) {
		// TODO Auto-generated method stub
		//bmpScaled = utils.decodeBitmapFromPath(filePath);
		//imageString = imgHandler.BitMapToString(bmpScaled);
		
		JSONObject circleDataObj = new JSONObject();
		JSONObject imgJsonObj = new JSONObject();
		
		try {
			circleDataObj.put("circleName", circleName);
		
			imgJsonObj.put("image", imageStr);
			
			addCircleHanlerObject = new AddCircleServiceHandler();
			addCircleHanlerObject.connectToWebService(circleDataObj,imgJsonObj,uri);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void getServiceData(String result) {
		// TODO Auto-generated method stub
		Log.d("CONT",result);
		if((result != null))
		{
			Log.d("CONTENTERED",result);
			addCircleActObj.getServiceData(result);
			
		}
		else
		{
			Log.d("CONTEXIT",result);
		}
	}

}
