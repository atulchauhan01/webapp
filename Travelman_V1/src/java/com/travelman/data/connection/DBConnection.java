package com.travelman.data.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import org.apache.log4j.Logger;

public class DBConnection {
    private Logger log=Logger.getLogger(DBConnection.class);

    private static DBConnection dbconnection;
    private static int counter = 0;

    private DBConnection() {

    }

    /**
     * Return Connection Instance
     *
     * @return
     */
    public static DBConnection getConnectionInstance() {

        if (dbconnection == null) {
            dbconnection = new DBConnection();
        }
        return dbconnection;
    }

    /**
     * @return Connection
     * @throws SQLException
     */
    public Connection getConnection() throws SQLException {
        log.info("Welcome in  getConnection()");
        counter++;
        log.info("Counter ::: "+counter);
        Connection con = null;
        try {
            ResourceBundle rBundle = ResourceBundle.getBundle("Travelman");
            /**             * 
             * Code for JNDI connection.
             */
            String dbjndi = rBundle.getString("JNDI_NAME");
            //log.info("dbjndi name ::: "+dbjndi);
            Context initContext = new InitialContext();
            //log.info("initContext ::: "+initContext);
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            //log.info("envContext ::: "+envContext);
            DataSource ds = (DataSource) envContext.lookup(dbjndi);
            //log.info("DS :::  "+ds);
            con = ds.getConnection();
            //log.info("con :::"+con);

            /**
             * Code for simple jdbc connection using property file.
             */
            /*                     
             String m_Driver = rBundle.getString("DRIVER");
             String m_Url = rBundle.getString("URL");
             String username = rBundle.getString("USERNAME");
             String password = rBundle.getString("PASSWORD");
             Class.forName(m_Driver).newInstance();
             con = DriverManager.getConnection(m_Url, username, password);
             */
        } catch (Exception e) {
            log.info(e);            
        }
        return con;
    }


    public static void main(String args[]) throws SQLException {
        Connection conn = new DBConnection().getConnection();
        if (conn != null) {
            System.out.println("Connection is OKEY");
        }
    }

}
