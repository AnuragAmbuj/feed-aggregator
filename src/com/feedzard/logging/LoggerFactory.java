package com.feedzard.logging;

import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.*;

/**
 * Created by aambuj on 07-09-2016.
 */
public class LoggerFactory {

        public static Logger CURRENT_LOGGER = Logger.getLogger(LoggerFactory.class.getName());
        public Logger logger = Logger.getLogger("FRLogger");
        public void setLogger(Logger logger) throws IOException {
            if(logger == null)
                this.logger = CURRENT_LOGGER;
            else
                this.logger = logger;
            logger.addHandler(new ConsoleHandler());
            logger.addHandler(new FileHandler("errors.log"));
        }
        public Logger getCurrentLogger(){
            return logger;
        }
    }

