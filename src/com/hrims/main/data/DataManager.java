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
public class DataManager {
    public static HashMap<Integer, Account> _accounts = new HashMap<Integer, Account>();
    public static HashMap<Integer, Product> _products = new HashMap<Integer, Product>();
    public static HashMap<Integer, Location> _locations = new HashMap<Integer, Location>();
    public static HashMap<Integer, Machine> _machines = new HashMap<Integer, Machine>();
    public static HashMap<Integer, Ticket> _tickets = new HashMap<Integer, Ticket>();
}
