package com.ray.leetcode.resolved;

import com.ray.util.Out;

/**
 * Longest Substring with At Least K Repeating Characters
 * -----------------------------------------------------------------------------
 * 
 * Find the length of the longest substring T of a given string (consists of lowercase letters only) such that every character in T appears no less than k times.
 *
 * Example:
 *      Example 1
 *      Input:
 *      s = "aaabb", k = 3
 *      Output:
 *      3
 *      The longest substring is "aaa", as 'a' is repeated 3 times.
 *      Example 2
 *      Input:
 *      s = "ababbc", k = 2
 *      Output:
 *      5
 *      The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters/
 * @since   2020-05-08 22:42:19
 */
public class L0395_Longest_Substring_with_At_Least_K_Repeating_Characters {
    static class Solution {
        public int longestSubstring(String s, int k) {
            return longestSubstring(s, 0, s.length()-1, k);
        }

        private int longestSubstring(String s, int l, int r, int k) {
            // 统计每个字符的个数
            int[] count = new int[255];
            int ct = 0;
            for (int i = l; i <= r; i++) {
                char c = s.charAt(i);
                if (count[c] == 0) {
                    ct ++;
                }
                if (count[c] == k-1) {
                    ct --;
                }
                count[c] ++;
            }

            if (ct == 0) {
                return r - l + 1;
            }

            // 如果有字符的数量小于 k，则从这个字符的左侧和右侧计算子字符串的长度
            int rs = 0;
            for (int i = l; i <= r; i++) {
                if (count[s.charAt(i)] < k ) {
                    int t = longestSubstring(s, l, i - 1, k);
                    rs = Math.max(t, rs);
                    l = i + 1;
                } else if (i == r && r - l + 1 >= k) {

                    int t = longestSubstring(s, l, r, k);
                    rs = Math.max(t, rs);
                    l = r + 1;
                }
            }
            return rs;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
