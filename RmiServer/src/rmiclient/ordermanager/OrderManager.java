package rmiclient.ordermanager;

import common.Constansts;
import common.IRmiSecureApi;
import common.pojo.Order;
import common.pojo.Product;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * ****************************************************************************
 * File:NewJFrame.java Course: 17655 Project: Assignment 2 Copyright: Copyright
 * (c) 2009 Carnegie Mellon University Versions: 1.0 November 2009 - Initial
 * rewrite of original assignment 2 (ajl).
 *
 * This class defines a GUI application that allows EEP order takers to enter
 * phone orders into the database.
 *
 *****************************************************************************
 */
/**
 *
 * @author lattanze
 */
public class OrderManager extends javax.swing.JFrame {

    String versionID = "v2.10.10";
    private final IRmiSecureApi api;
    private final String token;

    /**
     * Creates new form NewJFrame
     *
     * @param api
     * @param token
     */
    public OrderManager(IRmiSecureApi api, String token) {
        this.api = api;
        this.token = token;

        initComponents();
        jLabel1.setText("Order Management Application " + versionID);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    super.windowClosing(e);
                    api.logout(token);
                } catch (RemoteException ex) {
                    Logger.getLogger(OrderManager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jTextField3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Order Management Application");

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setText("Trees");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Seeds");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Shrubs");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel4.setText("Press Button For Inventory Display");

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jLabel6.setText("First Name");

        jLabel7.setText("Last Name");

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jLabel8.setText("Phone #");

        jLabel5.setText("Items Selected:");

        jButton4.setText("Add to Order");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel9.setText("Order Total Cost:");

        jTextField6.setText("$0");
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jButton5.setText("Submit Order");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel10.setText("Product ID : Product Description : Price : Items in Stock");

        jLabel2.setText("Messages:");

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane3.setViewportView(jTextArea3);

        jLabel3.setText("Customer Information");

        jLabel12.setText("Address");

        jTextArea4.setColumns(20);
        jTextArea4.setRows(5);
        jScrollPane4.setViewportView(jTextArea4);

        jLabel13.setText("SELECT ENTIRE INVENTORY LINE TO ADD ITEM TO ORDER (TRIPLE CLICK)");

        jButton6.setText("Culture Boxes");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Genomics");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Processing");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("Reference Materials");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(316, 316, 316)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1)
                                        .addComponent(jScrollPane2)
                                        .addComponent(jScrollPane3)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel4)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(10, 10, 10)
                                                    .addComponent(jLabel2))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jButton1)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jButton2)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jButton3)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(jButton6)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jButton7)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(jButton8)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(jButton9)))
                                            .addGap(0, 0, Short.MAX_VALUE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(jLabel5)))
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField6)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel10))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(93, 93, 93))
            .addGroup(layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(jButton5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addComponent(jLabel4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel3))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton2)
                        .addComponent(jButton3)
                        .addComponent(jButton6)
                        .addComponent(jButton7)
                        .addComponent(jButton8)
                        .addComponent(jButton9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(145, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        // jButton1 is responsible for querying the inventory database and
        // getting the tree inventory. Once retieved, the tree inventory is
        // displayed in jTextArea1. From here the user can select an inventory
        // item by triple clicking the item.
        // Database parameters
        String errString = null;            // String for displaying errors
        String msgString = null;            // String for displaying non-error messages

        try {
            //Display the data in the textarea
            jTextArea1.setText("");

            List<Product> trees = api.getTrees(token);
            for (Product tree : trees) {
                msgString = tree.getProductCode() + " : " + tree.getDescription()
                        + " : $" + tree.getPrice() + " : " + tree.getQuantity()
                        + " units in stock";
                jTextArea1.append(msgString + "\n");
            }
        } catch (Exception e) {

            errString = "\nProblem getting tree inventory:: " + e;
            jTextArea1.append(errString);

        } // end try-catch
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // This button gets the selected line of text from the
        // inventory list window jTextArea1. The line of text is parsed and
        // the relevant information is placed in the order area (jTextArea2).

        int beginIndex;                     // Parsing index
        int endIndex;                       // Parsing index
        Float fCost;                        // Item cost
        String productDescription = null;   // Product description
        String productID = null;            // Product ID pnemonic
        String sCost, sTotalCost;            // String order and total cost values
        Boolean IndexNotFound;              // Flag indicating a string index was not found.

        // Initialization
        String inventorySelection = null;
        IndexNotFound = false;
        sCost = null;
        sTotalCost = null;

        // this is the selected line of text
        inventorySelection = jTextArea1.getSelectedText();

        // make sure its not blank
        if (inventorySelection != null) {
            // get the product ID
            beginIndex = 0;
            endIndex = inventorySelection.indexOf(" : ", beginIndex);
            if (endIndex < 0) {
                IndexNotFound = true;
            } else {
                productID = inventorySelection.substring(beginIndex, endIndex);
            }

            if (!IndexNotFound) {
                // get the product description
                beginIndex = endIndex + 3; //skip over " : "
                endIndex = inventorySelection.indexOf(" : ", beginIndex);
                if (endIndex < 0) {
                    IndexNotFound = true;
                } else {
                    productDescription = inventorySelection.substring(beginIndex, endIndex);
                }
            }

            // get the string cost value
            if (!IndexNotFound) {
                beginIndex = endIndex + 4; //skip over " : $"
                endIndex = inventorySelection.indexOf(" : ", beginIndex);
                if (endIndex < 0) {
                    IndexNotFound = true;
                } else {
                    sCost = inventorySelection.substring(beginIndex, endIndex);
                }
            }

            // write the string to the order area
            if (!IndexNotFound) {
                jTextArea2.append(productID + " : " + productDescription + " : $"
                        + sCost + "\n");

                // convert the string cost to a float, add it to what is in the
                // cost field (jTextField6), and update the cost field with the
                // new value
                sTotalCost = jTextField6.getText();
                beginIndex = 0;
                beginIndex = sTotalCost.indexOf("$", beginIndex) + 1;
                sTotalCost = sTotalCost.substring(beginIndex, sTotalCost.length());
                fCost = Float.parseFloat(sTotalCost) + Float.parseFloat(sCost);
                jTextField6.setText("$" + fCost.toString());

            } else {
                jTextArea3.append("\nNo items selected...\nSELECT ENTIRE INVENTORY LINE TO ADD ITEM TO ORDER\n(TRIPLE CLICK ITEM LINE)");
            }
        } else {
            jTextArea3.append("\nNo items selected...\nSELECT ENTIRE INVENTORY LINE TO ADD ITEM TO ORDER\n(TRIPLE CLICK ITEM LINE)");
        } // Blank string check
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // This is the submit order button. This handler will check to make sure
        // that the customer information is provided, then create an entry in
        // the orderinfo::orders table. It will also create another table where
        // the list of items is stored. This table is also in the orderinfo
        // database as well.

        int beginIndex;                 // String parsing index
        int endIndex;                   // String paring index
        String description;             // Tree, seed, or shrub description
        String errString = null;        // String for displaying errors
        String msgString = null;        // String for displaying non-error messages
        String sTotalCost = null;       // String representing total order cost
        String sPerUnitCost = null;     // String representation of per unit cost
        String orderItem = null;        // Order line item from jTextArea2
        Float perUnitCost;              // Cost per tree, seed, or shrub unit
        String productID = null;        // Product id of tree, seed, or shrub

        // Check to make sure there is a first name, last name, address and phone
        if ((jTextField3.getText().length() > 0) && (jTextField4.getText().length() > 0)
                && (jTextField5.getText().length() > 0)
                && (jTextArea4.getText().length() > 0)) {
            try {
                Calendar rightNow = Calendar.getInstance();

                int TheHour = rightNow.get(rightNow.HOUR_OF_DAY);
                int TheMinute = rightNow.get(rightNow.MINUTE);
                int TheSecond = rightNow.get(rightNow.SECOND);
                int TheDay = rightNow.get(rightNow.DAY_OF_WEEK);
                int TheMonth = rightNow.get(rightNow.MONTH);
                int TheYear = rightNow.get(rightNow.YEAR);

                String dateTimeStamp = TheMonth + "/" + TheDay + "/" + TheYear + " "
                        + TheHour + ":" + TheMinute + ":" + TheSecond;

                // Get the order data
                sTotalCost = jTextField6.getText();
                beginIndex = 0;
                beginIndex = sTotalCost.indexOf("$", beginIndex) + 1;
                sTotalCost = sTotalCost.substring(beginIndex, sTotalCost.length());

                Order order = new Order();
                order.setDate(dateTimeStamp);
                order.setFirstName(jTextField3.getText());
                order.setLastName(jTextField4.getText());
                order.setAddress(jTextArea4.getText());
                order.setPhone(jTextField5.getText());
                order.setCost(Float.parseFloat(sTotalCost));
                order.setShippedStatus(0);
                order.setOrderTableName("order" + String.valueOf(rightNow.getTimeInMillis()));

                int result = api.createOrderItemTable(order.getOrderTableName(), token);
                if (result == Constansts.INVALID_RESULT) {
                    errString = "\nProblem creating order table " + order.getOrderTableName();
                    jTextArea3.append(errString);
                } else {
                    result = api.createOrder(order, token);
                    if (result == Constansts.INVALID_RESULT) {
                        errString = "\nProblem with inserting into table orders";
                        jTextArea3.append(errString);

                        result = api.dropOrderItemTable(order.getOrderTableName(), token);
                        if (result == Constansts.INVALID_RESULT) {
                            errString = "\nProblem deleting unused order table:: "
                                    + order.getOrderTableName();
                            jTextArea3.append(errString);
                        }
                    } else {
                        String[] items = jTextArea2.getText().split("\\n");

                        for (int i = 0; i < items.length; i++) {
                            orderItem = items[i];
                            jTextArea3.append("\nitem #:" + i + ": " + items[i]);

                            // Check just to make sure that a blank line was not stuck in
                            // there... just in case.
                            if (orderItem.length() > 0) {
                                // Parse out the product id
                                beginIndex = 0;
                                endIndex = orderItem.indexOf(" : ", beginIndex);
                                productID = orderItem.substring(beginIndex, endIndex);

                                // Parse out the description text
                                beginIndex = endIndex + 3; //skip over " : "
                                endIndex = orderItem.indexOf(" : ", beginIndex);
                                description = orderItem.substring(beginIndex, endIndex);

                                // Parse out the item cost
                                beginIndex = endIndex + 4; //skip over " : $"
                                //endIndex = orderItem.indexOf(" : ",orderItem.length());
                                //sPerUnitCost = orderItem.substring(beginIndex,endIndex);
                                sPerUnitCost = orderItem.substring(beginIndex, orderItem.length());
                                perUnitCost = Float.parseFloat(sPerUnitCost);

                                result = api.createOrderItem(order.getOrderTableName(), productID, description, perUnitCost, token);
                                if (result == Constansts.INVALID_RESULT) {
                                    errString = "\nProblem with inserting into table " + order.getOrderNumber();
                                    jTextArea3.append(errString);
                                } else {
                                    msgString = "\nORDER SUBMITTED FOR: " + order.getFirstName() + " " + order.getLastName();
                                    jTextArea3.setText(msgString);

                                    // Clean up the display
                                    jTextArea1.setText("");
                                    jTextArea2.setText("");
                                    jTextArea4.setText("");
                                    jTextField3.setText("");
                                    jTextField4.setText("");
                                    jTextField5.setText("");
                                    jTextField6.setText("$0");
                                }
                            } // line length check

                        } //for each line of text in order table
                    }
                }
            } catch (RemoteException ex) {
                Logger.getLogger(OrderManager.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // jButton2 is responsible for querying the inventory database and
        // getting the seed inventory. Once retieved, the seed inventory is
        // displayed in jTextArea1. From here the user can select an inventory
        // item by triple clicking the item.

        String errString = null;            // String for displaying errors
        String msgString = null;            // String for displaying non-error messages

        try {
            //Display the data in the textarea
            jTextArea1.setText("");

            List<Product> seeds = api.getSeeds(token);
            for (Product seed : seeds) {
                msgString = seed.getProductCode() + " : " + seed.getDescription()
                        + " : $" + seed.getPrice() + " : " + seed.getQuantity()
                        + " units in stock";
                jTextArea1.append(msgString + "\n");
            }

        } catch (Exception e) {

            errString = "\nProblem getting seed inventory:: " + e;
            jTextArea1.append(errString);

        } // end try-catch
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // jButton3 is responsible for querying the inventory database and
        // getting the shrub inventory. Once retieved, the shrub inventory is
        // displayed in jTextArea1. From here the user can select an inventory
        // item by triple clicking the item.

        String errString = null;            // String for displaying errors
        String msgString = null;            // String for displaying non-error messages

        try {
            //Display the data in the textarea
            jTextArea1.setText("");

            List<Product> shrubs = api.getShrubs(token);
            for (Product shurb : shrubs) {
                msgString = shurb.getProductCode() + " : " + shurb.getDescription()
                        + " : $" + shurb.getPrice() + " : " + shurb.getQuantity()
                        + " units in stock";
                jTextArea1.append(msgString + "\n");
            }
        } catch (Exception e) {
            errString = "\nProblem getting shrubs inventory:: " + e;
            jTextArea1.append(errString);

        } // end try-catch
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // jButton3 is responsible for querying the inventory database and
        // getting the processing inventory. Once retieved, the processing inventory is
        // displayed in jTextArea1. From here the user can select an inventory
        // item by triple clicking the item.

        String errString = null;            // String for displaying errors
        String msgString = null;            // String for displaying non-error messages

        try {
            //Display the data in the textarea
            jTextArea1.setText("");

            List<Product> processings = api.getProcessing(token);
            for (Product processing : processings) {
                msgString = processing.getProductCode() + " : " + processing.getDescription()
                        + " : $" + processing.getPrice() + " : " + processing.getQuantity()
                        + " units in stock";
                jTextArea1.append(msgString + "\n");
            }
        } catch (Exception e) {
            errString = "\nProblem getting processing inventory:: " + e;
            jTextArea1.append(errString);

        } // end try-catch
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // jButton3 is responsible for querying the inventory database and
        // getting the shrub inventory. Once retieved, the shrub inventory is
        // displayed in jTextArea1. From here the user can select an inventory
        // item by triple clicking the item.

        String errString = null;            // String for displaying errors
        String msgString = null;            // String for displaying non-error messages

        try {
            //Display the data in the textarea
            jTextArea1.setText("");

            List<Product> cultureBoxes = api.getCultureBoxes(token);
            for (Product cultureBox : cultureBoxes) {
                msgString = cultureBox.getProductCode() + " : " + cultureBox.getDescription()
                        + " : $" + cultureBox.getPrice() + " : " + cultureBox.getQuantity()
                        + " units in stock";
                jTextArea1.append(msgString + "\n");
            }
        } catch (Exception e) {
            errString = "\nProblem getting culture box inventory:: " + e;
            jTextArea1.append(errString);

        } // end try-catch
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // jButton3 is responsible for querying the inventory database and
        // getting the genomics inventory. Once retieved, the genomics inventory is
        // displayed in jTextArea1. From here the user can select an inventory
        // item by triple clicking the item.

        String errString = null;            // String for displaying errors
        String msgString = null;            // String for displaying non-error messages

        try {
            //Display the data in the textarea
            jTextArea1.setText("");

            List<Product> genomics = api.getGenomics(token);
            for (Product genomic : genomics) {
                msgString = genomic.getProductCode() + " : " + genomic.getDescription()
                        + " : $" + genomic.getPrice() + " : " + genomic.getQuantity()
                        + " units in stock";
                jTextArea1.append(msgString + "\n");
            }
        } catch (Exception e) {
            errString = "\nProblem getting genomics inventory:: " + e;
            jTextArea1.append(errString);

        } // end try-catch
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // jButton3 is responsible for querying the inventory database and
        // getting the Reference Materials inventory. Once retieved, the Reference Materials
        //inventory is displayed in jTextArea1. From here the user can select an inventory
        // item by triple clicking the item.

        String errString = null;            // String for displaying errors
        String msgString = null;            // String for displaying non-error messages

        try {
            //Display the data in the textarea
            jTextArea1.setText("");

            List<Product> referenceMaterials = api.getReferenceMaterials(token);
            for (Product material : referenceMaterials) {
                msgString = material.getProductCode() + " : " + material.getDescription()
                        + " : $" + material.getPrice() + " : " + material.getQuantity()
                        + " units in stock";
                jTextArea1.append(msgString + "\n");
            }
        } catch (Exception e) {
            errString = "\nProblem getting reference materials inventory:: " + e;
            jTextArea1.append(errString);

        } // end try-catch
    }//GEN-LAST:event_jButton9ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables

}
