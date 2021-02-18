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
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getEntryId() {
        return entryId;
    }

    public void setEntryId(int entryId) {
        this.entryId = entryId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    int userId;
    int entryId;
    String message;

    public TicketEntry(int userId, int entryId, String message) {
        this.userId = userId;
        this.entryId = entryId;
        this.message = message;
    }
}
