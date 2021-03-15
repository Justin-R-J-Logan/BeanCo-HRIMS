/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrims.main.sql;

import java.sql.ResultSet;

/**
 *
 * @author Justin
 */
public class SQLLogin {
    
    public static SQLLogin ME = new SQLLogin();
    
    public boolean Login(String username, String password) {
        boolean ret = false;
        
        try {
            System.out.print("User: " + username + " Pass: " + password + " ");
            String send = "SELECT accountid FROM account WHERE username = '" + username + "' AND password = '" + password + "'";
            
            ResultSet result = SQLCaller.ME.Submit_SQL_Query(send);
            
            System.out.println(result.first());
            ret = result.first();
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return ret;
    }
    
}
