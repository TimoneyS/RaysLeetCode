package com.ray.leetcode.resolved;

import com.ray.util.Out;

/**
 * Bulls and Cows
 * -----------------------------------------------------------------------------
 * You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to guess what the number is. Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess match your secret number exactly in both digit and position (called bulls) and how many digits match the secret number but locate in the wrong position (called cows). Your friend will use successive guesses and hints to eventually derive the secret number.
 * Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows. 
 * Please note that both secret number and friend's guess may contain duplicate digits.
 *
 * Example:
 *      Example 1
 *      Input: secret = 1807, guess = 7810
 *      Output: 1A3B
 *      Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7.
 *      Example 2
 *      Input: secret = 1123, guess = 0111
 *      Output: 1A1B
 *      Explanation: The 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow.
 *      Note: You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal.
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/bulls-and-cows/
 * @since   2020-03-11 00:12:07
 */
public class L0299_Bulls_and_Cows {
    static class Solution {
        public String getHint(String secret, String guess) {
            int cow = 0, bull = 0;
            int[] count = new int[10];
            // 如果字符位置正确，则猜中，否则记录其出现的次数
            for (int i = 0; i < secret.length(); i++) {
                if (secret.charAt(i) == guess.charAt(i)) bull++;
                else count[secret.charAt(i) - '0'] ++;
            }
            // 如果字符位置不正确，根据之前的统计数据，看是否时异位数字
            for (int i = 0; i < secret.length(); i++) {
                if (secret.charAt(i) != guess.charAt(i) && count[guess.charAt(i) - '0'] > 0) {
                    cow++;
                    count[guess.charAt(i) - '0'] --;
                }
            }
            return "" + bull + 'A' + cow + 'B';
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
