package rmiserver;

import common.Constansts;
import common.IRmiSecureApi;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

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
            IRmiSecureApi api = new RmiSecureApi();
            IRmiSecureApi stub
                    = (IRmiSecureApi) UnicastRemoteObject.exportObject(api, 0);
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind(Constansts.RMI_NAME, stub);
            System.out.println("Server is running");
        } catch (Exception e) {
            System.err.println("Problems with starting server");
            e.printStackTrace();
        }
    }

}
