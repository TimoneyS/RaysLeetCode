package com.ray.leetcode.resolved;

import com.ray.util.Out;

/**
 * Count Different Palindromic Subsequences
 * -----------------------------------------------------------------------------
 * 
 * Given a string S, find the number of different non-empty palindromic subsequences in S, and return that number modulo 10^9 + 7.
 * A subsequence of a string S is obtained by deleting 0 or more characters from S.
 * A sequence is palindromic if it is equal to the sequence reversed.
 * Two sequences A_1, A_2, ... and B_1, B_2, ... are different if there is some i for which A_i != B_i.
 *
 * Example:
 *      Example 1
 *      Input: 
 *      S = 'bccb'
 *      Output: 6
 *      Explanation: 
 *      The 6 different non-empty palindromic subsequences are 'b', 'c', 'bb', 'cc', 'bcb', 'bccb'.
 *      Note that 'bcb' is counted only once, even though it occurs twice.
 *      Example 2
 *      Input: 
 *      S = 'abcdabcdabcdabcdabcdabcdabcdabcddcbadcbadcbadcbadcbadcbadcbadcba'
 *      Output: 104860361
 *      Explanation: 
 *      There are 3104860382 different non-empty palindromic subsequences, which is 104860361 modulo 10^9 + 7.
 *      Note:
 *      The length of S will be in the range [1, 1000].
 *      Each character S[i] will be in the set {'a', 'b', 'c', 'd'}.
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/count-different-palindromic-subsequences/
 * @since   2020-04-30 20:17:34
 */
public class L0730_Count_Different_Palindromic_Subsequences {
    /**
     * 假设 s[i][j] 之间有 x 个不同的非空回文子序列。
     */
    static class Solution {
        public int countPalindromicSubsequences(String str) {
            if (str == null || str.isEmpty())
                return 0;
            int n = str.length();
            int[][] dp = new int[n][n];

            for (int len = 1; len <= n; len++) {
                for (int l = 0; l + len - 1 < n; l++) {
                    int r = l + len - 1;

                    if (l == r) {
                        dp[l][r] = 1;
                    } else if (str.charAt(l) != str.charAt(r)) {
                        dp[l][r] = dp[l + 1][r] + dp[l][r - 1] - dp[l + 1][r - 1];
                    } else {
                        // 两个字符 c 相等的情况，寻找两个字符 c 之内是否还有字符 c。
                        int left = l + 1, right = r - 1;
                        while (left <= right && str.charAt(left) != str.charAt(l))
                            left++;

                        while (left <= right && str.charAt(right) != str.charAt(l))
                            right--;

                        if (left == right) {
                            // 只有一个字符 c 说明只有 cc 可以作为新的回文串加入
                            dp[l][r] = dp[l + 1][r - 1] * 2 + 1;
                        } else if (left > right) {
                            // 没有字符 c，说明 c cc 可以作为新的回文串加入
                            dp[l][r] = dp[l + 1][r - 1] * 2 + 2;
                        } else {
                            // 有两个字符 c，如果用这两个字符作为新的回文边界，那么必然和已经存在的边界产生重复的部分结果
                            dp[l][r] = dp[l + 1][r - 1] * 2 - dp[left + 1][right - 1];
                        }
                    }
                    if (dp[l][r] < 0) {
                        // overflow
                        dp[l][r] += 1000000007;
                    } else {
                        dp[l][r] %= 1000000007;
                    }

                }
            }
            return dp[0][n - 1];
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
