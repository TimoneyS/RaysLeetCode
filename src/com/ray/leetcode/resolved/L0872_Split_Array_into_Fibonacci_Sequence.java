package com.ray.leetcode.resolved;

import com.ray.util.Out;

import java.util.ArrayList;
import java.util.List;

/**
 * Split Array into Fibonacci Sequence
 * -----------------------------------------------------------------------------
 * Given a string S of digits, such as S = 123456579, we can split it into a Fibonacci-like sequence [123, 456, 579].
 * Formally, a Fibonacci-like sequence is a list F of non-negative integers such that:
 * 	0 <= F[i] <= 2^31 - 1, (that is, each integer fits a 32-bit signed integer type);
 * 	F.length >= 3;
 * 	and F[i] + F[i+1] = F[i+2] for all 0 <= i < F.length - 2.
 * Also, note that when splitting the string into pieces, each piece must not have extra leading zeroes, except if the piece is the number 0 itself.
 * Return any Fibonacci-like sequence split from S, or return [] if it cannot be done.
 *
 * Example:
 *      Example 1
 *      Input: 123456579
 *      Output: [123,456,579]
 *      Example 2
 *      Input: 11235813
 *      Output: [1,1,2,3,5,8,13]
 *      Example 3
 *      Input: 112358130
 *      Output: []
 *      Explanation: The task is impossible.
 *      Example 4
 *      Input: 0123
 *      Output: []
 *      Explanation: Leading zeroes are not allowed, so 01, 2, 3 is not valid.
 *      Example 5
 *      Input: 1101111
 *      Output: [110, 1, 111]
 *      Explanation: The output [11, 0, 11, 11] would also be accepted.
 *      Note: 
 *      	1 <= S.length <= 200
 *      	S contains only digits.
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/split-array-into-fibonacci-sequence/
 * @since   2020-04-14 23:05:01
 */
public class L0872_Split_Array_into_Fibonacci_Sequence {
    static class Solution {
        public List<Integer> splitIntoFibonacci(String S) {
            List<Integer> rs = new ArrayList<>();
            if (!helper(rs, S, 0))
                rs.clear();
            return rs;
        }

        private boolean helper(List<Integer> rs, String S, int start) {
            if (start == S.length()) return  rs.size() > 2;
            int num = 0;
            for (int i = start; i < S.length(); i++) {
                // 数字的前导是 0， 不合法且无法向下选取
                if (S.charAt(start) == '0' && i > start)
                    return false;
                // 溢出了也无法向下选取
                if ((num = num * 10 + (S.charAt(i) - '0')) < 0)
                    return false;
                // 如果当前的数字可以构成斐波那契数列（可能两种情况：1.当前结果小于两个；2.当前数字等于后两个数字和）
                if (rs.size() < 2 || rs.get(rs.size() - 1) + rs.get(rs.size() - 2) == num) {
                    rs.add(num);
                    if (helper(rs, S, i+1)) {
                        return true;
                    }
                    rs.remove(rs.size() - 1);
                }
            }
            return false;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
