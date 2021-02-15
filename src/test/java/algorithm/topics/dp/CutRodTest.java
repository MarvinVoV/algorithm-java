package algorithm.topics.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CutRodTest {

    private static int[] price;
    private static int[] answer;

    static {
        price = new int[]{1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        answer = new int[]{1, 5, 8, 10, 13, 17, 18, 22, 25, 30};
    }

    @Test
    public void testRecursion() {
        for (int i = 1; i <= price.length; i++) {
            int q = CutRod.cutRod(price, i);
            assertEquals(answer[i - 1], q);
        }
    }

    @Test
    public void testMemorizedCutRod() {
        for (int i = 1; i < price.length; i++) {
            int q = CutRod.memorizedCutRod(price, i);
            assertEquals(answer[i - 1], q);
        }
    }

    @Test
    public void testBottomUpCutRod() {
        for (int i = 1; i < price.length; i++) {
            int q = CutRod.bottomUpCutRod(price, i);
            assertEquals(answer[i - 1], q);
        }
    }

}