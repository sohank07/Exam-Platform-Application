package com.vwits.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vwits.model.ExaminationLogin;
import com.vwits.model.User;


@WebServlet("/insert")
public class InsertUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public InsertUser() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		int id = Integer.parseInt(request.getParameter("id"));
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		String type = request.getParameter("type");
		String email = request.getParameter("email");
		
		ExaminationLogin e = new ExaminationLogin();
		User u = new User(id, user, pass, type, email);
		e.save(u);
		
		RequestDispatcher r = request.getRequestDispatcher("index.jsp");
		request.setAttribute("message2", "<p style='color:green'>User Created Successfully.. Please Login</p>");
		r.forward(request, response);
	}

}
