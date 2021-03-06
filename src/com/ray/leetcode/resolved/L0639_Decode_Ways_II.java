package com.ray.leetcode.resolved;

import com.ray.util.Out;

/**
 * Decode Ways II
 * -----------------------------------------------------------------------------
 * 
 * A message containing letters from A-Z is being encoded to numbers using the following mapping way:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Beyond that, now the encoded string can also contain the character '*', which can be treated as one of the numbers from 1 to 9.
 * Given the encoded message containing digits and the character '*', return the total number of ways to decode it.
 * Also, since the answer may be very large, you should return the output mod 109 + 7.
 *
 * Example:
 *      Example 1
 *      Input: "*"
 *      Output: 9
 *      Explanation: The encoded message can be decoded to the string: "A", "B", "C", "D", "E", "F", "G", "H", "I".
 *      Example 2
 *      Input: "1*"
 *      Output: 9 + 9 = 18
 *      Note:
 *      The length of the input string will fit in range [1, 105].
 *      The input string will only contain the character '*' and digits '0' - '9'.
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/decode-ways-ii/
 * @since   2020-04-30 20:44:13
 */
public class L0639_Decode_Ways_II {
    /**
     * 1. * 号单独解析，有 9 中可能
     * 2. * 号和其他数量相连有两种情况
     *    1.1. * 在前 *1 *2 *6 每种有2种情况，*7~*9 每种有1种情况
     *    1.2  * 在后 1* 18种， 2* 6种，其他数字都是 0种。
     *
     * 设 dp[i] 表示从 i 开始，字符串可以解析的方式数量
     *      dp[i] = way(i) * dp[i+1] + way(i, i+1) * dp[i+2]
     */
    static class Solution {
        public int numDecodings(String s) {
            long[] dp = new long[s.length()+2];
            dp[s.length()] = 1;
            for (int i = s.length()-1; i >= 0; i--) {
                dp[i] = way(s, i) * dp[i+1] + way(s, i, i+1) * dp[i+2];
                dp[i] = dp[i] % 1000000007;
            }
            return (int) dp[0] ;
        }

        int way(String s, int i) {
            char c = i >= s.length() ? '-' : s.charAt(i);
            if (c == '*') return 9;
            else if (c == '0') return 0;
            else if (c == '-') return 1;
            else return 1;
        }

        int way(String s, int i, int j) {
            if (i >= s.length() || j >= s.length() ) return 1;
            char c1 = s.charAt(i);
            char c2 = s.charAt(j);
            if (c1 == '*' && c2 == '*') {
                return 15;
            } else if (c1 == '*' && c2 < '7') {
                return 2;
            } else if (c1 == '*' && c2 > '6') {
                return 1;
            } else if (c2 == '*' && c1 == '1') {
                return 9;
            } else if (c2 == '*' && c1 == '2'){
                return 6;
            } else if (c1 == '1' || c1 == '2' && c2 < '7') {
                return 1;
            }
            return 0;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
