/**
 * 线程: 设置中断标识 - 中断标识校验 - 中断响应
 *
 *     Java中断模型:每个线程对象里都用一个boolean类型的标识,代表着是否有中断请求, t.interrupt()是唯一一个能将中断状态设置为true的方法;
 *	   Thread.interrupted():判断当前线程是否中断,如果未中断,返回false;如果已经中断返回true,并且清除中断的状态,即修改中断状态为false;
 *
 *     此外，类库中的有些类的方法也可能会调用中断，如FutureTask中的cancel方法，如果传入的参数为true，它将会在正在运行异步任务的线程上调用interrupt方法，
 *     如果正在执行的异步任务中的代码没有对中断做出响应，那么cancel方法中的参数将不会起到什么效果；又如ThreadPoolExecutor中的shutdownNow方法会遍历
 *     线程池中的工作线程并调用线程的interrupt方法来中断线程，所以如果工作线程中正在执行的任务没有对中断做出响应，任务将一直执行直到正常结束。
 *
 *	       如何方法的声明中声明了:throws InterruptedException,则此方法一般是可以响应中断请求的;
 *
 *
 *
 
 */
/**
 * @author ben xia
 * @date   2018年11月17日上午10:21:13
 */
package com.ben.java.core.thread.interrupt;