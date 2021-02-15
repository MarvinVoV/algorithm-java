package algorithm.topics.dp.knapsack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZeroOneKnapsackTest {

    @Test
    void zeroOneKnapsack() {
        int[] value = {60, 100, 120};
        int[] weight = {10, 20, 30};
        int W = 50;

        assertEquals(220, ZeroOneKnapsack.zeroOneKnapsack(W, weight, value, value.length));
    }
}