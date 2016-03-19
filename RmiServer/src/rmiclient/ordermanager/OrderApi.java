/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiclient.ordermanager;

import common.Constansts;
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
public class OrderApi {

    Statement inventoryStatement;

    public OrderApi() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection inventoryConnection = DriverManager.getConnection(Constansts.INVENTORY_URL, "remote", "remote_pass");
            inventoryStatement = inventoryConnection.createStatement();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(OrderApi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Product> getTrees() {
        try {
            ResultSet res = inventoryStatement.executeQuery("Select * from trees");
            List<Product> products = new ArrayList<>();
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
            Logger.getLogger(OrderApi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
