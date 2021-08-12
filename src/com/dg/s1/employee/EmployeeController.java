package com.dg.s1.employee;

import java.util.ArrayList;
import java.util.Scanner;

import com.dg.s1.location.LocationDAO;

public class EmployeeController {
	
	private EmployeeDAO employeeDAO;
	private EmployeeView employeeView;
	private EmployeeDTO employeeDTO;
	
	public EmployeeController() {
		employeeDAO = new EmployeeDAO();
		employeeView = new EmployeeView();
		employeeDTO = new EmployeeDTO();
	}
	
	public void start() {
		
		Scanner sc = new Scanner(System.in);
		
		
		boolean check = true;
		
		
		
		while(check) {
			System.out.println("번호를 눌러주세요");
			System.out.println("1. 전체 사원 출력");
			System.out.println("2. 번호입력 사원정보 검색");
			System.out.println("3. Last_name 입력 사원정보 검색");
			System.out.println("4. First_name 입력 사원정보 검색");
			System.out.println("5. 전체 평균 급여 정보");
			System.out.println("6. 부서별 평균 급여 정보");
			System.out.println("7. 종료");
			
			int select = sc.nextInt();
			
			switch(select) {
			
			case 1 :
				System.out.println("전체 사원 출력입니다.");
				ArrayList<EmployeeDTO> ar = employeeDAO.getList();
				employeeView.view(ar);
				break;
				
			case 2:
				System.out.println("번호를 입력해주세요");
				int num = sc.nextInt();
				employeeDTO = employeeDAO.getOne(num);
				employeeView.view(employeeDTO);
				break;
				
			case 3:
				System.out.println("Last_name을 입력해주세요");
				String lname = sc.next();
				employeeDTO = employeeDAO.getLname(lname);
				employeeView.view(employeeDTO);
				break;
				
			case 4:
				System.out.println("First_name을 입력해주세요");
				String fname = sc.next();
				employeeDTO = employeeDAO.getFname(fname);
				employeeView.view(employeeDTO);
				break;
				
			case 5:
				System.out.println("전체 평균 급여");
				double allavg = employeeDAO.getAavg();
				employeeView.view2(allavg);
				break;
				
			case 6:
				System.out.println("부서별 평균 급여");
				ArrayList<EmployeeDTO> ar2 = employeeDAO.getAvg();
				employeeView.view(ar2);
				break;
				
			case 7:
				System.out.println("종료");
				check = false;
			}
		}
		
		
	}

}
