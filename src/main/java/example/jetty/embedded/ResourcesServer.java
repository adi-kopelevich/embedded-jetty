package example.jetty.embedded;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ResourceHandler;
//import org.eclipse.jetty.server.handler.gzip.GzipHandler;

/**
 * Created by kopelevi on 05/10/2015.
 */
public class ResourcesServer {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);

        ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.setDirectoriesListed(true);
        resourceHandler.setResourceBase("C:\\projects\\embedded-server\\root\\");
        resourceHandler.setWelcomeFiles(new String[]{"index.html"});
//
//
//        GzipHandler gzip = new GzipHandler();
//        server.setHandler(gzip);
//        HandlerList handlers = new HandlerList();
//        handlers.setHandlers(new Handler[]{resourceHandler, new DefaultHandler()});
//        gzip.setHandler(handlers);

        server.start();
        server.join();
    }
}
