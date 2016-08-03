package controller;

import controller.gen.LocalNetsService;
import org.apache.thrift.TApplicationException;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

/**
 * Created by Dzmitry Saladukha on 15.04.2016.
 */
public class Controller {
    private LocalNetsService.Client client;

    public Controller() {
        try {
            TTransport transport;
            transport = new TSocket("localhost", 9090);
            transport.open();

            TProtocol protocol = new TBinaryProtocol(transport);
            client = new LocalNetsService.Client(protocol);
        } catch (TException e) {
            e.printStackTrace();
        }
    }

    public String create(String name, String definition) {
        String response = null;
        try {
            response = client.createDef(name, definition);
        } catch (TException e) {
            e.printStackTrace();
        }
        return response;
    }

    public String read(String name) {
        String response = null;
        try {
            response = client.retrieveDef(name);
        } catch (TApplicationException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        }
        return response;
    }

    public String update(String name, String definition) {
        String response = null;
        try {
            response = client.updateDef(name, definition);
        } catch (TException e) {
            e.printStackTrace();
        }
        return response;
    }

    public String delete(String name) {
        String response = null;
        try {
            response = client.deleteDef(name);
        } catch (TApplicationException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        }
        return response;
    }
}
