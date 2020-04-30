package com.ray.leetcode.resolved;

import com.ray.util.Out;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Binary Watch
 * -----------------------------------------------------------------------------
 * A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).
 * Each LED represents a zero or one, with the least significant bit on the right.
 * For example, the above binary watch reads "3:25".
 * Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times the watch could represent.
 *
 * Example:
 *      Example 1
 *      Input: n = 1Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
 *      Note:
 *      The order of output does not matter.
 *      The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".
 *      The minute must be consist of two digits and may contain a leading zero, for example "10:2" is not valid, it should be "10:02".
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/binary-watch/
 * @since   2020-04-30 20:28:14
 */
public class L0401_Binary_Watch {
    /**
     * hour < 12, minute < 60，
     * 所以最多小时可以有 3位1，分钟可以有5位1
     *
     * 先统计所有的位数位 n 对应的时间，然后分别相加即可
     */
    static class Solution {
        public List<String> readBinaryWatch(int num) {
            List<String> rs = new ArrayList<>();
            if (num < 0 || num > 8) return rs;

            Map<Integer, List<String>> hMap = new HashMap<>();
            Map<Integer, List<String>> mMap = new HashMap<>();

            for (int i = 0; i < 12; i++) {
                int c = count(Integer.toBinaryString(i));
                if (!hMap.containsKey(c))
                    hMap.put(c, new ArrayList<>());
                hMap.get(c).add(i+"");
            }

            for (int i = 0; i < 60; i++) {
                int c = count(Integer.toBinaryString(i));
                if (!mMap.containsKey(c))
                    mMap.put(c, new ArrayList<>());
                mMap.get(c).add(i < 10 ? "0"+i : ""+i);
            }

            for (int i = 0; i <= 3 && i <= num; i ++) {
                if (!mMap.containsKey(num-i)) continue;
                for (String p : hMap.get(i)) {
                    for (String s : mMap.get(num-i)) {
                        rs.add(p+":"+s);
                    }
                }
            }

            return rs;
        }

        int count(String bs) {
            int c = 0;
            for (int j = 0; j < bs.length(); j++)
                if (bs.charAt(j) == '1') c++;
            return c;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
