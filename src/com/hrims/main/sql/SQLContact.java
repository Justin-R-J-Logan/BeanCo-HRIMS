/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrims.main.sql;

import com.hrims.main.data.Contact;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Justin
 */
public class SQLContact {

    public static SQLContact ME = new SQLContact();
    
    public ArrayList<Contact> getContactsFromAccountID(int lowAccID, int highAccID) {
        
            ArrayList<Contact> contacts = new ArrayList<Contact>();
            try {
                ResultSet contactresults = SQLCaller.ME.Submit_SQL_Query("SELECT * FROM contact "
                                                        + "WHERE accountid BETWEEN " + lowAccID + " AND " + highAccID + ";");
                while(contactresults.next()) {
                    Contact con = new Contact();
                    con.setContactID(contactresults.getInt(1));
                    con.setAccountID(contactresults.getInt(2));
                    con.setLocationID(contactresults.getInt(3));
                    con.setFirstName(contactresults.getString(4));
                    con.setLastName(contactresults.getString(5));
                    con.setAddressL1(contactresults.getString(6));
                    con.setAddressL2(contactresults.getString(7));
                    con.setMainPhone(contactresults.getString(8));
                    con.setEmail(contactresults.getString(9));
                    con.setSin(contactresults.getString(10));
                    con.setCompany(contactresults.getString(11));

                    contacts.add(con);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        return contacts;
    }
}
