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
public class Machine 
{

    public int getMachineID() 
    {
        return _machineID;
    }

    public void setMachineID(int _machineID) 
    {
        this._machineID = _machineID;
    }

    public int getLocationID()
    {
        return _locationID;
    }

    public void setLocationID(int _locationID) 
    {
        this._locationID = _locationID;
    }

    public int getAccessRights() 
    {
        return _accessRights;
    }

    public void setAccessRights(int _accessRights) 
    {
        this._accessRights = _accessRights;
    }

    public String getMachineName() 
    {
        return _machineName;
    }

    public void setMachineName(String _machineName) 
    {
        this._machineName = _machineName;
    }

    public String getUsername() 
    {
        return _username;
    }

    public void setUsername(String _username) 
    {
        this._username = _username;
    }

    public String getPassword() 
    {
        return _password;
    }

    public void setPassword(String _password) 
    {
        this._password = _password;
    }

    public Date getPurchaseDate() 
    {
        return _purchaseDate;
    }

    public void setPurchaseDate(Date _purchaseDate) 
    {
        this._purchaseDate = _purchaseDate;
    }

    public Date getLastUse() 
    {
        return _lastUse;
    }

    public void setLastUse(Date _lastUse) 
    {
        this._lastUse = _lastUse;
    }

    public boolean isInUse() 
    {
        return _inUse;
    }

    public void setInUse(boolean _inUse) 
    {
        this._inUse = _inUse;
    }
    
    public Date getCreated() 
    {
        return _created;
    }

    public void setCreated(Date _created) 
    {
        this._created = _created;
    }

    public Date getLastLogin() 
    {
        return _lastLogin;
    }

    public void setLastLogin(Date _lastLogin) 
    {
        this._lastLogin = _lastLogin;
    }
    
    private int _machineID;
    private int _locationID;
    private int _accessRights;
    private String _machineName;
    private String _username;
    private String _password;
    private java.sql.Date _purchaseDate;
    private java.sql.Date _lastUse;
    private java.sql.Date _created;
    private java.sql.Date _lastLogin;
    private boolean _inUse;
}
