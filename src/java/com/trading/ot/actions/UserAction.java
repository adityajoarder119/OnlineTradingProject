/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trading.ot.actions;
import com.opensymphony.xwork2.ActionSupport;
import com.trading.ot.beans.User;
import com.trading.ot.dao.Admin;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;


/**
 *
 * @author ritup
 */
public class UserAction extends ActionSupport implements SessionAware{
    private static final long serialVersionUID = 4821216272008282533L;
    private SessionMap<String, Object> sessionMap;
    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap)map;
    }
    private int userId;
    private String name;
    private String emailId;
    private String phoneNumber;
    private String dob;
    private String password;
    private String address;
    private boolean validUser;
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
                return "ERROR";
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
            user=getAdmin().checkValidUser(getEmailId(), getPassword());
            int status=user.getStatus();
            String name=user.getName();
            
            if (user.isValidUser()==true) {
               //url=new URL("http://localhost:8010/OnlineTradingProject/dashboard.jsp");
               //connection=url.openConnection();
               //connection.setDoOutput(true);
               //String url="http://localhost:8010/OnlineTradingProject/admin-dashboard.jsp";
               //java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
               if(status==0)
               {
                   setMsg("Login successful");
                   sessionMap.put("login","true");
                   sessionMap.put("name",name);
                   return "USER";
               }
               if(status==1)
               {
                   setMsg("Login successful");
                   sessionMap.put("login","true");
                   sessionMap.put("name",name);
                   return "ADMINUSER";
               }
                
            } else {
                setMsg("Incorrect username or password!!");
                return "ERRORLOGIN";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;  
    }

    public String logout()
    {
        if(sessionMap!=null)
        {
            sessionMap.invalidate();
        }
        return "LOGOUT";
    }
    
    public String sessionout()
    {
        HttpSession session=ServletActionContext.getRequest().getSession(false);
        if(session == null || session.getAttribute("login")==null)
        {
            return "LOGOUT1";
        }
        else
        {
            return "PASS";
        }
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

    /**
     * @return the validUser
     */
    public boolean isValidUser() {
        return validUser;
    }

    /**
     * @param validUser the validUser to set
     */
    public void setValidUser(boolean validUser) {
        this.validUser = validUser;
    }

    /**
     * @return the session
     */

    /**
     * @param session the session to set
     */
    

    
}
