/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trading.ot.dao;

import com.trading.ot.core.ConnectionManager;
import com.trading.ot.beans.Stocks;
import com.trading.ot.beans.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adity
 */
public class Admin {
    
    public int registerUser(String name, String emailId, String phoneNumber, String dob,
            String password, String address) throws Exception {
        int i = 0;
        Connection con = null;
        try {
            con = ConnectionManager.getConnection();
            String sql = "INSERT INTO trading.user(name,emailId,phoneNumber,dob,password,address,status) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, emailId);
            ps.setString(3, phoneNumber);
            ps.setString(4, dob);
            ps.setString(5, password);
            ps.setString(6, address);
            ps.setInt(7, 0);
            System.out.println("SQL for insert="+ps);
            i = ps.executeUpdate();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return i;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    public int checkValidUser(String emailId, String password) throws SQLException, Exception {
        ResultSet rs = null;
        Connection con = null;
        int c=0;
        try {
            con = ConnectionManager.getConnection();
            String sql = "SELECT * FROM user WHERE emailId=? and password=?";
            PreparedStatement ps = con.prepareStatement(sql);
            System.out.println("emailId = " + emailId);
            ps.setString(1, emailId);
            ps.setString(2, password);
            System.out.println("Select SQL = " + ps);

            rs = ps.executeQuery();
            if (rs.next()) {
                
                return c+1;               
            }
            else
            {
                return c;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            return c;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }
   public List reportStock() throws SQLException, Exception {
        ResultSet rs = null;
        Connection con = null;
        List<Stocks> stockList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM trading.stocks";
            con = ConnectionManager.getConnection();
            System.out.println("Connection is " + con);
            PreparedStatement ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Stocks stocks = new Stocks();
                stocks.setStockId(rs.getInt("stockId"));
                stocks.setStockName(rs.getString("stockName"));
                stocks.setPrice(rs.getDouble("price"));
                stocks.setAvailability(rs.getInt("availability"));
                stockList.add(stocks);
            }
            return stockList;
        } catch (SQLException e) {
            return null;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }
   
   
   

}
