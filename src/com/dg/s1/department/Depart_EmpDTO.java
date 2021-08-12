package com.dg.s1.department;

import java.util.ArrayList;

import com.dg.s1.employee.EmployeeDTO;

public class Depart_EmpDTO extends DeparmentDTO{
	
	private ArrayList<EmployeeDTO> ar;

	public ArrayList<EmployeeDTO> getAr() {
		return ar;
	}

	public void setAr(ArrayList<EmployeeDTO> ar) {
		this.ar = ar;
	}
	
	

}
