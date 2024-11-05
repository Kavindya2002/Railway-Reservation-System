package com.costomer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/userDetails")
public class getData extends HttpServlet {
  
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<costomer> userList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
        	conn = dataBase.getConnection();
            String query = "SELECT * FROM user";
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("iduser");
                String fname = rs.getString("firstName");
                String lname = rs.getString("lastName");
                String username = rs.getString("userName");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String mnumber = rs.getString("mobileNumber");
                String password = rs.getString("password");

                costomer user = new costomer(id,fname,lname,username,email,address,mnumber,password);
                userList.add(user);
            }
            request.setAttribute("userList", userList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("allUser.jsp");
            dispatcher.forward(request, response);

        } catch (Exception e) {
            
            e.printStackTrace();
            
        } finally {
            
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }




}
