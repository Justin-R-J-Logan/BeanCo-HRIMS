package com.hrims.main.frames;

import com.hrims.main.data.Location;
import com.hrims.main.sql.SQLLocation;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mrdsc
 */
public class Editor_Location extends javax.swing.JInternalFrame {

    int pageNumber = 0;
    int numPerPage = 25;
    
    /**
     * Creates new form Employee
     */
    public Editor_Location() {
        initComponents();
    }

    private void Reload() {
        ArrayList<Location> locations = SQLLocation.ME.getLocations(pageNumber*numPerPage+1, pageNumber*numPerPage+numPerPage);
        
        for(int y = 0; y < tblLocations.getRowCount(); y++) {
                for(int x = 0; x < tblLocations.getColumnCount(); x++) {
                if(y >= locations.size()) {
                    tblLocations.getModel().setValueAt("", y, x);
                } else {
                    Location l = locations.get(y);
                    String information = "";
                    switch(x) {
                        case 0:
                            information = ""+l.getLocationID();
                            break;
                        case 1:
                            information = ""+l.getAddress() + " " + l.getAddress2();
                            break;
                        case 2:
                            information = ""+l.getMainPhone();
                            break;
                        case 3:
                            information = ""+l.getEmail();
                            break;
                        case 4:
                            information = ""+l.getCompany();
                            break;
                    }
                    tblLocations.getModel().setValueAt(information, y, x);
                }
            }
        }
        txtPageNumber.setText(""+(pageNumber+1));
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblLocations = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        txtPageNumber = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jToggleButton3 = new javax.swing.JToggleButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Location Editor");
        setMinimumSize(new java.awt.Dimension(1024, 540));
        setPreferredSize(new java.awt.Dimension(1024, 540));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        tblLocations.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "60 Commerce Crescent", "705.474.7600", "N/A", "Canadore"},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Location ID", "Address", "Phone", "Email", "Company"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblLocations);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);

        jButton2.setText("Edit");
        jPanel1.add(jButton2);

        jButton3.setText("Delete");
        jPanel1.add(jButton3);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setLayout(new java.awt.GridLayout(1, 0));

        jButton5.setText("Previous");
        jPanel3.add(jButton5);

        txtPageNumber.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPageNumber.setText("1");
        jPanel3.add(txtPageNumber);

        jButton4.setText("Next");
        jPanel3.add(jButton4);

        jPanel2.add(jPanel3, java.awt.BorderLayout.CENTER);

        jPanel4.setLayout(new java.awt.BorderLayout());

        jToggleButton3.setText("Search");
        jPanel4.add(jToggleButton3, java.awt.BorderLayout.LINE_END);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Location ID", "Address", "Phone", "Email", "Company" }));
        jComboBox1.setSelectedIndex(1);
        jPanel4.add(jComboBox1, java.awt.BorderLayout.LINE_START);

        jTextField1.setText("Search");
        jPanel4.add(jTextField1, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        Reload();
    }//GEN-LAST:event_formInternalFrameOpened


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JTable tblLocations;
    private javax.swing.JTextField txtPageNumber;
    // End of variables declaration//GEN-END:variables
}
