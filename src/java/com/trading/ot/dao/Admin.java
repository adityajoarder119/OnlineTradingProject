/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trading.ot.dao;

import com.trading.ot.core.ConnectionManager;
import com.trading.ot.beans.Stocks;
import com.trading.ot.beans.User;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Adity
 */
public class Admin {

    public int updateUserPassword(String curpassword, String newpassword, String renewpassword, String emailId) throws SQLException, Exception {

        Connection con = ConnectionManager.getConnection();
        ResultSet rs = null;
        User user = new User();
        int i = 0;
        try {

            String sql1 = "SELECT * FROM user WHERE emailId=?";
            PreparedStatement ps1 = con.prepareStatement(sql1);
            ps1.setString(1, emailId);
            rs = ps1.executeQuery();
            if (rs.next()) {
                String npassword = rs.getString("password");
                if (npassword.equals(curpassword) && newpassword.equals(renewpassword)) {
                    String sql = "UPDATE user SET password = ?"
                            + "WHERE emailId = ?";
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setString(1, newpassword);
                    ps.setString(2, emailId);
                    System.out.println("Select SQL = " + ps);
                    i = ps.executeUpdate();
                    return i;
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }
    
    
    public int updateOtpPassword(String newotp, String newpassword, String confirmpassword, String emailId) throws SQLException, Exception {

        Connection con = ConnectionManager.getConnection();
        ResultSet rs = null;
        User user = new User();
        int i = 0;
        try {

            String sql1 = "SELECT * FROM user WHERE emailId=?";
            PreparedStatement ps1 = con.prepareStatement(sql1);
            ps1.setString(1, emailId);
            rs = ps1.executeQuery();
            if (rs.next()) {
                String notp = rs.getString("otp");
                if (notp.equals(newotp) && newpassword.equals(confirmpassword)) {
                    String sql = "UPDATE user SET password = ?"
                            + "WHERE emailId = ?";
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setString(1, newpassword);
                    ps.setString(2, emailId);
                    System.out.println("Select SQL = " + ps);
                    i = ps.executeUpdate();
                    return i;
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }


    public int updateUserDetails(String name, String dob, String address, String phoneNumber,
            String emailId) throws SQLException, Exception {

        Connection con = ConnectionManager.getConnection();
        int i = 0;
        try {
            String sql = "UPDATE user SET name = ?, dob = ?, "
                    + "address = ?, phoneNumber = ?"
                    + "WHERE emailId = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, dob);
            ps.setString(3, address);
            ps.setString(4, phoneNumber);
            ps.setString(5, emailId);
            System.out.println("Select SQL = " + ps);
            i = ps.executeUpdate();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    public int updateStockDetails(int stockId, String stockName, double price, int availability) throws SQLException, Exception {

        Connection con = ConnectionManager.getConnection();
        int i = 0;
        try {
            String sql = "UPDATE stocks SET stockName = ?, price = ?, availability = ? WHERE stockId = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, stockName);
            ps.setDouble(2, price);
            ps.setInt(3, availability);
            ps.setInt(4, stockId);
            System.out.println("Select SQL = " + ps);
            i = ps.executeUpdate();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    public int updateStockLists(String csvFilePath) throws SQLException, Exception {

        Connection con = ConnectionManager.getConnection();
        int i = 0;
        int p = 0;
        int batchSize = 10;
        try {

            String sql = "INSERT INTO trading.stocks (stockName,price,availability) VALUES(?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);
            BufferedReader lineReader = new BufferedReader(new FileReader(csvFilePath));
            String lineText = null;

            int count = 0;
            lineReader.readLine();
            while ((lineText = lineReader.readLine()) != null) {
                String[] data = lineText.split(",");
                String stockName = data[0];
                String price = data[1];
                String availability = data[2];

                System.out.println(stockName);
                System.out.println(price);
                System.out.println(availability);

                ps.setString(1, stockName);
                ps.setDouble(2, Double.parseDouble(price));
                ps.setInt(3, Integer.parseInt(availability));

                System.out.println("Select SQL = " + ps);

                ps.addBatch();

                if (count % batchSize == 0) {
                    ps.executeBatch();
                }
                i = i + 1;
            }
            lineReader.close();

            // execute the remaining queries
            ps.executeBatch();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            if (con != null) {
                con.close();
            }
        }

    }

    public int deleteStock(int stockId) throws SQLException, Exception {

        Connection con = ConnectionManager.getConnection();
        int i = 0;
        try {
            String sql = "UPDATE trading.stocks SET availability = 0 WHERE stockId = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, stockId);
            i = ps.executeUpdate();
            return i;

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            if (con != null) {
                con.close();
            }
        }

    }

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
            System.out.println("SQL for insert=" + ps);
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

    public int addToCart(int stockId, int availability, int quantity, int addtocart) {
        int c = 0;
        if (availability >= quantity) {
            ArrayList cart = new ArrayList();
            if (addtocart > 0) {
                Stocks stocks = new Stocks();
                stocks.setStockId(stockId);
                stocks.setAvailability(availability);
                stocks.setQuantity(quantity);
                cart.add(stocks);
                c = cart.size();
                c = c + addtocart;
            } else {
                Stocks stocks = new Stocks();
                stocks.setStockId(stockId);
                stocks.setAvailability(availability);
                stocks.setQuantity(quantity);
                cart.add(stocks);
                c = cart.size();
            }

        }
        return c;
    }

    public int updateOtp(String otp, String emailId) throws Exception {
        int i = 0;
        Connection con = null;
        try {
            con = ConnectionManager.getConnection();
            String sql = "UPDATE trading.user SET otp=? WHERE emailId=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, otp);
            ps.setString(2, emailId);
            System.out.println("SQL for insert=" + ps);
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

    public User checkValidUser(String emailId, String password) throws SQLException, Exception {
        ResultSet rs = null;
        User user = new User();
        Connection con = null;
        boolean valid = true;
        try {
            con = ConnectionManager.getConnection();
            String sql = "SELECT * FROM user WHERE emailId=? and password=?";
            System.out.println("Got the connection.........................." + con);
            PreparedStatement ps = con.prepareStatement(sql);
            System.out.println("emailId = " + emailId);
            ps.setString(1, emailId);
            ps.setString(2, password);
            System.out.println("Select SQL = " + ps);

            rs = ps.executeQuery();
            if (rs.next()) {
                user.setName(rs.getString("name"));
                user.setEmailId(rs.getString("emailID"));
                user.setPhoneNumber(rs.getString("phoneNumber"));
                user.setDob(rs.getString("dob"));
                user.setPassword(rs.getString("password"));
                user.setAddress(rs.getString("address"));
                user.setStatus(rs.getInt("status"));
                user.setValidUser(valid);
            } else {
                valid = false;
                user.setValidUser(valid);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return user;

    }

    public User checkForgetPassword(String emailId) throws SQLException, Exception {
        ResultSet rs = null;
        User user = new User();
        Connection con = null;
        boolean valid = true;
        try {
            con = ConnectionManager.getConnection();
            String sql = "SELECT * FROM user WHERE emailId=?";
            System.out.println("Got the connection.........................." + con);
            PreparedStatement ps = con.prepareStatement(sql);
            System.out.println("emailId = " + emailId);
            ps.setString(1, emailId);
            System.out.println("Select SQL = " + ps);

            rs = ps.executeQuery();
            if (rs.next()) {

                user.setEmailId(rs.getString("emailID"));
                user.setValidUser(valid);
            } else {
                valid = false;
                user.setValidUser(valid);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return user;

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

    public String generateOTP() {
        String values = "0123456789";
        Random rndm_method = new Random();

        char[] otp = new char[4];

        for (int j = 0; j < 4; j++) {
            otp[j] = values.charAt(rndm_method.nextInt(values.length()));
        }

        String generatedOTP = new String(otp);
        return generatedOTP;
    }

    public static void send(String from, String password, String to, String sub, String msg) {
        //Get properties object    
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        //get Session   
        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });
        //compose message    
        try {
            MimeMessage message = new MimeMessage(session);
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(sub);
            message.setText(msg);
            //send message  
            Transport.send(message);
            System.out.println("message sent successfully");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }

}
