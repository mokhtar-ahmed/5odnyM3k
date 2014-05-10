package com.iti.jets.carpoolingV1.synccontactsactivity;


import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.iti.jets.carpoolingV1.R;
import com.iti.jets.carpoolingV1.R.layout;
import com.iti.jets.carpoolingV1.R.menu;
import com.iti.jets.carpoolingV1.common.Circle;
import com.iti.jets.carpoolingV1.common.User;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.app.Activity;
import android.app.ListActivity;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Resources;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class SyncContactsActivity extends Activity {

	ListView list;
	CheckBox checkBox;
    SyncContactsCustomArrayAdapter adapter;
    Button addFriendToCircleBtn ;
    private ArrayList<Integer> selectedUsersIds = new ArrayList<Integer>();
    private  ArrayList<User> registeredFriendsList = new ArrayList<User>();
    private AddUserToCircleController addUserToCircleCont;
    private User tempUser;
    private int userId,circleId;
    
    

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sync_contacts_view);
		addFriendToCircleBtn = (Button) findViewById(R.id.addFriendBtn);
		
    	ContentResolver contentResolver = getContentResolver();
		SyncContactsController controller = new SyncContactsController(contentResolver,this);
		addUserToCircleCont = new AddUserToCircleController(this);
		
		Bundle newIntent = getIntent().getExtras();
		if (newIntent != null) {
			
			circleId = newIntent.getInt("circle_Id");
		}
		addFriendToCircleBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				for(int i=0 ; i<registeredFriendsList.size();i++)
				{
					tempUser = registeredFriendsList.get(i);
					if (tempUser.getIsSelected())
					{
						Toast.makeText(getApplicationContext(), tempUser.getName()+" %%%", Toast.LENGTH_SHORT).show();
	
					}
				}
				userId = tempUser.getUserId();
				addUserToCircleCont.setArguments(userId,circleId);
				
			}
		});
	}
	
	public void getResultFromService(String result) {
		// TODO Auto-generated method stub
		
		  Toast.makeText(getApplicationContext(), "TESTTESTTEST", Toast.LENGTH_LONG).show();
		  registeredFriendsList = new ArrayList<User>();
		  ArrayList<String> namesList = new ArrayList<String>();
      	try {
      		Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
			JSONArray registeredFriendsJsArray = new JSONArray(result);
			for(int i=0;i<registeredFriendsJsArray.length();i++)
			{
				JSONObject jsObj = registeredFriendsJsArray.getJSONObject(i);
				System.out.println(jsObj);
				User tempUser = new User();
				tempUser.setName(jsObj.getString("name"));
				tempUser.setPhone(jsObj.getString("phone"));
				tempUser.setUserId(jsObj.getInt("id"));
				
				if(jsObj.getString("image") == null)
				{
					tempUser.setImageURL(jsObj.getString(null));
				}
				else
				{
					tempUser.setImageURL(jsObj.getString("image"));
				}
				
				namesList.add(tempUser.getName());
				registeredFriendsList.add(tempUser);
				Toast.makeText(getApplicationContext(),tempUser.getName(),Toast.LENGTH_LONG).show();
				System.out.println("Size"+"  "+registeredFriendsList.size());
			
			}			
			
	
			Resources res =getResources();
            list = ( ListView )findViewById( R.id.list );  // List defined in XML ( See Below )
             
            /**************** Create Custom Adapter *********/
            adapter=new SyncContactsCustomArrayAdapter(this,registeredFriendsList,res );
            list.setAdapter( adapter );
            
            
            
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}

		
	}
	public void onItemClick(int mPosition) {
		// TODO Auto-generated method stub
//		User userClickedValues = (User) registeredFriendsList.get(mPosition);
//		Toast.makeText(getApplicationContext(), userClickedValues.getName(),Toast.LENGTH_LONG).show();
		
	}
	
	
		
}
