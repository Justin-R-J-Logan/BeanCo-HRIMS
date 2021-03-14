/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrims.main.data;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Justin
 */
public class ScheduleDay {
    
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
    
    private int _accountid;
    private java.sql.Date _date;
    private java.sql.Time _start;
    private java.sql.Time _end;
    private int _totalBreakTime;
    
}
