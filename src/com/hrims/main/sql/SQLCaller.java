/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrims.main.sql;

import com.hrims.main.data.Account;
import java.net.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Justin
 */
public class SQLCaller {
    
    private String ip = "76.68.64.138";
    private String url = "jdbc:mariadb://76.68.64.138:3306";
    private String inturl = "jdbc:mariadb://192.168.2.193:3306";
    private String user = "beancoadmin2"; 
    private String pass = "tM7W9JMRH0pCeOql";
    private String db = "beanco";
    
    public static SQLCaller ME = new SQLCaller();
    
    public SQLCaller() {
    }
    
    public String checkIP() {
        try {
            URL whatismyip = new URL("http://checkip.amazonaws.com");
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    whatismyip.openStream()));

            String ip = in.readLine(); //you get the IP as a String
            //System.out.println(ip);
            return ip;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "";
    }
    
    public ResultSet Submit_SQL_Query(String strQuery) {
        ResultSet results = null;
        
        try {
            String turl = ME.checkIP().equalsIgnoreCase(ME.ip) ? inturl : url;
            Connection connection = DriverManager.getConnection(turl+ "/" + db + "?user=" + user + "&password=" + pass);
            Statement statement = connection.createStatement();
            results = statement.executeQuery(strQuery);
            
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return results;
    }
    
    public Account getAccount(int _accountNumber) {
        Account acc = new Account();
        try {
            ResultSet result = SQLCaller.ME.Submit_SQL_Query("SELECT * FROM account WHERE accountid=" + _accountNumber);
            result.first();
            acc.setAccountNumber(result.getInt(1));
            acc.setUsername(result.getString(2));
            acc.setPassword(result.getString(3));
            acc.setCreated(result.getDate(4));
            acc.setLastLogin(result.getDate(5));
            acc.setAccessRights(result.getInt(6));
            acc.setDiscount(result.getInt(7));
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return acc;
    }
    
    public ArrayList<Account> getAccounts(int low, int high) {
        ArrayList<Account> accounts = new ArrayList<Account>();
        
        try {
            ResultSet result = SQLCaller.ME.Submit_SQL_Query("SELECT * FROM account "
                                                        + "WHERE accountid BETWEEN " + low + " AND " + high + ";");
            while(result.next()) {
                Account acc = new Account();
                
                acc.setAccountNumber(result.getInt(1));
                acc.setUsername(result.getString(2));
                acc.setPassword(result.getString(3));
                acc.setCreated(result.getDate(4));
                acc.setLastLogin(result.getDate(5));
                acc.setAccessRights(result.getInt(6));
                acc.setDiscount(result.getInt(7));
                
                accounts.add(acc);
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return accounts;
    }
    
    public static void main(String arg[]) {
        
        ArrayList<Account> accounts = ME.getAccounts(0, 10);
        for(Account a : accounts) {
            System.out.println(a.toString());
        }
    }
}
