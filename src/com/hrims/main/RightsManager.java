package com.hrims.main;


import com.hrims.main.LoginManager;
import com.hrims.main.data.Account;
import com.hrims.main.frames.Menu_Main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Justin
 */
public class RightsManager {
    
    public static void UpdateMenus() {
        Account a = LoginManager.MYACCOUNT;
        
        boolean isFullAccess = (a.getAccessRights() & Account.ACCESS_FULLACCESS) == Account.ACCESS_FULLACCESS ? true : false;
        boolean isAdministrator = (a.getAccessRights() & Account.ACCESS_ADMINISTRATOR) == Account.ACCESS_ADMINISTRATOR ? true : false;
        boolean isManager = (a.getAccessRights() & Account.ACCESS_MANAGER) == Account.ACCESS_MANAGER ? true : false;
        boolean isMachine = (a.getAccessRights() & Account.ACCESS_MACHINE) == Account.ACCESS_MACHINE ? true : false;
        boolean isDistributor = (a.getAccessRights() & Account.ACCESS_DISTRIBUTOR) == Account.ACCESS_DISTRIBUTOR ? true : false;
        boolean isEmployee = (a.getAccessRights() & Account.ACCESS_ADMINISTRATOR) == Account.ACCESS_ADMINISTRATOR ? true : false;
        boolean isGuest = !(isFullAccess || isMachine || isAdministrator || isManager || isDistributor || isEmployee);
        
           Menu_Main mm = (Menu_Main)GUIManager.Lookup("Main_Frame");
        if(isEmployee || isFullAccess) {
            mm.btnEmployeeMenu.setEnabled(true);
            mm.setFocusable(true);
        } else {
            mm.btnEmployeeMenu.setEnabled(false);
            mm.setFocusable(false);
        }        
        if(isManager || isFullAccess) {
            mm.btnManagerMenu.setEnabled(true);
            mm.setFocusable(true);
        } else {
            mm.btnManagerMenu.setEnabled(false);
            mm.setFocusable(false);
        }
        if(isDistributor || isFullAccess) {
            mm.btnDistributorMenu.setEnabled(true);
            mm.setFocusable(true);
        } else {
            mm.btnDistributorMenu.setEnabled(false);
            mm.setFocusable(false);
        }
        if(isAdministrator || isFullAccess) {
            mm.btnAdministratorMenu.setEnabled(true);
            mm.setFocusable(true);
        } else {
            mm.btnAdministratorMenu.setEnabled(false);
            mm.setFocusable(false);
        }
        
        
        System.out.println(isGuest);
    }
}
