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
public class LoginAttempt {
    int loginAttemptID;

    public int getLoginAttemptID() {
        return loginAttemptID;
    }

    public void setLoginAttemptID(int loginAttemptID) {
        this.loginAttemptID = loginAttemptID;
    }

    public String getUsername() {
        return _username;
    }

    public void setUsername(String username) {
        this._username = username;
    }

    public String getPassword() {
        return _password;
    }

    public void setPassword(String password) {
        this._password = password;
    }

    public String getIpNum() {
        return _ipNum;
    }

    public void setIpNum(String ipNum) {
        this._ipNum = ipNum;
    }

    public String getTermType() {
        return _termType;
    }

    public void setTermType(String termType) {
        this._termType = termType;
    }

    public boolean isSuccess() {
        return _Success;
    }

    public void setSuccess(boolean Success) {
        this._Success = Success;
    }

    public Date getAttemptDate() {
        return _attemptDate;
    }

    public void setAttemptDate(Date attemptDate) {
        this._attemptDate = attemptDate;
    }
    String _username;
    String _password;
    String _ipNum;
    String _termType;
    boolean _Success;
    java.sql.Date _attemptDate;

    public LoginAttempt(int loginAttemptID, String _username, String _password, String _ipNum, String _termType, boolean _Success, Date _attemptDate) {
        this.loginAttemptID = loginAttemptID;
        this._username = _username;
        this._password = _password;
        this._ipNum = _ipNum;
        this._termType = _termType;
        this._Success = _Success;
        this._attemptDate = _attemptDate;
    }
    
    public LoginAttempt() {
    
    }
}
