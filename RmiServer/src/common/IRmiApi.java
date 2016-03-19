/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import common.pojo.Order;
import common.pojo.OrderItem;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author isakhankov
 */
public interface IRmiApi extends Remote {

    //used to authentificate user
    String login(String login, String password, String applicationName) throws RemoteException;

    Order getOrder(int id) throws RemoteException;

    List<Order> getOrders() throws RemoteException;

    List<OrderItem> getOrderItems(String orderTable) throws RemoteException;

    int updateShippedStatus(int id, boolean status) throws RemoteException;
}
