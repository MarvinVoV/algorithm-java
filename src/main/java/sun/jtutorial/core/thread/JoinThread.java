package sun.jtutorial.core.thread;

import java.util.Date;

/**
 * Created by 148112 on 2015/6/4.
 */
public class JoinThread {
    static boolean flag = false;

    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable() {
            public void run() {
                while (!flag) {
                    System.out.println("Thread running...");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println("interrupt");
                        flag = true;
                    }
                }
            }
        });
        thread.start();

        thread.interrupt();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main thread done.");
    }
}
