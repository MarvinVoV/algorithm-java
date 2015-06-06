package sun.jtutorial.core.collection;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by 148112 on 2015/6/4.
 */
public class SetToArray {
    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        set.add("hello");
        set.add("world");
        set.add("sentence");

        // This will throw ClassCastException. toArray() return Object[] and regardless of generics.
        // Should be use toArray(T[] var)
        //String[] array = (String[])set.toArray();

        String[] array = set.toArray(new String[0]);
        System.out.println(array.length);

        for (String str : array) {
            System.out.println(str);
        }

    }
}
