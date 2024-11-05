package com.costomer;
import java.util.*;



import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class costomerDButill {
	
	public static boolean isSuccess;
	private static Connection con = null;
	private static Statement stm = null;
	private static ResultSet rs = null;
	
	
	public static List<costomer> validate(String username,String password){
		ArrayList<costomer> cus = new ArrayList<>();
		
		
		
		//validate
	try {
		con = dataBase.getConnection();
		stm = con.createStatement();
		
		String sql="select * from user where userName='"+username+
				"'and password = '"+password+"'";
		rs = stm.executeQuery(sql);
		if(rs.next()) {
			int id =rs.getInt(1);
			String fname=rs.getString(2);
			String lname = rs.getString(3);
			String userName=rs.getString(4);
			String email=rs.getString(5);
			String address=rs.getString(6);
			String mnum=rs.getString(7);
			String passWord=rs.getString(8);
			
			costomer cs1=new costomer(id,fname,lname,userName,email,address,mnum,passWord);
			cus.add(cs1);
		}		
	}
	catch(Exception e){
		e.printStackTrace();	
	}	
		return cus;
	}
	
	
	//register user
	public static boolean registerUser(String fname,String lname,String uname,String mail,String address,String number,String password ) {
		boolean isSuccess = false;
		

		
		try{
			con = dataBase.getConnection();
			stm = con.createStatement();
			Class.forName("com.mysql.jdbc.Driver");
	
			String sql = "insert into user values (0,'"+fname+"','"+lname+"','"+uname+"','"+mail+"','"+address+"','"+number+"','"+password+"')";
			int rs = stm.executeUpdate(sql);
			

			if (rs > 0) {
				isSuccess = true;
				
			}
			else {
				isSuccess = false;
			}
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		
		return isSuccess;
	}
	
	//update the customer
	
	public static boolean updateCustomer(String id, String newUsername, String newEmail, String newAddress, String newMobileNumber) {
        boolean isSuccess = false;
        Connection conn = null;
        java.sql.PreparedStatement stmt = null;

        try {
            conn = dataBase.getConnection();
            String query = "UPDATE user SET username=?, email=?, address=?, mobileNumber=? WHERE iduser=?;";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, newUsername);
            stmt.setString(2, newEmail);
            stmt.setString(3, newAddress);
            stmt.setString(4, newMobileNumber);
            stmt.setString(5, id);
            int rowsAffected = stmt.executeUpdate();

            isSuccess = rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return isSuccess;
    }
	
	
	//read data and display
	public static List<costomer>  getCustomerDetails(String id){
		int convertId = Integer.parseInt(id);
		ArrayList<costomer> cus = new ArrayList<costomer>();
		
		try {
			con = dataBase.getConnection();
			stm = con.createStatement();
			String sql = "select * from user where iduser = '"+convertId+"'";
			rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				int iduser =rs.getInt(1);
				String fname=rs.getString(2);
				String lname = rs.getString(3);
				String userName=rs.getString(4);
				String email=rs.getString(5);
				String address=rs.getString(6);
				String mnum=rs.getString(7);
				String passWord=rs.getString(8);
				
				costomer c1 = new costomer(iduser, fname, lname, userName, email, address, mnum, passWord);
				cus.add(c1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cus;
	}
	
	// delete customers methode
    public static boolean deleteUserAccount(String username) {
        Connection conn = null;
        Statement stmt = null;
        try {
            
            conn = dataBase.getConnection();
            
            
            String sql = "DELETE FROM user WHERE username = '" + username + "'";
            
            
            stmt = conn.createStatement();
            
            
            int rowsAffected = stmt.executeUpdate(sql);
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}





