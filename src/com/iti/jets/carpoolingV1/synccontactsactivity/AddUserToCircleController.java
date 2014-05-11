package com.iti.jets.carpoolingV1.synccontactsactivity;

import org.json.JSONException;
import org.json.JSONObject;

import android.graphics.Bitmap;
import android.util.Log;

import com.iti.jets.carpoolingV1.addcircleactivity.AddCircleActivity;
import com.iti.jets.carpoolingV1.common.ImageHandler;
import com.iti.jets.carpoolingV1.common.ImageLoadingUtils;
import com.iti.jets.carpoolingV1.common.User;
import com.iti.jets.carpoolingV1.httphandler.AddCircleServiceHandler;
import com.iti.jets.carpoolingV1.httphandler.AddUserToCircleServiceHandler;
import com.iti.jets.carpoolingV1.httphandler.HttpHandlerUtil;

public class AddUserToCircleController {

	private ImageLoadingUtils utils;
	
	private SyncContactsActivity addUserToCircActObj;
		
	private AddUserToCircleServiceHandler addUserToCircleHanlerObject;
	private String uri = HttpHandlerUtil.SERVER_URL + HttpHandlerUtil.ADD_USERTO_CIRCLE_SERVICE_URL;
	
	public AddUserToCircleController() {
		// TODO Auto-generated constructor stub
		addUserToCircActObj = new SyncContactsActivity();
		
	}
	public AddUserToCircleController(SyncContactsActivity syncContactsActivity)
	{
		addUserToCircActObj = syncContactsActivity;
		
	}
	
	public void setArguments(int userId, int circleId) {
		// TODO Auto-generated method stub
		JSONObject circleUserObjJS = new JSONObject();
		try {
			circleUserObjJS.put("userId", userId);
			circleUserObjJS.put("circleId", circleId);
			addUserToCircleHanlerObject = new AddUserToCircleServiceHandler();
			addUserToCircleHanlerObject.connectToWebService(circleUserObjJS,uri);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

		
		
	
	
//	public void getServiceData(String result) {
//		// TODO Auto-generated method stub
////		Log.d("CONT",result);
////		if((result != null))
////		{
////			Log.d("CONTENTERED",result);
////			addCircleActObj.getServiceData(result);
////			
////		}
////		else
////		{
////			Log.d("CONTEXIT",result);
////		}
//	}
	

}
