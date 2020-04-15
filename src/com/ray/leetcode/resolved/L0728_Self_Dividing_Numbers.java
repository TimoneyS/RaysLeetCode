package com.ray.leetcode.resolved;

import com.ray.util.Out;

import java.util.ArrayList;
import java.util.List;

/**
 * Self Dividing Numbers
 * -----------------------------------------------------------------------------
 * 
 * A self-dividing number is a number that is divisible by every digit it contains.
 * For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
 * Also, a self-dividing number is not allowed to contain the digit zero.
 * Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.
 *
 * Example:
 *      Example 1
 *      Input: 
 *      left = 1, right = 22
 *      Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 *      Note:
 *      The boundaries of each input argument are 1 .
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/self-dividing-numbers/
 * @since   2020-04-15 23:41:21
 */
public class L0728_Self_Dividing_Numbers {
    static class Solution {
        public List<Integer> selfDividingNumbers(int lower, int upper) {
            List<Integer> arr = new ArrayList<Integer>();
            for (int i = lower; i <= upper && i != Integer.MIN_VALUE; i++)
                if (isDiv(i)) arr.add(i);
            return arr;
        }

        private boolean isDiv(int n) {
            if (n == 0) return false;
            int t =  n;
            while (true) {
                if (n == 0) return true;
                if (n % 10 == 0 || t % (n%10) != 0) return false;
                n = n / 10;
            }
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
