/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrims.main.sql;

import com.hrims.main.LoginManager;
import com.hrims.main.data.Account;
import com.hrims.main.data.Contact;
import com.hrims.main.data.Ticket;
import com.hrims.main.data.TicketEntry;
import static com.hrims.main.sql.SQLCaller.ME;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Justin
 */
public class SQLTicket {
    
    public static SQLTicket ME = new SQLTicket();
    
   public Ticket getTicket(int _accountNumber) { 
        Ticket tic = new Ticket();
        tic.getEntries().clear();
        try {
            
            ArrayList<TicketEntry> ticketEntries;
            ticketEntries = SQLTicketEntry.ME.getTicketsFromTicketId(_accountNumber, _accountNumber+1);
            
            ResultSet result = SQLCaller.ME.Submit_SQL_Query("SELECT * FROM ticket WHERE ticketid = " + _accountNumber);
            result.first();
            tic.setTicketId(result.getInt(1));
            tic.setUserID(result.getInt(2));
            tic.setDescription(result.getString(3));
            tic.setResolved(result.getBoolean(4));
            
            for(TicketEntry t : ticketEntries) {
                if(t.getTicketid() == tic.getTicketId()) {
                    tic.addEntry(t);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return tic;
    }
   
    public ArrayList<Ticket> getTicketsByPageNumber(int page, int maxp, boolean oneExtra) {
        ArrayList<Ticket> tickets = new ArrayList<Ticket>();
        try {
            ArrayList<TicketEntry> ticketEntries = new ArrayList<TicketEntry>();
            
            String SQL = "";
            
            SQL += "SELECT * ";
            SQL += "FROM ticket ";
            SQL += " LIMIT " + (page*maxp) + "," + (oneExtra ? maxp+1 : maxp) + ";";
            
            ResultSet result = SQLCaller.ME.Submit_SQL_Query(SQL);
            
            int min=-1, max=-1;
            
            while(result.next()) {
                Ticket tic = new Ticket();
                tic.getEntries().clear();
                //ticketid, accountid, description)
                tic.setTicketId(result.getInt(1));
                tic.setUserID(result.getInt(2));
                tic.setDescription(result.getString(3));
                tic.setResolved(result.getBoolean(4));
                
                if(tic.getTicketId()> max || max==-1) max = tic.getTicketId();
                if(tic.getTicketId()< min || min==-1) min = tic.getTicketId();
                
                tickets.add(tic);
            }
            
            ticketEntries = SQLTicketEntry.ME.getTicketsFromTicketId(min, max);
            for(Ticket tic : tickets) {
                for(TicketEntry t : ticketEntries) {
                    if(tic.getTicketId()== t.getTicketid())
                        tic.addEntry(t);
                }
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return tickets;
    }
    
    public ArrayList<Ticket> getTickets(int low, int high) {
        ArrayList<Ticket> tickets = new ArrayList<Ticket>();
        
        try {
            ArrayList<TicketEntry> ticketEntries;
            ticketEntries = SQLTicketEntry.ME.getTicketsFromTicketId(low, high);
            
            ResultSet result = SQLCaller.ME.Submit_SQL_Query("SELECT * FROM ticket "
                                                        + "WHERE ticketid BETWEEN " + low + " AND " + high + ";");
            while(result.next()) {
                Ticket tic = new Ticket();
                tic.getEntries().clear();
                //ticketid, accountid, description)
                tic.setTicketId(result.getInt(1));
                tic.setUserID(result.getInt(2));
                tic.setDescription(result.getString(3));
                tic.setResolved(result.getBoolean(4));
                
                for(TicketEntry t : ticketEntries) {
                    if(t.getTicketid() == tic.getTicketId()) {
                        tic.addEntry(t);
                    }
                }
                
                tickets.add(tic);
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return tickets;
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
        
        int isResolved = tic.isResolved() ? 1 : 0;
        
        String statement = "INSERT INTO ticket(accountid, description, status)" 
                + "\n VALUES ('" + tic.getUserID()+ "', '" + tic.getDescription()
                + "', '" + isResolved + "');";
        
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

    public boolean AddResponse(Ticket ticket, String text) {
        TicketEntry e = new TicketEntry();
        e.setMessage(text);
        e.setTicketid(ticket.getTicketId());
        e.setEntryId(ticket.getEntries().size()+1);
        if(LoginManager.MYACCOUNT != null) {
            e.setUserId(LoginManager.MYACCOUNT.getAccountNumber());
        } else {
            e.setUserId(-1);
        }
        
        SQLTicketEntry.ME.createTicketEntry(e);
        return true;
    }
    
}
