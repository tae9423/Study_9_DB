package com.dg.s1;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dg.s1.department.DeparmentDTO;
import com.dg.s1.department.Depart_EmpDTO;
import com.dg.s1.department.DepartmentDAO;
import com.dg.s1.employee.Emp_DepartDTO;
import com.dg.s1.employee.EmployeeController;
import com.dg.s1.employee.EmployeeDAO;
import com.dg.s1.employee.EmployeeDTO;
import com.dg.s1.location.LocationController;
import com.dg.s1.location.LocationDAO;
import com.dg.s1.util.DBConnect;

public class Study9Main {
	
	public static void main(String[] args) {
		
		//LocationController controller = new LocationController();
		//controller.start();
		
		//EmployeeController controller = new EmployeeController();
		//controller.start();
		
		//EmployeeDAO employeeDAO = new EmployeeDAO();
		//EmployeeDTO employeeDTO = new EmployeeDTO();
		//employeeDTO.setEmployee_id(101);
		//Emp_DepartDTO emp_DepartDTO = employeeDAO.getJoin(employeeDTO);
		
		
		//System.out.println(emp_DepartDTO.getFirst_name());
		//System.out.println(emp_DepartDTO.getSalary());
		//System.out.println(emp_DepartDTO.getHire_date());
		//System.out.println(emp_DepartDTO.getDeparmentDTO().getDepartment_name());
		
		DepartmentDAO departmentDAO = new DepartmentDAO();
		DeparmentDTO deparmentDTO = new DeparmentDTO();
		deparmentDTO.setDepartment_id(90);
		
		Depart_EmpDTO depart_EmpDTO = departmentDAO.getJoin(deparmentDTO);
		
		System.out.println(depart_EmpDTO.getDepartment_name());
		
		for(int i=0;i<depart_EmpDTO.getAr().size();i++) {
			System.out.println("==========================");
			System.out.println(depart_EmpDTO.getAr().get(i).getLast_name());
			System.out.println(depart_EmpDTO.getAr().get(i).getSalary());
			System.out.println(depart_EmpDTO.getAr().get(i).getHire_date());	
		}
		
		
	}
	

}
