package com.sunk.log4jtest;

import org.apache.log4j.Logger;

/**
 * @author sunk
 * @since 2023/1/5
 **/
public class LogTest01 {

    public static void main(String[] args) {
        final Logger logger = Logger.getLogger(LogTest01.class);
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
        logger.fatal("fatal");
    }

}
