package example.jetty.embedded;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by kopelevi on 05/10/2015.
 */
public class BasicHandler extends AbstractHandler {

    private static final String DEFAULT_RESPONSE_MSG = "Hi, this is the basic handler...";
    private final String msg;

    public BasicHandler() {
        this.msg = DEFAULT_RESPONSE_MSG;
    }

    public BasicHandler(String msg) {
        this.msg = msg;
    }

    @Override
    public void handle(String s, Request request, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        httpServletResponse.setContentType(MediaType.TEXT_HTML);
        PrintWriter out = httpServletResponse.getWriter();
        out.println("<h1>" + msg + "</h1>");
        request.setHandled(true);
    }
}
