package com.dg.s1.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dg.s1.department.DeparmentDTO;
import com.dg.s1.location.LocationDTO;
import com.dg.s1.util.DBConnect;

public class EmployeeDAO {
	private DBConnect dbConnect;
	private EmployeeDTO employeeDTO;

	public EmployeeDAO() {
		employeeDTO = new EmployeeDTO();
		dbConnect = new DBConnect();
	}
	
	public Emp_DepartDTO getJoin(EmployeeDTO employeeDTO) {
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		Emp_DepartDTO emp_DepartDTO = null;
		DeparmentDTO deparmentDTO = null;
		
		try {
			con = dbConnect.getConnect();
			String sql = "SELECT FIRST_NAME, SALARY, HIRE_DATE, DEPARTMENT_NAME	"
					+ "FROM DEPARTMENTS D INNER JOIN EMPLOYEES E "
					+ "USING(DEPARTMENT_ID)	WHERE EMPLOYEE_ID = ?";
			
			st = con.prepareStatement(sql);
			
			st.setInt(1, employeeDTO.getEmployee_id());
		
			rs = st.executeQuery();
			
			if (rs.next()) {
				emp_DepartDTO = new Emp_DepartDTO();
				emp_DepartDTO.setDeparmentDTO(new DeparmentDTO());
				
				emp_DepartDTO.setFirst_name(rs.getString("FIRST_NAME"));
				emp_DepartDTO.setSalary(rs.getInt("SALARY"));
				emp_DepartDTO.setHire_date(rs.getString("HIRE_DATE"));
				emp_DepartDTO.getDeparmentDTO().setDepartment_name(rs.getString("DEPARTMENT_NAME"));
				

			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		
		}
		
		return emp_DepartDTO;
		
	}

	public ArrayList<EmployeeDTO> getList() {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		ArrayList<EmployeeDTO> ar = new ArrayList<>();

		try {
			con = dbConnect.getConnect();

			String sql = "SELECT * FROM EMPLOYEES";

			st = con.prepareStatement(sql);

			rs = st.executeQuery();

			while (rs.next()) {

				employeeDTO.setEmployee_id(rs.getInt("employee_id"));
				employeeDTO.setFirst_name(rs.getString("first_name"));
				employeeDTO.setLast_name(rs.getString("last_name"));
				employeeDTO.setEmail(rs.getString("email"));
				employeeDTO.setPhone_number(rs.getString("phone_number"));
				employeeDTO.setHire_date(rs.getString("hire_date"));
				employeeDTO.setJob_id(rs.getString("job_id"));
				employeeDTO.setSalary(rs.getInt("salary"));
				employeeDTO.setCommission_pct(rs.getString("commission_pct"));
				employeeDTO.setManager_id(rs.getString("manager_id"));
				employeeDTO.setDepartment_id(rs.getInt("department_id"));

				ar.add(employeeDTO);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ar;

	}

	public EmployeeDTO getOne(int employee_id) {

		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		employeeDTO = null;

		try {
			con = dbConnect.getConnect();
			String sql = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, employee_id);
			rs = st.executeQuery();

			if (rs.next()) {
				employeeDTO = new EmployeeDTO();
				employeeDTO.setEmployee_id(rs.getInt("employee_id"));
				employeeDTO.setFirst_name(rs.getString("first_name"));
				employeeDTO.setLast_name(rs.getString("last_name"));
				employeeDTO.setEmail(rs.getString("email"));
				employeeDTO.setPhone_number(rs.getString("phone_number"));
				employeeDTO.setHire_date(rs.getString("hire_date"));
				employeeDTO.setJob_id(rs.getString("job_id"));
				employeeDTO.setSalary(rs.getInt("salary"));
				employeeDTO.setCommission_pct(rs.getString("commission_pct"));
				employeeDTO.setManager_id(rs.getString("manager_id"));
				employeeDTO.setDepartment_id(rs.getInt("department_id"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		return employeeDTO;
		
	}
	
	public EmployeeDTO getLname(String last_name) {
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		employeeDTO = null;

		try {
			con = dbConnect.getConnect();
			String sql = "SELECT * FROM EMPLOYEES WHERE LAST_NAME = ?";
			st = con.prepareStatement(sql);
			st.setString(1, last_name);
			rs = st.executeQuery();

			if (rs.next()) {
				employeeDTO = new EmployeeDTO();
				employeeDTO.setEmployee_id(rs.getInt("employee_id"));
				employeeDTO.setFirst_name(rs.getString("first_name"));
				employeeDTO.setLast_name(rs.getString("last_name"));
				employeeDTO.setEmail(rs.getString("email"));
				employeeDTO.setPhone_number(rs.getString("phone_number"));
				employeeDTO.setHire_date(rs.getString("hire_date"));
				employeeDTO.setJob_id(rs.getString("job_id"));
				employeeDTO.setSalary(rs.getInt("salary"));
				employeeDTO.setCommission_pct(rs.getString("commission_pct"));
				employeeDTO.setManager_id(rs.getString("manager_id"));
				employeeDTO.setDepartment_id(rs.getInt("department_id"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		return employeeDTO;
		
	}
	
	public EmployeeDTO getFname(String first_name) {
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		employeeDTO = null;

		try {
			con = dbConnect.getConnect();
			String sql = "SELECT * FROM EMPLOYEES WHERE FIRST_NAME = ?";
			st = con.prepareStatement(sql);
			st.setString(1, first_name);
			rs = st.executeQuery();

			if (rs.next()) {
				employeeDTO = new EmployeeDTO();
				employeeDTO.setEmployee_id(rs.getInt("employee_id"));
				employeeDTO.setFirst_name(rs.getString("first_name"));
				employeeDTO.setLast_name(rs.getString("last_name"));
				employeeDTO.setEmail(rs.getString("email"));
				employeeDTO.setPhone_number(rs.getString("phone_number"));
				employeeDTO.setHire_date(rs.getString("hire_date"));
				employeeDTO.setJob_id(rs.getString("job_id"));
				employeeDTO.setSalary(rs.getInt("salary"));
				employeeDTO.setCommission_pct(rs.getString("commission_pct"));
				employeeDTO.setManager_id(rs.getString("manager_id"));
				employeeDTO.setDepartment_id(rs.getInt("department_id"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		return employeeDTO;
		
	}
	
	public double getAavg() {
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		employeeDTO = null;
		double avg = 0;

		try {
			con = dbConnect.getConnect();
			String sql = "SELECT AVG(SALARY) FROM EMPLOYEES";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			
			rs.next();
			avg = rs.getDouble(1);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		return avg;
		
	}
	
	public ArrayList<EmployeeDTO> getAvg() {
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		employeeDTO = null;
		ArrayList<EmployeeDTO> ar = new ArrayList<>();

		try {
			con = dbConnect.getConnect();
			String sql = "SELECT AVG(SALARY) FROM EMPLOYEES GROUP BY DEPARTMENT_ID";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			
			while (rs.next()) {
				employeeDTO = new EmployeeDTO();
				employeeDTO.setSalary_avg(rs.getDouble("AVG(SALARY)"));
				
				ar.add(employeeDTO);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		return ar;
		
	}

}
