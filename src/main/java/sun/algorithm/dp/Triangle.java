/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package sun.algorithm.dp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * <a href="https://leetcode.com/problems/triangle/">Triangle</a>
 *
 * @author hufeng
 * @version $Id: Triangle.java, v 0.1 2018年11月29日 9:36 PM hufeng Exp $
 */
public class Triangle {
    /**
     * 动态规划求解-最优子结构: min = min(row[i]) + PathMinSum(i-1)
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        // 缓存到row[i]行的最小值
        int[] cache = new int[triangle.size()];
        // 记录min(row[i]) index = i
        int index = 0;
        for (int i = 0; i < triangle.size(); i++) {
            if (i == 0) {
                cache[0] = triangle.get(i).get(0);
            } else {
                if (triangle.get(i).get(index) > triangle.get(i).get(index + 1)) {
                    index = index + 1;
                }
                cache[i] = triangle.get(i).get(index) + cache[i - 1];
            }
        }
        return cache[cache.length - 1];
    }

    @Test
    public void testSolution() {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));

        assertEquals(11, minimumTotal(triangle));

    }

    @Test
    public void testSolutionCase2() {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(-1));
        triangle.add(Arrays.asList(2, 3));
        triangle.add(Arrays.asList(1, -1, -3));

        assertEquals(-1, minimumTotal(triangle));

    }

}