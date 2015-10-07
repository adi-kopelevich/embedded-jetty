package example.jetty.embedded;

import org.eclipse.jetty.jmx.MBeanContainer;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

import java.io.File;
import java.lang.management.ManagementFactory;

/**
 * Created by kopelevi on 05/10/2015.
 */
public class OneWebAppServer {

    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);

        MBeanContainer mBeanContainer = new MBeanContainer(ManagementFactory.getPlatformMBeanServer());
        server.addBean(mBeanContainer);

        WebAppContext webAppContext = new WebAppContext();
        webAppContext.setContextPath("/store-webapp");
        File warFile = new File("C:\\projects\\store-webapp\\target\\store-webapp.war");
        webAppContext.setWar(warFile.getAbsolutePath());
//        webAppContext.addAliasCheck(new AllowSymLinkAliasChecker());

        server.setHandler(webAppContext);

        server.start();
        server.join();
    }
}
