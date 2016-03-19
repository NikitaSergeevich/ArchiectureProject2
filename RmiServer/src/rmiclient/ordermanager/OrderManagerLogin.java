/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiclient.ordermanager;

import rmiclient.inventorymanager.*;
import common.Constansts;
import common.IRmiApi;
import rmiclient.LoginForm;

/**
 *
 * @author isakhankov
 */
public class OrderManagerLogin {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm(Constansts.ORDER_MANAGER) {
                    @Override
                    protected void openApplication(IRmiApi api, String token) {
                        new OrderManager(api, token).setVisible(true);
                    }

                }.setVisible(true);
            }
        }
        );
    }
}
