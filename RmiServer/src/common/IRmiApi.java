/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import common.pojo.Order;
import common.pojo.OrderItem;
import common.pojo.Product;
import java.util.List;

/**
 *
 * @author isakhankov
 */
public interface IRmiApi {

    Order getOrder(int id);

    List<Order> getOrders();

    List<OrderItem> getOrderItems(String orderTable);

    int updateShippedStatus(int id, boolean status);

    public int createOrderItemTable(String tableName);

    public int createOrder(Order order);

    public int dropOrderItemTable(String tableName);

    public int createOrderItem(String tableName, String productId, String description, float perUnitCost);

    /*Inventory Methods*/
    public List<Product> getShrubs();

    public List<Product> getSeeds();

    public List<Product> getTrees();

    public List<Product> getCultureBoxes();

    public List<Product> getGenomics();

    public List<Product> getProcessing();

    public List<Product> getReferenceMaterials();

    public int insertShrubs(String productID, int quantity, String description,
            float perUnitCost);

    public int insertTrees(String productID, int quantity, String description,
            float perUnitCost);

    public int insertSeeds(String productID, int quantity, String description,
            float perUnitCost);

    public int insertCultureBoxes(String productID, int quantity,
            String description, float perUnitCost);

    public int insertGenomics(String productID, int quantity,
            String description, float perUnitCost);

    public int insertProcessing(String productID, int quantity,
            String description, float perUnitCost);

    public int insertReferenceMaterials(String productID, int quantity,
            String description, float perUnitCost);
    
    public int deleteShrubs(String productID);
    
    public int deleteTrees(String productID);
    
    public int deleteSeeds(String productID);
    
    public int deleteCultureBoxes(String productID);
    
    public int deleteGenomics(String productID);
    
    public int deleteProcessing(String productID);
    
    public int deleteReferenceMaterials(String productID);
    
    public List<Product> decrementShrubs(String productID);
    
    public List<Product> decrementTrees(String productID);
    
    public List<Product> decrementSeeds(String productID);
    
    public List<Product> decrementCultureBoxes(String productID);
    
    public List<Product> decrementGenomics(String productID);
    
    public List<Product> decrementProcessing(String productID);
    
    public List<Product> decrementReferenceMaterials(String productID);
}
