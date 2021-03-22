/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrims.main.sql;

import com.hrims.main.data.Account;
import com.hrims.main.data.Contact;
import com.hrims.main.data.Ticket;
import com.hrims.main.data.TicketEntry;
import static com.hrims.main.sql.SQLCaller.ME;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

/**
 *
 * @author Justin
 */
public class SQLTicket {
    
    public static SQLTicket ME = new SQLTicket();
    
   /* public Ticket getTicket(int _accountNumber) { 
        Ticket acc = new Ticket();
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
    }*/
    
    public ArrayList<Ticket> getTickets(int low, int high) {
        ArrayList<Ticket> accounts = new ArrayList<Ticket>();
        
        try {
            ArrayList<TicketEntry> ticketEntries;
            ticketEntries = SQLTicketEntry.ME.getTicketsFromTicketId(low, high);
            
            ResultSet result = SQLCaller.ME.Submit_SQL_Query("SELECT * FROM ticket "
                                                        + "WHERE ticketid BETWEEN " + low + " AND " + high + ";");
            
            while(result.next()) {
                Ticket acc = new Ticket();
                //ticketid, accountid, description)
                acc.setTicketId(result.getInt(1));
                acc.setUserID(result.getInt(2));
                acc.setDescription(result.getString(3));
                acc.setResolved(result.getBoolean(4));
               
                for(TicketEntry c : ticketEntries) {
                    if(c.getTicketid() == acc.getTicketId()) {
                        acc.addEntry(c);
                    }
                }
                
                accounts.add(acc);
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return accounts;
    }
    /*int userID;
    String description;
    boolean resolved;
    int TicketId;*/
     public boolean updateTicket(Ticket tic) {
        String statement = "UPDATE ticket " + "\n"
                + "SET "
                + "accountid = '" + tic.getUserID() + "', "
                + "description = '" + tic.getDescription()+ "', "
                + "resolved = '" + tic.isResolved()+ "', "
                + "ticketid = '" + tic.getTicketId()+ "'\n"
                + "WHERE ticketid = " + tic.getTicketId();
        
        try {
            ResultSet result = SQLCaller.ME.Submit_SQL_Query(statement);
           /* ResultSetMetaData rsmd = result.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (result.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                if (i > 1) System.out.print(",  ");
                String columnValue = result.getString(i);
                System.out.print(columnValue + " " + rsmd.getColumnName(i));
            }
            System.out.println("");
        }*/
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        //TODO: Check if account actually created or not, don't just return true and assume;
        return true;
    }
    public boolean createTicket(Ticket tic) {
        
        String statement = "INSERT INTO ticket(accountid, description, resolved)" 
                + "\n VALUES ('" + tic.getUserID()+ "', '" + tic.getDescription()
                + "', '" + tic.isResolved() + "');";
        
        try {
            ResultSet result = SQLCaller.ME.Submit_SQL_Query(statement);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        
        //TODO: Check if account actually updated or not, don't just return true and assume;
        return true;
    }

    public boolean deleteTicket(Ticket tic) {
        String statement = ("DELETE FROM ticket WHERE \n" + 
                    "ticketid = " + tic.getTicketId()+ ";");
        
        try{
            SQLCaller.ME.Submit_SQL_Query(statement);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        
        return true;
    }
}
