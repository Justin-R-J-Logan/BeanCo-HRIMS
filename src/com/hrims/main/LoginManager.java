/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrims.main;

import java.util.Iterator;
import javax.swing.JOptionPane;

/**
 *
 * @author Justin
 */
public class LoginManager {

    /**
     *
     */
    public static String Username;

    /**
     *
     */
    public static enum Login_Status { 

        /**
         *
         */
        IN, 

        /**
         *
         */
        OUT, 

        /**
         *
         */
        ATTEMPT };

    /**
     *
     */
    public static Login_Status status = Login_Status.OUT;
    
    /**
     *
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
        if(UserPasswordVerification(username, password)) {
            GUIManager.Login();
            status = Login_Status.IN;
        } else {
            String infoMessage = "Failed to log in. Username or Password Incorrect";
            String titleBar = "Login Error";
            JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    /**
     *
     * @param user
     * @param pass
     * @return
     */
    public static boolean UserPasswordVerification(String user, String pass) {
        if(user.equalsIgnoreCase("username") || pass.equalsIgnoreCase("password")) return false;
        if(user.equalsIgnoreCase("") || pass.equalsIgnoreCase("")) return false;
        if(user.equalsIgnoreCase(" ") || pass.equalsIgnoreCase(" ")) return false;
        return true;
        //TODO: SQL JANK DOWN HERE
    }
}
