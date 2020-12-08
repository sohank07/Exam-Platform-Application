package com.vwits.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vwits.model.Result;
import com.vwits.util.MyDBConnection;

public class ResultDAO {

	MyDBConnection con = new MyDBConnection();
	List<String> users = new ArrayList<String>();
	
	public void addResult(Result r) {
		PreparedStatement ps = con.getPreparedStatement("insert into result values(?,?)");

		try {
			ps.setString(1, r.getUsername());
			ps.setInt(2, r.getTotal());

			ps.execute();
			con.closeConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public ResultSet displayResult() {
		ResultSet rs = null;
		
		try {
			String query = "select* from result";
			PreparedStatement ps = con.getPreparedStatement(query);
			rs = ps.executeQuery(query);
			return rs;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet getSingleResult(String username) {
		ResultSet rs = null;
		
		try {
			String query = "select* from result where username=?";
			
			PreparedStatement ps = con.getPreparedStatement(query);
			ps.setString(1, username);
			rs = ps.executeQuery();
			
			return rs;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
}
