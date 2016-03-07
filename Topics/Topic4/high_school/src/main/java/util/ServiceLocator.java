/**
 * 
 */
package util;



import java.sql.Connection;
import java.sql.*;
import java.sql.SQLException;

import business.User;

/**
 *
 */
public class ServiceLocator {

    /**
     * Instance of ServiceLocator
     */
    private static ServiceLocator instance = null;

    /**
     *Connection shared to the DB
     * 
     */
    private Connection connection = null;

    /**
     * Flag that indicates the state from the connection
       */
    private boolean connectionFree = true;
    /**
     * Here it goes the string for to realize the consults
     * 
     */
    private String sqlString = null;

    /**
     * @return instance of ServiceLocator for manipulate the connection
     */
    public static ServiceLocator getInstance(User user) {

        if (instance == null) {
            try {
                instance = new ServiceLocator(user);
                
            } catch (MException e) {
                System.out.println(e.getMessage());
            }
        }

        return instance;

    }

    private ServiceLocator(User user) throws MException {

        try {
            //Register  the Driver and  create the connection
            String url = "jdbc:mysql://localhost/high_school?autoReconnect=true&useSSL=false";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(url, user.getUser(), user.getPasswd());
            connection.setAutoCommit(false);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            throw new MException("ServiceLocator", "ERROR_CONEXION_BD " + e);
        }
    }



    /**
     * Take the connection for that  any process can be used
     *
     * @return the connection to DB
     */
    public synchronized Connection takeConnection() {
        while (!connectionFree) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        connectionFree = false;
        notify();
        return connection;
    }

    /**
     * Break free the connection to DB for that other process can be used
     */
    public synchronized void breakFreeConnection() {
        while (connectionFree) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        connectionFree = true;
        notify();
    }

    /**
     * Close the connection to DB when is finished of to execute the program
     * 
     */
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 
     * Realize the changes in the DB. With this method ensures that
     * don´t exist inconsistencies in the DB
     */
    public void commit() {
        try {
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Undo the changes in DB. With this method ensures that don´t existence inconsistencies.
     */
    public void rollback() {
        try {
            connection.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
