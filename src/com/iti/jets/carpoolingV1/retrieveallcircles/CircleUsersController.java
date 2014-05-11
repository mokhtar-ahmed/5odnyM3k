package com.iti.jets.carpoolingV1.retrieveallcircles;

import com.iti.jets.carpoolingV1.httphandler.CircleUsersHandler;
import com.iti.jets.carpoolingV1.httphandler.HttpConstants;
import com.iti.jets.carpoolingV1.httphandler.RetrieveAllCirclesServiceHandler;
import com.iti.jets.carpoolingV1.httphandler.HttpHandlerUtil;
public class CircleUsersController {


	private CircleUsersHandler handler;
	public CircleUsersController(String selectedCircleName, int userId,CircleUsersActivity circleUsersActivityObj) {
		
		handler = new CircleUsersHandler();
		String url = HttpHandlerUtil.SERVER_URL + HttpHandlerUtil.RETRIEVE_CIRCLE_USERS_URL;
		handler.connectToWebService(selectedCircleName,userId,circleUsersActivityObj,url);	
	}

	
}
