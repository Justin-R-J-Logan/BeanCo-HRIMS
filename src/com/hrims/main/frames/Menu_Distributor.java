/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrims.main.frames;

import com.hrims.main.GUIManager;

/**
 *
 * @author Justin
 */
public class Menu_Distributor extends javax.swing.JInternalFrame {

    /**
     * Creates new form Distributor_Menu_Frame
     */
    public Menu_Distributor() {
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

        btnNewOrder = new javax.swing.JButton();
        btnPreviousOrders = new javax.swing.JButton();
        btnDistributorInformation = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setTitle("Distributor Menu");
        setMinimumSize(new java.awt.Dimension(400, 300));
        setPreferredSize(new java.awt.Dimension(400, 300));
        getContentPane().setLayout(new java.awt.GridLayout(3, 1));

        btnNewOrder.setText("New Order");
        btnNewOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewOrderActionPerformed(evt);
            }
        });
        getContentPane().add(btnNewOrder);

        btnPreviousOrders.setText("Previous Orders");
        btnPreviousOrders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousOrdersActionPerformed(evt);
            }
        });
        getContentPane().add(btnPreviousOrders);

        btnDistributorInformation.setText("Distributor Information");
        btnDistributorInformation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDistributorInformationActionPerformed(evt);
            }
        });
        getContentPane().add(btnDistributorInformation);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewOrderActionPerformed
        GUIManager.Show("Distributor_NewOrder_Frame");
    }//GEN-LAST:event_btnNewOrderActionPerformed

    private void btnPreviousOrdersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousOrdersActionPerformed
        GUIManager.Show("Distributor_Previous_Orders");
    }//GEN-LAST:event_btnPreviousOrdersActionPerformed

    private void btnDistributorInformationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDistributorInformationActionPerformed
        GUIManager.Show("DistributorInfo");
    }//GEN-LAST:event_btnDistributorInformationActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDistributorInformation;
    private javax.swing.JButton btnNewOrder;
    private javax.swing.JButton btnPreviousOrders;
    // End of variables declaration//GEN-END:variables
}
