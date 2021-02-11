/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrims.main.data;

/**
 *
 * @author Justin
 */
public class Contact {
    
    private int _contactID;
    private int _locationID;
    private String _firstName;
    private String _lastName;
    private String _sin;
    private String _addressL1;
    private String _addressL2;
    private String _mainPhone;
    private String _email;
    private String _company;

    public int getContactID() {
        return _contactID;
    }

    public void setContactID(int _contactID) {
        this._contactID = _contactID;
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

    public int getLocationID() {
        return _locationID;
    }

    public void setLocationID(int _locationID) {
        this._locationID = _locationID;
    }
}
