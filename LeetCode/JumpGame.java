/**
https://leetcode.com/problems/jump-game/
 */

class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        return solve(nums);
    }
    
    private boolean solve(int[] nums) {
        int currRange = 0, nextRange = 0;
        for (int i = 0; i <= currRange; i++) {
            if (i == nums.length - 1) {
                return true;
            }
            nextRange = Math.max(nextRange, nums[i] + i);
            if (i == currRange) {
                currRange = nextRange;
            }
        }
        return false;
    }
}