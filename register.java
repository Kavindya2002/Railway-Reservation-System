package com.costomer;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fname = request.getParameter("firstName");
		String lname = request.getParameter("lastName");
		String uname = request.getParameter("username");
		String mail = request.getParameter("email");
		String address = request.getParameter("address");
		String number = request.getParameter("mobileNumber");
		String password = request.getParameter("password");
		
		boolean isTrue;
		
		isTrue = costomerDButill.registerUser(fname,lname,uname,mail,address,number,password);
		
		if(isTrue == true) {
			RequestDispatcher dispatch = request.getRequestDispatcher("login.jsp");
			dispatch.forward(request, response);
		}
		else {
			RequestDispatcher dispatch2 = request.getRequestDispatcher("signUp.jsp");
			dispatch2.forward(request, response);
		}
	}
	

	
	
		
	}

