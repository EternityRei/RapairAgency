package com.example.listener;

import com.example.db.DBUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.logging.LogManager;
import java.util.logging.Logger;

@WebListener
public class ContentListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext ctx = sce.getServletContext();
        String path = ctx.getRealPath("main/resources/log4j.xml");
        System.setProperty("logFile", path);

        final Logger log = LogManager.getLogManager().getLogger(String.valueOf(ContentListener.class));
        log.config("path = " + path);

        // check data source
        DBUtils.getInstance();
    }
}
