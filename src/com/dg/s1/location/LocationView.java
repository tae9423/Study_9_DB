package com.dg.s1.location;

import java.util.ArrayList;

public class LocationView {
	
	private LocationDTO locationDTO;
	
	public LocationView() {
		locationDTO = new LocationDTO();
	}
	
	public void view(String msg) {
		System.out.println(msg);
	}
	
	public void view(LocationDTO locationDTO) {
		
		System.out.print(locationDTO.getLocation_id()+"\t");
		System.out.print(locationDTO.getStreet_address()+"\t");
		System.out.print(locationDTO.getPostal_code()+"\t");
		System.out.print(locationDTO.getCity()+"\t");
		System.out.print(locationDTO.getState_province()+"\t");
		System.out.println(locationDTO.getCountry_id());
		
		
	}
	
	public void view(ArrayList<LocationDTO> ar) {
		
		for(int i=0;i<ar.size();i++) {
			System.out.println("==================================");
			this.view(ar.get(i));
			
		}
		
		
	}

}
