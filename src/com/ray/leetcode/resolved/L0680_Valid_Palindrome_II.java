package com.ray.leetcode.resolved;

import com.ray.util.Out;

/**
 * Valid Palindrome II
 * -----------------------------------------------------------------------------
 * 
 * Given a non-empty string s, you may delete at most one character.  Judge whether you can make it a palindrome.
 *
 * Example:
 *      Example 1
 *      Input: "aba"
 *      Output: True
 *      Example 2
 *      Input: "abca"
 *      Output: True
 *      Explanation: You could delete the character 'c'.
 *      Note:
 *      The string will only contain lowercase characters a-z.
 *      The maximum length of the string is 50000.
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/valid-palindrome-ii/
 * @since   2020-04-15 22:49:22
 */
public class L0680_Valid_Palindrome_II {
    static class Solution {
        public boolean validPalindrome(String s) {
            int i = 0, j = s.length()-1;
            while (i < j && s.charAt(i) == s.charAt(j)) {
                i ++;
                j --;
            }
            if (i < j) {
                return isPalindrome(s, i+1, j) || isPalindrome(s, i, j-1);
            } else {
                return true;
            }
        }

        public boolean isPalindrome(String s, int i, int j) {
            while (i < j) {
                if (s.charAt(i++) != s.charAt(j--)) return false;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        String s = "abc";
        Out.p(new Solution().validPalindrome(s));
    }
}
