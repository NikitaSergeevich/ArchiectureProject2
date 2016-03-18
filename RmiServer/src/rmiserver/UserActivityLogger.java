/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiserver;

import common.Constansts;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author isakhankov
 */
public class UserActivityLogger {

    private java.sql.Statement sqlStatement;

    public UserActivityLogger() {
        Connection dbConnection;
        try {
            dbConnection = DriverManager.getConnection(Constansts.USER_ACTIVITY_URL, Constansts.DATABASE_LOGIN, Constansts.DATABASE_PASSWORD);
            sqlStatement = dbConnection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(UserActivityLogger.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void logLogin(String user, String applicationName) {
        try {
            String query = "INSERT INTO useractivity (applicationname, "
                    + "message, date) VALUES ( '"
                    + applicationName + "', " + "' User: \"" + user + "\" has logged in', '"
                    + new Date() + "');";
            sqlStatement.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(UserActivityLogger.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
