/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrims.main.data;

import java.util.ArrayList;

/**
 * An object to hold the information pertaining to individual ingredients for
 * use in production.
 * @author Alexandra
 */
public class Ingredient {
    private int ingredientId;
    private String name;
    private String allergens;
    private ArrayList<Integer> products;
    
    /**
     * Constructs an ingredient with information about the ingredient.
     * 
     * @param ingredientId unique identifier for an ingredient to compare against the database.
     * @param name the common name of the ingredient. I.E. Soybean
     * @param allergens any allergens the ingredient may contain. I.E. Gluten, Dairy, Nuts.
     */
    public Ingredient(int ingredientId, String name, String allergens) {
        this.ingredientId = ingredientId;
        this.name = name;
        this.allergens = allergens;
    }
    
    /**
     * Constructs an empty ingredient.
     */
    public Ingredient() {
        ingredientId = 0;
        name = "Null";
        allergens = "N/A";
    }
    
    /**
     * @return the ingredients identifier.
     */
    public int getIngredientId() {
        return ingredientId;
    }
    
    /**
     * Sets the value of the identifier, overwriting the previous value.
     * @param ingredientId to set the identifier to.
     */
    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    /**
     * @return the name of the ingredient as a string.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the ingredient, overwriting the previous name.
     * @param name to set the ingredient to.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the string of different allergens the ingredient contains.
     */
    public String getAllergens() {
        return allergens;
    }
    /**
     * Sets the string of allergens, overwriting the previous string.
     * @param allergens to set the string to.
     */
    public void setAllergens(String allergens) {
        this.allergens = allergens;
    }
    
}
