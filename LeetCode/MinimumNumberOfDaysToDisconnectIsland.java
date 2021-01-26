/**
https://leetcode.com/problems/minimum-number-of-days-to-disconnect-island/
 */

class Solution {
    public int minDays(int[][] grid) {
        int N = grid.length;
        int M = grid[0].length;
        int count = connectComponents(grid, N, M);
        if (count != 1) {
            return 0;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    count = connectComponents(grid, N, M);
                    if (count != 1) {
                        return 1;
                    }
                    grid[i][j] = 1;
                }
            }
        }
        return 2;
    }
    
    private int connectComponents(int[][] grid, int N, int M) {
        boolean[][] visited = new boolean[N][M];
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    dfs(grid, i, j, N, M, visited);
                    count++;
                }
            }
        }
        return count;
    }
    
    private void dfs(int[][] grid, int i, int j, int N, int M, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= N || j >= M || visited[i][j] || grid[i][j] == 0) {
            return;
        }
        visited[i][j] = true;
        dfs(grid, i + 1, j, N, M, visited);
        dfs(grid, i - 1, j, N, M, visited);
        dfs(grid, i, j + 1, N, M, visited);
        dfs(grid, i, j - 1, N, M, visited);
    }
}