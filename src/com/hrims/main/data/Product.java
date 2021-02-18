/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrims.main.data;

import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * An object to hold the information pertaining to individual products.
 * @author Alexandra
 */
public class Product {
    private ArrayList<Ingredient> ingredientsList;
    private Machine productionMachine;
    private Location productionLocation;
    private Date dateOfProduction;
    private Date dateOfExpiry;
    
    /**
     * A standard constructor to create an object with known data.
     * @param ingredientsList ArrayList of ingredients used in production.
     * @param productionMachine Machine used in production.
     * @param productionLocation Location of Production.
     * @param dateOfProduction Date the product was manufactured.
     * @param dateOfExpiry Date the product expires.
     */
    public Product(ArrayList<Ingredient> ingredientsList, Machine productionMachine, 
            Location productionLocation, Date dateOfProduction, Date dateOfExpiry) {
        this.ingredientsList = ingredientsList;
        this.productionMachine = productionMachine;
        this.productionLocation = productionLocation;
        this.dateOfProduction = dateOfProduction;
        this.dateOfExpiry = dateOfExpiry;
    }
    
    /**
     * An empty constructor to all information to default values.
     */
    public Product() {
        ingredientsList = new ArrayList();
        //productionMachine = new Machine();
        //productionLocation = new Location();
        dateOfProduction = Calendar.getInstance().getTime();
        dateOfExpiry = Calendar.getInstance().getTime();
        
    }
    
    /**
     * @return the ArrayList of ingredients used in the product.
     */
    public ArrayList<Ingredient> getIngredientsList() {
        return ingredientsList;
    }
    
    /**
     * Sets the ArrayList of ingredients to a new ArrayList, overwriting the previous one.
     * @param ingredientsList to set the ingredient list to.
     */
    public void setIngredientsList(ArrayList<Ingredient> ingredientsList) {
        this.ingredientsList = ingredientsList;
    }
    
    /**
     * @return the machine which produced the product.
     */
    public Machine getProductionMachine() {
        return productionMachine;
    }
    
    /**
     * Sets the Machine that created the product, overwriting the previous Machine.
     * @param productionMachine to set the Machine to.
     */
    public void setProductionMachine(Machine productionMachine) {
        this.productionMachine = productionMachine;
    }
    
    /**
     * @return the location the product was manufactured at.
     */
    public Location getProductionLocation() {
        return productionLocation;
    }
    
    /**
     * Sets the location of production to a new location, overwriting the previous location.
     * @param productionLocation to set the Location to.
     */
    public void setProductionLocation(Location productionLocation) {
        this.productionLocation = productionLocation;
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
        if (dateOfProduction.before(dateOfExpiry)){ valid = true; }
        return valid;
    }
    
    /**
     * Adds an ingredient to the ArrayList of ingredients
     * @param ingredient to be added.
     */
    public void addIngredient(Ingredient ingredient){
        ingredientsList.add(ingredient);
    }
    
    /**
     * Removes an ingredient from the ArrayList of ingredients
     * @param ingredient to be removed, if present.
     */
    public void removeIngredient(Ingredient ingredient){
        if (ingredientsList.contains(ingredient)) {
            ingredientsList.remove(ingredient);
        }
    }
    
    /**
     * Removes an ingredient from the ArrayList of ingredients by index.
     * @param index to remove the ingredient from, if valid.
     */
    public void removeIngredient(int index){
        if (ingredientsList.size() >= index && index >= 0){
            ingredientsList.remove(index);
        }
    }
}
