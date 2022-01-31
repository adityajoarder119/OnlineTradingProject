/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trading.ot.actions;

import com.opensymphony.xwork2.ActionSupport;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.trading.ot.beans.Stocks;
import com.trading.ot.dao.Admin;


/**
 *
 * @author adity
 */
public class StockAction extends ActionSupport{

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
     * @return the stockId
     */
    public int getStockId() {
        return stockId;
    }

    /**
     * @param stockId the stockId to set
     */
    public void setStockId(int stockId) {
        this.stockId = stockId;
    }

    /**
     * @return the stockName
     */
    public String getStockName() {
        return stockName;
    }

    /**
     * @param stockName the stockName to set
     */
    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the availability
     */
    public int getAvailability() {
        return availability;
    }

    /**
     * @param availability the availability to set
     */
    public void setAvailability(int availability) {
        this.availability = availability;
    }
      private ResultSet rs = null;
     private int stockId;
     private String stockName;
     private double price;
     private int availability;
    private Stocks product = null;
    private List<Stocks> stockList = null;
    private Admin admin = new Admin();
    private boolean noData = false;
    private String msg = "";
    private int ctr = 0;
    private String csvFilePath;
    private int quantity;
    private int addtocart;

    public String StockReportAction()  {
      
        try {
            setStockList(new ArrayList<>());
            setStockList(getAdmin().reportStock());
            

            if (!stockList.isEmpty() ) {
                setNoData(false);
                System.out.println("Stocks retrieve = "+getStockList().size());
                System.out.println("setting nodata=false");
            } else {
                setNoData(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "REPORTSTOCK";
    }
    
    
    public String StockUpdateAction()  {
      
        try {
            setStockList(new ArrayList<>());
            setStockList(getAdmin().reportStock());
            

            if (!stockList.isEmpty() ) {
                setNoData(false);
                System.out.println("Stocks retrieve = "+getStockList().size());
                System.out.println("setting nodata=false");
            } else {
                setNoData(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "REPORTSTOCK";
    }
    
    public String StockAddToCartAction()  {
      
        try {
            setStockList(new ArrayList<>());
            setStockList(getAdmin().reportStock());
            

            if (!stockList.isEmpty() ) {
                setNoData(false);
                System.out.println("Stocks retrieve = "+getStockList().size());
                System.out.println("setting nodata=false");
            } else {
                setNoData(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "REPORTSTOCK";
    }
    
    public String updateStock()
    {
        Admin dao=new Admin();
         try {
                int i = dao.updateStockDetails(getStockId(), getStockName(), getPrice(), getAvailability());
                if (i > 0) {
                    setMsg("Stocks updated successfully");
                } else {
                    setMsg("error");
                }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "UPDATESTOCK";
    }
    
    public String addToCart()
    {
        Admin dao=new Admin();
        try{
            int i=dao.addToCart(getStockId(),getAvailability(), getQuantity(), getAddtocart());
            if (i > 0) {
                    setAddtocart(i);
                } else {
                    setMsg("error");
                }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
        return "ADDTOCART";
    }
    public String updateStockList()
    {
        Admin dao=new Admin();
         try {
                int i = dao.updateStockLists(getCsvFilePath());
                if (i > 0) {
                    setMsg("Stocks updated successfully");
                } else {
                    setMsg("error");
                }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "UPDATESTOCKLIST";
    }

    public String deleteStock()
    {
        Admin dao=new Admin();
        try {
            int isDeleted = dao.deleteStock(getStockId());
            if (isDeleted > 0) {
                setMsg("Stocks updated successfully");
            } else {
                setMsg("Some error");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "DELETESTOCK";
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
     * @return the product
     */
    public Stocks getProduct() {
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(Stocks product) {
        this.product = product;
    }

    /**
     * @return the stockList
     */
    public List<Stocks> getStockList() {
        return stockList;
    }

    /**
     * @param stockList the stockList to set
     */
    public void setStockList(List<Stocks> stockList) {
        this.stockList = stockList;
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
     * @return the csvFilePath
     */
    public String getCsvFilePath() {
        return csvFilePath;
    }

    /**
     * @param csvFilePath the csvFilePath to set
     */
    public void setCsvFilePath(String csvFilePath) {
        this.csvFilePath = csvFilePath;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the addtocart
     */
    public int getAddtocart() {
        return addtocart;
    }

    /**
     * @param addtocart the addtocart to set
     */
    public void setAddtocart(int addtocart) {
        this.addtocart = addtocart;
    }
    
}
