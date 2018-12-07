package sun.algorithm.courses.sort;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;
import java.util.Random;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by sunyamorn on 4/12/16.
 */
@RunWith(JUnit4.class)
public class ArraysUsage {

    @Test
    public void testEquals() {
        char a[] = {'a', 'b', 'c'};
        char b[] = {'a', 'b', 'c'};
        assertTrue(Arrays.equals(a, b));
    }

    @Test
    public void testRandomNum() {
        int data[] = new int[10];
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        // fill the data array with pseudo-random numbers from 0 to 99
        for (int i = 0; i < data.length; i++) {
            data[i] = rand.nextInt(99);
        }
        int[] orig = Arrays.copyOf(data, data.length);
        System.out.println("array equal before sort:" + Arrays.toString(data));
        Arrays.sort(orig);
        System.out.println("array equal after sort:" + Arrays.toString(orig));


    }


}
