/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiserver;

import common.Constansts;
import java.rmi.RemoteException;
import common.IRmiApi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author isakhankov
 */
class RmiApi implements IRmiApi {

    public RmiApi() {
    }

    @Override
    public int executeTask() throws RemoteException {
        return 42;
    }

    @Override
    public String login(String login, String password) throws RemoteException {
        try {
            Connection dbConnection = DriverManager.getConnection(Constansts.USER_ACTIVITY_URL, Constansts.DATABASE_LOGIN, Constansts.DATABASE_PASSWORD);
            java.sql.Statement sqlStatement = dbConnection.createStatement();
            String query = "SELECT password FROM user WHERE login = '" + login + "'";
            ResultSet result = sqlStatement.executeQuery(query);
            if (result.next()) {
                String expectedPassword = result.getString(Constansts.USER_PASSWORD);
                if (password.equals(expectedPassword)) {
                    return generateToken();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(RmiApi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private String generateToken() {
        //TODO
        return "Super Token";
    }

}
