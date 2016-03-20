/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiclient.inventorymanager;

import common.Constansts;
import common.IRmiSecureApi;
import rmiclient.LoginForm;

/**
 *
 * @author isakhankov
 */
public class InventoryManagerLogin {

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
                new LoginForm(Constansts.INVENTORY_MANAGER) {
                    @Override
                    protected void openApplication(IRmiSecureApi api, String token) {
                        new InventoryManager(api, token).setVisible(true);
                    }

                }.setVisible(true);
            }
        }
        );
    }
}
