package com.ben.java.core.log;


import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.*;

/**
 * @author: ben.xia
 * @desc:
 * @date: 2022/10/29
 */
public class JULTest {

    //    Logger对象父子关系
    @Test
    public void testParent() {
        Logger logger01 = Logger.getLogger("com");
        Logger logger02 = Logger.getLogger("com.ben");
        System.out.println(logger01.getParent().equals(logger02));

        // 所有日志记录器的顶级父元素  LogManager$RootLogger, name ""
        System.out.println("logger02 parent: " + logger02.getParent() + " , name: " + logger02.getParent().getName());

        // 关闭默认的配置
        logger02.setUseParentHandlers(false);
        // 设置logger02日志级别
        // 01.创建consoleHandler 控制台输出
        ConsoleHandler consoleHandler = new ConsoleHandler();
        //02. 创建简单格式转换对象
        SimpleFormatter simpleFormatter = new SimpleFormatter();
        //03. 进行关联
        consoleHandler.setFormatter(simpleFormatter);
        logger02.addHandler(consoleHandler);
//        consoleHandler.setFilter();

        //配置日志具体级别
        logger02.setLevel(Level.ALL);
        consoleHandler.setLevel(Level.ALL);

        //jul的7个日志级别
        logger02.severe("severe");
        logger02.warning("warning");
        logger02.info("info");
        logger02.config("config");
        logger02.fine("fine");
        logger02.finer("finer");
        logger02.finest("finest");


    }

    //    加载自定义配置文件
    @Test
    public void testConfig() {

        try {
            // 通过类加载器,读取配置文件
            InputStream ins = JULTest.class.getClassLoader().getResourceAsStream("logging.properties");
            // 创建LogManager
            LogManager logManager = LogManager.getLogManager();
            //通过LogManager加载配置文件,实例化日志相关对象
            logManager.readConfiguration(ins);

            //创建日志记录器
            Logger logger = Logger.getLogger("com.ben.java.core.log");
            //jul的7个日志级别
            logger.severe("severe");
            logger.warning("warning");
            logger.info("info");
            logger.config("config");
            logger.fine("fine");
            logger.finer("finer");
            logger.finest("finest");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
