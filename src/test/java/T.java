import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author hufeng
 * @version T.java, v 0.1 2021/2/17 10:13 Exp $
 */

public class T {
    @Test
    public void test() {
        Set<Integer> set = new LinkedHashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);

        set.remove(1);
        set.add(1);

        set.forEach(System.out::println);
    }
}
