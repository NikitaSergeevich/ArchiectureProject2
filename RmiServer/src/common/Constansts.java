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
public  class Constansts {
    private Constansts() {
        //To prevent creation instance of the class
    }
    
    public static String RMI_NAME = "project2";
    
    /***
     * DATABASE CREDENTIALS
     */
    public static String DATABASE_LOGIN = "remote";
    public static String DATABASE_PASSWORD = "remote_pass";
    
    /***
     * DATABASE NAMES
     */
    public static String USER_ACTIVITY_URL = "jdbc:mysql://localhost:3306/useractivities";
    public static String LEAF_TECH_URL = "jdbc:mysql://localhost:3306/leaftech";

    /***
     * COLUMN NAMES
     */
    public static String USER_LOGIN = "login";
    public static String USER_PASSWORD = "password";
}
