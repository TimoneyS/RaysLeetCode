package com.ray.leetcode;

import com.ray.util.Out;

/**
 * Stone Game
 * -----------------------------------------------------------------------------
 * 亚历克斯和李用几堆石子在做游戏。偶数堆石子排成一行，每堆都有正整数颗石子 piles[i] 。
 * 游戏以谁手中的石子最多来决出胜负。石子的总数是奇数，所以没有平局。
 * 亚历克斯和李轮流进行，亚历克斯先开始。 每回合，玩家从行的开始或结束处取走整堆石头。 这种情况一直持续到没有更多的石子堆为止，此时手中石子最多的玩家获胜。
 * 假设亚历克斯和李都发挥出最佳水平，当亚历克斯赢得比赛时返回 true ，当李赢得比赛时返回 false 。
 *
 * Example:
 * 输入：[5,3,4,5]
 * 输出：true
 * 解释：
 *      亚历克斯先开始，只能拿前 5 颗或后 5 颗石子 。
 *      假设他取了前 5 颗，这一行就变成了 [3,4,5] 。
 *      如果李拿走前 3 颗，那么剩下的是 [4,5]，亚历克斯拿走后 5 颗赢得 10 分。
 *      如果李拿走后 5 颗，那么剩下的是 [3,4]，亚历克斯拿走后 4 颗赢得 9 分。
 *      这表明，取前 5 颗石子对亚历克斯来说是一个胜利的举动，所以我们返回 true 。
 * Note:
 * 	    2 <= piles.length <= 500
 * 	    piles.length is even.
 * 	    1 <= piles[i] <= 500
 * 	    sum(piles) is odd.
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/stone-game/
 * @since   2020-04-07 22:38:06
 */
public class L0909_Stone_Game {
    static class Solution {
        public boolean stoneGame(int[] A) {
            return stoneGame(A, 0, A.length - 1, 0);
        }

        private boolean stoneGame(int[] A, int i, int j, int dif) {
            if (i > j) return dif > 0;
            return  stoneGame(A, i + 1, j - 1, dif + A[i] - A[j]) ||
                    stoneGame(A, i + 1, j - 1, dif + A[j] - A[i]) ||

                    stoneGame(A, i + 2, j , dif + A[i] - A[i+1]) ||
                    stoneGame(A, i, j - 2, dif + A[j] - A[j-1]);
        }
    }
    
    public static void main(String[] args) {
        int[] A = {5,3,4,5};
        Out.p(new Solution().stoneGame(A));
    }
}
