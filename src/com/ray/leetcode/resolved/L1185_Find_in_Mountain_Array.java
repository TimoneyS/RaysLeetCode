package com.ray.leetcode.resolved;

import com.ray.util.Out;

/**
 * Find in Mountain Array
 * -----------------------------------------------------------------------------
 * (This problem is an interactive problem.)
 * You may recall that an array A is a mountain array if and only if:
 * 	A.length >= 3
 * 	There exists some i with 0 < i < A.length - 1 such that:
 * 		A[0] < A[1] < ... A[i-1] < A[i]
 * 		A[i] > A[i+1] > ... > A[A.length - 1]
 * Given a mountain array mountainArr, return the minimum index such that mountainArr.get(index) == target.  If such an index doesn't exist, return -1.
 * You can't access the mountain array directly.  You may only access the array using a MountainArray interface:
 * 	MountainArray.get(k) returns the element of the array at index k (0-indexed).
 * 	MountainArray.length() returns the length of the array.
 * Submissions making more than 100 calls to MountainArray.get will be judged Wrong Answer.  Also, any solutions that attempt to circumvent the judge will result in disqualification.
 *
 * Example:
 *      Example 1
 *      Input: array = [1,2,3,4,5,3,1], target = 3
 *      Output: 2
 *      Explanation: 3 exists in the array, at index=2 and index=5. Return the minimum index, which is 2.
 *      Example 2
 *      Input: array = [0,1,2,4,2,1], target = 3
 *      Output: -1
 *      Explanation: 3 does not exist in the array, so we return -1.
 *      Constraints:
 *      	3 <= mountain_arr.length() <= 10000
 *      	0 <= target <= 10^9
 *      	0 <= mountain_arr.get(index) <= 10^9
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/find-in-mountain-array/
 * @since   2020-04-30 20:11:56
 */
public class L1185_Find_in_Mountain_Array {
    interface MountainArray {
        int get(int index);
        int length();
    }

    static class Solution {
        public int findInMountainArray(int target, MountainArray mountainArr) {
            return findInMountainArray(mountainArr, 0, mountainArr.length() - 1, target);
        }

        private int findInMountainArray(MountainArray mountainArr, int l, int r, int target) {
            int index = -1;
            if (l <= r) {
                int mid = (r + l) / 2;
                int midval = mountainArr.get(mid);
                int c = target - midval;
                if (c <= 0) {
                    index = findInMountainArray(mountainArr, l, mid - 1, target);
                    if (c == 0) {
                        if (index == - 1) index = mid;
                    } else if (index == -1) {
                        index = findInMountainArray(mountainArr, mid + 1, r, target);
                    }
                } else {
                    int p = position(mountainArr, mid, midval);
                    if (p < 0) {
                        index = findInMountainArray(mountainArr, mid + 1, r, target);
                    } else {
                        index = findInMountainArray(mountainArr, l, mid - 1, target);
                    }
                }
            }
            return index;
        }

        private int position(MountainArray mountainArr, int mid, int midval) {
            int l, r;
            if (mid == mountainArr.length() - 1) {
                l = mountainArr.get(mid-1);
                r = midval;
            } else {
                l = midval;
                r = mountainArr.get(mid + 1);
            }
            return l < r ? -1 : 1;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
