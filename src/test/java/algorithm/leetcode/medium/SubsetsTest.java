package algorithm.leetcode.medium;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;

import java.util.List;

import static algorithm.topics.recursion.Subsets.subsets;

class SubsetsTest {

    @Test
    public void testSolution1() {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> result = subsets(nums);
        System.out.println(JSON.toJSONString(result));
    }


}