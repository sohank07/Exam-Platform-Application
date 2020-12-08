package com.vwits.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.vwits.util.MyDBConnection;

public class ExaminationLogin {
	
	MyDBConnection con = new MyDBConnection();
	
	public void save(User u) {
		PreparedStatement ps = con.getPreparedStatement("insert into users values(?,?,?,?,?)");

		try {
			ps.setInt(1, u.getId());
			ps.setString(2, u.getUsername());
			ps.setString(3, u.getPassword());
			ps.setString(4, u.getType());
			ps.setString(5, u.getEmail());

			ps.execute();
			con.closeConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public int update(User u) {
		int x=0;
		PreparedStatement ps = con.getPreparedStatement("update users set username=?,password=?,type=?,email=? where id=?");

		try {
			ps.setInt(5, u.getId());
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getType());
			ps.setString(4, u.getEmail());

			x=ps.executeUpdate();
			con.closeConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return x;
	}
	
	public boolean validLogin(String user, String pass, String type) {
		
		Statement st = con.getStatement();
		
		String q = "Select* from users where username='"+user+"' and password='"+pass+"' and type='"+type+"'";

		try {
			ResultSet rs = st.executeQuery(q);

			if(rs.next()) {
				return true;
			}	
			else
				return false;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}
}
