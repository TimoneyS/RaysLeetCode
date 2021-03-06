package com.ray.leetcode.resolved;

import com.ray.util.Out;

/**
 * Super Egg Drop
 * -----------------------------------------------------------------------------
 * k个鸡蛋，N层楼（1 -> N）
 *
 * 鸡蛋有一个安全楼层 F （0 -> N）
 *     在F层及以下，扔下鸡蛋能够不碎
 *     在F层以上  ，扔下鸡蛋一定会碎
 * 鸡蛋如果没碎，可以继续使用
 *
 * F 可能是任意一个值，每次扔一个鸡蛋
 * 要找出这个 F 具体是那个数，在最坏的情况下，最少需要扔多少次鸡蛋(移动次数)
 *
 * Example 1
 *      Input: K = 1, N = 2
 *      Output: 2
 *      Explanation: 
 *      Drop the egg from floor 1.  If it breaks, we know with certainty that F = 0.
 *      Otherwise, drop the egg from floor 2.  If it breaks, we know with certainty that F = 1.
 *      If it didn't break, then we know with certainty F = 2.
 *      Hence, we needed 2 moves in the worst case to know what F is with certainty.
 * Example 2
 *      Input: K = 2, N = 6
 *      Output: 3
 * Example 3
 *      Input: K = 3, N = 14
 *      Output: 4
 * Note:
 * 	1 <= K <= 100
 * 	1 <= N <= 10000
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/super-egg-drop/
 * @since   2020-04-11 13:36:53
 */
public class L0923_Super_Egg_Drop {
    /**
     * dp[i][j] 表示 i 个 鸡蛋，j层楼，需要的最小移动次数
     *
     * 首先在 l 层尝试：
     *      如果鸡蛋碎了：那么 F 就在 l 以下，可用的鸡蛋数量  -1，结果为 dp[i-1][l-1]
     *      如果鸡蛋没碎：那么 F 就在 l 以上，可用的鸡蛋数量不变，结果为 dp[i][j-l-1]
     * 然后总是考虑最坏的情况
     *      dp[i][j] = 1 + max(dp[i-1][l-1], dp[i][j-l-1])
     */
    static class Solution {
        public int superEggDrop(int K, int N) {
            int[][] dp = new int[K+1][N+1];
            for (int i = 0; i <= K; i++) {
                dp[i][1] = 1;
            }
            for (int i = 0; i <= N; i++) {
                dp[1][i] = i;
            }

            for (int i = 2; i <= K; i++) {
                for (int j = 2; j <= N; j++) {
                    int l = 1, h = j;
                    while (l + 1 < h) {
                        int x = (l + h) / 2;
                        int t1 = dp[i-1][x-1];
                        int t2 = dp[i][j-x  ];
                        if (t1 < t2)
                            l = x;
                        else if (t1 > t2)
                            h = x;
                        else
                            l = h = x;
                    }
                    dp[i][j] = 1 + Math.min(
                            Math.max(dp[i-1][h-1], dp[i][j-h]),
                            Math.max(dp[i-1][l-1], dp[i][j-l]));
                }
            }
            return dp[K][N];
        }
    }
    
    public static void main(String[] args) {
        int K = 8;
        int N = 10000;
        Out.p(new Solution().superEggDrop(K, N));
    }
}
