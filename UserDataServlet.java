package com.costomer;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/userData")
public class UserDataServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("uid");
        String password = request.getParameter("pass");
        try {

            List<costomer> cusdetails = costomerDButill.validate(username, password);
            request.setAttribute("cusdetails", cusdetails);

            if (cusdetails.isEmpty()) {
                request.setAttribute("errorMessage", "Invalid username or password");
                RequestDispatcher errorDispatcher = request.getRequestDispatcher("login.jsp");
                errorDispatcher.forward(request, response);
                return;
            }

        } catch (Exception e) {
            e.printStackTrace();

        }

        RequestDispatcher dis = request.getRequestDispatcher("userProfile.jsp");
        dis.forward(request, response);

    }

}
