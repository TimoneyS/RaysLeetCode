package com.ray.leetcode.resolved;

import com.ray.util.Out;

/**
 * Partition Array into Disjoint Intervals
 * -----------------------------------------------------------------------------
 * Given an array A, partition it into two (contiguous) subarrays left and right so that:
 * 	Every element in left is less than or equal to every element in right.
 * 	left and right are non-empty.
 * 	left has the smallest possible size.
 * Return the length of left after such a partitioning.  It is guaranteed that such a partitioning exists.
 *
 * Example:
 *      Example 1
 *      Input: [5,0,3,8,6]
 *      Output: 3
 *      Explanation: left = [5,0,3], right = [8,6]
 *      Example 2
 *      Input: [1,1,1,0,6,12]
 *      Output: 4
 *      Explanation: left = [1,1,1,0], right = [6,12]
 *      Note:
 *      	2 <= A.length <= 30000
 *      	0 <= A[i] <= 10^6
 *      	It is guaranteed there is at least one way to partition A as described.
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/partition-array-into-disjoint-intervals/
 * @since   2020-04-14 23:01:52
 */
public class L0951_Partition_Array_into_Disjoint_Intervals {
    static class Solution {
        public int partitionDisjoint(int[] A) {
            // 计算某点开始的最小值
            int[] minFromRight = new int[A.length];
            for (int i = A.length-1; i >= 0; i --) {
                minFromRight[i] = (i == A.length-1 || A[i] < minFromRight[i+1]) ? A[i] : minFromRight[i+1];
            }
            // 计算到每个点为止的最大值，如果这个最大值小于其右侧开始的点的最小值，那么这个点就是符合要求的点
            int max = 0x80000000;
            for (int i = 0; i < A.length; i++) {
                max = Math.max(max, A[i]);
                if (max <= minFromRight[i+1])
                    return i+1;
            }
            return A.length;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
