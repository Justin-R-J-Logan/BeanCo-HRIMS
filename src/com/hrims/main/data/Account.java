/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrims.main.data;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Justin
 */
public class Account {

    public int getAccountNumber() {
        return _accountNumber;
    }

    public void setAccountNumber(int _accountNumber) {
        this._accountNumber = _accountNumber;
    }

    public int getAccessRights() {
        return _accessRights;
    }

    public void setAccessRights(int _accessRights) {
        this._accessRights = _accessRights;
    }

    public Date getDob() {
        return _dob;
    }

    public void setDob(Date _dob) {
        this._dob = _dob;
    }

    public Date getDod() {
        return _dod;
    }

    public void setDod(Date _dod) {
        this._dod = _dod;
    }

    public Date getCreated() {
        return _created;
    }

    public void setCreated(Date _created) {
        this._created = _created;
    }

    public Date getLastLogin() {
        return _lastLogin;
    }

    public void setLastLogin(Date _lastLogin) {
        this._lastLogin = _lastLogin;
    }
    
    public String getUsername() {
        return _username;
    }

    public void setUsername(String _username) {
        this._username = _username;
    }

    public String getPassword() {
        return _password;
    }

    public void setPassword(String _password) {
        this._password = _password;
    }
    
    private int _accountNumber;
    private int _accessRights;
    private java.sql.Date _dob;
    private java.sql.Date _dod;
    private java.sql.Date _created;
    private java.sql.Date _lastLogin;
    private String _username;
    private String _password;
    
    public final ArrayList<Contact> contacts = new ArrayList<Contact>();
    
}
