/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrims.main.data;

import com.hrims.main.sql.SQLCaller;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Justin
 */
public class Account {

    private static final int ACCESS_ADMINISTRATOR = 16;
    private static final int ACCESS_MANAGER = 8;
    private static final int ACCESS_MACHINE = 4;
    private static final int ACCESS_DISTRIBUTOR = 2;
    private static final int ACCESS_EMPLOYEE = 1;
    private static final int ACCESS_GUEST = 0;
    
    public Account() {
        
    }
    
    public Account(int _accountNumber, boolean _get) {
    }
    
    
    public Account(int _accountNumber, int _accessRights, Date _created, Date _lastLogin, String _username, String _password, int _access, int _discount) {
        this._accountNumber = _accountNumber;
        this._accessRights = _accessRights;
        this._created = _created;
        this._lastLogin = _lastLogin;
        this._username = _username;
        this._password = _password;
        this._access = _access;
        this._discount = _discount;
    }
    
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

    public int getAccess() {
        return _access;
    }

    public void setAccess(int _access) {
        this._access = _access;
    }
    
    public int getDiscount() {
        return _discount;
    }

    public void setDiscount(int _discount) {
        this._discount = _discount;
    }

    @Override
    public String toString() {
        return "Account{" + "_accountNumber=" + _accountNumber + ", _accessRights=" + _accessRights + ", _created=" + _created + ", _lastLogin=" + _lastLogin + ", _username=" + _username + ", _password=" + _password + ", _access=" + _access + ", _discount=" + _discount + ", contacts=" + contacts + '}';
    }
    
    private int _accountNumber;
    private int _accessRights;
    private java.sql.Date _created;
    private java.sql.Date _lastLogin;
    private String _username;
    private String _password;
    private int _access;
    private int _discount;

    
    public final ArrayList<Contact> contacts = new ArrayList<Contact>();
    
}
