package com.dg.s1.employee;

import com.dg.s1.department.DeparmentDTO;

public class Emp_DepartDTO extends EmployeeDTO {
	
	//사원은 부서를 가지고 있다.
	private DeparmentDTO deparmentDTO;

	public DeparmentDTO getDeparmentDTO() {
		return deparmentDTO;
	}

	public void setDeparmentDTO(DeparmentDTO deparmentDTO) {
		this.deparmentDTO = deparmentDTO;
	}

}
