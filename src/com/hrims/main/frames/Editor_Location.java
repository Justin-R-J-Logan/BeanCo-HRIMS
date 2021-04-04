package com.hrims.main.frames;

import com.hrims.main.GUIManager;
import com.hrims.main.data.Location;
import com.hrims.main.sql.SQLLocation;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mrdsc
 */
public class Editor_Location extends javax.swing.JInternalFrame implements Updatable {

    int pageNumber = 0;
    int numPerPage = 25;
    ArrayList<Location> locations;
    
    /**
     * Creates new form Employee
     */
    public Editor_Location() {
        initComponents();
    }

    public void Update() {
        locations = SQLLocation.ME.getLocationsByPage(pageNumber, numPerPage, true);
        if(pageNumber <= 0) btnPrevious.setEnabled(false);
        else btnPrevious.setEnabled(true);
        if(locations.size() > numPerPage) btnNext.setEnabled(true);
        else btnNext.setEnabled(false);     
        Reload();
    }
    public void Reload() {
        for(int y = 0; y < tblLocation.getRowCount(); y++) {
                for(int x = 0; x < tblLocation.getColumnCount(); x++) {
                if(y >= locations.size()) {
                    tblLocation.getModel().setValueAt("", y, x);
                } else {
                    Location l = locations.get(y);
                    String information = "";
                    switch(x) {
                        case 0:
                            information = ""+l.getAddress() + " " + l.getAddress2();
                            break;
                        case 1:
                            information = ""+l.getMainPhone();
                            break;
                        case 2:
                            information = ""+l.getEmail();
                            break;
                        case 3:
                            information = ""+l.getCompany();
                            break;
                    }
                    tblLocation.getModel().setValueAt(information, y, x);
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
        tblLocation = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
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
        jPanel4 = new javax.swing.JPanel();
        btnSearch = new javax.swing.JToggleButton();
        cmbSearchType = new javax.swing.JComboBox<>();
        txtSearch = new javax.swing.JTextField();

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
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        tblLocation.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"60 Commerce Crescent", "705.474.7600", "N/A", "Canadore"},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Address", "Phone", "Email", "Company"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblLocation.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tblLocation);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

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
        jPanel3.add(btnPrevious);

        txtPageNumber.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPageNumber.setText("1");
        jPanel3.add(txtPageNumber);

        btnNext.setText("Next");
        jPanel3.add(btnNext);

        jPanel2.add(jPanel3, java.awt.BorderLayout.CENTER);

        jPanel4.setLayout(new java.awt.BorderLayout());

        btnSearch.setText("Search");
        jPanel4.add(btnSearch, java.awt.BorderLayout.LINE_END);

        cmbSearchType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Location ID", "Address", "Phone", "Email", "Company" }));
        cmbSearchType.setSelectedIndex(1);
        jPanel4.add(cmbSearchType, java.awt.BorderLayout.LINE_START);

        txtSearch.setText("Search");
        jPanel4.add(txtSearch, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        try {
            Location loc = new Location();
            Properties_Editor<Location, Editor_Location> editor = (Properties_Editor<Location, Editor_Location>)GUIManager.Lookup("Account_Property_Editor");
            editor.setObject(loc);
            editor.setFrame(this);
            editor.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        Update();
    }//GEN-LAST:event_formInternalFrameOpened

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        int row = tblLocation.getSelectedRow();
        if(row < 0) return;
        try {
            Location loc = locations.get(row);
            Properties_Editor<Location, Editor_Location> editor = (Properties_Editor<Location, Editor_Location>)GUIManager.Lookup("Location_Property_Editor");
            editor.setObject(loc);
            editor.setFrame(this);
            editor.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        Update();
    }//GEN-LAST:event_formComponentShown

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int input = JOptionPane.showConfirmDialog(null, "Delete selected schedule?");
        if (input == 0){
            int locID = Integer.parseInt((String)tblLocation.getModel().getValueAt(tblLocation.getSelectedRow(), 0));
            Location loc = null;
            for(Location l : locations) {
                if(l.getLocationID()== locID) {
                    loc = l;
                }
            }
            SQLLocation.ME.deleteLocation(loc);
        }
        Update();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnReloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReloadActionPerformed
        Update();
    }//GEN-LAST:event_btnReloadActionPerformed

    private void btnDuplicateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDuplicateActionPerformed
        int row = tblLocation.getSelectedRow();
        try 
        {
            int locID = Integer.parseInt((String)tblLocation.getModel().getValueAt(row, 0));
            Location loc = null;
            for(Location l : locations) 
            {
                if(l.getLocationID()== locID) 
                {
                    loc = l;
                }
            }
            Location l = new Location();
            l.setAddress(loc.getAddress());
            l.setAddress2(loc.getAddress2());
            l.setCompany(loc.getCompany());
            l.setCreated(loc.getCreated());
            l.setEmail(loc.getEmail());
            l.setMainPhone(loc.getMainPhone());
            
            SQLLocation.ME.createLocation(l);
        } 
        catch (Exception ex) 
        {
            ex.printStackTrace();
        }
        Update();
    }//GEN-LAST:event_btnDuplicateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDuplicate;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JButton btnReload;
    private javax.swing.JToggleButton btnSearch;
    private javax.swing.JComboBox<String> cmbSearchType;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblLocation;
    private javax.swing.JTextField txtPageNumber;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
