package algorithm.topics.unclassified;

import java.util.Arrays;

/**
 * Created by sunyamorn on 4/12/16.
 */
public class Recursion {

    public static int factorial(int n) throws IllegalArgumentException {
        if (n < 0)
            throw new IllegalArgumentException();
        else if (n == 0)
            return 1;
        else
            return n * factorial(n - 1);
    }

    // Summing an array of integers using linear recursion
    public static int linearSum(int a[], int n) {
        if (n == 0)
            return 0;
        else
            return linearSum(a, n - 1) + a[n - 1];
    }

    // Reversing the elements of an array using linear recursion
    public static void reverseArray(int a[], int low, int high) {
        if (low < high) {
            int temp = a[low];
            a[low] = a[high];
            a[high] = temp;
            reverseArray(a, low + 1, high - 1);
        }
    }

    // power(x,n) = x^n
    public static double power(double x, int n) {
        if (n == 0)
            return 1;
        else
            return x * power(x, n - 1);
    }



    // Determine if a string is a palindrome
    public static boolean isPalindrome(char[] s, int start, int end) {
        return start >= end || s[start] == s[end] && isPalindrome(s, ++start, --end);
    }

    public static void main(String[] args) {

        System.out.println(Recursion.factorial(3));

        int a[] = {2, 4, 3, 5, 6, 7, 8};
        System.out.println(linearSum(a, 3));

        reverseArray(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));

        System.out.println(power(2, 3));

        String s = "racecar";
        System.out.println(isPalindrome(s.toCharArray(), 0, s.length() - 1));

    }
}
