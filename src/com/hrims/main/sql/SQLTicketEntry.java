/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrims.main.sql;

import com.hrims.main.data.Contact;
import com.hrims.main.data.TicketEntry;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Justin
 */
public class SQLTicketEntry {

    public static SQLTicketEntry ME = new SQLTicketEntry();
    
    public ArrayList<TicketEntry> getTicketsFromTicketId(int lowAccID, int highAccID) {
        
            ArrayList<TicketEntry> ticketEntries = new ArrayList<TicketEntry>();
            try {
                ResultSet ticketEntryresults = SQLCaller.ME.Submit_SQL_Query("SELECT * FROM contact "
                                                        + "WHERE accountid BETWEEN " + lowAccID + " AND " + highAccID + ";");
                while(ticketEntryresults.next()) {
                    
                    TicketEntry tic = new TicketEntry();
                    tic.setEntryId(ticketEntryresults.getInt(1));
                    tic.setTicketid(ticketEntryresults.getInt(2));
                    tic.setUserId(ticketEntryresults.getInt(3));
                    tic.setMessage(ticketEntryresults.getString(4));
                    
                    ticketEntries.add(tic);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        return ticketEntries;
    }
    
    /* int ticketid;
    int userid;
    int entryid;
    String message;*/
    public boolean updateTicketEntry(TicketEntry tic) {
        String statement = "UPDATE ticketentry " + "\n"
                + "SET "
                + "ticketid = '" + tic.getTicketid()+ "', "
                + "userid = '" + tic.getUserId()+ "', "
                + "entryid = '" + tic.getEntryId()+ "', "
                + "message = '" + tic.getMessage()+ "'\n"
                + "WHERE entryid = " + tic.getEntryId();
        
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
    public boolean createTicketEntry(TicketEntry tic) {
        
        String statement = "INSERT INTO ticketentry(ticketid, userid, entryid, message)" 
                + "\n VALUES ('" + tic.getTicketid()+ "', '" + tic.getUserId()
                + "', '" + tic.getEntryId() + tic.getMessage() + "');";
        
        try {
            ResultSet result = SQLCaller.ME.Submit_SQL_Query(statement);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        
        //TODO: Check if account actually updated or not, don't just return true and assume;
        return true;
    }

    public boolean deleteTicketEntry(TicketEntry tic) {
        String statement = ("DELETE FROM ticketentry WHERE \n" + 
                    "entryid = " + tic.getEntryId()+ ";");
        
        try{
            SQLCaller.ME.Submit_SQL_Query(statement);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        
        return true;
    }
}
