package com.iti.jets.carpoolingV1.httphandler;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import com.iti.jets.carpoolingV1.common.User;

import com.iti.jets.carpoolingV1.loginactivity.LoginController;

import android.os.AsyncTask;
import android.util.Log;

public class LoginServiceHandler {

	LoginController controller;
	JSONObject userToLoginJS;
	String returnServiceOutput;
	
	public LoginServiceHandler(LoginController loginController) {
		// TODO Auto-generated constructor stub
		controller = loginController;
	}

	public void connectToWebservice(User userToLogin, String url) {
		// TODO Auto-generated method stub
		userToLoginJS = new JSONObject();
		try {
			userToLoginJS.put("username",userToLogin.getName());
			userToLoginJS.put("password",userToLogin.getPassword());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String webserviceURI = url;
		WebserviceAsyncTask task = new WebserviceAsyncTask();
		task.execute(webserviceURI);
	}


	private class WebserviceAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
          
        	String url=urls[0];
		    DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(url);
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);	
            Log.d("RRRRRRRRRRRRRRRR",userToLoginJS.toString());
			nameValuePairs.add(new BasicNameValuePair("userData",userToLoginJS.toString()));
			
			try {	 		
			httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            HttpResponse httpResponse= httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            returnServiceOutput = EntityUtils.toString(httpEntity);   
            Log.d(returnServiceOutput,"%%%%%%%%%%%%%%%returnService%%%%%%%%%%%%%%%%%%%");
			} catch (Exception e) {
				
				e.printStackTrace();
			}   
     
	  return  returnServiceOutput;
		   
        }

        @Override
        protected void onPostExecute(String result) {
              
        	System.out.println("%%%%%%%%%%%%%RESULT"+"  "+result+"%%%%%%%%%%%%%");
        	controller.getResultFromWebservice(result);
		    
			
        	
        	
        	
        }
      }	

}
