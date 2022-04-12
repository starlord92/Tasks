package com.Filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.PrintWriter;



import javax.servlet.ServletException;
import javax.servlet.http.*;

public class HelloServlet extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(HelloServlet.class);
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        logger.info("log message");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.print("<br>welcome to servlet<br>");

    }

}
