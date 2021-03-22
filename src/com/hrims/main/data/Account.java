/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrims.main.data;

import com.hrims.main.sql.SQLAccount;
import com.hrims.main.sql.SQLCaller;
import com.hrims.main.sql.SQLContact;
import java.sql.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author Justin
 */
public class Account implements DataGrabber<Account> {

    private static final int ACCESS_ADMINISTRATOR = 16;
    private static final int ACCESS_MANAGER = 8;
    private static final int ACCESS_MACHINE = 4;
    private static final int ACCESS_DISTRIBUTOR = 2;
    private static final int ACCESS_EMPLOYEE = 1;
    private static final int ACCESS_GUEST = 0;
    
    public Account() {
        
    }
    
    public Account(int _accountNumber, boolean _get) {
        _accountNumber  = -1;
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

    public void addContact(Contact c) {
        contacts.add(c);
    }
    public void remContact(Contact c) {
        contacts.remove(c);
    }
    public void remContact(int c) {
        contacts.remove(c);
    }

    @Override
    public Map<String, Object> getResources() {
        Map<String, Object> resources = new LinkedHashMap<String, Object>();
        
        resources.put("Username", this._username);
        resources.put("Password", this._password);
        resources.put("Access Rights", this._accessRights);
        resources.put("Created", this._created);
        resources.put("Last Login", this._lastLogin);
        resources.put("Discount", this._discount);
        
        
        int i = 0;
        for(Contact c : contacts) {
            resources.put("Contact " + i + " Location ID", "" + c.getLocationID());
            resources.put("Contact " + i + " First Name", "" + c.getFirstName());
            resources.put("Contact " + i + " Last Name", "" + c.getLastName());
            resources.put("Contact " + i + " Address", "" + c.getAddressL1());
            resources.put("Contact " + i + " Address L2", "" + c.getAddressL1());
            resources.put("Contact " + i + " Phone", "" + c.getMainPhone());
            resources.put("Contact " + i + " Email", "" + c.getEmail());
            resources.put("Contact " + i + " Sin", "" + c.getSin());
            resources.put("Contact " + i + " Company", "" + c.getCompany());
        }
        
        return resources;
    }

    @Override
    public boolean SetResources(Map<String, Object> resources) {
        try {
            if(resources.containsKey("Username")) this.setUsername(resources.remove("Username").toString());
            if(resources.containsKey("Password")) this.setPassword(resources.remove("Password").toString());
            if(resources.containsKey("Access Rights")) this.setAccessRights(Integer.parseInt(""+resources.remove("Access Rights")));
            if(resources.containsKey("Created")) {
                Object o = resources.remove("Created");
                if(o instanceof java.sql.Date) {
                    this.setCreated((java.sql.Date)o);
                } else if((String)o == null || (String)o == "") {
                    
                } else {
                    String date = (String)o;
                    java.util.Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(date);
                    this.setCreated(new java.sql.Date(date1.getTime()));
                }
            }
            if(resources.containsKey("Last Login")) {
                Object o = resources.remove("Last Login");
                if(o instanceof java.sql.Date) {
                    this.setCreated((java.sql.Date)o);
                } else if((String)o == null || (String)o == "") {
                    
                } else {
                    String date = (String)o;
                    java.util.Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(date);
                    this.setCreated(new java.sql.Date(date1.getTime()));
                }
            }
            if(resources.containsKey("Discount")) this.setDiscount(Integer.parseInt(""+resources.remove("Discount")));
            
            //contacts.clear();
            for(int i = 0; i < (resources.size()/9); i++) {
                if(contacts.get(i)!=null) {
                    Contact c = contacts.get(i);
                    if(resources.containsKey("Contact " + i + " Location ID")) {
                        c.setLocationID(Integer.parseInt(resources.get("Contact " + i + " Location ID").toString()));
                    }
                    if(resources.containsKey("Contact " + i + " First Name")) {
                        c.setFirstName(resources.get("Contact " + i + " First Name").toString());
                    }
                    if(resources.containsKey("Contact " + i + " Last Name")) {
                        c.setLastName((resources.get("Contact " + i + " Last Name").toString()));
                    }
                    if(resources.containsKey("Contact " + i + " Address")) {
                        c.setAddressL1(resources.get("Contact " + i + " Address").toString());
                    }
                    if(resources.containsKey("Contact " + i + " Address L2")) {
                        c.setAddressL2(resources.get("Contact " + i + " Address L2").toString());
                    }
                    
                    if(resources.containsKey("Contact " + i + " Phone")) {
                        c.setMainPhone(resources.get("Contact " + i + " Phone").toString());
                    }
                    if(resources.containsKey("Contact " + i + " Email")) {
                        c.setEmail(resources.get("Contact " + i + " Email").toString());
                    }
                    if(resources.containsKey("Contact " + i + " Sin")) {
                        c.setSin(resources.get("Contact " + i + " Sin").toString());
                    }
                    if(resources.containsKey("Contact " + i + " Company")) {
                        c.setCompany((resources.get("Contact " + i + " Company").toString()));
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        //Make sure we check later for valid data or some shit.
        return true;
    }

    @Override
    public boolean Save() {
        if(this._accountNumber <= -1) {
            SQLAccount.ME.createAccount(this);
        } else {
            try {
                SQLAccount.ME.updateAccount(this);
                for(Contact c : contacts) {
                    SQLContact.ME.updateContact(c);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                return false;
            }
        }
        return true;
    }
    
}
