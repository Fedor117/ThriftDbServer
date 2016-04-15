package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * Created by Fedor on 15.04.2016.
 */
public class StartingServlet extends HttpServlet {

    public void init() throws ServletException {
        new ThriftRpcServer();
    }

}
