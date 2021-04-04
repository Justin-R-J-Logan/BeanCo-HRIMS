package com.hrims.main;

import com.hrims.main.frames.Order_PreviousOrder;
import com.hrims.main.frames.*;
import javax.swing.UIManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.


/**
 *
 * @author Justin
 */

public class BeanCoHRIMS {

    public static boolean DEBUG = false;
    /**
     * Main class for the program. Will be activated by the JAR or command line.
     * @param args the command line arguments. No arguments currently in use.
     */
    public static void main(String[] args) {
        try { 
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
        } catch (Exception ex) { 
            ex.printStackTrace(); 
        }  
        new Window().setVisible(true);
        GUIManager.Setup();
    }
    
}
