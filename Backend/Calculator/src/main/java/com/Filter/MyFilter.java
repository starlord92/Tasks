package com.Filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyFilter implements Filter{
    private static Logger logger = LoggerFactory.getLogger(HelloServlet.class);

    public void init(FilterConfig arg0) throws ServletException {}

    public void doFilter(ServletRequest req, ServletResponse resp,
                         FilterChain chain) throws IOException, ServletException {
        logger.info("Inside Authorization Filter");
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        Optional<Object> authCookie = Optional.empty();
        if(httpServletRequest.getCookies() != null){
            authCookie = Arrays.stream(httpServletRequest.getCookies()).filter(cookie -> "auth".equals(cookie.getName())).findAny().map(cookie -> cookie.getValue());
        }
        if(authCookie.isPresent() && Objects.equals(authCookie.get(),"ValidAuth")){
            logger.info("Valid User");
            chain.doFilter(req,resp);
        }else {
            logger.info("Not Valid");
            HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
            httpServletResponse.setStatus(401);
            httpServletResponse.getOutputStream().write("Unauthorized".getBytes());
        }

        PrintWriter out=resp.getWriter();
        out.print("filter is invoked before");

        chain.doFilter(req, resp);

        out.print("filter is invoked after");
    }
    public void destroy() {}
}
