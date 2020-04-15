package com.ray.LintCode.locked;

import java.util.ArrayList;
import java.util.List;

import com.ray.util.Out;

/**
 * 描述：
 *      A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 *      Find all strobogrammatic numbers that are of length = n.
 *
 * 用例：
 *      Example 1:
 *      ```
 *      Input: n = 2, 
 *      Output: ["11","69","88","96"]
 *      ```
 *      
 *      Example 2:
 *      ```
 *      Input: n = 1, 
 *      Output: ["0","1","8"]
 *      
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/strobogrammatic-number-ii/description
 * @date   2019-07-11 18:36:35
 */
public class L_0776_Strobogrammatic_Number_II {


    /**
     * 中心对称的数字
     *      1 - 1
     *      0 - 0
     *      8 - 8
     * 互相对称的数字
     *      6 - 9
     *      
     * 如果 n 是奇数，那么 dp[n] = dp[n-1]*3，相等于在长度为偶数的数字中，每个的中心加上 1、0、8     
     * 因此主要考虑是偶数的情况
     *      偶数的情况只要考虑一半的情况，比如左半部分长度为 n/2，每一位可以是是任意的 1 0 8 6 9
     *      当然数字的第一位不能为 0 （对应的最后一位也不能为0）
     *      
     * 这里算法直接递归，时间复杂度较高，可以考虑用dp存储中间的数组，用空间复杂度换取时间复杂度。     
     * @author rays1
     *
     */
    static class Solution {
        
        static int[] arr = {1, 0, 8, 6, 9};
        static int[] cens = {1, 0, 8};
        static int[] opersite = {0, 1, -1, -1, -1, -1, 9, -1, 8, 6};
        
        public List<String> findStrobogrammatic(int n) {
            List<String> rs = new ArrayList<>();
            help(new int[n/2], n/2-1, rs, n%2 == 0);
            return rs;
        }
        
        private void help(int[] base, int start, List<String> rs, boolean flag) {
            if (start == -1) {
                if (flag) {
                    genNum(base, rs, -1);
                } else {
                    for (int cen : cens) {
                        genNum(base, rs, cen);
                    }
                }
                return;
            }
            for (int num : arr) {
                if (start == 0 && num == 0) continue;
                base[start] = num;
                help(base, start-1, rs, flag);
            }
        }

        private void genNum(int[] base, List<String> rs, int cen) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < base.length; i ++)
                sb.append(base[i]);
            if (cen >= 0) sb.append(cen);
            for (int i = base.length-1; i >= 0; i --)
                sb.append(opersite[base[i]]);
            rs.add(sb.toString());
        }
    
    }
    
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}