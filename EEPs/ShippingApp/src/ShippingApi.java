
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    Statement s;

    public ShippingApi() {
        try {
            Connection DBConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/orderinfo", "remote", "remote_pass");
            Statement s = DBConn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ShippingApi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Order getOrder(int id) {
        try {
            String SQLStatement = "SELECT * FROM orders WHERE order_id = " + id;
            ResultSet res = s.executeQuery(SQLStatement);
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
}
