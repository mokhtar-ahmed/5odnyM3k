package com.iti.jets.carpoolingV1.synccontactsactivity;

import java.util.ArrayList;

import com.iti.jets.carpoolingV1.R;
import com.iti.jets.carpoolingV1.R.layout;
import com.iti.jets.carpoolingV1.R.menu;
import com.iti.jets.carpoolingV1.common.User;

import android.os.Bundle;
import android.app.Activity;
import android.content.ContentResolver;
import android.view.Menu;
import android.widget.TextView;

public class SyncContactsActivity extends Activity {

	private TextView contactTextView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sync_contacts);
		contactTextView = (TextView)findViewById(R.id.contactTextView1);
		ContentResolver contentResolver = getContentResolver();
		SyncContactsController controller = new SyncContactsController(contentResolver);
		
		

//		ArrayList<User> registerdFriendsList = controller.getRegisteredFriendsList();
//		System.out.println("TTTTTTTTTTTTTTTTTTTTTTTTTTTTT"+registerdFriendsList.size());
//		StringBuffer output = new StringBuffer();
//		for(int i=0;i<registerdFriendsList.size();i++)
//		{
//			User tempUser = registerdFriendsList.get(i);
//			output.append("Name:"+"  "+tempUser.getName());
//			output.append("\n Phone:"+"  "+tempUser.getPhone());
//			output.append("\n Id:"+"  "+tempUser.getUserId());
//			output.append("\n");
//			System.out.println("UUUUUUUUUUUUUUUUU"+"  "+output);
//			contactTextView.setText(output);
//			
//		}
//		
		
	}
		
}
