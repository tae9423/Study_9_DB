package com.dg.s1.location;

import java.util.Scanner;

public class LocationInput {
	
	
	public LocationDTO inputID(Scanner sc)  {
		
		LocationDTO locationDTO = new LocationDTO();
		
		System.out.println("Location_id를 입력하세요");
		int location_id = sc.nextInt();
		locationDTO.setLocation_id(location_id);
		
		return locationDTO;
		
	}

}
