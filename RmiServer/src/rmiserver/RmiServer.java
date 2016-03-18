package rmiserver;

import common.Constansts;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import common.IRmiApi;

/**
 *
 * @author isakhankov
 */
public class RmiServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            IRmiApi api = new RmiApi();
            IRmiApi stub
                    = (IRmiApi) UnicastRemoteObject.exportObject(api, 0);
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind(Constansts.RMI_NAME, stub);
            System.out.println("Server is running");
        } catch (Exception e) {
            System.err.println("ComputeEngine exception:");
            e.printStackTrace();
        }
    }

}
