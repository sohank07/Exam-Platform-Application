package com.vwits.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vwits.model.Questions;
import com.vwits.DAO.QuestionsDAO;

@WebServlet("/UpdateExamServlet")
public class UpdateExamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UpdateExamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Questions q = new Questions(7, "Birth Date?", "7", "8", "9", "10","7");
		
		QuestionsDAO qd = new QuestionsDAO();
		qd.addQuestion(q);
	}

}
