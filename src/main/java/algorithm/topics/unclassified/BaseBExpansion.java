package algorithm.topics.unclassified;

/**
 * @author hufeng
 * @version BaseBExpansion.java, v 0.1 2018/6/29 10:43 PM Exp $
 */

public class BaseBExpansion {
    /**
     * n = b * q + a    0 <= a < b, 0 < q < b
     *
     * @param n number
     * @param b base b
     * @return base b expansion
     */
    public static String baseBExpansion(int n, int b) {
        int q = n;  // quotient
        StringBuilder val = new StringBuilder();
        while (q != 0) {
            int r = q % b; // r = q mod b
            q = q / b; // q = q div b
            val.append(r);
        }
        return val.reverse().toString();
    }

    public static byte[] base2Add(byte[] a, byte[] b) {
        assert a.length == b.length;
        int len = a.length;
        byte c = 0;
        byte[] s = new byte[len + 1];
        for (int i = len - 1; i > 0; i++) {
            int d = (a[i] + b[i] + c) / 2;
            s[i] = (byte) (a[i] + b[i] + c - 2 * d);
            c = (byte) d;
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(baseBExpansion(241, 2));
        System.out.println(baseBExpansion(241, 8));
        System.out.println(baseBExpansion(10, 2));

    }
}
