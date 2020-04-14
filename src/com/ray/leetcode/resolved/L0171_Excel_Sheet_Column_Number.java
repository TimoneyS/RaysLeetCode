package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Excel Sheet Column Number
 * -----------------------------------------------------------------------------
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * For example:
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28 
 *     ...
 *
 * Example:
 *      Example 1
 *      Input: A
 *      Output: 1
 *      Example 2
 *      Input: AB
 *      Output: 28
 *      Example 3
 *      Input: ZY
 *      Output: 701
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/excel-sheet-column-number/
 * @since   2020-03-08 17:36:18
 */
public class L0171_Excel_Sheet_Column_Number {
    static class Solution {
        public int titleToNumber(String s) {
            int seed = 1;
            int rs = 0;
            for (int i = 0; i < s.length(); i++) {
                rs += seed * (s.charAt(s.length()-i-1) - 'A' + 1);
                seed *= 26;
            }
            return rs;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution().titleToNumber("A"));
        Out.p(new Solution().titleToNumber("B"));
        Out.p(new Solution().titleToNumber("Z"));
        Out.p(new Solution().titleToNumber("AA"));
        Out.p(new Solution().titleToNumber("AB"));
    }
}
