package com.hrims.main.frames;

import com.hrims.main.GUIManager;
import com.hrims.main.data.Ticket;
import com.hrims.main.data.TicketEntry;
import com.hrims.main.sql.SQLTicket;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mrdsc
 */
public class Ticket_Page extends javax.swing.JInternalFrame {
    
    public Ticket ticket;
    int pageNumber = 0;
    int maxPage = 0;
    int numPerPage = 25;
    
    public void Update() {
        int ticketid = ticket.getTicketId();
        
        //ticket = new Ticket();
        ticket = SQLTicket.ME.getTickets(ticket.getTicketId(),ticket.getTicketId()).get(0);
        ticket.setTicketId(ticketid);
        
        DefaultTableModel model = (DefaultTableModel) tblResponses.getModel();
        model.setRowCount(0);
        model.setRowCount(numPerPage);
        fixPageNumbers();
        
        Reload();
    }
    private void Reload() {
        for(int y = 0; y < tblResponses.getRowCount(); y++) {
                for(int x = 0; x < tblResponses.getColumnCount(); x++) {
                if(y >= ticket.getEntries().size()) {
                    tblResponses.getModel().setValueAt("", y, x);
                } else {
                    TicketEntry l = ticket.getEntries().get(y +(pageNumber*25));
                    String information = "";
                    switch(x) {
                        case 0:
                            information = ""+l.getEntryId();
                            break;
                        case 1:
                            information = ""+l.getUserId();//+l;
                            break;
                        case 2:
                            information = ""+l.getMessage();
                            break;
                    }
                    tblResponses.getModel().setValueAt(information, y, x);
                }
            }
        }
    }
    /**
     * Creates new form Employee
     */
    public Ticket_Page() {
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
        tblResponses = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnPrevious = new javax.swing.JButton();
        txtPageNumber = new javax.swing.JTextField();
        btnNext = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jToggleButton3 = new javax.swing.JToggleButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Ticket Responses");
        setMinimumSize(new java.awt.Dimension(1024, 540));
        setPreferredSize(new java.awt.Dimension(1024, 540));

        tblResponses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, ""},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Response ID", "UserID", "Response"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblResponses);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        btnAdd.setText("Add Response");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdd);

        btnEdit.setText("Edit");
        btnEdit.setEnabled(false);
        jPanel1.add(btnEdit);

        btnDelete.setText("Delete");
        btnDelete.setEnabled(false);
        jPanel1.add(btnDelete);

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

        jPanel4.setLayout(new java.awt.BorderLayout());

        jToggleButton3.setText("Search");
        jPanel4.add(jToggleButton3, java.awt.BorderLayout.LINE_END);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Response ID", "User ID", "Response", "Description" }));
        jComboBox1.setSelectedIndex(3);
        jPanel4.add(jComboBox1, java.awt.BorderLayout.LINE_START);

        jTextField1.setText("Search");
        jPanel4.add(jTextField1, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        Ticket_AddResponse tar = (Ticket_AddResponse)GUIManager.Lookup("Ticket_AddResponse");
        tar.setTicket(ticket);
        tar.setPage(this);
        tar.setVisible(true);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        pageNumber += 1;
        if(pageNumber == maxPage) {
            btnNext.setEnabled(false);
        }
        btnPrevious.setEnabled(true);
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        pageNumber--;
        if(pageNumber == 0) {
            btnPrevious.setEnabled(false);
        } if(pageNumber != maxPage) {
            btnNext.setEnabled(true);
        }
    }//GEN-LAST:event_btnPreviousActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JTable tblResponses;
    private javax.swing.JTextField txtPageNumber;
    // End of variables declaration//GEN-END:variables

    void setTicket(Ticket get) {
        this.ticket = get;
    }

    private void fixPageNumbers() {
        pageNumber = 0;
        txtPageNumber.setText("0");
        int size = ticket.getEntries().size();
        maxPage = size/25 + 1;
        btnPrevious.setEnabled(false);
        if(maxPage > 1) {
            btnNext.setEnabled(true);
        } else {
            btnNext.setEnabled(false);
        }
    }
}
