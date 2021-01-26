/**
https://leetcode.com/problems/range-sum-query-2d-immutable/
 */

class NumMatrix {
    int[][] mat;
    int R = 0, C = 0;
    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;
        R = matrix.length;
        C = matrix[0].length;
        mat = new int[R][C];
        for(int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++){
                mat[i][j] = matrix[i][j];
            }
        }
    }
    
    public void update(int row, int col, int val) {
        if(row < R && col < C) {
            mat[row][col] = val;
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2 && i < R; i++) {
            for (int j = col1; j <= col2 && j < C; j++) {
                sum += mat[i][j];
            }
        }
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */