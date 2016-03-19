
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author isakhankov
 */
public class ShippingApi {

    Statement orderInfoStatement;

    public ShippingApi() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection orderInfoConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/orderinfo", "remote", "remote_pass");
            orderInfoStatement = orderInfoConnection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ShippingApi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ShippingApi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
            Logger.getLogger(ShippingApi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Order> getOrders() {
        try {
            String SQLStatement = "Select * from orders";
            ResultSet res = orderInfoStatement.executeQuery(SQLStatement);
            List<Order> orders = new ArrayList<Order>();
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
            Logger.getLogger(ShippingApi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<OrderItem> getOrderItems(String orderTable) {
        try {
            String SQLStatement = "SELECT * FROM " + orderTable;
            ResultSet res = orderInfoStatement.executeQuery(SQLStatement);
            List<OrderItem> items = new ArrayList<OrderItem>();
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
            Logger.getLogger(ShippingApi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int updateShippedStatus(int id, boolean status) {
        try {
            String SQLStatement = "UPDATE orders SET shipped=" + status + " WHERE order_id=" + id;
            int rows = orderInfoStatement.executeUpdate(SQLStatement);
            return rows;
        } catch (SQLException ex) {
            Logger.getLogger(ShippingApi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
}
