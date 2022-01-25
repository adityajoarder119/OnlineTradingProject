/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trading.ot.dao;

import com.trading.ot.core.ConnectionManager;
import com.trading.ot.beans.Stocks;
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

   public List reportStock() throws SQLException, Exception {
        ResultSet rs = null;
        Connection con = null;
        List<Stocks> stockList = new ArrayList<>();
        try {
            String sql = "SELECT stockId, stockName, price, availability FROM stocks;";
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
