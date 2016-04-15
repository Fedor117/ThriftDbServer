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

    private Statement statement;
    private String    definition;
    private ResultSet resultSet;

    @Override
    public String findAndPost(String responce) throws TException {
        Connection connection = DbConnection.connection;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(responce);
            while(resultSet.next()) {
                definition = resultSet.getString("definition");
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return definition;
    }
}
