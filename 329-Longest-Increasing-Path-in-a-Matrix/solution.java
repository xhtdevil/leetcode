public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        if(m == 0)return 0;
        int n = matrix[0].length;
        if(n == 0)return 0;
        boolean[][] visited = new boolean[m][n];
        int[][] ans = new int[m][n];
        int max = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                
                if(visited[i][j] == false)max = Math.max(max, dfs(matrix, i, j, visited, ans));
            }
        }
        return max;
    }
    
    private int dfs(int[][] matrix, int i, int j, boolean[][] visited, int[][] ans) {
        if(ans[i][j] != 0)return ans[i][j];
        visited[i][j] = true;
        ans[i][j] = 1;
        int[][] a = {{i - 1, j}, {i + 1, j}, {i, j - 1}, {i, j + 1}};
        for(int[] x : a) {
            int g = x[0], h = x[1];
            if(g >= 0 && g < matrix.length && h >= 0 && h < matrix[0].length && visited[g][h] == false && matrix[g][h] > matrix[i][j]) {
                ans[i][j] = Math.max(ans[i][j], dfs(matrix, g, h, visited, ans) + 1);
            }
        }
        visited[i][j] = false; 
        return ans[i][j];
    }
}