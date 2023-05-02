package com.ben.java.gof.structural_model.decorator.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: ben.xia
 * @desc:
 * @date: 2023/5/2
 */
public class LoggerTest {
//    private static final Logger logger = LoggerFactory.getLogger(LoggerTest.class);
    private static final Logger jsonLogger = JSONLoggerFactory.getLogger(LoggerTest.class);
    public static void main(String[] args) {
//        logger.error("系统错误");
        jsonLogger.error("系统错误");

    }
}
