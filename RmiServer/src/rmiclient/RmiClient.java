/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiclient;

import common.Constansts;
import common.IRmiApi;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author isakhankov
 */
public class RmiClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            Registry registry = LocateRegistry.getRegistry(1099);
            IRmiApi comp = (IRmiApi) registry.lookup(Constansts.RMI_NAME);
            
            String goodUser = comp.login("test", "test", Constansts.INVENTORY_MANAGER);
            System.out.println(goodUser);
            String badUser = comp.login("root", "test", Constansts.INVENTORY_MANAGER);
            System.out.println(badUser);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
