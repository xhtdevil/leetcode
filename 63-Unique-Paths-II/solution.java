public class Solution {
    private HashMap<int[], Integer> map = new HashMap<int[], Integer>();
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int ans = helper(obstacleGrid, 0, 0);
        return ans;
    }
    
    private int helper(int[][] grid, int x, int y){
        int[] pair = {x, y};
        if(map.containsKey(pair))return map.get(pair);
        if(x >= grid.length || y >= grid[0].length || grid[x][y] == 1)return 0;
        if(x == grid.length - 1 && y == grid[0].length - 1)return 1;
        int ans = helper(grid, x + 1, y) + helper(grid, x, y + 1);
        map.put(pair, ans);
        return ans;
    }
}