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
}
