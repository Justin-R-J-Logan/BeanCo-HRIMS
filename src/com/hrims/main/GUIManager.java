package com.hrims.main;

import com.hrims.main.frames.Administrator_MachineStatus;
import com.hrims.main.frames.Editor_Account;
import com.hrims.main.frames.Editor_Location;
import com.hrims.main.frames.Editor_Machine;
import com.hrims.main.frames.Editor_Schedule;
import com.hrims.main.frames.Ticket_List;
import com.hrims.main.frames.Employee_Interface;
import com.hrims.main.frames.Login;
import com.hrims.main.frames.Machine_Breakdown;
import com.hrims.main.frames.Menu_Administrator;
import com.hrims.main.frames.Menu_Distributor;
import com.hrims.main.frames.Menu_Employee;
import com.hrims.main.frames.Menu_Main;
import com.hrims.main.frames.Menu_Manager;
import com.hrims.main.frames.Ticket_AddResponse;
import com.hrims.main.frames.Ticket_Page;
import com.hrims.main.frames.Order_NewOrder;
import com.hrims.main.frames.Order_PreviousOrder;
import com.hrims.main.frames.Order_PreviousOrderList;
import com.hrims.main.frames.Properties_DistributorInfo;
import com.hrims.main.frames.Properties_ProgramSettings;
import com.hrims.main.frames.Schedule_Viewer;
import com.hrims.main.frames.Startup_ProgressBar;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Justin
 */
public class GUIManager {
    private static HashMap<String, JInternalFrame> _table = new HashMap<String, JInternalFrame>();
    private static int Windows_Running = 0;
    private static final Startup_ProgressBar bar = new Startup_ProgressBar();
    
    public static JInternalFrame Lookup(String s) {
        if(_table.containsKey(s)) return _table.get(s);
        else {
            String infoMessage = "GUI Not found! Please check the register code.";
            String titleBar = "GUI Not Found";
            JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
            return null;
        }
    }
    
    public static boolean Show(String s) {
        JInternalFrame f = Lookup(s);
        if(f == null || f.isVisible() == true ) return false;
        else {
            f.setVisible(true);
            Windows_Running++;
            int xloc = Math.max(Windows_Running-1,0) * 20;
            int yloc = Math.max(Windows_Running-1,0) * 20;
            f.setLocation(xloc, yloc);
            return true;
        }
    }
    
    public static boolean Register(String s, JInternalFrame f) {
        boolean ret = false;
        if(!_table.containsKey(s)) {
            f.setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
            f.addInternalFrameListener(new InternalWindowListener());
            _table.put(s, f);
            ret = true;
            bar.increment();
        }
        Window.paneDesktop.add(f);
        return ret;
    }

    public static boolean Hide(String s) {
        JInternalFrame f = Lookup(s);
        if(f == null) {
            return false;
        }
        else {
            f.setVisible(false);
            f.setLocation(0, 0);
            Windows_Running--;
            return true;
        }
    }
    
    public static void Logout() {
        for (String key : _table.keySet()) {
            if(_table.get(key).isVisible()) Hide(key);
        }
        Windows_Running = 0;
        Show("Login");
    }

    public static void Window_Closed() {
        Windows_Running--;
    }

    static void Setup() {
        
        
        bar.setMaxVal(24);
        
        Register("LoadingBar", bar);
        
        Show("LoadingBar");
        
        Register("Login", new Login());
        Register("Administrator_Frame", new Menu_Administrator());
        Register("Main_Frame", new Menu_Main());
        Register("Manager_Frame", new Menu_Manager());
        Register("Machine_List_Frame", new Editor_Machine());
        Register("Distributor_Menu", new Menu_Distributor());
        Register("Distributor_NewOrder_Frame", new Order_NewOrder());
        Register("Distributor_Previous_Orders", new Order_PreviousOrderList());
        Register("Distributor_PreviousOrder_ShowOrder", new Order_PreviousOrder());
        Register("Inventory_SearchItems", new Ticket_AddResponse());
        Register("Employee_Frame", new Menu_Employee());
        Register("Employee_Interface", new Employee_Interface());
        Register("Machine_Breakdown", new Machine_Breakdown());
        Register("Schedule_Editor", new Editor_Schedule());
        Register("Schedule_Viewer", new Schedule_Viewer());
        Register("Order_AddItem", new Ticket_AddResponse());
        Register("DistributorInfo", new Properties_DistributorInfo());
        Register("Settings", new Properties_ProgramSettings());
        Register("Employee_Editor", new Editor_Account());
        Register("Location_Editor", new Editor_Location());
        Register("Machine_Editor", new Editor_Machine());
        Register("Schedule_Editor", new Editor_Schedule());
        Register("Administrator_MachineStatus", new Administrator_MachineStatus());
        Register("TicketList", new Ticket_List());
        Register("TicketPage", new Ticket_Page());
        Register("Ticket_AddResponse", new Ticket_AddResponse());
        
        
        Hide("LoadingBar");
        Show("Login");        
    }

    static void Login() {
        GUIManager.Hide("Login");
        //TODO: Show only what the user can do.
        GUIManager.Show("Main_Frame");
    }
}
