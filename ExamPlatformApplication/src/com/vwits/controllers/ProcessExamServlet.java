package com.vwits.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vwits.DAO.QuestionsDAO;
import com.vwits.model.Result;
import com.vwits.DAO.ResultDAO;

@WebServlet("/ProcessExamServlet")
public class ProcessExamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ProcessExamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		ResultSet rs = new QuestionsDAO().displayQuestions();
		List<String> questionIds = new ArrayList<String>();
		List<String> correctAns = new QuestionsDAO().getCorrectAnswers(); 
		String userSession = request.getParameter("userSession");
		int totalCorrect = 0;
		try {
			while(rs.next()) {
				questionIds.add(rs.getString(1));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(String key : questionIds) {
			
			String ques1 = request.getParameter("ans"+key); 
			if(correctAns.contains(ques1)) {
				totalCorrect++;
			}
		}
		
		Result r = new Result(userSession, totalCorrect);
		ResultDAO rd = new ResultDAO();
		rd.addResult(r);
		out.println("<h2>Exam submitter successfully!</h2>");
		out.println("<a href='studenthome.jsp'>Home Page");
		
		
	}

}
