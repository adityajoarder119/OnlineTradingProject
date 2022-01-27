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
      private ResultSet rs = null;
    private Stocks product = null;
    private List<Stocks> stockList = null;
    private Admin admin = new Admin();
    private boolean noData = false;

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
    
}
