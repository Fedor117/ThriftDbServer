package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Fedor on 15.04.2016.
 */
public class DbConnection {

    public  static Connection   connection;
    public  static Statement    statement;
    public  static ResultSet    resultSet;

    private static volatile  DbConnection instance = new DbConnection();

    private DbConnection() {

    }

    public static DbConnection getInstance() {
        DbConnection localInstance = instance;
        if (localInstance == null) {
            synchronized (DbConnection.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new DbConnection();
                }
            }
        }
        return localInstance;
    }

    public void connectToDb() {
        connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:local_nets_db.db");
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }
}
