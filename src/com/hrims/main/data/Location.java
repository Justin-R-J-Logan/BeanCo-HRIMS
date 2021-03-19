/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrims.main.data;

import com.hrims.main.sql.SQLLocation;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author Matthew
 */
public class Location implements DataGrabber
{
    public int getLocationID() 
    {
        return _locationID;
    }

    public void setLocationID(int _locationID) 
    {
        this._locationID = _locationID;
    }
    
    public String getAddress() 
    {
        return _address;
    }

    public void setAddress(String _address) 
    {
        this._address = _address;
    }
    
    public String getMainPhone() 
    {
        return _mainPhone;
    }

    public void setMainPhone(String _mainPhone) 
    {
        this._mainPhone = _mainPhone;
    }
    
    public String getEmail() 
    {
        return _email;
    }

    public void setEmail(String _email) 
    {
        this._email = _email;
    }
    
    public String getCompany() 
    {
        return _company;
    }

    public void setCompany(String _company) 
    {
        this._company = _company;
    }

    public Date getCreated() 
    {
        return _created;
    }

    public void setCreated(Date _created) 
    {
        this._created = _created;
    }

    public String getAddress2() {
        return _address2;
    }

    public void setAddress2(String _address2) {
        this._address2 = _address2;
    }
    
    private int _locationID;
    private String _address;
    private String _address2;
    private String _mainPhone;
    private String _email;
    private String _company;
    private java.sql.Date _created;

    public Map<String, Object> getResources() {
        Map<String, Object> resources = new LinkedHashMap<String, Object>();
        
        resources.put("Location ID", this._locationID);
        resources.put("Address", this._address);
        resources.put("Address 2", this._address2);
        resources.put("Main Phone", this._mainPhone);
        resources.put("Email", this._email);
        resources.put("Company", this._company);
        resources.put("Created", this._created);
        
        
        return resources;
    }

    @Override
    public boolean SetResources(Map<String, Object> resources) {
        try {
            if(resources.containsKey("Location ID")) this.setLocationID(Integer.parseInt(resources.remove("Location ID").toString()));
            if(resources.containsKey("Address")) this.setAddress(resources.remove("Address").toString());
            if(resources.containsKey("Address2")) this.setAddress2(resources.remove("Address2").toString());
            if(resources.containsKey("Main Phone")) this.setMainPhone(resources.remove("Main Phone").toString());
            if(resources.containsKey("Company")) this.setCompany(resources.remove("Company").toString());
            if(resources.containsKey("Email")) this.setEmail(resources.remove("Email").toString());
            if(resources.containsKey("Created")) {
                Object o = resources.remove("Created");
                if(o instanceof java.sql.Date) {
                    this.setCreated((java.sql.Date)o);
                } else {
                    String date = (String)o;
                    java.util.Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(date);
                    this.setCreated(new java.sql.Date(date1.getTime()));
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
        SQLLocation.ME.updateLocation(this);
        return true;
    }
}
