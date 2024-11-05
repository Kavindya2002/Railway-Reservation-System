package com.costomer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updateDetails")
public class UpdateDetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        String newUsername = request.getParameter("newUsername");
        String newEmail = request.getParameter("newEmail");
        String newAddress = request.getParameter("newAddress");
        String newMobileNumber = request.getParameter("newMobileNumber");
        String fname = request.getParameter("fname"); 
        String lname = request.getParameter("lname"); 
        
        boolean isSuccess = costomerDButill.updateCustomer(id, newUsername, newEmail, newAddress, newMobileNumber);
        
        if (isSuccess) {

            response.sendRedirect("userProfile.jsp?id=" + id +
                "&fname=" + fname +
                "&lname=" + lname +
                "&phone=" + newMobileNumber +
                "&username=" + newUsername +
                "&email=" + newEmail +
                "&address=" + newAddress +
                "&password=" + request.getParameter("password"));
        }
    }
}
