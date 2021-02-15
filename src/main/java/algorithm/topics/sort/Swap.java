package algorithm.topics.sort;

/**
 * Created by yamorn on 2016/4/15.
 *
 * swap two variables without other variable
 */
public class Swap {

    public static void main(String[] args) {
        int a = 3, b = 4;
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("a = " + a + " b = " + b);
    }
}
