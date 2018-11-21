/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package sun.algorithm.leetcode.easy;


import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * <a href="https://leetcode.com/problems/move-zeroes/">Move Zeroes</a>
 *
 * @author hufeng
 * @version $Id: MoveZeroes.java, v 0.1 2018年11月21日 8:26 PM hufeng Exp $
 */
public class MoveZeroes {

    /**
     * Solution 1
     *
     * @param nums nums
     */
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int p = -1, i = 0;
        while (i < nums.length) {
            if (nums[i] == 0) {
                if (p == -1) {
                    p = i;
                }
                while (++i < nums.length && nums[i] == 0) {
                    // find the first non zero num
                }
                if (i == nums.length) break;
                // swap and reset zero pointer
                nums[p] = nums[i];
                nums[i] = 0;
                while (++p <= i && nums[p] != 0) {
                    // find the first zero index
                }
            } else if (nums[i] != 0 && p != -1) {
                nums[p] = nums[i];
                nums[i] = 0;
                while (++p <= i && nums[p] != 0) {
                    // find the first zero index
                }
            }
            i++;
        }
    }

    /**
     * Solution 2
     *
     * @param nums nums
     */
    public void moveZeros2(int[] nums) {
        int firstZeroPointer = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 && firstZeroPointer == -1) {
                firstZeroPointer = i;
                continue;
            }
            if (nums[i] != 0 && firstZeroPointer > -1) {
                nums[firstZeroPointer] = nums[i];
                nums[i] = 0;
                firstZeroPointer++;
            }
        }
    }


    @Test
    public void testSolution1() {
//        int[] nums = new int[]{0, 1, 0, 3, 12};
//        int[] nums = new int[]{1, 0, 0, 0, 12};
//        int[] nums = new int[]{0, 1, 1, 0};
//        int[] nums = new int[]{1, 0, 1, 0};
        int[] nums = new int[]{-959151711, 623836953, 209446690, -1950418142, 1339915067, -733626417, 481171539, -2125997010, -1225423476, 1462109565, 147434687, -1800073781, -1431212205, -450443973, 50097298, 753533734, -747189404, -2070885638, 0, -1484353894, -340296594, -2133744570, 619639811, -1626162038, 669689561, 0, 112220218, 502447212, -787793179, 0, -726846372, -1611013491, 204107194, 1605165582, -566891128, 2082852116, 0, 532995238, -1502590712, 0, 2136989777, -2031153343, 371398938, -1907397429, 342796391, 609166045, -2007448660, -1096076344, -323570318, 0, -2082980371, 2129956379, -243553361, -1549960929, 1502383415, 0, -1394618779, 694799815, 78595689, -1439173023, -1416578800, 685225786, -333502212, -1181308536, -380569313, 772035354, 0, -915266376, 663709718, 1443496021, -777017729, -883300731, -387828385, 1907473488, -725483724, -972961871, -1255712537, 383120918, 1383877998, 1722751914, 0, -1156050682, 1952527902, -560244497, 1304305692, 1173974542, -1313227247, -201476579, -298899493, -1828496581, -1724396350, 1933643204, 1531804925, 1728655262, -955565449, 0, -69843702, -461760848, 268336768, 1446130876};
        int[] expect = new int[]{-959151711, 623836953, 209446690, -1950418142, 1339915067, -733626417, 481171539, -2125997010, -1225423476, 1462109565, 147434687, -1800073781, -1431212205, -450443973, 50097298, 753533734, -747189404, -2070885638, -1484353894, -340296594, -2133744570, 619639811, -1626162038, 669689561, 112220218, 502447212, -787793179, -726846372, -1611013491, 204107194, 1605165582, -566891128, 2082852116, 532995238, -1502590712, 2136989777, -2031153343, 371398938, -1907397429, 342796391, 609166045, -2007448660, -1096076344, -323570318, -2082980371, 2129956379, -243553361, -1549960929, 1502383415, -1394618779, 694799815, 78595689, -1439173023, -1416578800, 685225786, -333502212, -1181308536, -380569313, 772035354, -915266376, 663709718, 1443496021, -777017729, -883300731, -387828385, 1907473488, -725483724, -972961871, -1255712537, 383120918, 1383877998, 1722751914, -1156050682, 1952527902, -560244497, 1304305692, 1173974542, -1313227247, -201476579, -298899493, -1828496581, -1724396350, 1933643204, 1531804925, 1728655262, -955565449, -69843702, -461760848, 268336768, 1446130876};

        moveZeroes(nums);
        assertArrayEquals(Arrays.copyOf(nums, expect.length), expect);
    }
}