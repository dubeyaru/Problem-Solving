/**
https://leetcode.com/problems/trapping-rain-water/
 */

 class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxL = 0;
        int maxR = 0;
        int result = 0;
        while (left <= right) {
            if (height[left] <= height[right]) {
                if (height[left] >= maxL) {
                    maxL = height[left];
                } else {
                    result += (maxL - height[left]);
                }
                left++;
            } else {
                if (height[right] >= maxR) {
                    maxR = height[right];
                } else {
                    result += (maxR - height[right]);
                }
                right--;
            }
        }
        return result;
    }
}