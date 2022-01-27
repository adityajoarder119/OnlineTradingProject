/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trading.ot.actions;

import com.trading.ot.beans.User;
import com.trading.ot.dao.Admin;
import java.net.URL;
import java.net.URLConnection;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author ritup
 */
public class UserAction {
    private int userId;
    private String name;
    private String emailId;
    private String phoneNumber;
    private String dob;
    private String password;
    private String address;
    private String validUser;
    private int status;
    
    
    
    private ResultSet rs = null;
    private User user = null;
    private List<User> userList = null;
    private boolean noData = false;

    private String msg = "";
    private Admin admin = null;
    private int ctr = 0;
    private String submitType;
    public String addUsers()
    {
        setAdmin(new Admin());

        try {
            setCtr(getAdmin().registerUser(getName(), getEmailId(), getPhoneNumber(), getDob(), getPassword(), getAddress()));
            if (getCtr() > 0) {
               
                setMsg("Registration Successfully");
            } else {
                setMsg("Some error");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "REGISTER";
        
    }
    
    public String checkValidUser()
    {
        //URL url;
        //URLConnection connection;
        
        
        setAdmin(new Admin());
        try {
            setCtr(getAdmin().checkValidUser(getEmailId(), getPassword()));
            if (getCtr() > 0) {
               //url=new URL("http://localhost:8010/OnlineTradingProject/dashboard.jsp");
               //connection=url.openConnection();
               //connection.setDoOutput(true);
               //String url="http://localhost:8010/OnlineTradingProject/admin-dashboard.jsp";
               //java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
                setMsg("Login Successfull");
            } else {
                setMsg("Some error");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "USER";
        
    }

    /**
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the emailId
     */
    public String getEmailId() {
        return emailId;
    }

    /**
     * @param emailId the emailId to set
     */
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return the dob
     */
    public String getDob() {
        return dob;
    }

    /**
     * @param dob the dob to set
     */
    public void setDob(String dob) {
        this.dob = dob;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the validUser
     */
    public String getValidUser() {
        return validUser;
    }

    /**
     * @param validUser the validUser to set
     */
    public void setValidUser(String validUser) {
        this.validUser = validUser;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * @return the rs
     */
    public ResultSet getRs() {
        return rs;
    }

    /**
     * @param rs the rs to set
     */
    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @return the userList
     */
    public List<User> getUserList() {
        return userList;
    }

    /**
     * @param userList the userList to set
     */
    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    /**
     * @return the noData
     */
    public boolean isNoData() {
        return noData;
    }

    /**
     * @param noData the noData to set
     */
    public void setNoData(boolean noData) {
        this.noData = noData;
    }

    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * @return the admin
     */
    public Admin getAdmin() {
        return admin;
    }

    /**
     * @param admin the admin to set
     */
    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    /**
     * @return the ctr
     */
    public int getCtr() {
        return ctr;
    }

    /**
     * @param ctr the ctr to set
     */
    public void setCtr(int ctr) {
        this.ctr = ctr;
    }

    /**
     * @return the submitType
     */
    public String getSubmitType() {
        return submitType;
    }

    /**
     * @param submitType the submitType to set
     */
    public void setSubmitType(String submitType) {
        this.submitType = submitType;
    }
    
}
