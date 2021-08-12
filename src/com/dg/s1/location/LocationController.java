package com.dg.s1.location;

import java.util.ArrayList;
import java.util.Scanner;

public class LocationController {
	
	private LocationDAO locationDAO;
	private LocationView locationView;
	private LocationInput locationInput;
	private Scanner sc;
	
	public LocationController() {
		
		locationDAO = new LocationDAO();
		this.locationView = new LocationView();
		sc = new Scanner(System.in);
		locationInput = new LocationInput();
		
	}
	
	public void start() {
		
		boolean check = true;
		
		while(check) {
			System.out.println("번호를 눌러주세요");
			System.out.println("1. 전체 정보 출력");
			System.out.println("2. 한개 정보 출력");
			System.out.println("3. 종료");
			
			int select = sc.nextInt();
			
			switch(select) {
			
			case 1:
				ArrayList<LocationDTO> ar = locationDAO.getList();
				if(ar.size()>0) {
					locationView.view(ar);
				} else {
					locationView.view("Data가 없습니다.");
				}
				break;
				
			case 2:
				
					LocationDTO locationDTO = locationInput.inputID(sc);
					
					locationDTO = locationDAO.getOne(locationDTO);
					
					if(locationDTO !=null) {
						locationView.view(locationDTO);
					} else {
						locationView.view("없는 ID 입니다.");
					}
					
				break;
				
			case 3:
				System.out.println("종료합니다.");
				check =! check;
				
			}
			
		}
		
	}

}
