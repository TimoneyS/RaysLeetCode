package com.ray.LintCode.temp;

import com.ray.util.Out;

/**
 * 描述：
 *      Given a `positive` integer `n` (1 <= n <= `10^18`). Check whether a number has exactly three distinct factors, return true if it has exactly three distinct factors, otherwise false.
 *
 * 用例：
 *      **Example1**
 *      
 *      ```
 *      Input: n = 9
 *      Output: true
 *      Explanation:
 *      Number 9 has exactly three factors: 1, 3, 9, so return true.
 *      ```
 *      
 *      **Example2**
 *      
 *      ```
 *      Input: n = 10
 *      Output: false
 *      Explanation:
 *      Number 10 has four factors: 1, 2, 5, 10, so return false.
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/three-distinct-factors/description
 * @date   2019-07-11 18:35:52
 */
public class L_0728_Three_Distinct_Factors {


    /**
     * 数字是平方数，且根为质数
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public boolean isThreeDisctFactors(long n) {
            if (n <= 1) return false;
            long fac = (long) Math.sqrt(n);
            return fac * fac == n && isPrim(fac);
        }
        
        public boolean isPrim(long n) {
            if (n == 2) return true;
            
            for (long i = 3; i < n/2; i++) {
                if (n%i == 0) return false;
            }
            return true;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
