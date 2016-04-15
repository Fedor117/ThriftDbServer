package controller;

import controller.gen.LocalNetsService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

/**
 * Created by Dzmitry Saladukha on 15.04.2016.
 */
public class EntryPoint {
    public static void main(String[] args) {
        try {
            TTransport transport;
            transport = new TSocket("localhost", 9090);
            transport.open();

            TProtocol protocol = new TBinaryProtocol(transport);
            LocalNetsService.Client client = new LocalNetsService.Client(protocol);

            perform(client);
        } catch (TException e) {
            e.printStackTrace();
        }
    }

    private static void perform(LocalNetsService.Client client) throws TException {
        System.out.println("Сеть — " + client.findAndPost("Сеть"));
        System.out.println("Сервер — " + client.findAndPost("Сервер"));
        System.out.println("Локальные сети — " + client.findAndPost("Локальные сети"));
        System.out.println("Концентратор — " + client.findAndPost("Концентратор"));
        System.out.println("Коммутатор — " + client.findAndPost("Коммутатор"));
        System.out.println("Протоколы TCP/IP — " + client.findAndPost("Протоколы TCP/IP"));
    }
}
