/**
https://leetcode.com/problems/maximum-product-subarray/
 */

class Solution {
    public int maxProduct(int[] nums) {
        int left = 0, right = 0, result = nums[0];
        int N = nums.length;
        for (int i = 0; i < N; i++) {
            if (left == 0) {
                left = nums[i];
            } else {
                left *= nums[i];
            }
            if (right == 0) {
                right = nums[N - i - 1];
            } else {
                right *= nums[N - i - 1];
            }
            result = Math.max(result, Math.max(left, right));
        }
        return result;
    }
}