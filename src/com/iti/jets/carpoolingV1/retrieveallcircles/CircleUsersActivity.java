package com.iti.jets.carpoolingV1.retrieveallcircles;

import org.json.JSONArray;
import org.json.JSONException;

import com.iti.jets.carpoolingV1.R;
import com.iti.jets.carpoolingV1.R.layout;
import com.iti.jets.carpoolingV1.R.menu;
import com.iti.jets.carpoolingV1.synccontactsactivity.SyncContactsActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CircleUsersActivity extends Activity {

	private TextView circleName;
	private ImageView addFriendImgView;
	private String selectedCircleName;
	private int circle_Id;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_circle_users);
		circleName = (TextView)findViewById(R.id.circleNameTextView);
		addFriendImgView = (ImageView)findViewById(R.id.addFriendImgView);
		
		addFriendImgView.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(),SyncContactsActivity.class);
				intent.putExtra("circleID",circle_Id);
				startActivity(intent);
			}
		});
		
		Bundle newIntent = getIntent().getExtras();
		if (newIntent != null) {
			String flag = newIntent.getString("flag");
			circle_Id = newIntent.getInt("circle_Id");
			if(flag.equals("resultFlag"))
			{
				try {
					circleName.setText(newIntent.getString("circleName"));
					 
					JSONArray circleUsersJSArray = new JSONArray(newIntent.getString("circleUsers"));
					if(circleUsersJSArray.length() == 0)
					{
						System.out.println("&&&&&&&&&&&&&&EMPTYUSERSARRAY&&&&&&&&&&&&&&&&&");
					}
					else
					{
						System.out.println("&&&&&&&&&&&&&&FILLEEEEEED&&&&&&&&&&&&&&&&&");
					}
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
			else
			{
				int userId = newIntent.getInt("userId");	
				selectedCircleName = newIntent.getString("selectedCircleName");
				new CircleUsersController(selectedCircleName,userId,this);
				
			}
						
		}
		
	}


}
