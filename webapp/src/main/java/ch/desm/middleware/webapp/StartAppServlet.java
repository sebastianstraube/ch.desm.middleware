package ch.desm.middleware.webapp;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Sebastian on 16.10.2014.
 */
public class StartAppServlet extends HttpServlet {

    private static Logger LOGGER = Logger.getLogger(StartAppServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            PrintWriter out= response.getWriter();
            out.println("<font color=red>StartAppServlet opened ....</font>");

        LOGGER.log(Level.ERROR, "StartAppServlet loaded ! ");
    }

}
