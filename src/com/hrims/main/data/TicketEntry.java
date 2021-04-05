/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrims.main.data;

import java.util.Date;

/**
 *
 * @author Justin
 */
public class TicketEntry {

    int ticketid;
    int accountid;
    int entryid;
    String message;
    java.util.Date date;
    String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    public TicketEntry() {
        
    }

    public int getAccountid() {
        return accountid;
    }

    public void setAccountid(int userId) {
        this.accountid = userId;
    }

    public int getEntryId() {
        return entryid;
    }

    public void setEntryId(int entryId) {
        this.entryid = entryId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getTicketid() {
        return ticketid;
    }

    public void setTicketid(int ticketid) {
        this.ticketid = ticketid;
    }
}
