package algorithm.topics.bitwise;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given two binary strings, return their sum (also a binary string).
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 * <p>
 * Reference: <a href="https://leetcode.cn/problems/add-binary/"> Add Binary </a>
 * Difficulty: Easy
 *
 * @author hufeng
 * @version AddBinary.java, v 0.1 05/12/2017 11:33 AM Exp $
 */

public class AddBinary {
    public static String addBinary(String a, String b) {
        // two stack and one carry storage register
        Stack<Character> stackA = new Stack<>();
        Stack<Character> stackB = new Stack<>();

        if (a != null && a.length() > 0) {
            for (Character c : a.toCharArray()) {
                stackA.push(c);
            }
        }
        if (b != null && b.length() > 0) {
            for (Character c : b.toCharArray()) {
                stackB.push(c);
            }
        }

        List<Character> list = new ArrayList<>();
        boolean carray = false;
        while (!stackA.isEmpty() || !stackB.isEmpty()) {
            Character ca = stackA.isEmpty() ? null : stackA.pop();
            Character cb = stackB.isEmpty() ? null : stackB.pop();
            if (ca != null && cb != null && ca == cb) {
                if (carray) {
                    if (ca == '0') {
                        carray = false;
                    }
                    list.add(0, '1');
                } else {
                    if (ca == '1') {
                        carray = true;
                    }
                    list.add(0, '0');
                }
            } else if (ca != null && cb != null) {
                if (carray) {
                    list.add(0, '0');
                } else {
                    list.add(0, '1');
                }
            } else {
                if (carray) {
                    if ((ca != null && ca == '1') || (cb != null && cb == '1')) {
                        list.add(0, '0');
                    } else {
                        list.add(0, '1');
                        carray = false;
                    }
                } else {
                    list.add(0, ca != null ? ca : cb);
                }
            }
        }
        if (carray) {
            list.add(0, '1');
        }
        StringBuilder sb = new StringBuilder();
        list.forEach(sb::append);
        return sb.toString();
    }


    public static String addBinary2(String a, String b) {
        String s = "";
        int c = 0, i = a.length() - 1, j = b.length() - 1;
        while (i >= 0 || j >= 0 || c == 1) {
            c += i >= 0 ? a.charAt(i--) - '0' : 0;
            c += j >= 0 ? b.charAt(j--) - '0' : 0;
            s = (char) (c % 2 + '0') + s;
            c /= 2;
        }
        return s;
    }

}
