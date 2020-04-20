package com.ray.leetcode.resolved;

import com.ray.util.Out;

import java.util.HashMap;
import java.util.Map;

/**
 * Count The Repetitions
 * -----------------------------------------------------------------------------
 * Define S = [s,n] as the string S which consists of n connected strings s. For example, ["abc", 3] ="abcabcabc". 
 * On the other hand, we define that string s1 can be obtained from string s2 if we can remove some characters from s2 such that it becomes s1. For example, “abc”  can be obtained from “abdbec” based on our definition, but it can not be obtained from “acbbe”.
 * You are given two non-empty strings s1 and s2 (each at most 100 characters long) and two integers 0 ≤ n1 ≤ 106 and 1 ≤ n2 ≤ 106. Now consider the strings S1 and S2, where S1=[s1,n1] and S2=[s2,n2]. Find the maximum integer M such that [S2,M] can be obtained from S1.
 *
 * Example:
 *      Example 1
 *      Input:
 *      s1="acb", n1=4
 *      s2="ab", n2=2
 *      Return:
 *      2
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/count-the-repetitions/
 * @since   2020-04-19 13:44:17
 */
public class L0466_Count_The_Repetitions {
    static class Solution {
        public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
            Map<Integer, int[]> index = new HashMap<>();
            int j = 0, c1 = 0, c2 = 0;
            while (c1 < n1) {
                for (int i = 0; i < s1.length(); i++) {
                    if (s1.charAt(i) == s2.charAt(j)) {
                        j ++;
                    }
                    if (j == s2.length()) {c2 ++; j = 0;}
                }
                c1 ++;
                if (index.containsKey(j)) {
                    int[] prev = index.get(j);
                    // 每 d1 个 s1，就有 d2 个 s2
                    int d1 = c1 - prev[0];
                    int d2 = c2 - prev[1];
                    // 剩下 n1 - prev[0] 个 s1
                    c2 += (n1 - c1) / d1 * d2;
                    c1 += (n1 - c1) / d1 * d1;
                } else {
                    index.put(j, new int[]{c1, c2});
                }
            }
            return c1 / n2;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
