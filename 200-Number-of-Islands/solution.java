public class Solution {

    public int numIslands(char[][] grid) {
        if(grid == null){return 0;}
        int island = 0;
        int m = grid.length, n = grid[0].length;
        int[][] mark = new int[m][];
        for(int i = 0; i < m; i++){
            mark[i] = new int[n];
        }
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mark[i][j] == 0 && grid[i][j] == '1'){
                    markIsland(grid, mark, i, j, ++island);
                }
            }
        }
        
        return island;
    }
    
    private void markIsland(char[][] grid, int[][] mark, int i, int j, int island){
        mark[i][j] = island;
        int m = grid.length, n = grid[0].length;
        if(i < m - 1 && grid[i + 1][j] == '1' && mark[i + 1][j] != island)markIsland(grid, mark, i + 1, j, island);
        if(j < n - 1 && grid[i][j + 1] == '1' && mark[i][j + 1] != island)markIsland(grid, mark, i, j + 1, island);
    } 
}