/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

/**
 *
 * @author isakhankov
 */
public class Constansts {

    private Constansts() {
        //To prevent creation instance of the class
    }

    public static String RMI_NAME = "project2";
    public static int INVALID_RESULT = -1;
    
    /***
     * APPLICATION NAMES
     */
    public static String INVENTORY_MANAGER = "inventorymanager";
    public static String ORDER_MANAGER = "ordermanager";
    public static String SHIPPING_MANAGER = "shippingmanager";
    
    /**
     * *
     * DATABASE CREDENTIALS
     */
    public static String DATABASE_LOGIN = "remote";
    public static String DATABASE_PASSWORD = "remote_pass";

    /**
     * *
     * DATABASE NAMES
     */
    public static String USER_ACTIVITY_URL = "jdbc:mysql://localhost:3306/useractivities";
    public static String LEAF_TECH_URL = "jdbc:mysql://localhost:3306/leaftech";
    public static String INVENTORY_URL = "jdbc:mysql://localhost:3306/inventory";
    public static String ORDERINFO_URL = "jdbc:mysql://localhost:3306/orderinfo";

    /**
     * *
     * COLUMN NAMES
     */
    public static String USER_LOGIN = "login";
    public static String USER_PASSWORD = "password";
}
