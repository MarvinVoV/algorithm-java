package sun.jtutorial.core.concept;

/**
 * Created by 264929 on 2015/6/18.
 */
public class LifecycleMBeanBase extends LifecycleBase {
    @Override
    protected void initInternal() {
        System.out.println("LifecycleMBeanBase initInternal.");
    }
}
