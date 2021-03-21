/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrims.main.data;

import com.hrims.main.sql.SQLSchedule;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author Justin
 */
public class ScheduleDay implements DataGrabber {
    
    public int getAccountid() {
        return _accountid;
    }

    public void setAccountid(int _accountid) {
        this._accountid = _accountid;
    }

    public Date getDate() {
        return _date;
    }

    public void setDate(Date _date) {
        this._date = _date;
    }

    public Time getStart() {
        return _start;
    }

    public void setStart(Time _start) {
        this._start = _start;
    }

    public Time getEnd() {
        return _end;
    }

    public void setEnd(Time _end) {
        this._end = _end;
    }

    public int getTotalBreakTime() {
        return _totalBreakTime;
    }

    public void setTotalBreakTime(int _totalBreakTime) {
        this._totalBreakTime = _totalBreakTime;
    }

    @Override
    public String toString() {
        return "ScheduleDay{" + "_accountid=" + _accountid + ", _date=" + _date + ", _start=" + _start + ", _end=" + _end + ", _totalBreakTime=" + _totalBreakTime + '}';
    }
    
    private int _accountid;
    private java.sql.Date _date;
    private java.sql.Time _start;
    private java.sql.Time _end;
    private int _totalBreakTime;

    @Override
    public Map<String, Object> getResources() {
        Map<String, Object> resources = new LinkedHashMap<String, Object>();
        
        resources.put("Date", this._date);
        resources.put("Account ID", this._accountid);
        resources.put("Start Time", this._start);
        resources.put("End Time", this._end);
        resources.put("Total Break Time", this._totalBreakTime);
        
        return resources;
    }

    @Override
    public boolean SetResources(Map<String, Object> resources) {
        try {
            if(resources.containsKey("Date")) {
                Object o = resources.remove("Date");
                if(o instanceof java.sql.Date) {
                    this.setDate((java.sql.Date)o);
                } else {
                    String date = (String)o;
                    java.util.Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(date);
                    this.setDate(new java.sql.Date(date1.getTime()));
                }
            }
            
            if(resources.containsKey("Account ID")) this.setAccountid(Integer.parseInt(resources.remove("Accound ID").toString()));
            
            if(resources.containsKey("Start Time")) {
                Object o = resources.remove("Start Time");
                if(o instanceof java.sql.Time) {
                    this.setStart((java.sql.Time)o);
                } else {
                    String Time = (String)o;
                    java.util.Date date1 = new SimpleDateFormat("kk:mm:ss").parse(Time);
                    this.setStart(new java.sql.Time(date1.getTime()));
                }
            }
            if(resources.containsKey("End Time")){
                Object o = resources.remove("End Time");
                if(o instanceof java.sql.Time) {
                    this.setEnd((java.sql.Time)o);
                } else {
                    String Time = (String)o;
                    java.util.Date date1 = new SimpleDateFormat("kk:mm:ss").parse(Time);
                    this.setEnd(new java.sql.Time(date1.getTime()));
                }
            }
            if(resources.containsKey("Total Break Time")) this.setTotalBreakTime(Integer.parseInt(resources.remove("Total Break Time").toString()));
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        //Make sure we check later for valid data or some shit.
        return true;
    }

    @Override
    public boolean Save() {
        SQLSchedule.ME.updateSchedule(this);
        return true;
    }
    
}
