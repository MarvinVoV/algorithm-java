package sun.jtutorial.core.concept;

/**
 * Created by 264929 on 2015/6/18.
 */
public abstract class LifecycleBase implements Lifecycle{

    public final void init() {

        System.out.println("LifecycleBase init.");

        initInternal();

    }

    protected abstract void initInternal();
}
