package example.jetty.embedded;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;

/**
 * Created by kopelevi on 05/10/2015.
 */
public class OneContextServer {

    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);

        ContextHandler contextHandler = new ContextHandler();
        contextHandler.setContextPath("/hi");
        contextHandler.setHandler(new BasicHandler());

        server.setHandler(contextHandler);

        server.start();
        server.join();

    }
}
