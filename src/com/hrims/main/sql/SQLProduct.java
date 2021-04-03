/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrims.main.sql;

import com.hrims.main.data.Product;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Justin
 */
public class SQLProduct {

    /**
     * A static variable to get one main instance of this class
     */
    public static SQLProduct ME = new SQLProduct();
    
    /**
     * Fetches a product from the SQL database.
     * @param productID an ID for the product we want to fetch
     * @return the Product created from the SQL data.
     */
    
    public Product getProduct(int productID) {
        Product p = new Product();
        String SQL;
        SQL = "SELECT FROM product \n"
            + "WHERE productid = " + productID + ";";
        try {
            ResultSet result = SQLCaller.ME.Submit_SQL_Query(SQL);
            result.first();
            
            p.setProductID(productID);
            p.setName(result.getString(2));
            p.setMachineID(result.getInt(3));
            
            //TODO: Ingredient list
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return p;
    }
    
    /**
     * Fetches a list of products that can be modified or viewed.
     * @param low the lowest ID of the products we want to fetch
     * @param high the highest ID of the products we want to fetch
     * @return an ArrayList containing the products we were able to fetch.
     */
    public ArrayList<Product> getProductsFromIdRange(int low, int high) {
        ArrayList<Product> products = new ArrayList<Product>();
        String SQL;
        SQL = "SELECT FROM product \n"
            + "WHERE productid BETWEEN " + low + " AND " + high + ";";
        try {
            ResultSet result = SQLCaller.ME.Submit_SQL_Query(SQL);
            result.first();
            
            while(result.next()) {
                Product p = new Product();
                p.setProductID(result.getInt(1));
                p.setName(result.getString(2));
                p.setMachineID(result.getInt(3));
                products.add(p);
            }
            
            //TODO: Ingredient list
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return products;
    }
    
    /**
     * Fetches a number of products from the SQL database, skipping over deleted objects
     * @param page the page number we are currently on
     * @param max the number of items per page that we are fetching
     * @param extra check if we want one extra (used for page systems)
     * @return an ArrayList containing the products we were able to fetch. Does not guarantee ArrayList size equal to max
     */
    public ArrayList<Product> getProductsFromPageAndMax(int page, int max, boolean extra) {
        ArrayList<Product> products = new ArrayList<Product>();
        String SQL = "";
        SQL += "SELECT * ";
        SQL += "FROM account ";
        SQL += " LIMIT " + (page*max) + "," + (extra ? max+1 : max) + ";";
        
        try {
            ResultSet result = SQLCaller.ME.Submit_SQL_Query(SQL);
            result.first();
            
            while(result.next()) {
                Product p = new Product();
                p.setProductID(result.getInt(1));
                p.setName(result.getString(2));
                p.setMachineID(result.getInt(3));
                products.add(p);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return products;
    }
}
