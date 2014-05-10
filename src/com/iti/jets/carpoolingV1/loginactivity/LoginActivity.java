package com.iti.jets.carpoolingV1.loginactivity;
import org.json.JSONException;
import org.json.JSONObject;

import com.iti.jets.carpoolingV1.R;

import com.iti.jets.carpoolingV1.common.MyApplication;
import com.iti.jets.carpoolingV1.common.User;
import com.iti.jets.carpoolingV1.editprofileactivity.EditProfileActivity;
import com.iti.jets.carpoolingV1.registrationactivity.RegisterActivity;
import com.iti.jets.carpoolingV1.uimanager.UIManagerHandler;

import OptionsActivity.OptionsActivity;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends Activity{

	EditText usernameTxt;
	EditText passwordTxt;
	Button	 loginBtn;
	Button 	 faceBookBtn;
	Button   googleBtn;
	Button   registerBtn;
	String phone;
	User userToLogin;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		 setContentView(R.layout.activity_login);
		
		 usernameTxt = (EditText) findViewById(R.id.usernameTxt);
		 passwordTxt = (EditText) findViewById(R.id.passwordTxt);
		 loginBtn	 = (Button) findViewById(R.id.Loginbutton);
		// faceBookBtn = (Button) findViewById(R.id.FacebookBtn);
		// googleBtn 	 = (Button) findViewById(R.id.googleBtn);
		 registerBtn = (Button) findViewById(R.id.registerButton);
		 userToLogin = new User();
		 loginBtn.setOnClickListener(new View.OnClickListener() {
		
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				//UIManagerHandler.goToHome(LoginActivity.this);
				userToLogin.setName(usernameTxt.getText().toString());
				userToLogin.setPassword(passwordTxt.getText().toString());
				LoginController controller = new LoginController(userToLogin,LoginActivity.this);
				
				
				
				
			}
		});
		 
//		 registerBtn.setOnClickListener(new View.OnClickListener() {
//				
//				@Override
//				public void onClick(View v) {
//					// TODO Auto-generated method stub
//					//UIManagerHandler.goToRegister(LoginActivity.this);
//					Intent intent = new Intent(getApplicationContext(),RegisterActivity.class);
//					startActivity(intent);
//				}
//			});
//		 
//		 faceBookBtn.setOnClickListener(new View.OnClickListener() {
//				
//				@Override
//				public void onClick(View v) {
//					// TODO Auto-generated method stub
//					
//				}
//			});
//		 
//		 
//		 
//		 googleBtn.setOnClickListener(new View.OnClickListener() {
//				
//				@Override
//				public void onClick(View v) {
//					// TODO Auto-generated method stub
//					
//				}
//			});
		 
	
		 
		 
	}



	public void getResultFromWebservice(String result) {
		// TODO Auto-generated method stub
		if(result.equals("NotExist"))
		{
			
			//Toast.makeText(getApplicationContext(), "CONDITION",Toast.LENGTH_LONG).show();
			AlertDialog alertDialog = new AlertDialog.Builder(
                    LoginActivity.this).create();

		    // Setting Dialog Title
		    alertDialog.setTitle("Error");
		
		    // Setting Dialog Message
		    alertDialog.setMessage("Invalid username or password");
		
		    // Setting Icon to Dialog
		    alertDialog.setIcon(R.drawable.tick3);
		    
		
		    
		    alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					
				}
			});
		    
		    alertDialog.show();
		}
		else
		{
			JSONObject userPhone;
			String phone;
			try {
				userPhone = new JSONObject(result);
				phone = userPhone.getString("phone");
				User currentUser = new User();
				currentUser.setPhone(phone);
//				((MyApplication) this.getApplication()).setCurretUser(currentUser);
//				Intent intent = new Intent(getApplicationContext(),OptionsActivity.class);
//				intent.putExtra("phone", phone);
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
					
			
		}
	}

	
}
