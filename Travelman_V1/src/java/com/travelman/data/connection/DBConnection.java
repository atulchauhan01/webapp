package com.travelman.data.connection;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;

public class DBConnection {

	private static DBConnection dbconnection;

	private DBConnection() {

	}
    
	/**
	 * Return  Connection Instance
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
	 * 
	 * @return
	 * @throws SQLException
	 */
	public Connection getConnection() throws SQLException {

		Connection con = null;
                

		try {

			String m_Driver = "com.mysql.jdbc.Driver";
			String m_Url = "jdbc:mysql://localhost:3306/trackman";                        
                        String username = "root";
                        String password = "root";
//                        String m_Url = "jdbc:mysql://68.67.69.9:3306/trackman";
//			String username = "trackman";
//			String password = "m!ntr!ck";
//                        
			Class.forName(m_Driver).newInstance();

			con = DriverManager.getConnection(m_Url, username, password);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;

	}

	protected Object clone() throws CloneNotSupportedException {

		throw new CloneNotSupportedException();

	}

	public static void main(String args[]) throws SQLException {
		DBConnection db = new DBConnection();
		Connection conn = db.getConnection();
                if(conn!=null){
                    System.out.println("Connection is OKEY");
                }
                

	}

}
