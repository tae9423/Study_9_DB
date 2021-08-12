package com.dg.s1;

import java.sql.Connection;
import java.sql.SQLException;

import com.dg.s1.location.LocationController;
import com.dg.s1.location.LocationDAO;
import com.dg.s1.util.DBConnect;

public class Study9Main {
	
	public static void main(String[] args) {
		
		LocationController locationController = new LocationController();
		locationController.start();
		
	}
	

}
