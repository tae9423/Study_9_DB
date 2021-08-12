package com.dg.s1.location;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.dg.s1.util.DBConnect;

public class LocationDAO {

	private DBConnect dbConnect;

	public LocationDAO() {

		dbConnect = new DBConnect();
	}

	public ArrayList<LocationDTO> getList() {
		System.out.println("LOCATION Select Start");
		// LOCATIONS Table을 조회해서 출력

		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<LocationDTO> ar = new ArrayList<>();

		try {
			// 2. 드라이버 로딩
			con = dbConnect.getConnect();

			// 4. SQL문 생성
			String sql = "SELECT * FROM LOCATIONS";

			// 5. SQL문 미리 보내기
			st = con.prepareStatement(sql);

			// 6.

			// 7. 최종 전송 후 결과 처리
			rs = st.executeQuery();

			while (rs.next()) {
				LocationDTO locationDTO = new LocationDTO();
				locationDTO = new LocationDTO();
				locationDTO.setLocation_id(rs.getInt("location_id"));
				locationDTO.setStreet_address(rs.getString("street_address"));
				locationDTO.setPostal_code(rs.getString("postal_code"));
				locationDTO.setCity(rs.getString("city"));
				locationDTO.setState_province(rs.getString("state_province"));
				locationDTO.setCountry_id(rs.getString("country_id"));

				ar.add(locationDTO);

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
		return ar;

	}

	public LocationDTO getOne(int location_id) {

		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		LocationDTO locationDTO = null;

		try {
			con = dbConnect.getConnect();

			String sql = "SELECT * FROM LOCATIONS WHERE LOCATION_ID = ?";

			st = con.prepareStatement(sql);

			st.setInt(1, location_id);

			rs = st.executeQuery();

			if (rs.next()) {
				locationDTO = new LocationDTO();
				locationDTO.setLocation_id(rs.getInt("location_id"));
				locationDTO.setStreet_address(rs.getString("street_address"));
				locationDTO.setPostal_code(rs.getString("postal_code"));
				locationDTO.setCity(rs.getString("city"));
				locationDTO.setState_province(rs.getString("state_province"));
				locationDTO.setCountry_id(rs.getString("country_id"));

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

		return locationDTO;

	}

	public ArrayList<LocationDTO> getSearch(String select) {

		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		LocationDTO locationDTO = null;
		ArrayList<LocationDTO> ar = new ArrayList<>();

		try {
			// 2. 드라이버 로딩

			// 1. Connection
			con = dbConnect.getConnect();

			// 2. sql문 생성
			String sql = "SELECT * FROM LOCATIONS WHERE STREET_ADDRESS LIKE ?";

			// 3. 미리 전송
			st = con.prepareStatement(sql);

			// 4. ? 값 설정
			st.setString(1, select);

			rs = st.executeQuery();

			while (rs.next()) {

				locationDTO = new LocationDTO();
				locationDTO.setLocation_id(rs.getInt("location_id"));
				locationDTO.setStreet_address(rs.getString("street_address"));
				locationDTO.setPostal_code(rs.getString("postal_code"));
				locationDTO.setCity(rs.getString("city"));
				locationDTO.setState_province(rs.getString("state_province"));
				locationDTO.setCountry_id(rs.getString("country_id"));

				ar.add(locationDTO);

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

		return ar;
	}

	public int getCount() {

		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<LocationDTO> ar = new ArrayList<>();
		LocationDTO locationDTO = null;
		int count = 0;

		try {
			con = dbConnect.getConnect();

			String sql = "SELECT COUNT(LOCATION_ID) FROM LOCATIONS";

			st = con.prepareStatement(sql);

			rs = st.executeQuery();
			
			rs.next();
			
			count = rs.getInt(1);
			
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

		return count;

	}
	
	public LocationDTO getLocation(int employee_id) {
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		LocationDTO locationDTO = null;
		

		try {
			con = dbConnect.getConnect();

			String sql = "SELECT * FROM LOCATIONS WHERE LOCATION_ID = (SELECT LOCATION_ID FROM  DEPARTMENTS WHERE DEPARTMENT_ID "
					+ "= (SELECT DEPARTMENT_ID FROM EMPLOYEES WHERE EMPLOYEE_ID = ?))";

			st = con.prepareStatement(sql);
			
			st.setInt(1, employee_id);

			rs = st.executeQuery();
			
			if (rs.next()) {
				locationDTO = new LocationDTO();
				locationDTO.setLocation_id(rs.getInt("location_id"));
				locationDTO.setStreet_address(rs.getString("street_address"));
				locationDTO.setPostal_code(rs.getString("postal_code"));
				locationDTO.setCity(rs.getString("city"));
				locationDTO.setState_province(rs.getString("state_province"));
				locationDTO.setCountry_id(rs.getString("country_id"));

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
		
		return locationDTO;
		
	}

}
