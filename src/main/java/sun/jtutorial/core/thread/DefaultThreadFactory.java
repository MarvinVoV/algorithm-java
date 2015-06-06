package sun.jtutorial.core.thread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by 148112 on 2015/6/5.
 */
public class DefaultThreadFactory implements ThreadFactory{
    private final ThreadGroup group;
    private final AtomicInteger threadNumber = new AtomicInteger();
    private final String namePrefix;

    public DefaultThreadFactory(String namePrefix) {
        SecurityManager s = System.getSecurityManager();
        group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
        this.namePrefix = namePrefix;
    }


    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(group, runnable, namePrefix + threadNumber.getAndIncrement());
        thread.setDaemon(true);
        return thread;
    }
}
