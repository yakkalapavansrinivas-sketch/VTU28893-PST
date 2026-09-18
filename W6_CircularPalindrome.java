import java.io.*;
import java.util.*;

public class Solution {

    static int[] manacher(char[] s) {
        int n = s.length;
        int[] p = new int[n];

        int center = 0;
        int right = 0;

        for (int i = 0; i < n; i++) {

            int mirror = 2 * center - i;

            if (i < right) {
                p[i] = Math.min(right - i, p[mirror]);
            }

            while (i - p[i] - 1 >= 0 &&
                   i + p[i] + 1 < n &&
                   s[i - p[i] - 1] == s[i + p[i] + 1]) {
                p[i]++;
            }

            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }
        }

        return p;
    }

    static int[][] sparse;
    static int[] log;

    static void buildSparseTable(int[] a) {

        int n = a.length;

        log = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            log[i] = log[i / 2] + 1;
        }

        int levels = log[n] + 1;

        sparse = new int[levels][n];

        System.arraycopy(a, 0, sparse[0], 0, n);

        for (int k = 1; k < levels; k++) {

            int len = 1 << k;
            int half = len >> 1;

            for (int i = 0; i + len <= n; i++) {
                sparse[k][i] = Math.max(
                        sparse[k - 1][i],
                        sparse[k - 1][i + half]
                );
            }
        }
    }

    static int rangeMax(int left, int right) {

        if (left > right) {
            return 0;
        }

        int length = right - left + 1;
        int k = log[length];

        return Math.max(
                sparse[k][left],
                sparse[k][right - (1 << k) + 1]
        );
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());

        String s = br.readLine().trim();

        /*
         * Duplicate the string.
         *
         * Example:
         * abcde
         *
         * becomes:
         * abcdeabcde
         */
        String doubled = s + s;

        /*
         * Transform:
         *
         * abc -> #a#b#c#
         *
         * This allows us to handle both odd and even
         * length palindromes with one Manacher array.
         */
        int m = doubled.length() * 2 + 1;

        char[] transformed = new char[m];

        for (int i = 0; i < m; i++) {

            if ((i & 1) == 0) {
                transformed[i] = '#';
            } else {
                transformed[i] = doubled.charAt(i / 2);
            }
        }

        // Manacher
        int[] radius = manacher(transformed);

        // RMQ over Manacher radii
        buildSparseTable(radius);

        StringBuilder out = new StringBuilder();

        /*
         * Rotation k corresponds to the window:
         *
         * doubled[k ... k+n-1]
         *
         * In transformed string:
         *
         * L = 2*k + 1
         * R = 2*(k+n-1) + 1
         */
        for (int k = 0; k < n; k++) {

            int L = 2 * k + 1;
            int R = 2 * (k + n - 1) + 1;

            int low = 1;
            int high = n;
            int answer = 1;

            /*
             * Binary search the maximum palindrome length.
             */
            while (low <= high) {

                int len = (low + high) >>> 1;

                /*
                 * A palindrome of length len must have
                 * its center between:
                 *
                 * L + len - 1
                 * and
                 * R - len + 1
                 */
                int leftCenter = L + len - 1;
                int rightCenter = R - len + 1;

                if (leftCenter <= rightCenter &&
                    rangeMax(leftCenter, rightCenter) >= len) {

                    answer = len;
                    low = len + 1;

                } else {
                    high = len - 1;
                }
            }

            out.append(answer).append('\n');
        }

        System.out.print(out);
    }
}
