package com.dg.s1.location;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dg.s1.util.DBConnect;

public class LocationDAO {

	private DBConnect dbConnect;

	public LocationDAO() {

		dbConnect = new DBConnect();
	}

	public ArrayList<LocationDTO> getList() {
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		LocationDTO locationDTO = null;
		ArrayList<LocationDTO> ar = new ArrayList<>();
		
		try {
			con = dbConnect.getConnect();
			String sql = "SELECT * FROM LOCATIONS";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			
			while(rs.next()) {
				
				locationDTO = new LocationDTO();
				
				locationDTO.setLocation_id(rs.getInt("LOCATION_ID"));
				locationDTO.setStreet_address(rs.getString("STREET_ADDRESS"));
				locationDTO.setPostal_code(rs.getString("POSTAL_CODE"));
				locationDTO.setCity(rs.getString("CITY"));
				locationDTO.setState_province(rs.getString("STATE_PROVINCE"));
				locationDTO.setCountry_id(rs.getString("COUNTRY_ID"));
				
				ar.add(locationDTO);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ar;

	}
	
	public LocationDTO getOne(LocationDTO locationDTO) {
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		LocationDTO result = null;
		
		
		try {
			con = dbConnect.getConnect();
			String sql = "SELECT * FROM LOCATIONS WHERE LOCATION_ID = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, locationDTO.getLocation_id());
			
			rs= st.executeQuery();
			
			if(rs.next()) {
				
				result = new LocationDTO();
				
				result.setLocation_id(rs.getInt("LOCATION_ID"));
				result.setStreet_address(rs.getString("STREET_ADDRESS"));
				result.setPostal_code(rs.getString("POSTAL_CODE"));
				result.setCity(rs.getString("CITY"));
				result.setState_province(rs.getString("STATE_PROVINCE"));
				result.setCountry_id(rs.getString("COUNTRY_ID"));
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbConnect.disConnect(rs, st, con);
		}
		
		return result;
		
	}

}
