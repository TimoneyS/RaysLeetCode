package com.ray.leetcode.resolved;

import com.ray.util.Out;

import java.util.ArrayList;
import java.util.List;

/**
 * 24 Game
 * -----------------------------------------------------------------------------
 * 
 * You have 4 cards each containing a number from 1 to 9.
 * You need to judge whether they could operated through *, /, +, -, (, ) to get the value of 24.
 *
 * Example 1
 *      Input: [4, 1, 8, 7]
 *      Output: True
 *      Explanation: (8-4) * (7-1) = 24
 * Example 2
 *      Input: [1, 2, 1, 2]
 *      Output: False
 * Note:
 *      The division operator / represents real division, not integer division.  For example, 4 / (1 - 2/3) = 12.
 *      Every operation done is between two numbers.  In particular, we cannot use - as a unary operator.  For example, with [1, 1, 1, 1] as input, the expression -1 - 1 - 1 - 1 is not allowed.
 *      You cannot concatenate numbers together.  For example, if the input is [1, 2, 1, 2], we cannot write this as 12 + 12.
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/24-game/
 * @since   2020-04-22 22:41:42
 */
public class L0679_24_Game {
    /**
     * 首先定义一个表示分数的类，用分子分母方式存储，并定义加减乘除方法
     *
     * 然后任意从 4 个数中选取两个数 f1 f2
     * 计算  f1 加减乘除 f2 f2 加减乘除 f1 等 8 个结果
     * 然后用这个结果从 剩下的数中任意挑选一个执行以上操作，直到所有的数字都已经计算
     *
     * 等于是暴力算法，没有技巧性，复杂度是阶乘级别，可优化空间较大
     */
    static class Solution {
        static int[] toArr(int...args) {
            return args;
        }

        static int[] add(int[] n1, int[] n2) {
            return toArr(n1[0] * n2[1] + n1[1] * n2[0], n1[1] * n2[1]);
        }

        static int[] deg(int[] n1, int[] n2) {
            return toArr(Math.abs(n1[0] * n2[1] - n1[1] * n2[0]), n1[1] * n2[1]);
        }

        static int[] mut(int[] n1, int[] n2) {
            return toArr(n1[0] * n2[0], n1[1] * n2[1]);
        }

        static int[] div(int[] n1, int[] n2) {
            return toArr(n1[0] * n2[1], n1[1] * n2[0]);
        }

        static int[] operate(int[] n1, int[] n2, int opt) {
            switch (opt){
                case 0 : return add(n1, n2);
                case 1 : return deg(n1, n2);
                case 2 : return mut(n1, n2);
                case 3 : return div(n1, n2);
                default: return div(n2, n1);
            }
        }

        static boolean isValue(int[] n) {
            return n[1] != 0 && (24 * n[1] == n[0] || 24 * n[0] == n[1]);
        }

        public boolean judgePoint24(int[] nums) {
            List<int[]> l = new ArrayList<>();
            for (int i : nums) {
                l.add(toArr(i, 1));
            }
            return judgePoint24(l);
        }

        private boolean judgePoint24(List<int[]> l) {
            if (l.size() == 1) {
                return isValue(l.get(0));
            }
            for (int i = 0; i < l.size(); i++) {
                for (int j = i+1; j < l.size(); j ++) {
                    List<int[]> list = new ArrayList<>();
                    for (int k = 0; k < l.size(); k ++) {
                        if (k != i && k != j)
                            list.add(l.get(k));
                    }
                    // 操作
                    for (int opt = 0; opt < 5; opt ++) {
                        list.add(operate(l.get(i), l.get(j), opt));
                        if (judgePoint24(list)) {
                            return true;
                        }
                        list.remove(list.size() - 1);
                    }
                }
            }
            return false;
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {1,9,1,2};
        Out.p(new Solution().judgePoint24(nums));
    }
}
