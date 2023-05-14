package com.ben.java.gof.creative_mode.factory.simplefactory;

/**
 *  工厂方法用于去创建:  同一类型多不同实例的场景
 *  工厂类: 创建对象
 *  工厂类: 本身是单例
 *  创建的对象使用本地缓存: 享元模式
 *  对象类对象: 使用策略模式
 *  对象类方法: 使用模板模式
 *
 *
 * 2.适用场景
 *    工厂类负责创建的对象较少; 客户端只需要传入工厂类的参数,对于如何创建对象的逻辑不需要关系;
 * 3.源码分析:  Calendar  LoggerFactory
 *
 *
 *
 *
 **/