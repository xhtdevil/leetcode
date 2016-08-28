public class Solution {
    // private HashMap<int[], Integer> map = new HashMap<int[], Integer>();
    // public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    //     int ans = helper(obstacleGrid, 0, 0);
    //     return ans;
    // }
    
    // private int helper(int[][] grid, int x, int y){
    //     int[] pair = {x, y};
    //     if(map.containsKey(pair))return map.get(pair);
    //     if(x >= grid.length || y >= grid[0].length || grid[x][y] == 1)return 0;
    //     if(x == grid.length - 1 && y == grid[0].length - 1)return 1;
    //     int ans = helper(grid, x + 1, y) + helper(grid, x, y + 1);
    //     map.put(pair, ans);
    //     return ans;
    // }
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int sum = 0;
        int[][] dp = new int[m][];
       for(int i = m - 1; i >= 0; i--){
           dp[i] = new int[n];
           for(int j = n - 1; j >= 0; j--){
               if(obstacleGrid[i][j] == 1)dp[i][j] = 0;
               else if(i == m - 1 && j == n - 1)dp[i][j] = 1;
               else if(i == m - 1)dp[i][j] = dp[i][j + 1];
               else if(j == n - 1)dp[i][j] = dp[i + 1][j];
               else dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
           }
       }
       return dp[0][0];
    }
}