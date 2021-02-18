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
    
public static HashMap<Integer, TicketEntry> tickets = new HashMap<Integer, TicketEntry>();
int userID;
String description;
boolean resolved;
    
}
