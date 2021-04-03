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
    
    private int productID;
    private String name;
    private int machineID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMachineID() {
        return machineID;
    }

    public void setMachineID(int machineID) {
        this.machineID = machineID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }
    private ArrayList<Ingredient> ingredientsList;
    private Machine productionMachine;
    
    /**
     * A standard constructor to create an object with known data.
     * @param ingredientsList ArrayList of ingredients used in production.
     * @param productionMachine Machine used in production.
     */
    public Product(int productID, ArrayList<Ingredient> ingredientsList, Machine productionMachine) {
        this.productID = productID;
        this.ingredientsList = ingredientsList;
        this.productionMachine = productionMachine;
    }
    
    /**
     * An empty constructor to all information to default values.
     */
    public Product() {
        ingredientsList = new ArrayList();
        //productionMachine = new Machine();
        //productionLocation = new Location();
        
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
