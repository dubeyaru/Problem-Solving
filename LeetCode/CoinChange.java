/**
https://leetcode.com/problems/coin-change/
 */

 class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return 0;
        }
        int count = solve(coins, amount);
        if (count == Integer.MAX_VALUE || count == Integer.MAX_VALUE - 1) {
            return -1;
        }
        return count;
    }
    
    private int solve(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i = 0; i <= amount; i++) {
            dp[0][i] = Integer.MAX_VALUE - 1;
        }
        for (int i = 0; i <= coins.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i - 1] <= j) {
                    dp[i][j] = Math.min(1 + dp[i][j - coins[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[coins.length][amount];
    }
}