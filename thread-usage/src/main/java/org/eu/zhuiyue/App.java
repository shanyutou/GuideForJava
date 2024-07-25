package org.eu.zhuiyue;

import java.util.concurrent.*;

/**
 * Hello world!
 *
 */
public class App 
{

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Hello World! method 1 Thread");
        }
    }

    static class MyCallable implements Callable<String>

    {
        @Override
        public String call() throws Exception {
            return "Hello World! Callable Interface";
        }
    }
    public static void main( String[] args ) throws ExecutionException, InterruptedException {
        System.out.println( "method 1 继承 Thread 类： " );
        Thread thread = new MyThread();
        thread.start();
        System.out.println( "method 2 实现 Runnable Interface " );
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World! method 2 Runnable Interface");
            }
        }).start();

        System.out.println( "method 2 lambda Runnable Interface " );

        new Thread(()->{
            System.out.println("Hello World!");
        }).start();

        System.out.println( "method 3 实现 Callable Interface 带返回值 " );

        MyCallable myCallable = new MyCallable();
        FutureTask<String> futureTask = new FutureTask<>(myCallable);
        Thread thread3 = new Thread(futureTask);
        thread3.start();
        String result = futureTask.get();
        System.out.println(result);

        System.out.println("method 4 Executor");
        //实际项目中创建线程池，不可用该方法，默认实现是无界队列，有OOM风险；
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executorService.execute(()->{
                System.out.println("Hello World! Executor");
            });
        }


        System.out.println("method 4 custom Executor");
        //正确使用线程池方法，使用有界队列
        int corePoolSize = Runtime.getRuntime().availableProcessors();
        int maximumPoolSize = 10;
        long keepAliveTime = 1000;
        TimeUnit unit = TimeUnit.MILLISECONDS;
        //有界队列
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(10);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        for (int i = 0; i < 10; i++) {
            executor.execute(()->{
                System.out.println("Hello World! custom Executor");
            });
        }
    }
}
