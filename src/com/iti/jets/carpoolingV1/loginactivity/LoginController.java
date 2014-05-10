package com.iti.jets.carpoolingV1.loginactivity;

import com.iti.jets.carpoolingV1.common.User;
import com.iti.jets.carpoolingV1.httphandler.HttpHandlerUtil;
import com.iti.jets.carpoolingV1.httphandler.LoginServiceHandler;

public class LoginController {

	LoginServiceHandler serviceHandler ;
	LoginActivity loginActivity;
	public LoginController(User userToLogin, LoginActivity loginActivity ) {
		// TODO Auto-generated constructor stub
		serviceHandler = new LoginServiceHandler(this);
		String url = HttpHandlerUtil.SERVER_URL + HttpHandlerUtil.LOGIN_SERVICE_URL;
		serviceHandler.connectToWebservice(userToLogin,url);
		this.loginActivity = loginActivity;
	}
	public void getResultFromWebservice(String result) {
		// TODO Auto-generated method stub
		loginActivity.getResultFromWebservice(result);
	}

}
