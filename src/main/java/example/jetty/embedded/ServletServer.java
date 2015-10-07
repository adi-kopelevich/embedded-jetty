package example.jetty.embedded;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

/**
 * Created by kopelevi on 05/10/2015.
 */
public class ServletServer {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8008);

        ServletHandler handler = new ServletHandler();
        server.setHandler(handler);


        handler.addServletWithMapping(BasicServlet.class, "/*");

        server.start();
        server.join();


    }
}
