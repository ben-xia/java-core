package com.ben.java.core.guava.concurrency;

import com.google.common.base.Function;
import com.google.common.util.concurrent.*;
import io.netty.util.concurrent.DefaultThreadFactory;
import org.junit.Test;

import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


/**
 * @author ben-xia
 * @date 2020/03/27
 * @Description https://www.jianshu.com/p/9c57aa5e34af
 **/
public class ListenableFutureTest01 {

    @Test
    public void testListenableFuture01() {
        //ListenableFutureTask通过静态create方法返回实例，还有一个重载方法，不太常用
        ListenableFutureTask<String> task = ListenableFutureTask.create(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "";
            }
        });
        //启动任务
        new Thread(task).start();
        //增加回调方法，MoreExecutors.directExecutor()返回guava默认的Executor，执行回调方法不会新开线程，所有回调方法都在当前线程做(可能是主线程或者执行ListenableFutureTask的线程，具体可以看最后面的代码)。
        //guava异步模块中参数有Executor的方法，一般还会有一个没有Executor参数的重载方法，使用的就是MoreExecutors.directExecutor()
        task.addListener(new Runnable() {
            @Override
            public void run() {
                System.out.println("done");
            }
        }, MoreExecutors.directExecutor());
    }

    @Test
    public void testListenableFuture02() {
        //真正干活的线程池
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
                5,
                5,
                0,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(100),
                new DefaultThreadFactory("demo"),
                new ThreadPoolExecutor.DiscardPolicy());
        //guava的接口ListeningExecutorService继承了jdk原生ExecutorService接口，重写了submit方法，修改返回值类型为ListenableFuture
        ListeningExecutorService listeningExecutor = MoreExecutors.listeningDecorator(poolExecutor);

        //像线程池提交任务，并得到ListenableFuture
        ListenableFuture<String> listenableFuture = listeningExecutor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "hhhh";
            }
        });
//可以通过addListener对listenableFuture注册回调，但是通常使用Futures中的工具方法
        Futures.addCallback(listenableFuture, new FutureCallback<String>() {
            @Override
            public void onSuccess(String result) {
                System.out.println("result=" + result);
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println("t=" + t.getMessage());
            }
        }, MoreExecutors.directExecutor());

    }

    @Test  //不使用guava的异步链式执行
    public void testListenableFuture03() {
        ListenableFutureTask<String> task1 = ListenableFutureTask.create(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("task1-------------------");
                return "";
            }
        });
        new Thread(task1).start();
        task1.addListener(new Runnable() {
            @Override
            public void run() {
                ListenableFutureTask<String> task2 = ListenableFutureTask.create(new Callable<String>() {
                    @Override
                    public String call() throws Exception {
                        System.out.println("task2-------------------");
                        return "";
                    }
                });
                task2.addListener(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("task3-------------------");
                    }
                }, MoreExecutors.directExecutor());
                new Thread(task2).start();
            }
        }, MoreExecutors.directExecutor());
    }

    @Test  //使用guava的异步链式执行
    public void testListenableFuture04() {
        ListenableFutureTask<String> task1 = ListenableFutureTask.create(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("task1-------------------");
                return "input";
            }
        });
        new Thread(task1).start();

        //当task1执行完毕会回调执行Function的apply方法，如果有task1有异常抛出，则task2也抛出相同异常，不执行apply
        ListenableFuture<String> task2 = Futures.transform(task1, new Function<String, String>() {
            @Override
            public String apply(String input) {
                System.out.println("task2()====" + input);
                return input;
            }
        }, MoreExecutors.directExecutor());
        ListenableFuture<String> task3 = Futures.transform(task2, new Function<String, String>() {
            @Override
            public String apply(String input) {
                System.out.println("task3()====" + input);
                return input;
            }
        }, MoreExecutors.directExecutor());
        //处理最终的异步任务
        Futures.addCallback(task3, new FutureCallback<String>() {
            @Override
            public void onSuccess(String result) {
                System.out.println("result===" + result);
            }

            @Override
            public void onFailure(Throwable t) {

            }
        }, MoreExecutors.directExecutor());

    }

    /**
     * Futures.transform()和Futures.addCallback()都是对addListener做了封装，进行回调的设置，
     * 但是transform更适合用在链式处理的中间过程，addCallback更适合用在处理最终的结果上
     * <p>
     * Futures.transform()和Futures.transformAsync()的区别在于一个参数为Function，一个是AsyncFuntion，
     * AsyncFuntion的apply方法返回值类型也是ListenableFuture，也就是回调方法也是异步的
     */
    @Test
    public void testListenableFuture05() throws InterruptedException {
        ListenableFutureTask<String> task1 = ListenableFutureTask.create(new Callable<String>() {
            @Override
            public String call() throws Exception {
                TimeUnit.SECONDS.sleep(5);
                System.err.println("task1 over\t" + new Date());
                System.err.println("task1 over\t" + Thread.currentThread());
                return "";
            }
        });
        new Thread(task1).start();
        //放开注释的话，上面的线程已经结束，所以是主线程执行回调方法，因此主线程会阻塞5s
//        TimeUnit.SECONDS.sleep(6);
        ListenableFuture<String> transform = Futures.transform(task1, new Function<String, String>() {  //Function是回调函数
            @Override
            public String apply(String input) {
                try {
                    TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
                System.err.println("transform over\t" + new Date());
                //显示的是执行task1的线程
                System.err.println("transform over\t" + Thread.currentThread());
                return "";
            }
        },MoreExecutors.directExecutor());

        while (true) {
            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(new Date().toString() +2020+"\t"+ Thread.currentThread());
        }
    }
}
