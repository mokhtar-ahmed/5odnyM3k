package com.iti.jets.carpoolingV1.retrieveallcircles;

import com.iti.jets.carpoolingV1.httphandler.*;
import com.iti.jets.carpoolingV1.httphandler.RetrieveAllCirclesServiceHandler;



public class RetrieveAllCirclesListController {
	
	private RetrieveAllCirclesServiceHandler serviceHandler;
	private int userId;
	
public RetrieveAllCirclesListController(int userId,AllCirclesListActivity circleListReference)
	{
		this.userId = userId;
		
		serviceHandler = new RetrieveAllCirclesServiceHandler();
		String url =  HttpHandlerUtil.SERVER_URL+HttpHandlerUtil.RETRIEVE_ALL_CIRCLES_URL;
     	serviceHandler.connectToWebService(userId,circleListReference,url);	
		
	}

}
