/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiserver;

import common.Constansts;
import common.IRmiApi;
import common.RmiApi;
import common.IRmiSecureApi;
import common.pojo.Order;
import common.pojo.OrderItem;
import common.pojo.Product;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author isakhankov
 */
public class RmiSecureApi implements IRmiSecureApi {

    private Statement userStatement;

    private final IRmiApi api = new RmiApi();
    private static final Random random = new Random();
    private final UserActivityLogger logger = new UserActivityLogger();

    {
        try {
            Connection userConnection = DriverManager.getConnection(Constansts.USER_ACTIVITY_URL, Constansts.DATABASE_LOGIN, Constansts.DATABASE_PASSWORD);
            userStatement = userConnection.createStatement();

        } catch (SQLException ex) {
            Logger.getLogger(RmiApi.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public String login(String login, String password, String applicationName) throws RemoteException {
        try {
            String query = "SELECT password FROM user WHERE login = '" + login
                    + "' and applicationname = '" + applicationName + "'";
            ResultSet result = userStatement.executeQuery(query);

            if (result.next()) {
                String expectedPassword = result.getString(Constansts.USER_PASSWORD);
                if (password.equals(expectedPassword)) {
                    logger.logLogin(login, applicationName);
                    String token = generateToken();
                    query = "Update user set token = '" + token + "' WHERE login = '" + login
                            + "' and applicationname = '" + applicationName + "'";
                    userStatement.executeUpdate(query);
                    return token;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(RmiApi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private String generateToken() {
        return "token" + random.nextLong();
    }

    @Override
    public void logout(String token) throws RemoteException {
        try {
            String query = "SELECT login, applicationname FROM user WHERE token = '" + token
                    + "'";
            ResultSet result = userStatement.executeQuery(query);

            if (result.next()) {
                String login = result.getString(Constansts.USER_LOGIN);
                String applicationName = result.getString(Constansts.USER_APPLICATION_NAME);
                logger.logLogout(login, applicationName);
            }
            query = "UPDATE user SET token= null WHERE token = '" + token
                    + "'";
            userStatement.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(RmiApi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private boolean checkToken(String token) {
        try {
            String query = "SELECT login FROM user WHERE token = '" + token + "'";
            ResultSet result = userStatement.executeQuery(query);
            return result.next();
        } catch (SQLException ex) {
            Logger.getLogger(RmiSecureApi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Order getOrder(int id, String token) throws RemoteException {
        if (checkToken(token)) {
            return api.getOrder(id);
        }
        return null;
    }

    @Override
    public List<Order> getOrders(String token) throws RemoteException {
        if (checkToken(token)) {
            return api.getOrders();
        }
        return null;
    }

    @Override
    public List<OrderItem> getOrderItems(String orderTable, String token) throws RemoteException {
        if (checkToken(token)) {
            return api.getOrderItems(orderTable);
        }
        return null;
    }

    @Override
    public int updateShippedStatus(int id, boolean status, String token) throws RemoteException {
        if (checkToken(token)) {
            return api.updateShippedStatus(id, status);
        }
        return Constansts.INVALID_RESULT;
    }

    @Override
    public int createOrderItemTable(String tableName, String token) throws RemoteException {
        if (checkToken(token)) {
            return api.createOrderItemTable(tableName);
        }
        return Constansts.INVALID_RESULT;
    }

    @Override
    public int createOrder(Order order, String token) throws RemoteException {
        if (checkToken(token)) {
            return api.createOrder(order);
        }
        return Constansts.INVALID_RESULT;
    }

    @Override
    public int dropOrderItemTable(String tableName, String token) throws RemoteException {
        if (checkToken(token)) {
            return api.dropOrderItemTable(tableName);
        }
        return Constansts.INVALID_RESULT;
    }

    @Override
    public int createOrderItem(String tableName, String productId, String description, float perUnitCost, String token) throws RemoteException {
        if (checkToken(token)) {
            return api.createOrderItem(tableName, productId, description, perUnitCost);
        }
        return Constansts.INVALID_RESULT;
    }

    @Override
    public List<Product> getShrubs(String token) throws RemoteException {
        if (checkToken(token)) {
            return api.getShrubs();
        }
        return null;
    }

    @Override
    public List<Product> getSeeds(String token) throws RemoteException {
        if (checkToken(token)) {
            return api.getSeeds();
        }
        return null;
    }

    @Override
    public List<Product> getTrees(String token) throws RemoteException {
        if (checkToken(token)) {
            return api.getTrees();
        }
        return null;
    }

    @Override
    public List<Product> getCultureBoxes(String token) throws RemoteException {
        if (checkToken(token)) {
            return api.getCultureBoxes();
        }
        return null;
    }

    @Override
    public List<Product> getGenomics(String token) throws RemoteException {
        if (checkToken(token)) {
            return api.getGenomics();
        }
        return null;
    }

    @Override
    public List<Product> getProcessing(String token) throws RemoteException {
        if (checkToken(token)) {
            return api.getProcessing();
        }
        return null;
    }

    @Override
    public List<Product> getReferenceMaterials(String token) throws RemoteException {
        if (checkToken(token)) {
            return api.getReferenceMaterials();
        }
        return null;
    }

    @Override
    public int insertShrubs(String productID, int quantity, String description, float perUnitCost, String token) throws RemoteException {
        if (checkToken(token)) {
            return api.insertShrubs(productID, quantity, description, perUnitCost);
        }
        return Constansts.INVALID_RESULT;
    }

    @Override
    public int insertTrees(String productID, int quantity, String description, float perUnitCost, String token) throws RemoteException {
        if (checkToken(token)) {
            return api.insertTrees(productID, quantity, description, perUnitCost);
        }
        return Constansts.INVALID_RESULT;
    }

    @Override
    public int insertSeeds(String productID, int quantity, String description, float perUnitCost, String token) throws RemoteException {
        if (checkToken(token)) {
            return api.insertSeeds(productID, quantity, description, perUnitCost);
        }
        return Constansts.INVALID_RESULT;
    }

    @Override
    public int insertCultureBoxes(String productID, int quantity, String description, float perUnitCost, String token) throws RemoteException {
        if (checkToken(token)) {
            return api.insertCultureBoxes(productID, quantity, description, perUnitCost);
        }
        return Constansts.INVALID_RESULT;
    }

    @Override
    public int insertGenomics(String productID, int quantity, String description, float perUnitCost, String token) throws RemoteException {
        if (checkToken(token)) {
            return api.insertGenomics(productID, quantity, description, perUnitCost);
        }
        return Constansts.INVALID_RESULT;
    }

    @Override
    public int insertProcessing(String productID, int quantity, String description, float perUnitCost, String token) throws RemoteException {
        if (checkToken(token)) {
            return api.insertProcessing(productID, quantity, description, perUnitCost);
        }
        return Constansts.INVALID_RESULT;
    }

    @Override
    public int insertReferenceMaterials(String productID, int quantity, String description, float perUnitCost, String token) throws RemoteException {
        if (checkToken(token)) {
            return api.insertReferenceMaterials(productID, quantity, description, perUnitCost);
        }
        return Constansts.INVALID_RESULT;
    }

    @Override
    public int deleteShrubs(String productID, String token) throws RemoteException {
        if (checkToken(token)) {
            return api.deleteShrubs(productID);
        }
        return Constansts.INVALID_RESULT;
    }

    @Override
    public int deleteTrees(String productID, String token) throws RemoteException {
        if (checkToken(token)) {
            return api.deleteTrees(productID);
        }
        return Constansts.INVALID_RESULT;
    }

    @Override
    public int deleteSeeds(String productID, String token) throws RemoteException {
        if (checkToken(token)) {
            return api.deleteSeeds(productID);
        }
        return Constansts.INVALID_RESULT;
    }

    @Override
    public int deleteCultureBoxes(String productID, String token) throws RemoteException {
        if (checkToken(token)) {
            return api.deleteCultureBoxes(productID);
        }
        return Constansts.INVALID_RESULT;
    }

    @Override
    public int deleteGenomics(String productID, String token) throws RemoteException {
        if (checkToken(token)) {
            return api.deleteGenomics(productID);
        }
        return Constansts.INVALID_RESULT;
    }

    @Override
    public int deleteProcessing(String productID, String token) throws RemoteException {
        if (checkToken(token)) {
            return api.deleteProcessing(productID);
        }
        return Constansts.INVALID_RESULT;
    }

    @Override
    public int deleteReferenceMaterials(String productID, String token) throws RemoteException {
        if (checkToken(token)) {
            return api.deleteReferenceMaterials(productID);
        }
        return Constansts.INVALID_RESULT;
    }

    @Override
    public List<Product> decrementShrubs(String productID, String token) throws RemoteException {
        if (checkToken(token)) {
            return api.decrementShrubs(productID);
        }
        return null;
    }

    @Override
    public List<Product> decrementTrees(String productID, String token) throws RemoteException {
        if (checkToken(token)) {
            return api.decrementTrees(productID);
        }
        return null;
    }

    @Override
    public List<Product> decrementSeeds(String productID, String token) throws RemoteException {
        if (checkToken(token)) {
            return api.decrementSeeds(productID);
        }
        return null;
    }

    @Override
    public List<Product> decrementCultureBoxes(String productID, String token) throws RemoteException {
        if (checkToken(token)) {
            return api.decrementCultureBoxes(productID);
        }
        return null;
    }

    @Override
    public List<Product> decrementGenomics(String productID, String token) throws RemoteException {
        if (checkToken(token)) {
            return api.decrementGenomics(productID);
        }
        return null;
    }

    @Override
    public List<Product> decrementProcessing(String productID, String token) throws RemoteException {
        if (checkToken(token)) {
            return api.decrementProcessing(productID);
        }
        return null;
    }

    @Override
    public List<Product> decrementReferenceMaterials(String productID, String token) throws RemoteException {
        if (checkToken(token)) {
            return api.decrementReferenceMaterials(productID);
        }
        return null;
    }

}
