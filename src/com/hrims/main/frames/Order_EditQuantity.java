/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrims.main.frames;

/**
 *
 * @author Justin
 */
public class Order_EditQuantity extends javax.swing.JDialog {

    /**
     * Creates new form Order_EditQuantity
     */
    public Order_EditQuantity(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
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

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        value = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edit Quantity");
        setType(java.awt.Window.Type.POPUP);

        jButton1.setText("Submit");
        getContentPane().add(jButton1, java.awt.BorderLayout.LINE_END);

        jLabel1.setText("Please input new quantity:");
        getContentPane().add(jLabel1, java.awt.BorderLayout.PAGE_START);

        value.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        getContentPane().add(value, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * 
     */
    
    public int getValue() {
        int i = -1;
        try {
            i = Integer.parseInt(value.getText());
        } catch (Exception ex) {
            
        }
        return i;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JFormattedTextField value;
    // End of variables declaration//GEN-END:variables
}
