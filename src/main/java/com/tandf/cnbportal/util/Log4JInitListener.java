package com.tandf.cnbportal.util;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.core.config.DefaultConfiguration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.File;




    public class Log4JInitListener implements ServletContextListener {

        // @Inject
        private Logger logger;

        public void contextInitialized(ServletContextEvent evt) {


            String configPath = evt.getServletContext().getInitParameter("log4jconfig");

            //the configuration file must be called log4j2.xml, so create a different folder for each launch - get the product acronym out of the servletContext
            //configPath = "C:\\Upgrades\\loggingConfig\\POC\\log4j2.xml";

            if (configPath == null) {
                //  System.out.println("unable to find unable to configure log4j" + configPath);
                System.out.println("log4j configuration path was null, unable to configure log4j  path to config file." + configPath);
                return;
            } else {

                Configurator.initialize(new DefaultConfiguration());
                LoggerContext context = (LoggerContext) LogManager.getContext(false);
                File file = new File(configPath);
                context.setConfigLocation(file.toURI());

            }

        }

        public void contextDestroyed(ServletContextEvent evt) {

        }
    }
