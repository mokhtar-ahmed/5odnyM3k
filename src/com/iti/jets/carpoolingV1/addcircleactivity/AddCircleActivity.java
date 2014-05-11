package com.iti.jets.carpoolingV1.addcircleactivity;

import com.iti.jets.carpoolingV1.R;
import com.iti.jets.carpoolingV1.R.layout;
import com.iti.jets.carpoolingV1.R.menu;
import com.iti.jets.carpoolingV1.common.ImageCompressionHandler;
import com.iti.jets.carpoolingV1.editprofileactivity.EditProfileActivity;
import com.iti.jets.carpoolingV1.retrieveallcircles.GoToAllCirclesListActivity;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class AddCircleActivity extends Activity {

	private Button addCircleBtn;
	private EditText circleNameTxt;
	private ImageView circleImageView;
	private final int REQUEST_CODE_FROM_GALLERY = 01;
	private Uri selectedImageUri;
	private String filePath; 
	private Bitmap imgBitmap;
	private ImageCompressionHandler imageHandler;
	private AddCircleController controller;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_circle);
		addCircleBtn = (Button) findViewById(R.id.addCircleBtn);
		circleNameTxt = (EditText) findViewById(R.id.circleNameTxt);
		circleImageView = (ImageView) findViewById(R.id.circleImgView);
		controller = new AddCircleController();
		circleImageView.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
			  			intent.setType("image/*");
			  			startActivityForResult(intent, REQUEST_CODE_FROM_GALLERY); 
						
					}
				});
		addCircleBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String circleName = circleNameTxt.getText().toString();
				
				controller.setArguments(circleName,imgBitmap,filePath);
				
			}
		});
	}
	
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
	    super.onActivityResult(requestCode, resultCode, data);
	    if (resultCode == RESULT_OK) {
                
        	selectedImageUri = data.getData();
        	//imageHandler = new ImageCompressionHandler(data.getDataString(),AddCircleActivity.this);
          
        } 

    }

	public void sendBitMapImg(Bitmap bitmapImg,String filePath) {
		// TODO Auto-generated method stub
		this.filePath = filePath;
		if(bitmapImg == null)
		{
			Toast.makeText(getApplicationContext(), "NULLLLLLLLIMAGE", Toast.LENGTH_LONG).show();
		}
		else
		{
			imgBitmap = bitmapImg;
			circleImageView.setImageBitmap(imgBitmap);
		}
		
		
		
	}

	public void getServiceData(String result) {
		// TODO Auto-generated method stub
		if(result.equals("ADDED"))
		{
			//Intent intent = new Intent(getApplicationContext(),GoToAllCirclesListActivity.class);
			//startActivity(intent);
//			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
//
//			         alertDialogBuilder.setTitle(this.getTitle()+ " decision");
//			37
//			         alertDialogBuilder.setMessage("Are you sure?");
//			38
//			         // set positive button: Yes message
//			39
//			         alertDialogBuilder.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
//			40
//			                public void onClick(DialogInterface dialog,int id) {
//			41
//			                    // go to a new activity of the app
//			42
//			                    Intent positveActivity = new Intent(getApplicationContext(),
//			43
//			                            PositiveActivity.class);
//			44
//			                    startActivity(positveActivity);
//			45
//			                }
//			46
//			              });
//			47
//			         // set negative button: No message
//			48
//			         alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {
//			49
//			                public void onClick(DialogInterface dialog,int id) {
//			50
//			                    // cancel the alert box and put a Toast to the user
//			51
//			                    dialog.cancel();
//			52
//			                    Toast.makeText(getApplicationContext(), "You chose a negative answer",
//			53
//			                            Toast.LENGTH_LONG).show();
//			54
//			                }
//			55
//			            });
//			56
//			         // set neutral button: Exit the app message
//			57
//			         alertDialogBuilder.setNeutralButton("Exit the app",new DialogInterface.OnClickListener() {
//			58
//			                public void onClick(DialogInterface dialog,int id) {
//			59
//			                    // exit the app and go to the HOME
//			60
//			                    MainActivity.this.finish();
//			61
//			                }
//			62
//			            });
//			63
//			          
//			64
//			         AlertDialog alertDialog = alertDialogBuilder.create();
//			65
//			         // show alert
//			66
//			         alertDialog.show();

			//Log.d("NOTNULL","RRRRRRRRRRRRRRRRRRr");
			//Toast.makeText(this.getApplicationContext(), result, Toast.LENGTH_LONG).show();
		}
		
	}
}
