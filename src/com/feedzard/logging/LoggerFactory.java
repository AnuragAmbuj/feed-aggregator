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
        private static Logger logger = Logger.getLogger("FRLogger");
        public static Logger getLogger(){
            return logger;
        }
    }

