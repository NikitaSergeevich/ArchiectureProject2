/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import common.pojo.Order;
import common.pojo.OrderItem;
import common.pojo.Product;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author isakhankov
 */
public interface IRmiSecureApi extends Remote {

    String login(String login, String password, String applicationName) throws RemoteException;

    void logout(String token) throws RemoteException;

    Order getOrder(int id, String token) throws RemoteException;

    List<Order> getOrders(String token) throws RemoteException;

    List<OrderItem> getOrderItems(String orderTable, String token) throws RemoteException;

    int updateShippedStatus(int id, boolean status, String token) throws RemoteException;

    public int createOrderItemTable(String tableName, String token) throws RemoteException;

    public int createOrder(Order order, String token) throws RemoteException;

    public int dropOrderItemTable(String tableName, String token) throws RemoteException;

    public int createOrderItem(String tableName, String productId, String description, float perUnitCost, String token) throws RemoteException;

    /*Inventory Methods*/
    public List<Product> getShrubs(String token) throws RemoteException;

    public List<Product> getSeeds(String token) throws RemoteException;

    public List<Product> getTrees(String token) throws RemoteException;

    public List<Product> getCultureBoxes(String token) throws RemoteException;

    public List<Product> getGenomics(String token) throws RemoteException;

    public List<Product> getProcessing(String token) throws RemoteException;

    public List<Product> getReferenceMaterials(String token) throws RemoteException;

    public int insertShrubs(String productID, int quantity, String description,
            float perUnitCost, String token) throws RemoteException;

    public int insertTrees(String productID, int quantity, String description,
            float perUnitCost, String token) throws RemoteException;

    public int insertSeeds(String productID, int quantity, String description,
            float perUnitCost, String token) throws RemoteException;

    public int insertCultureBoxes(String productID, int quantity,
            String description, float perUnitCost, String token) throws RemoteException;

    public int insertGenomics(String productID, int quantity,
            String description, float perUnitCost, String token) throws RemoteException;

    public int insertProcessing(String productID, int quantity,
            String description, float perUnitCost, String token) throws RemoteException;

    public int insertReferenceMaterials(String productID, int quantity,
            String description, float perUnitCost, String token) throws RemoteException;

    public int deleteShrubs(String productID, String token) throws RemoteException;

    public int deleteTrees(String productID, String token) throws RemoteException;

    public int deleteSeeds(String productID, String token) throws RemoteException;

    public int deleteCultureBoxes(String productID, String token) throws RemoteException;

    public int deleteGenomics(String productID, String token) throws RemoteException;

    public int deleteProcessing(String productID, String token) throws RemoteException;

    public int deleteReferenceMaterials(String productID, String token) throws RemoteException;

    public List<Product> decrementShrubs(String productID, String token) throws RemoteException;

    public List<Product> decrementTrees(String productID, String token) throws RemoteException;

    public List<Product> decrementSeeds(String productID, String token) throws RemoteException;

    public List<Product> decrementCultureBoxes(String productID, String token) throws RemoteException;

    public List<Product> decrementGenomics(String productID, String token) throws RemoteException;

    public List<Product> decrementProcessing(String productID, String token) throws RemoteException;

    public List<Product> decrementReferenceMaterials(String productID, String token) throws RemoteException;
}
