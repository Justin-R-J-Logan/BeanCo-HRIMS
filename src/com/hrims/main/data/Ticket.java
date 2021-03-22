/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrims.main.data;

import com.hrims.main.sql.SQLTicket;
import com.hrims.main.sql.SQLTicketEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author Justin
 */
public class Ticket implements DataGrabber<Ticket> {

    public Ticket() {
        TicketId = -1;
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
    
    public TicketEntry[] getEntries() {
        return (TicketEntry[])tickets.toArray();
    }

    @Override
    public Map<String, Object> getResources() {
        Map<String, Object> resources = new LinkedHashMap<String, Object>();
        
        resources.put("userID", this.userID);
        resources.put("description", this.description);
        resources.put("resolved", this.resolved);
       
        
        //userid,message
        int i = 0;
        for(TicketEntry c : tickets) {
            resources.put("Entry " + i + " userid", "" + c.getUserId());
            resources.put("Entry " + i + " message", "" + c.getMessage());
            i++;
        }
        
        return resources;
    }

    @Override
    public boolean SetResources(Map<String, Object> resources) {
        try {
            if(resources.containsKey("userID")) this.setUserID(Integer.parseInt(resources.remove("userID").toString()));
            if(resources.containsKey("description")) this.setDescription(resources.remove("description").toString());
            if(resources.containsKey("resolved")) this.setResolved((""+resources.remove("resolved")));
           
            
            //contacts.clear();
            for(int i = 0; i < (resources.size()/3); i++) {
                if(tickets.get(i)!=null) {
                    TicketEntry c = tickets.get(i);
                    if(resources.containsKey("Entry " + i + " userid")) {
                        c.setUserId(Integer.parseInt(resources.get("Entry " + i + " userid").toString()));
                    }
                    if(resources.containsKey("Entry " + i + " message")) {
                        c.setMessage(resources.get("Entry " + i + " message").toString());
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        //Make sure we check later for valid data or some shit.
        return true;
    }

    @Override
    public boolean Save() {
        if(this.TicketId <= -1) {
            SQLTicket.ME.createTicket(this);
        } else {
            try {
                SQLTicket.ME.updateTicket(this);
                for(TicketEntry c : tickets) {
                    SQLTicketEntry.ME.updateTicketEntry(c);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                return false;
            }
        }
        return true;
    }
    
}
