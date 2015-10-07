package example.jetty.embedded;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;

/**
 * Created by kopelevi on 05/10/2015.
 */
public class OneConnectorServer {

    public static void main(String[] args) throws Exception {
        Server server = new Server();

        ServerConnector httpConnector = new ServerConnector(server);
        httpConnector.setHost("localhost");
        httpConnector.setPort(8080);
        httpConnector.setIdleTimeout(30000);

        server.addConnector(httpConnector);

        server.setHandler(new BasicHandler());

        server.start();
        server.join();

    }
}
