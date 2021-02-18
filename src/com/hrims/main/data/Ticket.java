/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrims.main.data;

import java.util.HashMap;

/**
 *
 * @author Justin
 */
public class Ticket {

    public static HashMap<Integer, TicketEntry> getTickets() {
        return tickets;
    }

    public static void setTickets(HashMap<Integer, TicketEntry> tickets) {
        Ticket.tickets = tickets;
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
    
    public static HashMap<Integer, TicketEntry> tickets = new HashMap<Integer, TicketEntry>();
    int userID;
    String description;
    boolean resolved;
    
}
