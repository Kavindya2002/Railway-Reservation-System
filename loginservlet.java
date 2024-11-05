package com.costomer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/loginservlet")
public class loginservlet extends HttpServlet { //Inheritance
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)//polymorphism
            throws ServletException, IOException {

        String username = request.getParameter("uid");
        String password = request.getParameter("pass");

        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement stmt = null;

        try {                                     //exception
            conn = dataBase.getConnection();
            String query = "select * from user where userName=? and password=?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            rs = stmt.executeQuery();
            if (rs.next()) {
                HttpSession session = request.getSession();
                session.setAttribute("username", username);

            }

            List<costomer> cusdetails = costomerDButill.validate(username, password);
            request.setAttribute("cusdetails", cusdetails);    //abstraction

            if (cusdetails.isEmpty()) {
                request.setAttribute("errorMessage", "Invalid username or password");
                RequestDispatcher errorDispatcher = request.getRequestDispatcher("login.jsp");
                errorDispatcher.forward(request, response);
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        RequestDispatcher dis = request.getRequestDispatcher("homepage.jsp");
        dis.forward(request, response);
    }
}
