/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrims.main.data;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Justin
 */
public class Ticket {

    public Ticket() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isResolved() {
        return resolved;
    }

    public void setResolved(boolean resolved) {
        this.resolved = resolved;
    }

    public Ticket(int userID, String description, boolean resolved) {
        this.userID = userID;
        this.description = description;
        this.resolved = resolved;
    }
    
    public static ArrayList<TicketEntry> tickets = new ArrayList<TicketEntry>();
    int userID;
    String description;
    boolean resolved;
    int TicketId;

    public int getTicketId() {
        return TicketId;
    }

    public void setTicketId(int TicketId) {
        this.TicketId = TicketId;
    }

    public void setTicketNumber(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void addEntry(TicketEntry c) {
       tickets.add(c);
    }
    
}
