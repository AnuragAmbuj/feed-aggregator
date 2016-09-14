package com.feedzard.logging;

import java.util.logging.*;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;

/**
 * Created by aambuj on 06-09-2016.
 */
public class Log {


    static LoggerFactory loggerFactory = new LoggerFactory();
    Logger logger;
    public Log(){
        try {
            loggerFactory.setLogger(null);
            logger = loggerFactory.getCurrentLogger();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void writeLine(Level level,String text){
        new Log().logger.log(level,text);
    }

}
