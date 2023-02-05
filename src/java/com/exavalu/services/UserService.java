/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.services;

import com.exavalu.models.User;
import com.exavalu.utils.JDBCConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class UserService {
     public static UserService userService = null;
    
    private UserService(){}
    
    public static UserService getInstance()
    {
        if(userService==null)
        {
            return new UserService();
        }
        else
        {
            return userService;
        }
    }
    
    public boolean doLogin(User user)
    {
        boolean success = false;
        
        String sql = "Select * from users where emailAddress=? and password=?";
        
        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getEmailAddress());
            ps.setString(2, user.getPassword());
            
            System.out.println("LoginService :: "+ps);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next())
            {
                success = true;
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        return success;
    }

    public boolean doSignup(User user) {
        boolean result = false;
        String sql = "INSERT INTO users (emailAddress,password,firstName,lastName,status)"
                    + "VALUES (?,?,?,?,?)";
        try {

            Connection con = JDBCConnectionManager.getConnection();
            

            PreparedStatement preparedStatement;
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, user.getEmailAddress());
            preparedStatement.setString(2, user.getPassword());

            preparedStatement.setString(3, user.getFirstName());
            preparedStatement.setString(4, user.getLastName());
            preparedStatement.setInt(5, 1);

            int row = preparedStatement.executeUpdate();
            if (row == 1) {
                result = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }

    public User getUser(String emailAddress) {
       User user= new User();
        Connection con = JDBCConnectionManager.getConnection();
        try {
            
            String sql = "Select * from users where emailAddress=?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, emailAddress);

            ResultSet rs = preparedStatement.executeQuery();

            if(rs.next())
            {

                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
            }

        } catch (SQLException ex) {

        }

       
        return user;
    }
}
