/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrims.main.data;

import java.sql.Date;

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

    public int getLocationID() {
        return _locationID;
    }

    public void setLocationID(int _locationID) {
        this._locationID = _locationID;
    }

    public int getAccessRights() {
        return _accessRights;
    }

    public void setAccessRights(int _accessRights) {
        this._accessRights = _accessRights;
    }

    public String getFirstName() {
        return _firstName;
    }

    public void setFirstName(String _firstName) {
        this._firstName = _firstName;
    }

    public String getLastName() {
        return _lastName;
    }

    public void setLastName(String _lastName) {
        this._lastName = _lastName;
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

    public String getSin() {
        return _sin;
    }

    public void setSin(String _sin) {
        this._sin = _sin;
    }

    public String getAddressL1() {
        return _addressL1;
    }

    public void setAddressL1(String _addressL1) {
        this._addressL1 = _addressL1;
    }

    public String getAddressL2() {
        return _addressL2;
    }

    public void setAddressL2(String _addressL2) {
        this._addressL2 = _addressL2;
    }

    public String getMainPhone() {
        return _mainPhone;
    }

    public void setMainPhone(String _mainPhone) {
        this._mainPhone = _mainPhone;
    }

    public String getEmail() {
        return _email;
    }

    public void setEmail(String _email) {
        this._email = _email;
    }

    public String getCompany() {
        return _company;
    }

    public void setCompany(String _company) {
        this._company = _company;
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
    private int _locationID;
    private int _accessRights;
    private String _firstName;
    private String _lastName;
    private java.sql.Date _dob;
    private java.sql.Date _dod;
    private java.sql.Date _created;
    private java.sql.Date _lastLogin;
    private String _sin;
    private String _addressL1;
    private String _addressL2;
    private String _mainPhone;
    private String _email;
    private String _company;
    private String _username;
    private String _password;
}
