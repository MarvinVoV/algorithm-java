package algorithm.leetcode.easy;

import java.util.Map;

/**
 * https://leetcode-cn.com/problems/excel-sheet-column-title/
 */
public class ExcelSheetColumnTitle {

    public static String convertToTitle(int columnNumber) {
        // A 65 , Z 90
        StringBuilder sb = new StringBuilder();
        while (columnNumber != 0) {
            columnNumber--;
            int rem = columnNumber % 26;
            sb.append((char) (rem + 'A'));
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(28)); // AB
        System.out.println(convertToTitle(701)); // ZY
        System.out.println(convertToTitle(52)); // AZ
    }
}
