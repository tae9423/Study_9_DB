package com.dg.s1.location;

import java.util.ArrayList;

public class LocationController {
	
	private LocationDAO locationDAO;
	private LocationView locationView;
	
	public LocationController() {
		locationDAO = new LocationDAO();
		locationView = new LocationView();
	}
	
	public void start() {

		//ArrayList<LocationDTO> ar = locationDAO.getList();
		//locationView.view(ar);
		
		//String s = "%"+"Ave"+"%";
		
		//int count = locationDAO.getCount();
		//locationView.view(count);
		
		//locationDAO.getList();
		//LocationDTO locationDTO = locationDAO.getOne(1000);
		//locationView.view(locationDTO);
		
		LocationDTO locationDTO = locationDAO.getLocation(100);
		locationView.view(locationDTO);
		
	}

}
