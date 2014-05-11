package com.iti.jets.carpoolingV1.editprofileactivity;



import com.iti.jets.carpoolingV1.R;
import com.iti.jets.carpoolingV1.common.ImageCompressionHandler;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class EditProfileActivity extends Activity {

	private ImageView userImgView,editNameImgView,editDobImgView;
	private TextView usernameTextView,dateTextView;
	private final int REQUEST_CODE_FROM_GALLERY = 01;
	private Uri selectedImageUri;
	Button doneBtn;
	String username,newDate;
	String flag = null;
	Bitmap imgBitmap;
	ImageCompressionHandler imageHandler;
	EditProfileController controller;
	String filePath;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_profile);
		controller = new EditProfileController(this);
		userImgView = (ImageView)findViewById(R.id.userImgView);
		editNameImgView = (ImageView)findViewById(R.id.editnameImgView);
		editDobImgView = (ImageView)findViewById(R.id.editdateImgView);
		usernameTextView = (TextView)findViewById(R.id.NametextView);
		dateTextView = (TextView)findViewById(R.id.dateTextView);
		doneBtn = (Button)findViewById(R.id.doneBtn);
		doneBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			
				String user_name =  usernameTextView.getText().toString();
				String user_Dob  = dateTextView.getText().toString();
				controller.setArguments(user_name,user_Dob,imgBitmap,filePath);
			}
		});
		
		
		Bundle newIntent = getIntent().getExtras();
		if (newIntent != null) {
			flag = newIntent.getString("flag");
			if(flag.equals("0"))
			{
				username = newIntent.getString("username");
				usernameTextView.setText(username);	
			}
			else
			{
				newDate = newIntent.getString("newDate");
				dateTextView.setText(newDate);
			}
			
			}
		
		
		userImgView.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
	  			intent.setType("image/*");
	  			startActivityForResult(intent, REQUEST_CODE_FROM_GALLERY); 
				
			}
		});
		editNameImgView.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(),EditNameActivity.class);
				intent.putExtra("username",usernameTextView.getText());
				startActivity(intent);
				
			}
		}) ;
		editDobImgView.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(),EditDateActivity.class);
				intent.putExtra("date",dateTextView.getText());
				startActivity(intent);
				
			}
		});
		
	}

	public void onActivityResult(int requestCode, int resultCode, Intent data) {
	    super.onActivityResult(requestCode, resultCode, data);
	    if (resultCode == RESULT_OK) {
                
        	selectedImageUri = data.getData();
        	//imageHandler = new ImageCompressionHandler(data.getDataString(),EditProfileActivity.this);
          
        } 

    }

	public void sendBitMapImg(Bitmap bitmapImg,String filePath) {
		// TODO Auto-generated method stub
		this.filePath = filePath;
		if(bitmapImg == null)
		{
			Toast.makeText(getApplicationContext(), "NULLLLLLLLIMAGE", Toast.LENGTH_LONG).show();
		}
		imgBitmap = bitmapImg;
		userImgView.setImageBitmap(imgBitmap);
		
		
	}

	public void getServiceData(String result) {
		// TODO Auto-generated method stub
		
		Toast.makeText(getApplicationContext(), "UUUUUUUUUUUUUUU "+"   "+result, Toast.LENGTH_LONG).show();
	}

}
