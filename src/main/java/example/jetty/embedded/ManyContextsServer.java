package example.jetty.embedded;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;

/**
 * Created by kopelevi on 05/10/2015.
 */
public class ManyContextsServer {

    public static void main(String[] args) throws Exception {

        Server server = new Server(8080);

        ContextHandler rootContextHandler = new ContextHandler();
        rootContextHandler.setContextPath("/");
        rootContextHandler.setHandler(new BasicHandler());

        ContextHandler frContextHandler = new ContextHandler();
        frContextHandler.setContextPath("/fr");
        frContextHandler.setHandler(new BasicHandler("Bonjoir"));

        ContextHandler itContextHandler = new ContextHandler();
        itContextHandler.setContextPath("/it");
        itContextHandler.setHandler(new BasicHandler("Bongiorno"));

        ContextHandler virtualContextHandler = new ContextHandler();
        virtualContextHandler.setContextPath("/");
        virtualContextHandler.setVirtualHosts(new String[]{"127.0.0.2"});
        virtualContextHandler.setHandler(new BasicHandler("Virtual Hello"));

        ContextHandlerCollection handlerCollection = new ContextHandlerCollection();
        handlerCollection.setHandlers(new Handler[]{rootContextHandler, frContextHandler, itContextHandler});

        server.setHandler(handlerCollection);

        server.start();
        server.join();
    }
}
