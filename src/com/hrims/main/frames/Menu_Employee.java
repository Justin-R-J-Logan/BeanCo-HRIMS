package com.hrims.main.frames;

import com.hrims.main.GUIManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Seilum
 */
public class Menu_Employee extends javax.swing.JInternalFrame {

    /** Creates new form EmployeeMiddleGUI */
    public Menu_Employee() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnViewSchedule = new javax.swing.JButton();
        btnOperateMachine = new javax.swing.JButton();
        btnTickets = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setTitle("Employee Menu");
        setMinimumSize(new java.awt.Dimension(400, 300));
        setPreferredSize(new java.awt.Dimension(400, 300));
        getContentPane().setLayout(new java.awt.GridLayout(0, 1));

        btnViewSchedule.setText("View Schedule");
        btnViewSchedule.setActionCommand("ViewSchedule");
        btnViewSchedule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewScheduleActionPerformed(evt);
            }
        });
        getContentPane().add(btnViewSchedule);
        btnViewSchedule.getAccessibleContext().setAccessibleName("ViewSchedule");

        btnOperateMachine.setText("Operate Machine");
        btnOperateMachine.setActionCommand("OperateMachine");
        btnOperateMachine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOperateMachineActionPerformed(evt);
            }
        });
        getContentPane().add(btnOperateMachine);

        btnTickets.setText("Tickets");
        btnTickets.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTicketsActionPerformed(evt);
            }
        });
        getContentPane().add(btnTickets);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewScheduleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewScheduleActionPerformed
        GUIManager.Show("Schedule_Viewer");
    }//GEN-LAST:event_btnViewScheduleActionPerformed

    private void btnOperateMachineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOperateMachineActionPerformed
        GUIManager.Show("Employee_Interface");
    }//GEN-LAST:event_btnOperateMachineActionPerformed

    private void btnTicketsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTicketsActionPerformed
        Ticket_List tl = (Ticket_List)GUIManager.Lookup("TicketList");
        tl.setViewOnly(true);
        GUIManager.Show("TicketList");
    }//GEN-LAST:event_btnTicketsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOperateMachine;
    private javax.swing.JButton btnTickets;
    private javax.swing.JButton btnViewSchedule;
    // End of variables declaration//GEN-END:variables

}
