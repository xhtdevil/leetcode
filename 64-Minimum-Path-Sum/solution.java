public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        
        int[] uppermin = new int[n];
        int summin = 0;
        for(int j = 0; j < n; j++){
            summin += grid[0][j];
            uppermin[j] = summin;
        }
        
        //uppermin[0] += grid[0][0];
        
        for(int i = 1; i < m; i++){
            uppermin[0] += grid[i][0];
            for(int j = 1; j < n; j++){
                uppermin[j] = Math.min(uppermin[j - 1], uppermin[j]) + grid[i][j];
            }
        }
        
        return uppermin[n - 1];
    }
}