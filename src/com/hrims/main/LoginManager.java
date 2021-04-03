/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrims.main;

import com.hrims.main.data.Account;
import com.hrims.main.sql.SQLAccount;
import com.hrims.main.sql.SQLLogin;
import java.util.Iterator;
import javax.swing.JOptionPane;

/**
 *
 * @author Justin
 */
public class LoginManager {

    /**
     * Currently used username, DO NOT EDIT.
     */
    public static String Username;
    /**
     * Current account, DO NOT EDIT.
     */
    public static Account MYACCOUNT;

    /**
     * Login status enum to show if we are logged in.
     */
    public static enum Login_Status { 

        /**
         * Logged in
         */
        IN, 

        /**
         * Logged out
         */
        OUT, 

        /**
         * Attempting a log in
         */
        ATTEMPT };

    /**
     * current login status.
     */
    public static Login_Status status = Login_Status.OUT;
    
    /**
     * Log user out of the program
     */
    public static void Logout() {
        if(status == Login_Status.IN) {
            GUIManager.Logout();
        }
    }
    
    /**
     * Attempts to log the user in using the given username and password. 
     * @param username given from the login GUI
     * @param password given from the login GUI
     */
    public static void Login(String username, String password) {
        MYACCOUNT = null;
        if(SQLLogin.ME.Login(username, password)) {
            GUIManager.Login();
            status = Login_Status.IN;
            MYACCOUNT = SQLAccount.ME.getAccountByUsername(username);
            
            RightsManager.UpdateMenus();
        } else {
            String infoMessage = "Failed to log in. Username or Password Incorrect";
            String titleBar = "Login Error";
            JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    /**
     * Attempts to verify username and password. Deprecated, please do not use.
     * @param user username given to us
     * @param pass password given to us
     * @return true if correct data, false otherwise.
     */
    @Deprecated
    public static boolean UserPasswordVerification(String user, String pass) {
        if(user.equalsIgnoreCase("username") || pass.equalsIgnoreCase("password")) return false;
        if(user.equalsIgnoreCase("") || pass.equalsIgnoreCase("")) return false;
        if(user.equalsIgnoreCase(" ") || pass.equalsIgnoreCase(" ")) return false;
        return true;
        //TODO: SQL JANK DOWN HERE
    }
}
