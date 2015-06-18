package sun.jtutorial.core.concept;

/**
 * Created by 264929 on 2015/6/18.
 */
public class StandardService extends LifecycleMBeanBase {
    @Override
    protected void initInternal() {

        super.initInternal();

        System.out.println("StandardService initInternal.");

    }

    public static void main(String[] args) {
        StandardService service =new StandardService();
        service.init();
    }
}
