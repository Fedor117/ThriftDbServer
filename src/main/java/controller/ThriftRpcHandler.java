package controller;

import controller.gen.LocalNetsService;
import model.DbConnection;
import org.apache.thrift.TException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Fedor on 15.04.2016.
 */
public class ThriftRpcHandler implements LocalNetsService.Iface {

    private static final String MESSAGE_CREATE = "Record added";
    private static final String MESSAGE_DELETE = "Record deleted";
    private static final String MESSAGE_UPDATE = "Record updated";

    private Statement statement;
    private String    definition;
    private ResultSet resultSet;

    @Override
    public String deleteDef(String responce) throws TException {
        Connection connection = DbConnection.connection;
        try {
            statement = connection.createStatement();
            String sql = "DELETE FROM local_nets WHERE name='" + responce + "';";
            statement.executeUpdate(sql);
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return MESSAGE_DELETE;
    }

    @Override
    public String updateDef(String responce, String definition)
            throws TException {
        Connection connection = DbConnection.connection;
        try {
            statement = connection.createStatement();
            String sql = "UPDATE local_nets SET definition = '" +
                    definition + "' WHERE name='" + responce + "';";
            statement.executeUpdate(sql);
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return MESSAGE_UPDATE;
    }

    @Override
    public String retrieveDef(String responce) throws TException {
        Connection connection = DbConnection.connection;
        try {
            statement = connection.createStatement();
            String sql = "SELECT * FROM local_nets WHERE name='" + responce + "';";
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()) {
                definition = resultSet.getString("definition");
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return definition;
    }

    @Override
    public String createDef(String responce, String definition)
            throws TException {
        Connection connection = DbConnection.connection;
        try {
            statement = connection.createStatement();
            String sql = "INSERT INTO local_nets( name, definition)" +
                    " VALUES ('" + responce +"', '" + definition + "');";
            statement.executeUpdate(sql);
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return MESSAGE_CREATE;
    }
}
