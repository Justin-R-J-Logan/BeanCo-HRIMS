/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrims.main.sql;

import com.hrims.main.data.Location;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Justin
 */
public class SQLLocation {
    public static SQLLocation ME = new SQLLocation();
    
    
    
    public ArrayList<Location> getLocations(int low, int high) {
        ArrayList<Location> locations = new ArrayList<Location>();
        
        try {
            
            ResultSet result = SQLCaller.ME.Submit_SQL_Query("SELECT * FROM location "
                                                        + "WHERE locationid BETWEEN " + low + " AND " + high + ";");
            
            while(result.next()) {
                Location loc = new Location();
                
                loc.setLocationID(result.getInt(1));
                loc.setAddress(result.getString(2));
                loc.setAddress2(result.getString(3));
                loc.setMainPhone(result.getString(4));
                loc.setEmail(result.getString(5));
                loc.setCreated(result.getDate(6));
                loc.setCompany(result.getString(7));
                
                locations.add(loc);
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return locations;
    }
    
    public boolean updateLocation(Location loc) {
        String statement = "UPDATE location " + "\n"
                + "SET "
                + "address = '" + loc.getAddress() + "', "
                + "address2 = '" + loc.getAddress2() + "', "
                + "phone = '" + loc.getMainPhone()+ "', "
                + "email = '" + loc.getEmail()+ "', "
                + "company = '" + loc.getCompany()+ "' \n"
                + "WHERE locationid = " + loc.getLocationID();
        try {
            ResultSet result = SQLCaller.ME.Submit_SQL_Query(statement);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        
        return true;
    }
    public boolean createLocation(Location loc) {
        
        String statement = "INSERT INTO location(address, address2, phone, email, company)" + 
                "\n VALUES ('" + loc.getAddress() + "', '" + loc.getAddress2() + "', '" + loc.getMainPhone() + "', '" + loc.getEmail() + "', '" + loc.getCompany() + "');";
        try {
            ResultSet result = SQLCaller.ME.Submit_SQL_Query(statement);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return true;
    }
    
    
    public ArrayList<Location> getLocationsByPage(int pageNumber, int maxPer, boolean oneExtra) {
        ArrayList<Location> locations = new ArrayList<Location>();
        
        try {
            //ArrayList<Contact> contacts;
            //contacts = SQLContact.ME.getContactsFromLocationID(low, high);
            
            String SQL = "";
            
            SQL += "SELECT * ";
            SQL += "FROM location ";
            SQL += " LIMIT " + (pageNumber*maxPer) + "," + (oneExtra ? maxPer+1 : maxPer) + ";";
            
            ResultSet result = SQLCaller.ME.Submit_SQL_Query(SQL);
            
            while(result.next()) {
                Location loc = new Location();
                
                loc.setLocationID(result.getInt(1));
                loc.setAddress(result.getString(2));
                loc.setAddress2(result.getString(3));
                loc.setMainPhone(result.getString(4));
                loc.setEmail(result.getString(5));
                loc.setCreated(result.getDate(6));
                loc.setCompany(result.getString(7));
                
                locations.add(loc);
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return locations;
    }

    public boolean deleteLocation(Location loc) {
        String statement = ("DELETE FROM location WHERE \n" + 
                    "locationid = " + loc.getLocationID() + ";");
        
        try{
            SQLCaller.ME.Submit_SQL_Query(statement);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        
        return true;
    }
}
