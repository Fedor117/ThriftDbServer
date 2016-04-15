package controller;

import controller.gen.LocalNetsService;
import model.DbConnection;
import org.apache.thrift.TException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Fedor on 15.04.2016.
 */
public class ThriftRpcHandler implements LocalNetsService.Iface {

    private PreparedStatement getDefinitionStatement;
    private String    definition;
    private ResultSet resultSet;
    private String getDefinitionQuery = "SELECT definition FROM local_nets WHERE name = ?;";

    public ThriftRpcHandler() {
        Connection connection = DbConnection.connection;
        try {
            getDefinitionStatement = connection.prepareStatement(getDefinitionQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String findAndPost(String responce) throws TException {
        try {
            getDefinitionStatement.setString(1, responce);
            resultSet = getDefinitionStatement.executeQuery();
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
