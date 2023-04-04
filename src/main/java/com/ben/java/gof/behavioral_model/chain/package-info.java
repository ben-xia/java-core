package com.ben.java.gof.behavioral_model.chain;

/**
 * 责任链模式【Chain of Responsibility Pattern】
 *
 * 1.定义
 *   责任链模式是将链中每一个节点看作是一个对象,每个节点处理的请求均不同,且内部自动维护一个下一个节点的对象.当一个请求从链式的
 *   首端发出时,会沿着链的路径依次传递给每一个节点对象,直至有对象处理这个请求为止;
 * 2.使用场景
 *      审批流程(层层传递,每一次只负责做好自己的事,自己处理完交给下一个人)
 * 3.源码分析
 *      servlet-api: FilterChain  Filter
 *      netty: ChannelPipeline
 *      权限框架: shiro,Spring-security
 *
 * 4. 自己实现一个双向链路
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */