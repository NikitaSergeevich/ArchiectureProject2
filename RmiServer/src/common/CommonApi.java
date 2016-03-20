/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import common.pojo.Order;
import common.pojo.OrderItem;
import common.pojo.Product;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author isakhankov
 */
public class CommonApi implements ICommonApi {

    private Statement orderInfoStatement;
    private Statement inventoryStatement;
    private Statement leaftechStatement;

    public CommonApi() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection orderInfoConnection = DriverManager.getConnection(Constansts.ORDERINFO_URL, Constansts.DATABASE_LOGIN, Constansts.DATABASE_PASSWORD);
            orderInfoStatement = orderInfoConnection.createStatement();

            Connection inventoryConnection = DriverManager.getConnection(Constansts.INVENTORY_URL, Constansts.DATABASE_LOGIN, Constansts.DATABASE_PASSWORD);
            inventoryStatement = inventoryConnection.createStatement();

            Connection leaftechConnection = DriverManager.getConnection(Constansts.LEAF_TECH_URL, Constansts.DATABASE_LOGIN, Constansts.DATABASE_PASSWORD);
            leaftechStatement = leaftechConnection.createStatement();

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CommonApi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Order getOrder(int id) {
        try {
            String SQLStatement = "SELECT * FROM orders WHERE order_id = " + id;
            ResultSet res = orderInfoStatement.executeQuery(SQLStatement);
            Order order = new Order();
            while (res.next()) {
                order.setTableName(res.getString(9));         // name of table with list of items
                order.setFirstName(res.getString(3)); // first name
                order.setLastName(res.getString(4)); // last name
                order.setPhone(res.getString(6)); // phone
                order.setDate(res.getString(2)); // order date
                order.setAddress(res.getString(5));  // address
            }
            return order;
        } catch (SQLException ex) {
            Logger.getLogger(CommonApi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Order> getOrders() {
        try {
            String SQLStatement = "Select * from orders";
            ResultSet res = orderInfoStatement.executeQuery(SQLStatement);
            List<Order> orders = new ArrayList<>();
            while (res.next()) {
                Order order = new Order();
                order.setOrderNumber(res.getString(1));
                order.setTableName(res.getString(9));         // name of table with list of items
                order.setFirstName(res.getString(3)); // first name
                order.setLastName(res.getString(4)); // last name
                order.setPhone(res.getString(6)); // phone
                order.setDate(res.getString(2)); // order date
                order.setAddress(res.getString(5));  // address
                order.setShippedStatus(Integer.parseInt(res.getString(8)));
                orders.add(order);
            }
            return orders;
        } catch (SQLException ex) {
            Logger.getLogger(CommonApi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<OrderItem> getOrderItems(String orderTable) {
        try {
            String SQLStatement = "SELECT * FROM " + orderTable;
            ResultSet res = orderInfoStatement.executeQuery(SQLStatement);
            List<OrderItem> items = new ArrayList<>();
            while (res.next()) {
                OrderItem item = new OrderItem();
                item.setId(res.getString(1));
                item.setProductId(res.getString(2));
                item.setDescription(res.getString(3));
                item.setPrice(res.getString(4));
                items.add(item);

            }
            return items;
        } catch (SQLException ex) {
            Logger.getLogger(CommonApi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public int updateShippedStatus(int id, boolean status) {
        try {
            String SQLStatement = "UPDATE orders SET shipped=" + status + " WHERE order_id=" + id;
            int rows = orderInfoStatement.executeUpdate(SQLStatement);
            return rows;
        } catch (SQLException ex) {
            Logger.getLogger(CommonApi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    private List<Product> parseProductResultSet(ResultSet res) {
        List<Product> products = new ArrayList<>();
        try {
            while (res.next()) {
                Product product = new Product();
                product.setProductCode(res.getString(1));
                product.setDescription(res.getString(2));
                product.setQuantity(res.getInt(3));
                product.setPrice(res.getFloat(4));
                products.add(product);
            }
            return products;
        } catch (SQLException ex) {
            Logger.getLogger(CommonApi.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<Product> getShrubs() {
        try {
            ResultSet res = inventoryStatement.executeQuery("Select * from shrubs");
            if (res != null) {
                return parseProductResultSet(res);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommonApi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Product> getTrees() {
        try {
            ResultSet res = inventoryStatement.executeQuery("Select * from trees");
            if (res != null) {
                return parseProductResultSet(res);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommonApi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Product> getSeeds() {
        try {
            ResultSet res = inventoryStatement.executeQuery("Select * from seeds");
            if (res != null) {
                return parseProductResultSet(res);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommonApi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Product> getCultureBoxes() {
        try {
            ResultSet res = leaftechStatement.executeQuery("Select * from cultureboxes");
            if (res != null) {
                return parseProductResultSet(res);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommonApi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Product> getGenomics() {
        try {
            ResultSet res = leaftechStatement.executeQuery("Select * from genomics");
            if (res != null) {
                return parseProductResultSet(res);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommonApi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Product> getProcessing() {
        try {
            ResultSet res = leaftechStatement.executeQuery("Select * from processing");
            if (res != null) {
                return parseProductResultSet(res);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommonApi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Product> getReferenceMaterials() {
        try {
            ResultSet res = leaftechStatement.executeQuery("Select * from referencematerials");
            if (res != null) {
                return parseProductResultSet(res);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommonApi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public int insertShrubs(String productID, int quantity, String description,
            float perUnitCost) {
        try {
            int res = inventoryStatement.executeUpdate("INSERT INTO shrubs (product_code, "
                    + "productdescription, productquantity, productprice) VALUES ( '"
                    + productID + "', " + "'" + description + "', "
                    + quantity + ", " + perUnitCost + ");");
            if (res != -1) {
                return res;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommonApi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Constansts.INVALID_RESULT;
    }

    @Override
    public int insertTrees(String productID, int quantity, String description,
            float perUnitCost) {
        try {
            int res = inventoryStatement.executeUpdate("INSERT INTO trees (product_code, "
                    + "productdescription, productquantity, productprice) VALUES ( '"
                    + productID + "', " + "'" + description + "', "
                    + quantity + ", " + perUnitCost + ");");
            if (res != -1) {
                return res;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommonApi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Constansts.INVALID_RESULT;
    }

    @Override
    public int insertSeeds(String productID, int quantity, String description,
            float perUnitCost) {
        try {
            int res = inventoryStatement.executeUpdate("INSERT INTO seeds (product_code, "
                    + "productdescription, productquantity, productprice) VALUES ( '"
                    + productID + "', " + "'" + description + "', "
                    + quantity + ", " + perUnitCost + ");");
            if (res != -1) {
                return res;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommonApi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Constansts.INVALID_RESULT;
    }

    @Override
    public int insertCultureBoxes(String productID, int quantity, String description,
            float perUnitCost) {
        try {
            int res = leaftechStatement.executeUpdate("INSERT INTO cultureboxes (productid, "
                    + "productdescription, productquantity, productprice) VALUES ( '"
                    + productID + "', " + "'" + description + "', "
                    + quantity + ", " + perUnitCost + ");");
            if (res != -1) {
                return res;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommonApi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Constansts.INVALID_RESULT;
    }

    @Override
    public int insertGenomics(String productID, int quantity, String description,
            float perUnitCost) {
        try {
            int res = leaftechStatement.executeUpdate("INSERT INTO genomics (productid, "
                    + "productdescription, productquantity, productprice) VALUES ( '"
                    + productID + "', " + "'" + description + "', "
                    + quantity + ", " + perUnitCost + ");");
            if (res != -1) {
                return res;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommonApi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Constansts.INVALID_RESULT;
    }

    @Override
    public int insertProcessing(String productID, int quantity, String description,
            float perUnitCost) {
        try {
            int res = leaftechStatement.executeUpdate("INSERT INTO processing (productid, "
                    + "productdescription, productquantity, productprice) VALUES ( '"
                    + productID + "', " + "'" + description + "', "
                    + quantity + ", " + perUnitCost + ");");
            if (res != -1) {
                return res;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommonApi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Constansts.INVALID_RESULT;
    }

    @Override
    public int insertReferenceMaterials(String productID, int quantity, String description,
            float perUnitCost) {
        try {
            int res = leaftechStatement.executeUpdate("INSERT INTO referencematerials (productid, "
                    + "productdescription, productquantity, productprice) VALUES ( '"
                    + productID + "', " + "'" + description + "', "
                    + quantity + ", " + perUnitCost + ");");
            if (res != -1) {
                return res;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommonApi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Constansts.INVALID_RESULT;
    }

    @Override
    public int deleteShrubs(String productID) {
        String query = "DELETE FROM shrubs WHERE product_code = '"
                + productID + "';";
        try {
            // execute the delete query
            int res = inventoryStatement.executeUpdate(query);
            return res;
        } catch (Exception ex) {
            Logger.getLogger(CommonApi.class.getName()).log(Level.SEVERE, null, ex);
            return Constansts.INVALID_RESULT;
        }
    }

    @Override
    public int deleteTrees(String productID) {
        String query = "DELETE FROM trees WHERE product_code = '"
                + productID + "';";
        try {
            // execute the delete query
            int res = inventoryStatement.executeUpdate(query);
            return res;
        } catch (Exception ex) {
            Logger.getLogger(CommonApi.class.getName()).log(Level.SEVERE, null, ex);
            return Constansts.INVALID_RESULT;
        }
    }

    @Override
    public int deleteSeeds(String productID) {
        String query = "DELETE FROM seeds WHERE product_code = '"
                + productID + "';";
        try {
            // execute the delete query
            int res = inventoryStatement.executeUpdate(query);
            return res;
        } catch (Exception ex) {
            Logger.getLogger(CommonApi.class.getName()).log(Level.SEVERE, null, ex);
            return Constansts.INVALID_RESULT;
        }
    }

    @Override
    public int deleteCultureBoxes(String productID) {
        String query = "DELETE FROM cultureboxes WHERE productid = '"
                + productID + "';";
        try {
            // execute the delete query
            int res = leaftechStatement.executeUpdate(query);
            return res;
        } catch (Exception ex) {
            Logger.getLogger(CommonApi.class.getName()).log(Level.SEVERE, null, ex);
            return Constansts.INVALID_RESULT;
        }
    }

    @Override
    public int deleteGenomics(String productID) {
        String query = "DELETE FROM genomics WHERE productid = '"
                + productID + "';";
        try {
            // execute the delete query
            int res = leaftechStatement.executeUpdate(query);
            return res;
        } catch (Exception ex) {
            Logger.getLogger(CommonApi.class.getName()).log(Level.SEVERE, null, ex);
            return Constansts.INVALID_RESULT;
        }
    }

    @Override
    public int deleteProcessing(String productID) {
        String query = "DELETE FROM processing WHERE productid = '"
                + productID + "';";
        try {
            // execute the delete query
            int res = leaftechStatement.executeUpdate(query);
            return res;
        } catch (Exception ex) {
            Logger.getLogger(CommonApi.class.getName()).log(Level.SEVERE, null, ex);
            return Constansts.INVALID_RESULT;
        }
    }

    @Override
    public int deleteReferenceMaterials(String productID) {
        String query = "DELETE FROM shrubs WHERE productid = '"
                + productID + "';";
        try {
            // execute the delete query
            int res = leaftechStatement.executeUpdate(query);
            return res;
        } catch (Exception ex) {
            Logger.getLogger(CommonApi.class.getName()).log(Level.SEVERE, null, ex);
            return Constansts.INVALID_RESULT;
        }
    }

    @Override
    public List<Product> decrementShrubs(String productID) {
        String SQLStatement1 = ("UPDATE shrubs set quantity=(quantity-1) where product_code = '" + productID + "';");
        String SQLStatement2 = ("SELECT * from shrubs where product_code = '" + productID + "';");
        try {
            // execute the delete query
            inventoryStatement.executeUpdate(SQLStatement1);
            ResultSet res = inventoryStatement.executeQuery(SQLStatement2);
            if (res != null) {
                return parseProductResultSet(res);
            }
        } catch (Exception ex) {
            Logger.getLogger(CommonApi.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return null;
    }

    @Override
    public List<Product> decrementTrees(String productID) {
        String SQLStatement1 = ("UPDATE trees set quantity=(quantity-1) where product_code = '" + productID + "';");
        String SQLStatement2 = ("SELECT * from trees where product_code = '" + productID + "';");
        try {
            // execute the delete query
            inventoryStatement.executeUpdate(SQLStatement1);
            ResultSet res = inventoryStatement.executeQuery(SQLStatement2);
            if (res != null) {
                return parseProductResultSet(res);
            }
        } catch (Exception ex) {
            Logger.getLogger(CommonApi.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return null;
    }

    @Override
    public List<Product> decrementSeeds(String productID) {
        String SQLStatement1 = ("UPDATE seeds set quantity=(quantity-1) where product_code = '" + productID + "';");
        String SQLStatement2 = ("SELECT * from seeds where product_code = '" + productID + "';");
        try {
            // execute the delete query
            inventoryStatement.executeUpdate(SQLStatement1);
            ResultSet res = inventoryStatement.executeQuery(SQLStatement2);
            if (res != null) {
                return parseProductResultSet(res);
            }
        } catch (Exception ex) {
            Logger.getLogger(CommonApi.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return null;
    }

    @Override
    public List<Product> decrementCultureBoxes(String productID) {
        String SQLStatement1 = ("UPDATE cultureboxes set quantity=(quantity-1) where productid = '" + productID + "';");
        String SQLStatement2 = ("SELECT * from cultureboxes where productid = '" + productID + "';");
        try {
            // execute the delete query
            inventoryStatement.executeUpdate(SQLStatement1);
            ResultSet res = inventoryStatement.executeQuery(SQLStatement2);
            if (res != null) {
                return parseProductResultSet(res);
            }
        } catch (Exception ex) {
            Logger.getLogger(CommonApi.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return null;
    }

    @Override
    public List<Product> decrementGenomics(String productID) {
        String SQLStatement1 = ("UPDATE genomics set quantity=(quantity-1) where productid = '" + productID + "';");
        String SQLStatement2 = ("SELECT * from genomics where productid = '" + productID + "';");
        try {
            // execute the delete query
            inventoryStatement.executeUpdate(SQLStatement1);
            ResultSet res = inventoryStatement.executeQuery(SQLStatement2);
            if (res != null) {
                return parseProductResultSet(res);
            }
        } catch (Exception ex) {
            Logger.getLogger(CommonApi.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return null;
    }

    @Override
    public List<Product> decrementProcessing(String productID) {
        String SQLStatement1 = ("UPDATE processing set quantity=(quantity-1) where productid = '" + productID + "';");
        String SQLStatement2 = ("SELECT * from processing where productid = '" + productID + "';");
        try {
            // execute the delete query
            inventoryStatement.executeUpdate(SQLStatement1);
            ResultSet res = inventoryStatement.executeQuery(SQLStatement2);
            if (res != null) {
                return parseProductResultSet(res);
            }
        } catch (Exception ex) {
            Logger.getLogger(CommonApi.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return null;
    }

    @Override
    public List<Product> decrementReferenceMaterials(String productID) {
        String SQLStatement1 = ("UPDATE referencematerials set quantity=(quantity-1) where productid = '" + productID + "';");
        String SQLStatement2 = ("SELECT * from referencematerials where productid = '" + productID + "';");
        try {
            // execute the delete query
            inventoryStatement.executeUpdate(SQLStatement1);
            ResultSet res = inventoryStatement.executeQuery(SQLStatement2);
            if (res != null) {
                return parseProductResultSet(res);
            }
        } catch (Exception ex) {
            Logger.getLogger(CommonApi.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return null;
    }

    @Override
    public int createOrderItemTable(String tableName) {
        try {
            String SQLstatement = ("CREATE TABLE " + tableName
                    + "(item_id int unsigned not null auto_increment primary key, "
                    + "product_id varchar(20), description varchar(80), "
                    + "item_price float(7,2) );");
            int result = orderInfoStatement.executeUpdate(SQLstatement);

            return result;
        } catch (SQLException ex) {
            Logger.getLogger(CommonApi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Constansts.INVALID_RESULT;
    }

    @Override
    public int dropOrderItemTable(String tableName) {
        try {
            String SQLstatement = ("DROP TABLE " + tableName + ";");
            int result = orderInfoStatement.executeUpdate(SQLstatement);

            return result;
        } catch (SQLException ex) {
            Logger.getLogger(CommonApi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Constansts.INVALID_RESULT;
    }

    @Override
    public int createOrder(Order order) {
        try {
            String SQLstatement = ("INSERT INTO orders (order_date, " + "first_name, "
                    + "last_name, address, phone, total_cost, shipped, "
                    + "ordertable) VALUES ( '" + order.getDate() + "', "
                    + "'" + order.getFirstName() + "', " + "'" + order.getLastName() + "', "
                    + "'" + order.getAddress() + "', " + "'" + order.getPhone() + "', "
                    + order.getCost() + ", " + order.getShippedStatus() + ", '" + order.getOrderTableName() + "' );");
            int result = orderInfoStatement.executeUpdate(SQLstatement);

            return result;
        } catch (SQLException ex) {
            Logger.getLogger(CommonApi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Constansts.INVALID_RESULT;
    }

    @Override
    public int createOrderItem(String tableName, String productId, String description, float perUnitCost) {
        try {
            String SQLstatement = ("INSERT INTO " + tableName
                    + " (product_id, description, item_price) "
                    + "VALUES ( '" + productId + "', " + "'"
                    + description + "', " + perUnitCost + " );");
            int result = orderInfoStatement.executeUpdate(SQLstatement);

            return result;
        } catch (SQLException ex) {
            Logger.getLogger(CommonApi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Constansts.INVALID_RESULT;
    }

}
