package algorithm.topics.counting;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/check-if-one-string-swap-can-make-strings-equal">Check if One String Swap Can Make Strings Equal</a>
 *
 * @author marvin
 * @version CheckIfOneStringSwapCanMakeStringsEqual.java, v 0.1 2022/10/11 01:21 Exp $
 */
public class CheckIfOneStringSwapCanMakeStringsEqual {

    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }

        int n = s1.length();
        List<Integer> diff = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (diff.size() >= 2) {
                    return false;
                }
                diff.add(i);
            }
        }
        if (diff.isEmpty()) {
            return true;
        }
        if (diff.size() != 2) {
            return false;
        }
        return s1.charAt(diff.get(0)) == s2.charAt(diff.get(1)) &&
                s1.charAt(diff.get(1)) == s2.charAt(diff.get(0));
    }

}
