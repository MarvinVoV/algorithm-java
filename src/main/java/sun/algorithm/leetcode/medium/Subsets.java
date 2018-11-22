/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package sun.algorithm.leetcode.medium;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/subsets/">Subsets</a>
 *
 * @author hufeng
 * @version $Id: Subsets.java, v 0.1 2018年11月22日 10:33 AM hufeng Exp $
 */
public class Subsets {
    /**
     * Explain: <a href="https://leetcode.com/problems/subsets/discuss/122645/3ms-easiest-solution-no-backtracking-no-bit-manipulation-no-dfs-no-bullshit"/>
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
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

    @Test
    public void testSolution1() {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> result = subsets(nums);
        System.out.println(JSON.toJSONString(result));
    }


}