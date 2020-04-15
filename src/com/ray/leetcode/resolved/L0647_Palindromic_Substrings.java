package com.ray.leetcode.resolved;

import com.ray.util.Out;

/**
 * Palindromic Substrings
 * -----------------------------------------------------------------------------
 * Given a string, your task is to count how many palindromic substrings in this string.
 * The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
 *
 * Example:
 *      Example 1
 *      Input: abc
 *      Output: 3
 *      Explanation: Three palindromic strings: a, b, c.
 *      Example 2
 *      Input: aaa
 *      Output: 6
 *      Explanation: Six palindromic strings: a, a, a, aa, aa, aaa.
 *      Note:
 *      	The input string length won't exceed 1000.
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/palindromic-substrings/
 * @since   2020-04-15 23:08:50
 */
public class L0647_Palindromic_Substrings {
    /**
     * 每个位置 i 统计以 i 为中心，以i,i+1 为中心的回文数
     */
    static class Solution {
        public int countSubstrings(String s) {
            int c = 0;
            for (int i = 0; i < s.length(); i++)
                c += paliNum(s, i);
            return c;
        }

        int paliNum(String str, int i) {
            int c = 0;
            int l = i, r = i;
            while (l >= 0 && r < str.length() && str.charAt(l--) == str.charAt(r++)) c++;
            l = i; r = i+1;
            while (l >= 0 && r < str.length() && str.charAt(l--) == str.charAt(r++)) c++;
            return c;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
