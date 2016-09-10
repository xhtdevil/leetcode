public class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){return 0;}
        int m = matrix.length, n = matrix[0].length;
        int[][] b = new int[m + 1][n + 1];
        int max = 0;
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(matrix[i - 1][j - 1] == '1'){
                    b[i][j] = Math.min(Math.min(b[i - 1][j - 1], b[i - 1][j]), b[i][j - 1]) + 1;
                    max = Math.max(max, b[i][j]);
                }
            }
        }
        return max * max;
    }
}