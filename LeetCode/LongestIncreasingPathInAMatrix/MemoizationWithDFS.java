class Solution {
    int[][] dp;
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int N = matrix.length;
        int M = matrix[0].length;
        dp = new int[N][M];
        int maxCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int count = dfs(matrix, i, j, N, M, -1);
                maxCount = Math.max(count, maxCount);
            }
        }
        return maxCount;
    }
    
    private int dfs(int[][] matrix, int i, int j, int N, int M, int currVal) {
        if (i < 0 || j < 0 || i >= N || j >= M || matrix[i][j] <= currVal) {
            return 0;
        }
        if (dp[i][j] > 0) {
            return dp[i][j];
        }
        int a = dfs(matrix, i + 1, j, N, M, matrix[i][j]);
        int b = dfs(matrix, i - 1, j, N, M, matrix[i][j]);
        int c = dfs(matrix, i, j + 1, N, M, matrix[i][j]);
        int d = dfs(matrix, i, j - 1, N, M, matrix[i][j]);
        dp[i][j] = Math.max(a, Math.max(b, Math.max(c, d))) + 1; 
        return dp[i][j];
    }
}