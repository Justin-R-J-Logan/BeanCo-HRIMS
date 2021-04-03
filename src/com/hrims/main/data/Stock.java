/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrims.main.data;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Justin
 */
public class Stock {
    
    private int StockID;

    
    public Stock() {
        
    }
    public Stock(int StockID, Product product, int price, Location location, Date dateOfProduction, Date dateOfExpiry) {
        this.StockID = StockID;
        this.product = product;
        this.price = price;
        this.location = location;
        this.dateOfProduction = dateOfProduction;
        this.dateOfExpiry = dateOfExpiry;
    }
    
    private Product product;
    private int price;
    private Location location;
    private Date dateOfProduction;
    private Date dateOfExpiry;
    
    /*
        this.productionLocation = productionLocation;
        this.dateOfProduction = dateOfProduction;
        this.dateOfExpiry = dateOfExpiry;
    */
    
    
    /**
     * @return the location the product was manufactured at.
     */
    
    public Location getProductionLocation() {
        return location;
    }
    
    /**
     * Sets the location of production to a new location, overwriting the previous location.
     * @param productionLocation to set the Location to.
     */
    public void setProductionLocation(Location productionLocation) {
        this.location = productionLocation;
    }
    
    /**
     * @return the date the product was manufactured.
     */
    public Date getDateOfProduction() {
        return dateOfProduction;
    }
    
    /**
     * Sets the Date of Production to a new date, overwriting the previous date.
     * @param dateOfProduction to set the date to.
     */
    public void setDateOfProduction(Date dateOfProduction) {
        this.dateOfProduction = dateOfProduction;
    }

    /**
     * @return the date the product will expire.
     */
    public Date getDateOfExpiry() {
        return dateOfExpiry;
    }
    
    /**
     * Sets the date of expiry to a new date, overwriting the previous date.
     * @param dateOfExpiry to set the date to.
     */
    public void setDateOfExpiry(Date dateOfExpiry) {
        this.dateOfExpiry = dateOfExpiry;
    }
    
    /**
     * Checks the validity of the product by comparing the production and expiry dates.
     * @return true if the product is valid, or false if the product is invalid or expired.
     */
    public boolean checkValidity(){
        boolean valid = false;
        if (dateOfProduction.before(dateOfExpiry) && dateOfExpiry.after(Calendar.getInstance().getTime())){ valid = true; }
        return valid;
    }
}
