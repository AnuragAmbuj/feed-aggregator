package com.feedzard.logging;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by aambuj on 07-09-2016.
 */
public class LoggerFactory {
    Logger logger;
    Class contextClass;
    public LoggerFactory(Class contextClass){
        this.contextClass = contextClass;
        logger = Logger.getLogger(contextClass.getName());
        logger.addHandler(new ConsoleHandler());
        try {
            logger.addHandler(new FileHandler("logger.dump"));
        }catch (IOException ie){
            logger.log(Level.SEVERE,ie.getStackTrace().toString());
        }
    }
}
