package rmiclient.inventorymanager;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author n.avrelin
 */
public class DbCalls {

    Connection DBConn = null;
    ResultSet res = null;
    
    public int insert(String tableName, String productID,
            int quantity, String description, float perUnitCost) {
        int executeUpdateVal = 0;
        try {
            // create an SQL statement variable and create the INSERT
            // query to insert the new inventory into the database
            java.sql.Statement s = DBConn.createStatement();
            String SQLstatement = ("INSERT INTO " + tableName + " (productid, "
                    + "productdescription, productquantity, productprice) VALUES ( '"
                    + productID + "', " + "'" + description + "', "
                    + quantity + ", " + perUnitCost + ");");
            // execute the update
            executeUpdateVal = s.executeUpdate(SQLstatement);
        } catch (Exception ex) {
            return 0;
        }

        return executeUpdateVal;
    }

    ResultSet selectAll(String tablename) {
        int executeUpdateVal = 0;
        String query = "Select * from " + tablename;
        try {
            // create an SQL statement variable and create the INSERT
            // query to insert the new inventory into the database
            java.sql.Statement s = DBConn.createStatement();
            res = s.executeQuery(query);
        } catch (Exception ex) {
            return null;
        }

        return res;
    }

    int delete(String tablename, String filedname, String productID) {
        String query = "DELETE FROM " + tablename + " WHERE productid = '"
                + productID + "';";
        int executeUpdateVal = 0;

        try {
            // create an SQL statement variable and create the DELETE
            // query to delete new inventory from the database
            java.sql.Statement s = DBConn.createStatement();
            // execute the delete query
            executeUpdateVal = s.executeUpdate(query);
        } catch (Exception ex) {
            return 0;
        }

        return executeUpdateVal;
    }

    public ResultSet decrementCount(String tablename, String filedname, String productID) {
        int executeUpdateVal = 0;
        String sqlStatement = ("UPDATE " + tablename
                + " set quantity=(quantity-1) where " + filedname + " = '"
                + productID + "';");
        String SQLstatement2 = ("SELECT * from " + tablename
                + " where " + filedname + " = '" + productID + "';");

        try {
            // execute the update, then query the BD for the table entry for the item just changed
            java.sql.Statement s = DBConn.createStatement();
            // execute the delete query
            executeUpdateVal = s.executeUpdate(sqlStatement);
            res = s.executeQuery(SQLstatement2);
        } catch (Exception ex) {
            return null;
        }

        return res;
    }
}
