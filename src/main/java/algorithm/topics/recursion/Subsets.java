/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package algorithm.topics.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/subsets/">Subsets</a>
 *
 * @author hufeng
 * @version $Id: Subsets.java, v 0.1 2018年11月22日 10:33 AM hufeng Exp $
 */
public class Subsets {
    /**
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int n : nums) {
            int size = result.size();
            for (int i = 0; i < size; i++) {
                List<Integer> subset = new ArrayList<>(result.get(i));
                subset.add(n);
                result.add(subset);
            }
        }
        return result;
    }


}