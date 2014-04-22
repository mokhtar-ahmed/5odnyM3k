package com.iti.jets.carpoolingV1.jsonhandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.iti.jets.carpoolingV1.common.User;

public class JsonConverter {
	
	
	
	public JSONObject objectToJSON (User user)
	{
		JSONObject tempJasonObj = new JSONObject();
		try {			
			tempJasonObj.put("name", user.getName());
			tempJasonObj.put("phone", user.getPhone());
			tempJasonObj.put("userId", user.getUserId());
			return tempJasonObj;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}
		return tempJasonObj;
	}
	
	public JSONArray arrayListToJSONArray (ArrayList<String> arrayList)
	{
		JSONArray jsonArray = new JSONArray(arrayList);
		return jsonArray;
	}
	


}
