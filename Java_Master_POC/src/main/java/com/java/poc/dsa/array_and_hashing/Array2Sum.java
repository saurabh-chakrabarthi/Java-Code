package com.java.poc.dsa.array_and_hashing;

import java.util.*;

/**
 * 1. Two Sum
 * Solved
 * Easy
 * Topics
 * Companies
 * Hint
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 *
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * Only one valid answer exists.
 */
public class Array2Sum {

    public static void main(String[] args) {
        int[] arr = {8, 7, 10, 4, 5, 5, 5};
        System.out.println("input array : " + Arrays.toString(arr));
        int target = 15;
        System.out.println("target : " + target);
        //List<int[]> arrElementList = calculate_using_brute_force(arr, target);
        //List<int[]> arrElementList = calculate_using_sorting(arr,target);
        List<int[]> arrElementList = calculate_using_hashing(arr,target);

        if (arrElementList.size() == 0) {
            System.out.println("No matching pair found !");
        } else {
            System.out.println("The matching pair(s) are : ");
            for (int[] i : arrElementList) {
                System.out.println(Arrays.toString(i));
            }
        }
    }

    //O(n^2) time complexity, O(1) space complexity
    private static List<int[]> calculate_using_brute_force(int[] arr, int target) {
        List<int[]> arrElementList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    arrElementList.add(new int[]{arr[i], arr[j]});
                }
            }
        }
        return arrElementList;
    }

    //O(nlog(n)) time complexity, O(1) space complexity
    private static List<int[]> calculate_using_sorting(int[] arr, int target) {
        List<int[]> arrElementList = new ArrayList<>();
        Arrays.sort(arr);

        int low = 0;
        int high = arr.length - 1;

        while (low < high) {
            if (arr[low] + arr[high] == target) {
                arrElementList.add(new int[]{arr[low], arr[high]});
            }

            // increment the low index if sum is less than target. Else, decrement high index.
            if (arr[low] + arr[high] < target) {
                low++;
            } else {
                high--;
            }
        }
        return arrElementList;
    }

    //O(n) time complexity, O(n) space complexity
    private static List<int[]> calculate_using_hashing(int[] arr, int target) {
        List<int[]> arrElementList = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(target - arr[i])) {
                arrElementList.add(new int[]{arr[i], target - arr[i]});
            }
            map.put(arr[i], i);
        }
        return arrElementList;
    }
}
