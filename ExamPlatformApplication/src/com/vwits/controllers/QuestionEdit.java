package com.vwits.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vwits.model.Questions;
import com.vwits.DAO.QuestionsDAO;

@WebServlet("/QuestionEdit")
public class QuestionEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public QuestionEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String question = request.getParameter("question");
		String option1 = request.getParameter("option1");
		String option2 = request.getParameter("option2");
		String option3 = request.getParameter("option3");
		String option4 = request.getParameter("option4");
		String answer = request.getParameter("answer");
		
		Questions q = new Questions(id, question, option1, option2, option3, option4, answer);
		QuestionsDAO qd = new QuestionsDAO();
		qd.editQuestion(q);
		PrintWriter out = response.getWriter();
		out.println("Updation Successful!");
	}

}
