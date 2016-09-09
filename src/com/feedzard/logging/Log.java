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


    static final Logger _CURRENT_CONTEXT_LOGGER =LoggerFactory.getLogger();
    public static void writeLine(Level level,String text){
        _CURRENT_CONTEXT_LOGGER.log(level,text);
    }

}
