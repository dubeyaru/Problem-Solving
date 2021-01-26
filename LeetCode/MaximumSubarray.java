/**
https://leetcode.com/problems/maximum-subarray/
 */

class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int maxSum = Integer.MIN_VALUE;
        int maxSumSoFar = 0;
        for (int i = 0; i < nums.length; i++) {
            maxSumSoFar = Math.max(nums[i], nums[i] + maxSumSoFar);
            maxSum = Math.max(maxSum, maxSumSoFar);
        }
        return maxSum;
    }
}