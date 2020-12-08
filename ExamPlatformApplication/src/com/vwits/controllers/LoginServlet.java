package com.vwits.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vwits.model.ExaminationLogin;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		String type = request.getParameter("logintype");
		RequestDispatcher r = request.getRequestDispatcher("index.jsp");
		
		ExaminationLogin login = new ExaminationLogin();
		boolean flag = login.validLogin(user, pass, type);
		if(type.equals("student")) {
			if(flag==true) {
				HttpSession session = request.getSession();
				session.setAttribute("username", user);
				response.sendRedirect("studenthome.jsp");
			}
			else {
				request.setAttribute("message", "<p style='color:red'>Invalid User</p>");
				r.forward(request, response);
			}
		}
		
		else if(type.equals("teacher")) {
			if(flag==true) {
				HttpSession session = request.getSession();
				session.setAttribute("username", user);
				response.sendRedirect("teacherhome.jsp");
			}
			else {
				request.setAttribute("message", "<p style='color:red'>Invalid User</p>");
				r.forward(request, response);
			}
		}
		
	}

}
