/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Matthew
 */

package com.hrims.main.data;

import com.hrims.main.sql.SQLMachine;
import com.hrims.main.sql.SQLContact;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.Map;

public class Machine implements DataGrabber<Machine>
{

    public Machine() 
    {
        _machineID = -1;
    }

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
    
    @Override
    public Map<String, Object> getResources() 
    {
        Map<String, Object> resources = new LinkedHashMap<String, Object>();
        
        //resources.put("Machine ID", this._machineID);
        resources.put("Location ID", this._locationID);
        resources.put("Name", this._machineName);
        resources.put("Purchase Date", this._purchaseDate);
        resources.put("Last Use", this._lastUse);
        resources.put("Created", this._created);
        resources.put("In Use", this._inUse);
        
        return resources;
    }

    @Override
    public boolean SetResources(Map<String, Object> resources) 
    {
        try 
        {
            //if(resources.containsKey("Machine ID")) this.setMachineID(Integer.parseInt(resources.remove("Machine ID").toString()));
            if(resources.containsKey("Location ID")) this.setLocationID(Integer.parseInt(resources.remove("Location ID").toString()));
            if(resources.containsKey("Name")) this.setMachineName(resources.remove("Name").toString());
            if(resources.containsKey("Purchase Date")) 
            {
                Object o = resources.remove("Purchase Date");
                if(o instanceof java.sql.Date) 
                {
                    this.setPurchaseDate((java.sql.Date)o);
                } 
                else 
                {
                    String date = (String)o;
                    java.util.Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(date);
                    this.setPurchaseDate(new java.sql.Date(date1.getTime()));
                }
            }
            if(resources.containsKey("Last Use")) 
            {
                Object o = resources.remove("Last Use");
                if(o instanceof java.sql.Date) 
                {
                    this.setLastUse((java.sql.Date)o);
                } 
                else 
                {
                    String date = (String)o;
                    java.util.Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(date);
                    this.setLastUse(new java.sql.Date(date1.getTime()));
                }
            }
            if(resources.containsKey("Created")) 
            {
                Object o = resources.remove("Created");
                if(o instanceof java.sql.Date) 
                {
                    this.setCreated((java.sql.Date)o);
                }
                else 
                {
                    String date = (String)o;
                    java.util.Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(date);
                    this.setCreated(new java.sql.Date(date1.getTime()));
                }
            }
            if(resources.containsKey("In Use")) this.setInUse(Boolean.parseBoolean(""+resources.remove("In Use")));
        } 
        catch (Exception ex) 
        {
            ex.printStackTrace();
            return false;
        }
        //Make sure we check later for valid data or some shit.
        return true;
    }

    @Override
    public boolean Save() 
    {
        if (_machineID == -1)
        {
            SQLMachine.ME.createMachine(this);
        }
        else
        {
            SQLMachine.ME.updateMachine(this);
        }
        return true;
    }
}
