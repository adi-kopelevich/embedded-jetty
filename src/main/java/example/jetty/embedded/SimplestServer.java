package example.jetty.embedded;

import org.eclipse.jetty.server.Server;

/**
 * Created by kopelevi on 05/10/2015.
 */
public class SimplestServer {


    /**
     * The simplest possible Jetty server.
     */

    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        server.setHandler(new BasicHandler());
        server.start();
        server.dumpStdErr();
        server.join();

    }

}
