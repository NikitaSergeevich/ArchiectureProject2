package rmiclient.shippingmanager;

import common.IRmiApi;
import common.pojo.Order;
import common.pojo.OrderItem;
import java.sql.*;
import java.util.List;

/**
 * ****************************************************************************
 * File:ShippingManager.java Course: 17655 Project: Assignment 2 Copyright:
 * Copyright (c) 2009 Carnegie Mellon University Versions: 1.0 November 2009 -
 * Initial rewrite of original assignment 2 (ajl).
 *
 * This class defines a GUI application that allows EEP shipping personnel to
 * mark orders as shipped.
 *
 *****************************************************************************
 */
/*
 * Created on Feb 4, 2010, 7:40:03 PM
 *
 * @author lattanze
 */
public class ShippingManager extends javax.swing.JFrame {

    Integer updateOrderID;
    String versionID = "v2.10.10";
    private final IRmiApi api;
    private final String token;

    /**
     * Creates new form NewJFrame
     *
     * @param api
     * @param token
     */
    public ShippingManager(IRmiApi api, String token) {
        this.api = api;
        this.token = token;
        initComponents();
        jLabel1.setText("Shipping Application " + versionID);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Shipping Application");

        jTextArea1.setColumns(20);
        jTextArea1.setEditable(false);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel3.setText("Server IP Address:");

        jTextField1.setText("localhost");

        jTextField2.setEditable(false);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel4.setText("Order Information:");

        jLabel5.setText("Customer First Name:");

        jLabel6.setText("Last Name:");

        jTextField3.setEditable(false);
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel7.setText("Phone Number:");

        jTextField4.setEditable(false);
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jLabel8.setText("Mailing Address");

        jTextArea2.setColumns(20);
        jTextArea2.setEditable(false);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jButton1.setText("Mark As Shipped");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Show  Pending Orders");
        jButton2.setDefaultCapable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Select Order");
        jButton3.setEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel10.setText("Order Number : Order Date & Time: Customer Name");

        jTextArea3.setColumns(20);
        jTextArea3.setEditable(false);
        jTextArea3.setRows(5);
        jScrollPane3.setViewportView(jTextArea3);

        jLabel9.setText("Order Items ");

        jLabel11.setText("Messages");

        jButton4.setText("Show Shipped Orders");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTextArea4.setColumns(20);
        jTextArea4.setEditable(false);
        jTextArea4.setRows(5);
        jScrollPane4.setViewportView(jTextArea4);

        jLabel2.setText("Order Date:");

        jTextField5.setEditable(false);
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 894, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 894, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 551, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(228, 228, 228))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 715, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 716, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(187, 187, 187)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 351, Short.MAX_VALUE))
                                    .addComponent(jTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE))))
                        .addGap(45, 45, 45))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel9)
                            .addComponent(jLabel4)
                            .addComponent(jLabel10))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(8, 8, 8)
                .addComponent(jButton4)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jLabel11))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // jButton2 is responsible for refreshing the list of pending
        // orders.
        getPendingOrders();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // This button gets the selected line of text from the
        // order list window jTextArea1. The line of text is parsed for the
        // order number. Once the order number is parsed, then the order is
        // retrieved from the orders database. The ordertabel field from the
        // record contains the name of the table that has the items that make
        // up the order. This table is opened and all the items are listed
        // in jTextArea3.

        String errString = null;            // String for displaying errors
        int beginIndex;                     // Parsing index
        int endIndex;                       // Parsing index
        String msgString = null;            // String for displaying non-error messages
        String orderSelection = null;       // Order selected from TextArea1
        String orderTable = null;           // The name of the table containing the order items
        String orderID = null;              // Product ID pnemonic
        String productDescription = null;   // Product description
        Boolean orderBlank = false;         // False: order string is not blank

        // this is the selected line of text
        orderSelection = jTextArea1.getSelectedText();

        // make sure its not blank
        if (orderSelection.length() > 0) {
            // get the product ID
            beginIndex = 0;
            beginIndex = orderSelection.indexOf(" # ", beginIndex);
            beginIndex = beginIndex + 3; //skip past _#_
            endIndex = orderSelection.indexOf(" :", beginIndex);
            orderID = orderSelection.substring(beginIndex, endIndex);

        } else {

            msgString = ">> Order string is blank...";
            jTextArea4.setText("\n" + msgString);
            orderBlank = true;

        } // Blank string check

        // If an order was selected, then connect to the orderinfo database. In
        // all normal situations this would be impossible to do since the select
        // button is disabled until an order is selected... just in case the
        // check is here.
        if (!orderBlank) {
            try {
                Order order = api.getOrder(Integer.parseInt(orderID));
                orderTable = order.getTableName();

                jTextField2.setText(order.getFirstName()); // first name
                jTextField3.setText(order.getLastName()); // last name
                jTextField4.setText(order.getPhone()); // phone
                jTextField5.setText(order.getDate()); // order date
                jTextArea2.setText(order.getAddress());  // address

                // list the items on the form that comprise the order
                jTextArea3.setText("");

                List<OrderItem> orderItems = api.getOrderItems(orderTable);
                for (OrderItem orderItem : orderItems) {
                    msgString = orderItem.getId() + ":  PRODUCT ID: " + orderItem.getProductId()
                            + "  DESCRIPTION: " + orderItem.getDescription()
                            + "  PRICE $" + orderItem.getPrice();
                    jTextArea3.append(msgString + "\n");
                }

                // This global variable is used to update the record as shipped
                updateOrderID = Integer.parseInt(orderID);

                // Update the form
                jButton1.setEnabled(true);
                msgString = "RECORD RETRIEVED...";
                jTextArea4.setText(msgString);

            } catch (Exception e) {

                errString = "\nProblem getting order items:: " + e;
                jTextArea1.append(errString);

            } // end try-catch

        } // connect and blank order check

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // This method is responsible changing the status of the order
        // to shipped.

        String errString = null;            // String for displaying errors
        int rows;                           // Rows updated

        try {

            // execute the statement
            rows = api.updateShippedStatus(updateOrderID, true);

            // if the query worked, then we display the data in TextArea 4 - BTW, its highly
            // unlikely that the row won't exist and if it does the database tables are
            // really screwed up... this should not fail if you get here, but the check (in the
            // form of the else clause) is in place anyway
            if (rows > 0) {
                jTextArea4.setText("\nOrder #" + updateOrderID + " status has been changed to shipped.");

            } else {

                jTextArea4.setText("\nOrder #" + updateOrderID + " record not found.");

            } // execute check

            // Clean up the form
            jButton1.setEnabled(false);
            jButton3.setEnabled(false);
            jTextArea1.setText("");
            jTextArea2.setText("");
            jTextArea3.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
            jTextField4.setText("");
            jTextField5.setText("");

        } catch (Exception e) {

            errString = "\nProblem updating status:: " + e;
            jTextArea4.append(errString);
            jTextArea1.setText("");

        } // end try-catch


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // This button will display the list of orders that have already
        // have been shipped.

        getShippedOrders();

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void getPendingOrders() {

        // This method is responsible for querying the orders database and
        // getting the list of pending orders. This are orders that have not
        // been shipped as of yet. The list of pending orders is written to
        // jTextArea1.
        String errString = null;            // String for displaying errors
        String msgString = null;            // String for displaying non-error messages

        // Clean up the form before we start
        jTextArea1.setText("");
        jTextArea2.setText("");
        jTextArea3.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");

        try {
            //Display the data in the textarea
            jTextArea1.setText("");
            // For each row returned, we check the shipped status. If it is
            // equal to 0 it means it has not been shipped as of yet, so we
            // display it in TextArea 1. Note that we use an integer because
            // MySQL stores booleans and a TinyInt(1), which we interpret
            // here on the application side as an integer. It works, it just
            // isn't very elegant.
            List<Order> orders = api.getOrders();
            for (Order order : orders) {
                if (order.getShippedStatus() == 0) {
                    msgString = "ORDER # " + order.getOrderNumber() + " : " + order.getDate()
                            + " : " + order.getFirstName() + " : " + order.getLastName();
                    jTextArea1.append(msgString + "\n");
                }
            }

            // notify the user all went well and enable the select order
            // button
            jButton3.setEnabled(true);
            msgString = "\nPENDING ORDERS RETRIEVED...";
            jTextArea4.setText(msgString);

        } catch (Exception e) {

            errString = "\nProblem getting tree inventory:: " + e;
            jTextArea4.append(errString);

        } // end try-catch

    } // getPendingOrders

    private void getShippedOrders() {

        // This method is responsible for querying the orders database and
        // getting the list of orders that have been shipped. The list of shipped
        // orders is written to jTextArea1.
        String errString = null;            // String for displaying errors
        String msgString = null;            // String for displaying non-error messages

        // Clean up the form before we start
        jTextArea1.setText("");
        jTextArea2.setText("");
        jTextArea3.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");

        try {
            //Display the data in the textarea
            jTextArea1.setText("");

            // For each row returned, we check the shipped status. If it is
            // equal to 0 it means it has not been shipped as of yet, so we
            // display it in TextArea 1. Note that we use an integer because
            // MySQL stores booleans and a TinyInt(1), which we interpret
            // here on the application side as an integer. It works, it just
            // isn't very elegant.
            List<Order> orders = api.getOrders();
            for (Order order : orders) {
                if (order.getShippedStatus() == 0) {
                    msgString = "ORDER # " + order.getOrderNumber() + " : " + order.getDate()
                            + " : " + order.getFirstName() + " : " + order.getLastName();
                    jTextArea1.append(msgString + "\n");
                }
            }

            jButton1.setEnabled(false);
            jButton3.setEnabled(false);

            msgString = "\nSHIPPED ORDERS RETRIEVED...";
            jTextArea4.setText(msgString);

        } catch (Exception e) {

            errString = "\nProblem getting tree inventory:: " + e;
            jTextArea4.append(errString);

        } // end try-catch

    } // getPendingOrders

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables

}
