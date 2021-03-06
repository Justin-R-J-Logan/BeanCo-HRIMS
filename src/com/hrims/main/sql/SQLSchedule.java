/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrims.main.sql;

import com.hrims.main.data.ScheduleDay;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * an SQL manager for the scheduleDay object.
 * @author Alexandra
 */
public class SQLSchedule {
    public static SQLSchedule ME = new SQLSchedule();
    
    
    /***
     * Selects all ScheduleDays of a given date. We. We can figure out how to 
     * Paginate it right?
     * @param date the date of ScheduleDays to be selected.
     * @return the ArrayList of ScheduleDays selected.
     */
    public ArrayList<ScheduleDay> getSchedules(java.sql.Date date) {
        ArrayList<ScheduleDay> schedules = new ArrayList<ScheduleDay>();
        
        try {
            
            ResultSet result = SQLCaller.ME.Submit_SQL_Query("SELECT * FROM scheduleday "
                                                        + "WHERE day='" + date + "';");
            
            while(result.next()) {
                ScheduleDay schd = new ScheduleDay();
                
                schd.setDate(result.getDate(1));
                schd.setAccountid(result.getInt(2));
                schd.setStart(result.getTime(3));
                schd.setEnd(result.getTime(4));
                schd.setTotalBreakTime(result.getInt(5));
                
                schedules.add(schd);
            }
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return schedules;
    }
    
    /***
     * Update the corresponding ScheduleDay in the database.
     * @param sched the updated ScheduledDay to be pushed to the database.
     * @return 
     */
    public boolean updateSchedule(ScheduleDay sched) {
        String statement = "UPDATE scheduleday " + "\n"
                + "SET "
                + "start = '" + sched.getStart()+ "', "
                + "end = '" + sched.getEnd()+ "', "
                + "totalbreaktime = '" + sched.getTotalBreakTime()+ "'\n"
                + "WHERE day = '" + sched.getDate() + "' AND accountid = " + sched.getAccountid() + ";";
        
        try {
            ResultSet result = SQLCaller.ME.Submit_SQL_Query(statement);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        
        return true;
    }
    
    /***
     * Insert a new ScheduleDay into the database.
     * @param sched object representing the new ScheduleDay to be inserted.
     * @return 
     */
    public boolean createScheduleDay(ScheduleDay sched) {
        
        String statement = "INSERT INTO scheduleDay(day, accountid, start, end, totalbreaktime)" + 
                "\n VALUES ('" + sched.getDate() + "', '" + sched.getAccountid() + "', '" + sched.getStart() + "', '" + sched.getEnd() + "', '" + sched.getTotalBreakTime() + "');";
        
        try {
            ResultSet result = SQLCaller.ME.Submit_SQL_Query(statement);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return true;
    }
    
    /***
     * Deletes a schedule day from the database.
     * 
     * @param sched The schedule day to be deleted.
     * @return true if successful.
     */
    public boolean deleteScheduleDay(ScheduleDay sched){
        String statement = ("DELETE FROM scheduleday WHERE \n" + 
                    "day = '" + sched.getDate() + 
                    "' AND accountid =" + sched.getAccountid() + ";");
        
        try{
            SQLCaller.ME.Submit_SQL_Query(statement);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return true;
    }
    
    /**
     * A main function to test the SQL functions.
     * @param arg 
     */
    public static void main(String arg[]) {
        /* Code to test the various sql functions.
        
        
        int year = 2021; //Enter the exact year.
        int month = 03; // Enter the exact month.
        int day = 14; //Enter the exact day.
        
        //Tests select on the given date.
        java.sql.Date testDate = new java.sql.Date(year-1900, month-1, day);
        System.out.println(testDate);
        System.out.println(ME.getSchedules(testDate).get(0).toString());*/
    }

    public ArrayList<ScheduleDay> getSchedulesFromAccountIDandStartDate(int accountNumber, Date d) {
        ArrayList<ScheduleDay> ret = new ArrayList<ScheduleDay>();
        
        String SQL = "";
        Date d2 = new java.sql.Date(d.getTime());
        d2.setDate(d2.getDate()+31);
        
        try {
            SQL += "SELECT * \n";
            SQL += "FROM scheduleday \n";
            SQL += "WHERE accountid = " + accountNumber + " AND day BETWEEN '" + d + "' AND '" + d2 + "'\n";
            SQL += "ORDER BY day;";
            
            ResultSet result = SQLCaller.ME.Submit_SQL_Query(SQL);
            
            System.out.println(SQL);
            
            while(result.next()) {
                ScheduleDay schd = new ScheduleDay();
                
                schd.setDate(result.getDate(1));
                schd.setAccountid(result.getInt(2));
                schd.setStart(result.getTime(3));
                schd.setEnd(result.getTime(4));
                schd.setTotalBreakTime(result.getInt(5));
                
                ret.add(schd);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return ret;
    }
}
