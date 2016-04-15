package controller;

import controller.gen.LocalNetsService;
import model.DbConnection;

/**
 * Created by Fedor on 15.04.2016.
 */
public class ThriftRpcServer {

    private ThriftRpcHandler handler;
    private LocalNetsService.Processor<ThriftRpcHandler> processor;
    private ProcessorRunner runner;

    public ThriftRpcServer() {
        try {
            DbConnection dbConnection = DbConnection.getInstance();
            dbConnection.connectToDb();

            handler   = new ThriftRpcHandler();
            processor = new LocalNetsService.Processor<ThriftRpcHandler>(handler);
            runner    = new ProcessorRunner(processor);

            new Thread(runner).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
