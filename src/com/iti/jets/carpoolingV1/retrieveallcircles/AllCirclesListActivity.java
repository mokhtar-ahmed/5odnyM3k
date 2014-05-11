package com.iti.jets.carpoolingV1.retrieveallcircles;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.iti.jets.carpoolingV1.R;
import com.iti.jets.carpoolingV1.R.layout;
import com.iti.jets.carpoolingV1.R.menu;
import com.iti.jets.carpoolingV1.addcircleactivity.AddCircleActivity;
import com.iti.jets.carpoolingV1.common.Circle;
import com.iti.jets.carpoolingV1.*;
import com.iti.jets.carpoolingV1.httphandler.HttpConstants;
import com.iti.jets.carpoolingV1.synccontactsactivity.SyncContactsCustomArrayAdapter;


import android.R.color;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

public class AllCirclesListActivity extends Activity {

	ArrayList<Circle> userCirclesList = new ArrayList<Circle>();
	ListView list;
	CirclesCustomArrayAdapter adapter;
	ImageView addCircle,delCircle;
	
	int userId = 1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.activity_allcircles_list);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,R.layout.custom_title_bar);
		
		
		//View view = LayoutInflater.from(AllCirclesListActivity.this).inflate(R.layout.custom_title_bar, null);
		addCircle = (ImageView)findViewById(R.id.addCircle);
		delCircle = (ImageView)findViewById(R.id.deleteCircle);
		addCircle.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(),AddCircleActivity.class);
				startActivity(intent);
			}
		});
		Bundle newIntent = getIntent().getExtras();
		if (newIntent != null) {
			int userId = newIntent.getInt("userId");		
			
			RetrieveAllCirclesListController contoller =	new RetrieveAllCirclesListController(userId,this);
				
		}
		delCircle.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			//	((CheckBox) findViewById(R.id.chkbox)).setCursorVisible(true);
			}
		});
		
	}

	public void getUserCircles(String result) {
		
		// TODO Auto-generated method stub
		JSONArray circlesJsArray;
		try {
			circlesJsArray = new JSONArray(result);
		
		for(int i=0;i<circlesJsArray.length();i++)
		{
			JSONObject jsObj = circlesJsArray.getJSONObject(i);
			System.out.println(jsObj);
			Circle tempCircle = new Circle();
			tempCircle.setCircleName(jsObj.getString("circleName"));
			tempCircle.setCircleId(jsObj.getInt("circleId"));
			tempCircle.setCircleImage(jsObj.getString("circleImage"));
			
			userCirclesList .add(tempCircle);
			Toast.makeText(getApplicationContext(),tempCircle.getCircleName(),Toast.LENGTH_LONG).show();
			System.out.println("Size"+"  "+userCirclesList.size());
		}
		
		
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Resources res =getResources();
        list = ( ListView )findViewById( R.id.list );   
        /**************** Create Custom Adapter *********/
        adapter=new CirclesCustomArrayAdapter(this,userCirclesList,res);
        list.setAdapter(adapter);
        
       
	
	}

	public void onItemClick(int mPosition) {
		// TODO Auto-generated method stub
		Circle circleClickedValues = (Circle) userCirclesList.get(mPosition);

		String selectedCircleName = circleClickedValues.getCircleName();
		int circle_Id = circleClickedValues.getCircleId();
		Toast.makeText(getApplicationContext(), selectedCircleName, Toast.LENGTH_LONG).show();
		int userId = 1;
		Intent intent = new Intent(getApplicationContext(),CircleUsersActivity.class);	
		intent.putExtra("selectedCircleName", selectedCircleName);
		intent.putExtra("circle_Id", circle_Id);
		intent.putExtra("userId", userId);
		intent.putExtra("flag", "inputFlag");
		startActivity(intent);   
 
	}

 
}
