package com.vwits.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vwits.util.MyDBConnection;

public class UserLogin {
	MyDBConnection con = new MyDBConnection();
	String name = null;

	public String fetchNameOfUser(String id) {
		String query = "SELECT USERNAME FROM USERS WHERE ID=?";
		try {
			PreparedStatement ps = con.getPreparedStatement(query);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				name = rs.getString(1);
					return name;

			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return name;
	}

}
