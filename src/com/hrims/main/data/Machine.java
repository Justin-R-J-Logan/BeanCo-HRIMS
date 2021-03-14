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

    public Machine(int _machineID, int _locationID, String _machineName, Date _purchaseDate, Date _lastUse, Date _created, boolean _inUse) {
        this._machineID = _machineID;
        this._locationID = _locationID;
        this._machineName = _machineName;
        this._purchaseDate = _purchaseDate;
        this._lastUse = _lastUse;
        this._created = _created;
        this._inUse = _inUse;
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

    public String getMachineName() 
    {
        return _machineName;
    }

    public void setMachineName(String _machineName) 
    {
        this._machineName = _machineName;
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
    
    private int _machineID;
    private int _locationID;
    private String _machineName;
    private java.sql.Date _purchaseDate;
    private java.sql.Date _lastUse;
    private java.sql.Date _created;
    private boolean _inUse;
}
