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
        public static Logger getLogger()  {
            logger.addHandler(new ConsoleHandler());
            try {
                logger.addHandler(new FileHandler("errors.log"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return logger;
        }
    }

