package com.vwits.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vwits.model.Questions;
import com.vwits.util.MyDBConnection;

public class QuestionsDAO {

	MyDBConnection con = new MyDBConnection();
	List<String> correctAns = new ArrayList<String>();
	
	public void editQuestion(Questions q) {
		PreparedStatement ps = con.getPreparedStatement("update questions set question=?,option1=?,option2=?,option3=?,option4=?,answer=? where id=?");

		try {
			ps.setInt(7, q.getId());
			ps.setString(1, q.getQuestion());
			ps.setString(2, q.getOption1());
			ps.setString(3, q.getOption2());
			ps.setString(4, q.getOption3());
			ps.setString(5, q.getOption4());
			ps.setString(6, q.getAnswer());

			ps.execute();
			con.closeConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void addQuestion(Questions q) {
		PreparedStatement ps = con.getPreparedStatement("insert into questions values(?,?,?,?,?,?,?)");

		try {
			ps.setInt(1, q.getId());
			ps.setString(2, q.getQuestion());
			ps.setString(3, q.getOption1());
			ps.setString(4, q.getOption2());
			ps.setString(5, q.getOption3());
			ps.setString(6, q.getOption4());
			ps.setString(7, q.getAnswer());

			ps.execute();
			con.closeConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public ResultSet displayQuestions() {
		ResultSet rs = null;
		
		try {
			String query = "SELECT id,question,option1,option2,option3,option4 from questions";
			PreparedStatement ps = con.getPreparedStatement(query);
			rs = ps.executeQuery(query);
			return rs;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	
	public List<String> getCorrectAnswers(){
		ResultSet rs;
		
		try {
			String query = "select answer from questions";
			PreparedStatement ps = con.getPreparedStatement(query);
			rs = ps.executeQuery(query);
			while(rs.next()) {
				correctAns.add(rs.getString("answer"));
			}
			return correctAns;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return correctAns;
	}
}
