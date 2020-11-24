package com.ray.leetcode.resolved;

import com.ray.util.Out;

/**
 * 514.自由之路
 * ==========================================
 * 电子游戏“辐射4”中，任务“通向自由”要求玩家到达名为“Freedom Trail Ring”的金属表盘，并使用表盘拼写特定关键词才能开门。
 * 给定一个字符串 ring，表示刻在外环上的编码；给定另一个字符串 key，表示需要拼写的关键词。您需要算出能够拼写关键词中所有字符的最少步数。
 * 最初，ring 的第一个字符与12:00方向对齐。您需要顺时针或逆时针旋转 ring 以使 key 的一个字符在 12:00 方向对齐，然后按下中心按钮，以此逐个拼写完 key 中的所有字符。
 * 旋转 ring 拼出 key 字符 key[i] 的阶段中：
 * 	您可以将 ring 顺时针或逆时针旋转一个位置，计为1步。旋转的最终目的是将字符串 ring 的一个字符与 12:00 方向对齐，并且这个字符必须等于字符 key[i] 。
 * 	如果字符 key[i] 已经对齐到12:00方向，您需要按下中心按钮进行拼写，这也将算作 1 步。按完之后，您可以开始拼写 key 的下一个字符（下一阶段）, 直至完成所有拼写。
 *
 * Example:
 *      示例 1
 *       
 *       
 *      输入: ring = "godding", key = "gd"
 *      输出: 4
 *      解释:
 *       对于 key 的第一个字符 'g'，已经在正确的位置, 我们只需要1步来拼写这个字符。 
 *       对于 key 的第二个字符 'd'，我们需要逆时针旋转 ring "godding" 2步使它变成 "ddinggo"。
 *       当然, 我们还需要1步进行拼写。
 *       因此最终的输出是 4。
 *      提示：
 *      	ring 和 key 的字符串长度取值范围均为 1 至 100；
 *      	两个字符串中都只有小写字符，并且均可能存在重复字符；
 *      	字符串 key 一定可以由字符串 ring 旋转拼出。
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/freedom-trail/
 * @since   2020-11-25 00:10:22
 */
public class L0514_Freedom_Trail {
    static class Solution {
        public int findRotateSteps(String ring, String key) {
            int[][] dp = new int[key.length()][ring.length()];
            for (int i = 0; i < key.length(); i++) {
                for (int j = 0; j < ring.length(); j ++) {
                    if (i == 0) {
                        if (ring.charAt(j) == key.charAt(i)) {
                            dp[i][j] = Math.min((ring.length() - j) % ring.length(), j) + 1;
                        } else {
                            dp[i][j] = -1;
                        }
                    } else {
                        if (ring.charAt(j) != key.charAt(i)) {
                            continue;
                        }
                        for (int k = 0; k < ring.length(); k ++) {
                            if (dp[i-1][k] > 0) {
                                int dst = Math.min((j+ring.length() - k) % ring.length(),  (k+ring.length() - j) % ring.length()) + 1;
                                if (dp[i][j] == 0) {
                                    dp[i][j] = dp[i-1][k] + dst;
                                } else {
                                    dp[i][j] = Math.min(dp[i-1][k] + dst, dp[i][j]);
                                }
                            }
                        }
                    }
                }
            }
            int rs = Integer.MAX_VALUE;
            for (int i = 0; i < ring.length(); i ++) {
                if (dp[key.length() - 1][i] > 0) {
                    rs = Math.min(dp[key.length() - 1][i], rs);
                }
            }
            return rs;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
