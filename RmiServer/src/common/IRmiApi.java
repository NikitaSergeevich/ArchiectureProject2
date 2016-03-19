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
public interface IRmiApi extends Remote {

    //used to authentificate user
    String login(String login, String password, String applicationName) throws RemoteException;

    Order getOrder(int id) throws RemoteException;

    List<Order> getOrders() throws RemoteException;

    List<OrderItem> getOrderItems(String orderTable) throws RemoteException;

    int updateShippedStatus(int id, boolean status) throws RemoteException;

    public int createOrderItemTable(String tableName) throws RemoteException;

    public int createOrder(Order order) throws RemoteException;

    public int dropOrderItemTable(String tableName) throws RemoteException;

    public int createOrderItem(String tableName, String productId, String description, float perUnitCost) throws RemoteException;
    
    /*Inventory Methods*/
    
    public List<Product> getShrubs() throws RemoteException;
     
    public List<Product> getSeeds() throws RemoteException;
     
    public List<Product> getTrees() throws RemoteException;
             
    public List<Product> getCultureBoxes() throws RemoteException;
             
    public List<Product> getGenomics() throws RemoteException;
    
    public List<Product> getProcessing() throws RemoteException;    
             
    public List<Product> getReferenceMaterials() throws RemoteException;
             
    public int insertShrubs(String productID, int quantity, String description, 
            float perUnitCost) throws RemoteException;
             
    public int insertTrees(String productID, int quantity, String description, 
            float perUnitCost) throws RemoteException;
             
    public int insertSeeds(String productID, int quantity, String description, 
            float perUnitCost) throws RemoteException;
             
    public int insertCultureBoxes(String productID, int quantity, 
            String description, float perUnitCost) throws RemoteException;
             
    public int insertGenomics(String productID, int quantity, 
            String description, float perUnitCost) throws RemoteException;
    
    public int insertProcessing(String productID, int quantity,
            String description, float perUnitCost) throws RemoteException;    
             
    public int insertReferenceMaterials(String productID, int quantity, 
            String description, float perUnitCost) throws RemoteException;
    
    public int deleteShrubs(String productID) throws RemoteException;
    
    public int deleteTrees(String productID) throws RemoteException;
    
    public int deleteSeeds(String productID) throws RemoteException;
    
    public int deleteCultureBoxes(String productID) throws RemoteException;
    
    public int deleteGenomics(String productID) throws RemoteException;
    
    public int deleteProcessing(String productID) throws RemoteException;
    
    public int deleteReferenceMaterials(String productID) throws RemoteException;
}
