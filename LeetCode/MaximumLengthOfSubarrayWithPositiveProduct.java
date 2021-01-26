/**
https://leetcode.com/problems/maximum-length-of-subarray-with-positive-product/
 */

class Solution {
    public int getMaxLen(int[] nums) {
        int maxLen = 0;
        int negIdx = -1;
        int zeroIdx = -1;
        int negCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                if(negIdx == -1) {
                    negIdx = i;
                }
                negCount++;
            } 
            if (nums[i] == 0) {
                zeroIdx = i;
                negCount = 0;
                negIdx = -1;
            } else {
                if (negCount % 2 == 0) {
                    maxLen = Math.max(i - zeroIdx, maxLen);
                } else {
                    maxLen = Math.max(i - negIdx, maxLen);
                }
            }
        }
        return maxLen;
    }
}