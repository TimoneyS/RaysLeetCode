package com.ray.leetcode.resolved;

import com.ray.util.Out;

/**
 * Poor Pigs
 * -----------------------------------------------------------------------------
 * There are 1000 buckets, one and only one of them is poisonous, while the rest are filled with water. They all look identical. If a pig drinks the poison it will die within 15 minutes. What is the minimum amount of pigs you need to figure out which bucket is poisonous within one hour?
 * Answer this question, and write an algorithm for the general case.
 * General case: 
 * If there are n buckets and a pig drinking poison will die within m minutes, how many pigs (x) you need to figure out the poisonous bucket within p minutes? There is exactly one bucket with poison.
 * Note:
 * 	A pig can be allowed to drink simultaneously on as many buckets as one would like, and the feeding takes no time.
 * 	After a pig has instantly finished drinking buckets, there has to be a cool down time of m minutes. During this time, only observation is allowed and no feedings at all.
 * 	Any given bucket can be sampled an infinite number of times (by an unlimited number of pigs).
 *
 * Example:
 *      
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/poor-pigs/
 * @since   2020-04-14 23:04:02
 */
public class L0458_Poor_Pigs {
    /**
     * 能够测试的次数 m = minutesToTest / minutesToDie
     * 问题可以转换为 n 个水，测试 x 次
     * =====================================================================================
     * 如果有 2 头猪，测试 1 次
     * 对于每桶水，猪有喝水(1)或不喝(0)，两个选择
     * 只要保证每桶水被猪喝的方式不同，然后观察猪的死亡情况，就能确定具体哪桶水有毒。
     * 2 头猪可能喝的方式有 2 ^ 2 种 (00,01,10,11)
     *
     * 如果没有猪死亡  ，那么一定是喝水方式为 00 的有毒
     * 如果第一头猪死亡，那么一定是喝水方式为 10 的有毒
     * 如果第二头猪死亡，那么一定是喝水方式为 01 的有毒
     * 如果两头猪均死亡，那么一定是喝水方式为 11 的有毒
     *
     * 如果有 2 头猪，测试 1 次，最多可以确定 8 桶水
     * =====================================================================================
     * 如果有 2 头猪，测试 2 次
     * 对于每桶水，猪有不喝(0),第一次喝(1)，第二次喝(2)，三个选择
     * 2 头猪可能喝的方式有 3 ^ 2 种 (00,01,02,10,11,12,20,21,22)
     *
     * 如果没有猪死亡       ，那么一定是喝水方式为 00 的有毒
     * 如果第一头猪第一轮死亡，那么一定是喝水方式为 10 的有毒
     * 如果第一头猪第二轮死亡，那么一定是喝水方式为 20 的有毒
     * 如果第一头猪第一轮死亡第二头猪第二轮死亡，那么一定是喝水方式为 12 的有毒
     * ...
     * =====================================================================================
     * 如果 n 个水，测试 x 次，需要 k 头猪，则一定有
     * (x+1) ^ k >= n
     *
     * (minutesToTest / minutesToDie + 1) ^ rs >= buckets
     * 两边取 log
     * rs >= log(minutesToTest / minutesToDie + 1, buckets)
     * rs >= log(10, buckets) / log(10, minutesToTest / minutesToDie + 1)
     * rs >= Math.log(buckets) / Math.log(minutesToTest / minutesToDie + 1)
     */
    static class Solution {
        public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
            return (int) Math.ceil(Math.log(buckets) / Math.log(minutesToTest / minutesToDie + 1));
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
