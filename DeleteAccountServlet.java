package com.costomer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteAccount")
public class DeleteAccountServlet extends HttpServlet {
 
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = (String) request.getSession().getAttribute("username");
        

        boolean success = costomerDButill.deleteUserAccount(username);
        

        if (success) {

            response.sendRedirect("login.jsp");
        } 
    }
}
