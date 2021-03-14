/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrims.main.data;

/**
 *
 * @author Justin
 */
public class TicketEntry {

    public int getUserId() {
        return userid;
    }

    public void setUserId(int userId) {
        this.userid = userId;
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
    
    int ticketid;
    int userid;
    int entryid;
    String message;

    public TicketEntry(int ticketid, int userId, int entryid, String message) {
        this.ticketid = ticketid;
        this.userid = userId;
        this.entryid = entryid;
        this.message = message;
    }
}
