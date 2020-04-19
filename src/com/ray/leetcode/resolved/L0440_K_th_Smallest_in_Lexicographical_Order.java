package com.ray.leetcode.resolved;

import com.ray.util.Out;

/**
 * K-th Smallest in Lexicographical Order
 * -----------------------------------------------------------------------------
 * Given integers n and k, find the lexicographically k-th smallest integer in the range from 1 to n.
 * Note: 1 ≤ k ≤ n ≤ 109.
 *
 * Example:
 *      Example 1
 *      Input:
 *      n: 13   k: 2
 *      Output:
 *      10
 *      Explanation:
 *      The lexicographical order is [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9], so the second smallest number is 10.
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/k-th-smallest-in-lexicographical-order/
 * @since   2020-04-19 13:34:35
 */
public class L0440_K_th_Smallest_in_Lexicographical_Order {

    /**
     * 总体的过程是迭代
     *
     * 对于任意的 1234 和 567
     * 先计算 1 为前缀的小于n的数字的个数
     *      count_1 = count(1, 1234) = 346
     * 如果 346 < 567 ，说明结果不在 1 开始的数字中。
     * 排除了前 346 个数字，后续计算时，需要调整 k = 567 - 346 = 221
     *
     * 计算 2 为前缀的 小于 n 的数字个数
     *      count_2 = count(2, 1234) = 111
     *      111 < 221
     *      所以数字也不在 2 为前缀的数字中，调整 k = 221 - 111 = 110
     *
     * 计算 3 为前缀的小于 n 的数字个数
     *      count_3 = count(3, 1234) = 111
     *      111 > 110
     *      所以数字是 3 为前缀的 第 110 个数字，因为 k > 1 所以 3 也可以排除，调整 k = 109
     *
     * 计算 30为前缀的小于 n 的数字个数
     *      count_30 = count(31, 1234) = 11 < k = 109
     *      调整 k = 109 - 11 = 98
     * ... 重复以上步骤  32 -> k=87 -> ... 39 -> k = 10
     *
     * 计算 39 为前缀的小于 n 的数字个数
     *      count_31 = count(31, 1234) = 11 > k = 10
     *      因此 结果是 39 为前缀的 第 10 个数字，因为 k > 1 所以 39 也可以排除，调整 k = 9
     * 计算 390 为前缀的小于 n 的数字个数 = 1， k = 8
     * 计算 391 为前缀的小于 n 的数字个数 = 1， k = 7
     *
     * 计算 398 为前缀的小于 n 的数字个数 = 1， k = 0 找到了结果 398
     */
    static class Solution {
        public int findKthNumber(int n, int k) {

            int number = n;
            int prefix = 0;
            while (k > 0) {
                for (int i = 0; i < 10; i ++) {
                    if (prefix == 0 && i == 0) continue;
                    int tempPrefix = prefix * 10 + i;
                    int count = count(tempPrefix, number);
                    if (count >= k) {
                        prefix = tempPrefix;
                        k -= 1;
                        break;
                    } else {
                        k -= count;
                    }
                }
            }
            return prefix;
        }

        private int count(int prefix, int n) {
            int r1 = (int) Math.log10(prefix);
            int r2 = (int) Math.log10(n);
            int pow = (int) Math.pow(10, r2 - r1);
            if ((prefix + 1) * pow <= n ) {
                return getMuti1(r2-r1+1);
            } else {
                return getMuti1(r2-r1) + Math.max(0, n - prefix * pow + 1);
            }
        }

        private int getMuti1(int n) {
            int i = 1;
            while (--n > 0) {
                i = i * 10 + 1;
            }
            return i;
        }
    }

    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
