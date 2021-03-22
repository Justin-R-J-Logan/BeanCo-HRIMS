/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrims.main.sql;

import com.hrims.main.data.Account;
import com.hrims.main.data.Contact;
import static com.hrims.main.sql.SQLCaller.ME;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

/**
 *
 * @author Justin
 */
public class SQLAccount {
    
    public static SQLAccount ME = new SQLAccount();
    
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
    
    public ArrayList<Account> getAccountsByIDRange(int low, int high) {
        ArrayList<Account> accounts = new ArrayList<Account>();
        
        try {
            ArrayList<Contact> contacts;
            contacts = SQLContact.ME.getContactsFromAccountID(low, high);
            
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
                
                for(Contact c : contacts) {
                    if(c.getAccountID() == acc.getAccountNumber()) {
                        acc.addContact(c);
                    }
                }
                
                accounts.add(acc);
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return accounts;
    }
    
    
    public boolean updateAccount(Account acc) {
        String statement = "UPDATE account " + "\n"
                + "SET "
                + "username = '" + acc.getUsername() + "', "
                + "password = '" + acc.getPassword()+ "', "
                + "accessrights = '" + acc.getAccessRights()+ "', "
                + "discount = '" + acc.getDiscount()+ "'\n"
                + "WHERE accountid = " + acc.getAccountNumber();
        
        try {
            ResultSet result = SQLCaller.ME.Submit_SQL_Query(statement);
            ResultSetMetaData rsmd = result.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (result.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                if (i > 1) System.out.print(",  ");
                String columnValue = result.getString(i);
                System.out.print(columnValue + " " + rsmd.getColumnName(i));
            }
            System.out.println("");
        }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        //TODO: Check if account actually created or not, don't just return true and assume;
        return true;
    }
    public boolean createAccount(Account acc) {
        
        String statement = "INSERT INTO account(username, password, accessrights, discount)" + 
                "\n VALUES ('" + acc.getUsername() + "', '" + acc.getPassword() + "', '" + acc.getAccessRights() + "', '" + acc.getDiscount() + "');";
        
        try {
            ResultSet result = SQLCaller.ME.Submit_SQL_Query(statement);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        
        //TODO: Check if account actually updated or not, don't just return true and assume;
        return true;
    }

    public ArrayList<Account> getAccountsByPage(int pageNumber, int maxPer, boolean oneExtra) {
        ArrayList<Account> accounts = new ArrayList<Account>();
        
        try {
            //ArrayList<Contact> contacts;
            //contacts = SQLContact.ME.getContactsFromAccountID(low, high);
            
            String SQL = "";
            
            SQL += "SELECT * ";
            SQL += "FROM account ";
            SQL += " LIMIT " + (pageNumber*maxPer) + "," + (oneExtra ? maxPer+1 : maxPer) + ";";
            
            //System.out.println(SQL);
            
            
            ResultSet result = SQLCaller.ME.Submit_SQL_Query(SQL);
            
            int min=0, max=0;
            
            while(result.next()) {
                Account acc = new Account();
                
                acc.setAccountNumber(result.getInt(1));
                acc.setUsername(result.getString(2));
                acc.setPassword(result.getString(3));
                acc.setCreated(result.getDate(4));
                acc.setLastLogin(result.getDate(5));
                acc.setAccessRights(result.getInt(6));
                acc.setDiscount(result.getInt(7));
                
                if(acc.getAccountNumber() > max) max = acc.getAccountNumber();
                if(acc.getAccountNumber() < min) min = acc.getAccess();
                
                accounts.add(acc);
            }
            ArrayList<Contact> contacts = SQLContact.ME.getContactsFromAccountID(min, max);
            for(Account acc : accounts) {
                for(Contact c : contacts) {
                    if(c.getAccountID() == acc.getAccountNumber())
                        acc.addContact(c);
                }
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return accounts;
    }

    public boolean deleteAccount(Account acc) {
        String statement = ("DELETE FROM account WHERE \n" + 
                    "accountid = " + acc.getAccountNumber()+ ";");
        
        try{
            SQLCaller.ME.Submit_SQL_Query(statement);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        
        return true;
    }
}
