package com.ben.java.gof.structural_model.decorator.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: ben.xia
 * @desc:
 * @date: 2023/5/2
 */
public class JSONLoggerFactory {

    public static JSONLogger getLogger(Class clazz){
        Logger logger = LoggerFactory.getLogger(clazz);
        return new JSONLogger(logger);
    }
}
