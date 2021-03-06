package com.iti.jets.carpoolingV1.registrationactivity;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.graphics.Bitmap;
import android.widget.Toast;

import com.iti.jets.carpoolingV1.common.ImageHandler;
import com.iti.jets.carpoolingV1.common.ImageLoadingUtils;
import com.iti.jets.carpoolingV1.common.User;
import com.iti.jets.carpoolingV1.httphandler.HttpHandlerUtil;
import com.iti.jets.carpoolingV1.httphandler.RegisterationServiceHandler;



public class RegisterationController {

	public RegisterationServiceHandler serviceHandler;
	RegisterActivity registerActivity;
	private Bitmap bmpScaled;
	private String imageString;
	private ImageHandler imgHandler ;
	private ImageLoadingUtils utils;
	public RegisterationController(User newUser,RegisterActivity registerActivity, Bitmap imgBitmap, String filePath) {
		
		utils = new ImageLoadingUtils(registerActivity.getApplicationContext());
		bmpScaled = utils.decodeBitmapFromPath(filePath);
		imgHandler = new ImageHandler();
		imageString = imgHandler.BitMapToString(bmpScaled);
		this.registerActivity = registerActivity;
		Toast.makeText(registerActivity.getApplicationContext(), "EnteredController", Toast.LENGTH_LONG).show();
		serviceHandler = new RegisterationServiceHandler(RegisterationController.this);
		String url =  HttpHandlerUtil.SERVER_URL+ HttpHandlerUtil.REGISTER_SERVICE_URL;
     	serviceHandler.connectToWebService(newUser,url,imageString);	
     	
		
	}
	public void getResultFromWebservice(String result) {
		// TODO Auto-generated method stub
		
		registerActivity.getResultFromWebservice(result);
	
	}
	
	public Activity getRef()
	{
		return registerActivity;
	}

	
}

