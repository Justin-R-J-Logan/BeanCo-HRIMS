package com.hrims.main;

import com.hrims.main.data.Account;
import com.hrims.main.data.Location;
import com.hrims.main.data.Machine;
import com.hrims.main.data.ScheduleDay;
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
import com.hrims.main.frames.Order_AddItem;
import com.hrims.main.frames.Ticket_AddResponse;
import com.hrims.main.frames.Ticket_Page;
import com.hrims.main.frames.Order_NewOrder;
import com.hrims.main.frames.Order_PreviousOrder;
import com.hrims.main.frames.Order_PreviousOrderItems;
import com.hrims.main.unusedclasses.Properties_DistributorInfo;
import com.hrims.main.frames.Properties_Editor;
import com.hrims.main.unusedclasses.Properties_ProgramSettings;
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
 * GUI management class for the program. Manages GUIs so we can reference them easier.
 * @author Justin
 */
public class GUIManager {
    private static HashMap<String, JInternalFrame> _table = new HashMap<String, JInternalFrame>();
    private static int Windows_Running = 0;
    private static final Startup_ProgressBar bar = new Startup_ProgressBar();
    
    /**
     * Looks to see if a GUI (internal frame) exists by name identifier.
     * @param gui_name name of the internal frame
     * @return returns the frame if found, null if not found.
     */
    public static JInternalFrame Lookup(String gui_name) {
        if(_table.containsKey(gui_name)) return _table.get(gui_name);
        else {
            String infoMessage = "GUI Not found! Please check the register code.";
            String titleBar = "GUI Not Found";
            JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
            return null;
        }
    }
    
    /**
     * Shows a frame by name.
     * @param gui_name name of the internal frame
     * @return true if found and shown, false if not found or already visible
     */
    public static boolean Show(String gui_name) {
        JInternalFrame f = Lookup(gui_name);
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
    
    /**
     * Registers a frame in the GUIRegister by a given name. 
     * @param gui_name name of the internal frame
     * @param frame to be registered.
     * @return true if the frame gets registered, false if not.
     */
    public static boolean Register(String gui_name, JInternalFrame frame) {
        boolean ret = false;
        if(!_table.containsKey(gui_name)) {
            frame.setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
            frame.addInternalFrameListener(new InternalWindowListener());
            _table.put(gui_name, frame);
            ret = true;
            bar.increment();
            try {
                Window.paneDesktop.add(frame);
            } catch (Exception ex) {
                
            }
        }
        return ret;
    }

    /**
     * Hides a GUI by name.
     * @param gui_name to hide
     * @return true if hidden, false if not found or already hidden
     */
    public static boolean Hide(String gui_name) {
        JInternalFrame f = Lookup(gui_name);
        if(f == null | f.isVisible() == false) {
            return false;
        }
        else {
            f.setVisible(false);
            f.setLocation(0, 0);
            Windows_Running--;
            return true;
        }
    }
    
    /**
     * Logs user out.
     */
    public static void Logout() {
        for (String key : _table.keySet()) {
            if(_table.get(key).isVisible()) Hide(key);
        }
        Windows_Running = 0;
        Show("Login");
    }

    /**
     * Check to count currently open windows.
     */
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
        Register("Distributor_Previous_Orders", new Order_PreviousOrderItems());
        Register("Distributor_PreviousOrder_ShowOrder", new Order_PreviousOrder());
        Register("Inventory_SearchItems", new Ticket_AddResponse());
        Register("Employee_Frame", new Menu_Employee());
        Register("Employee_Interface", new Employee_Interface());
        Register("Machine_Breakdown", new Machine_Breakdown());
        Register("Schedule_Editor", new Editor_Schedule());
        Register("Schedule_Viewer", new Schedule_Viewer());
        Register("Order_AddItem", new Order_AddItem());
        Register("DistributorInfo", new Properties_DistributorInfo());
        Register("Settings", new Properties_ProgramSettings());
        Register("Employee_Editor", new Editor_Account());
        Register("Location_Editor", new Editor_Location());
        Register("Machine_Editor", new Editor_Machine());
        Register("TicketList", new Ticket_List());
        Register("TicketPage", new Ticket_Page());
        Register("Ticket_AddResponse", new Ticket_AddResponse());
        Register("Account_Property_Editor", new Properties_Editor<Account, Editor_Account>());
        Register("Location_Property_Editor", new Properties_Editor<Location, Editor_Location>());
        Register("Schedule_Property_Editor", new Properties_Editor<ScheduleDay, Editor_Schedule>());
        Register("Machine_Property_Editor", new Properties_Editor<Machine, Editor_Machine>());


        Hide("LoadingBar");
        Show("Login");        
    }

    static void Login() {
        GUIManager.Hide("Login");
        //TODO: Show only what the user can do.
        GUIManager.Show("Main_Frame");
    }
}
