class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int N = matrix.length;
        int M = matrix[0].length;
        boolean[][] visited = new boolean[N][M];
        int[] count = new int[1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dfs(matrix, i, j, N, M, count, visited, 1, -1);
            }
        }
        return count[0];
    }
    
    private void dfs(int[][] matrix, int i, int j, int N, int M, int[] count, boolean[][] visited, int len, int currVal) {
        if (i < 0 || j < 0 || i >= N || j >= M || visited[i][j] || matrix[i][j] <= currVal) {
            return;
        }
        visited[i][j] = true;
        count[0] = Math.max(count[0], len);
        dfs(matrix, i + 1, j, N, M, count, visited, len + 1, matrix[i][j]);
        dfs(matrix, i - 1, j, N, M, count, visited, len + 1, matrix[i][j]);
        dfs(matrix, i, j + 1, N, M, count, visited, len + 1, matrix[i][j]);
        dfs(matrix, i, j - 1, N, M, count, visited, len + 1, matrix[i][j]);
        visited[i][j] = false;
    }
}
