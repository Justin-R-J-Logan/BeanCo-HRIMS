/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrims.main.data;

import java.sql.Date;

/**
 *
 * @author Matthew
 */
public class Location 
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

    public Location(int _locationID, String _address, String _mainPhone, String _email, String _company, Date _created, Date _lastLogin) {
        this._locationID = _locationID;
        this._address = _address;
        this._mainPhone = _mainPhone;
        this._email = _email;
        this._company = _company;
        this._created = _created;
        this._lastLogin = _lastLogin;
    }

    public Date getLastLogin() 
    {
        return _lastLogin;
    }

    public void setLastLogin(Date _lastLogin) 
    {
        this._lastLogin = _lastLogin;
    }
    
    private int _locationID;
    private String _address;
    private String _mainPhone;
    private String _email;
    private String _company;
    private java.sql.Date _created;
    private java.sql.Date _lastLogin;
}
