package sun.jtutorial.core.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by 148112 on 2015/6/5.
 */
public class ThreadPoolExample {

    public static void main(String[] args) {

        int corePoolSize = Runtime.getRuntime().availableProcessors();

        int maximumPoolSize = 5;

        long keepAliveTime = 10;

        TimeUnit unit = TimeUnit.SECONDS;

        BlockingQueue<Runnable> workQueue = new LinkedBlockingDeque<Runnable>();

        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize,
                maximumPoolSize, keepAliveTime, unit,
                workQueue, new DefaultThreadFactory("-defaultThread-"));

        executor.allowCoreThreadTimeOut(true);


        // Test
        executor.execute(new Runnable() {
            public void run() {
                while(true){
                    System.out.println("test");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });

    }
}
