package com.vwits.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vwits.model.ExaminationLogin;
import com.vwits.model.User;

@WebServlet("/update")
public class ProfileUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ProfileUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		String type = "student";
		String email = request.getParameter("email");
		
		ExaminationLogin e = new ExaminationLogin();
		User u = new User(id, user, pass, type, email);
		int x = e.update(u);
		PrintWriter out = response.getWriter();
		if(x!=-1)
			out.println("<h3 style='text-align: center; color: green'>Profile updated successfully!</h3>");
		else
			out.println("<h2 style='text-align: center; color: red'>Operation failed");
		out.println("<p style='text-align: center'><a href='studenthome.jsp'>Home Page</a>");
	}

}
