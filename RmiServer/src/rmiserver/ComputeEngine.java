/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiserver;

import common.Task;
import common.Compute;
import java.rmi.RemoteException;

/**
 *
 * @author isakhankov
 */
class ComputeEngine implements Compute {

    public ComputeEngine() {
    }

    @Override
    public <T> T executeTask(Task<T> t) throws RemoteException {
        return t.execute();
    }
    
}
