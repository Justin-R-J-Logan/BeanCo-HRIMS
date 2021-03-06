/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hrims.main.frames;

import com.hrims.main.data.Product;
import java.util.ArrayList;

/**
 *
 * @author Justin
 */
public class Editor_Products extends javax.swing.JInternalFrame {

    int pageNumber = 0;
    int numPerPage = 25;
    boolean lockForward = false;
    ArrayList<Product> products;
    
    /**
     * Creates new form Products_SelectProduct
     */
    public Editor_Products() {
        initComponents();
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
        tblMachine = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnReload = new javax.swing.JButton();
        btnDuplicate = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnPrevious = new javax.swing.JButton();
        txtPageNumber = new javax.swing.JTextField();
        btnNext = new javax.swing.JButton();

        tblMachine.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, "Mean Bean Machine (TM)"},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Name", "Machine"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMachine.setDoubleBuffered(true);
        tblMachine.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tblMachine);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jButton1.setText("Select");
        jPanel1.add(jButton1);

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdd);

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jPanel1.add(btnEdit);

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btnDelete);

        btnReload.setText("Reload");
        btnReload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReloadActionPerformed(evt);
            }
        });
        jPanel1.add(btnReload);

        btnDuplicate.setText("Duplicate");
        btnDuplicate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDuplicateActionPerformed(evt);
            }
        });
        jPanel1.add(btnDuplicate);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setLayout(new java.awt.GridLayout(1, 0));

        btnPrevious.setText("Previous");
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });
        jPanel3.add(btnPrevious);

        txtPageNumber.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPageNumber.setText("1");
        jPanel3.add(txtPageNumber);

        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        jPanel3.add(btnNext);

        jPanel2.add(jPanel3, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Update() {
        
        Reload();
    }
    
    private void Reload() {
        
    }
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        try
        {
            /*Machine mac = new Machine();
            Date d = new Date(new java.util.Date().getTime());
            mac.setCreated(d);
            mac.setLastUse(d);
            mac.setPurchaseDate(d);
            Properties_Editor<Machine, Editor_Machine> editor = (Properties_Editor<Machine, Editor_Machine>)GUIManager.Lookup("Machine_Property_Editor");
            editor.setObject(mac);
            editor.setFrame(this);
            editor.setVisible(true);*/
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        int row = tblMachine.getSelectedRow();
        try
        {/*
            Machine acc = machines.get(row);
            Properties_Editor<Machine, Editor_Machine> editor = (Properties_Editor<Machine, Editor_Machine>)GUIManager.Lookup("Machine_Property_Editor");
            editor.setObject(acc);
            editor.setFrame(this);
            editor.setVisible(true);*/
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        /*
        int input = JOptionPane.showConfirmDialog(null, "Delete selected machine?");
        if (input == 0)
        {
            int machineID = Integer.parseInt(tblMachine.getModel().getValueAt(tblMachine.getSelectedRow(), 0).toString());
            SQLMachine.ME.deleteMachine(machineID);
        }*/
        Update();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnReloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReloadActionPerformed
        Update();
    }//GEN-LAST:event_btnReloadActionPerformed

    private void btnDuplicateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDuplicateActionPerformed
        int row = tblMachine.getSelectedRow();
        try
        {/*
            int macID = Integer.parseInt((String)tblMachine.getModel().getValueAt(row, 0));
            Machine mac = null;
            for(Machine m : machines)
            {
                if(m.getMachineID() == macID)
                {
                    mac = m;
                }
            }
            Machine m = new Machine();
            m.setCreated(mac.getCreated());
            m.setInUse(mac.isInUse());
            m.setLocationID(mac.getLocationID());
            m.setMachineName(mac.getMachineName());
            m.setPurchaseDate(mac.getPurchaseDate());
            m.setLastUse(mac.getLastUse());

            m.Save();*/
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        Update();
    }//GEN-LAST:event_btnDuplicateActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        pageNumber--;
        if(pageNumber<0) pageNumber=0;
        Update();
    }//GEN-LAST:event_btnPreviousActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        pageNumber++;
        Update();
    }//GEN-LAST:event_btnNextActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDuplicate;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JButton btnReload;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMachine;
    private javax.swing.JTextField txtPageNumber;
    // End of variables declaration//GEN-END:variables
}
