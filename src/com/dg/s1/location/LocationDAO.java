package com.dg.s1.location;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dg.s1.util.DBConnect;

public class LocationDAO {

	private DBConnect dbConnect;

	public LocationDAO() {

		dbConnect = new DBConnect();
	}

	public void getList() {
		System.out.println("LOCATION Select Start");
		// LOCATIONS Table을 조회해서 출력

		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;

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
				System.out.print(rs.getInt("LOCATION_ID") + "\t");
				System.out.print(rs.getString("STREET_ADDRESS") + "\t");
				System.out.print(rs.getString("POSTAL_CODE") + "\t");
				System.out.print(rs.getString("CITY") + "\t");
				System.out.print(rs.getString("STATE_PROVINCE") + "\t");
				System.out.println(rs.getString("COUNTRY_ID"));
				System.out.println("--------------------------------------------------");

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

		System.out.println("LOCATION Select Finish");

	}

	public void getOne(int location_id) {

		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			con = dbConnect.getConnect();

			String sql = "SELECT * FROM LOCATIONS WHERE LOCATION_ID = ?";

			st = con.prepareStatement(sql);

			st.setInt(1, location_id);

			rs = st.executeQuery();

			if (rs.next()) {
				System.out.println(rs.getString("STREET_ADDRESS"));
			} else {
				System.out.println("그런 번호는 없다");
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

	}

}
