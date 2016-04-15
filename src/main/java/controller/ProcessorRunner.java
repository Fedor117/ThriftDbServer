package controller;

import controller.gen.LocalNetsService;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

/**
 * Created by Fedor on 15.04.2016.
 */
public class ProcessorRunner implements Runnable {

    private LocalNetsService.Processor processor;

    public ProcessorRunner(LocalNetsService.Processor processor) {
        this.processor = processor;
    }

    @Override
    public void run() {
        try {
            TServerTransport serverTransport = new TServerSocket(9090);
            TServer server = new TSimpleServer(new TServer.Args(serverTransport).processor(processor));

            System.out.println("Starting server on socket 9090.");
            server.serve();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
