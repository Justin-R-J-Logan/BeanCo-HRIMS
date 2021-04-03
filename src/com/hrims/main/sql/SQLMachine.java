/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrims.main.sql;

import com.hrims.main.data.Machine;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Justin / Matthew
 */
public class SQLMachine
{
    public static SQLMachine ME = new SQLMachine();
    
    public ArrayList<Machine> getMachines(int low, int high) 
    {
        ArrayList<Machine> machines = new ArrayList<Machine>();
        
        try 
        {
            
            ResultSet result = SQLCaller.ME.Submit_SQL_Query("SELECT * FROM machine "
                     + "WHERE machineid BETWEEN " + low + " AND " + high + ";");
            
            while(result.next()) 
            {
                Machine mac = new Machine();
                
                mac.setMachineID(result.getInt(1));
                mac.setLocationID(result.getInt(2));
                mac.setMachineName(result.getString(3));
                mac.setPurchaseDate(result.getDate(4));
                mac.setLastUse(result.getDate(5));
                mac.setCreated(result.getDate(6));
                mac.setInUse(result.getBoolean(7));
                mac.setStatus(result.getBoolean(8));
                
                machines.add(mac);
            }
            
        } 
        
        catch (Exception ex) 
        {
            ex.printStackTrace();
        }
        
        return machines;
    }
    
    public boolean updateMachine(Machine mac) 
    {
        String statement = "UPDATE machine " + "\n"
                + "SET "
                + "locationid = '" + mac.getLocationID() + "', "
                + "name = '" + mac.getMachineName() + "', "
                + "purchasedate = '" + mac.getPurchaseDate()+ "', "
                + "lastuse = '" + mac.getLastUse()+ "', "
                + "created = '" + mac.getCreated()+ "'"
                + "status = '" + mac.isStatus()+ "' \n"
                + "WHERE machineid = " + mac.getMachineID();
        
        try 
        {
            ResultSet result = SQLCaller.ME.Submit_SQL_Query(statement);
        } 
        catch (Exception ex) 
        {
            ex.printStackTrace();
        }
        
        
        return true;
    }
    public boolean createMachine(Machine mac) 
    {
        
        String statement = "INSERT INTO machine(locationid, name, purchasedate, lastuse, created)" + 
                "\n VALUES ('" + mac.getLocationID() + "', '" + mac.getMachineName() + "', '" + mac.getPurchaseDate() + "', '" + mac.getLastUse() + "', '" + mac.getCreated() + "');";
        
        try 
        {
            ResultSet result = SQLCaller.ME.Submit_SQL_Query(statement);
        } 
        catch (Exception ex) 
        {
            ex.printStackTrace();
        }
        
        return true;
    }
    
    public boolean deleteMachine(int machineID)
    {
        String statement = ("DELETE FROM machine WHERE \n" + "machineid = '" + machineID + "';");
        try
        {
            SQLCaller.ME.Submit_SQL_Query(statement);
            return true;
        } 
        catch (Exception ex) 
        {
            ex.printStackTrace();
            return false;
        }   
    }
    
    public ArrayList<Machine> getMachinesByPage(int pageNumber, int maxPer, boolean oneExtra) {
        ArrayList<Machine> machines = new ArrayList<Machine>();
        
        try {
            //ArrayList<Contact> contacts;
            //contacts = SQLContact.ME.getContactsFromMachineID(low, high);
            
            String SQL = "";
            
            SQL += "SELECT * ";
            SQL += "FROM machine ";
            SQL += " LIMIT " + (pageNumber*maxPer) + "," + (oneExtra ? maxPer+1 : maxPer) + ";";
            
            //System.out.println(SQL);
            
            
            ResultSet result = SQLCaller.ME.Submit_SQL_Query(SQL);
            
            while(result.next()) {
                Machine mac = new Machine();
                
                mac.setMachineID(result.getInt(1));
                mac.setLocationID(result.getInt(2));
                mac.setMachineName(result.getString(3));
                mac.setPurchaseDate(result.getDate(4));
                mac.setLastUse(result.getDate(5));
                mac.setCreated(result.getDate(6));
                mac.setInUse(result.getBoolean(7));
                mac.setStatus(result.getBoolean(8));
                
                machines.add(mac);
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return machines;
    }
    
    public void fixMachine(Machine m) {
        if(m.isStatus()) {
            String SQL = "UPDATE machine \n"
                        + "SET "
                        + "status = '0' \n"
                       + "WHERE machineid = " + m.getMachineID();
            try {
                ResultSet result = SQLCaller.ME.Submit_SQL_Query(SQL);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            m.setStatus(false);
        }
    }
}
