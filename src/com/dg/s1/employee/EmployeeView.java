package com.dg.s1.employee;

import java.util.ArrayList;

public class EmployeeView {

	public void view(ArrayList<EmployeeDTO> ar) {
		
		for(int i=0;i<ar.size();i++) {
			
			this.view(ar.get(i));
			System.out.println("---------------------------------------------");
			
		}
		
	}

	public void view(EmployeeDTO employeeDTO) {

		System.out.println(employeeDTO.getEmployee_id());
		System.out.println(employeeDTO.getFirst_name());
		System.out.println(employeeDTO.getLast_name());
		System.out.println(employeeDTO.getEmail());
		System.out.println(employeeDTO.getPhone_number());
		System.out.println(employeeDTO.getHire_date());
		System.out.println(employeeDTO.getJob_id());
		System.out.println(employeeDTO.getSalary());
		System.out.println(employeeDTO.getCommission_pct());
		System.out.println(employeeDTO.getManager_id());
		System.out.println(employeeDTO.getDepartment_id());

	}
	
	public void view2(double avg) {
		
		System.out.println("전체 평균 급여 :" +avg);
	}

}
