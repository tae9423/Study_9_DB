package com.dg.s1.department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dg.s1.employee.Emp_DepartDTO;
import com.dg.s1.employee.EmployeeDTO;
import com.dg.s1.util.DBConnect;

public class DepartmentDAO {
	
	private DBConnect dbConnect;
	
	public DepartmentDAO() {
		
		dbConnect = new DBConnect();
		
		
	}
	
	public Depart_EmpDTO getJoin(DeparmentDTO deparmentDTO ) {
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		Depart_EmpDTO depart_EmpDTO = null;
		
		
		
		
		try {
			con = dbConnect.getConnect();
			String sql = "SELECT E.LAST_NAME, E.SALARY, E.HIRE_DATE, D.DEPARTMENT_NAME "
					+ "FROM EMPLOYEES E INNER JOIN DEPARTMENTS D "
					+ "USING(DEPARTMENT_ID) "
					+ "WHERE DEPARTMENT_ID =?";
			
			st = con.prepareStatement(sql);
			
			st.setInt(1, deparmentDTO.getDepartment_id());
			
			rs = st.executeQuery();
			
			depart_EmpDTO = new Depart_EmpDTO();
			depart_EmpDTO.setAr(new ArrayList<EmployeeDTO>());
			while(rs.next()) {
				
				
				EmployeeDTO employeeDTO = new EmployeeDTO(); 
				
				employeeDTO.setLast_name(rs.getString("LAST_NAME"));
				employeeDTO.setSalary(rs.getInt("SALARY"));
				employeeDTO.setHire_date(rs.getString("HIRE_DATE"));
				depart_EmpDTO.getAr().add(employeeDTO);

				depart_EmpDTO.setDepartment_name(rs.getNString("DEPARTMENT_NAME"));
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return depart_EmpDTO;
		
	}

}
