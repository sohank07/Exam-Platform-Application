package com.vwits.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import com.vwits.DAO.QuestionsDAO;
import com.vwits.DAO.ResultDAO;


@WebServlet("/ProcessResult")
public class ProcessResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ProcessResult() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String userSession = request.getParameter("userSession");
		ResultSet rs = new ResultDAO().getSingleResult(userSession);
		
		
	}

}
