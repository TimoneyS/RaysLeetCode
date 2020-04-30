package com.ray.leetcode.resolved;

import com.ray.util.Out;

/**
 * Replace Elements with Greatest Element on Right Side
 * -----------------------------------------------------------------------------
 * Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.
 * After doing so, return the array.
 *
 * Example:
 *      Example 1
 *      Input: arr = [17,18,5,4,6,1]
 *      Output: [18,6,6,6,1,-1]
 *      Constraints:
 *      	1 <= arr.length <= 10^4
 *      	1 <= arr[i] <= 10^5
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/replace-elements-with-greatest-element-on-right-side/
 * @since   2020-04-30 20:20:13
 */
public class L1231_Replace_Elements_with_Greatest_Element_on_Right_Side {
    static class Solution {
        public int[] replaceElements(int[] nums) {
            int size = nums.length;
            int greatestFromRight = nums[size - 1];
            nums[size - 1] = -1;
            for (int i = size - 2; i >= 0; i--) {
                int temp = nums[i];
                nums[i] = greatestFromRight;
                if (greatestFromRight < temp) {
                    greatestFromRight = temp;
                }
            }
            return nums;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
