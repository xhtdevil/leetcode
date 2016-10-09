public class Solution {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        int m = matrix.length;
        List<int[]> ans = new ArrayList<>();
        if(m == 0)return ans;
        int n = matrix[0].length;
        //boolean[][] visited = new boolean[m][n];
        boolean[][] Pac = new boolean[m][n];
        boolean[][] Atl = new boolean[m][n];
        //int seaLevel = Integer.MIN_VALUE;
        for(int i = 0; i < m; i++) {
            dfs(matrix, i, 0, Pac);
            dfs(matrix, i, n - 1, Atl);
        }
        for(int j = 0; j < n; j++) {
            dfs(matrix, 0, j, Pac);
            dfs(matrix, m - 1, j, Atl);
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(Pac[i][j] && Atl[i][j]) {
                    ans.add(new int[]{i,j});
                }
            }
        }
        return ans;
    }
    
    private void dfs(int[][] matrix, int i, int j, boolean[][] visited) {
        visited[i][j] = true;
        int[][] cands = {{i - 1, j}, {i + 1, j}, {i, j - 1}, {i, j + 1}};
        for(int[] cand : cands) {
            if(cand[0] >= 0 && cand[0] < matrix.length && cand[1] >= 0 && cand[1] < matrix[0].length && matrix[i][j] <= matrix[cand[0]][cand[1]] && visited[cand[0]][cand[1]] == false ) {
                dfs(matrix, cand[0], cand[1], visited);
            }
        }
        // if(i == 0 || j == 0)Pac[i][j] = 1;
        // if(i == matrix.length || j == matrix[0].length) Atl[i][j] = 1;
        // if(Pac[i][j] == 1 && Atl[i][j] == 1) return;
        // int[][] cands = {{i - 1, j}, {i + 1, j}, {i, j - 1}, {i, j + 1}};
        // for(int[] cand : cands) {
        //     if(cand[0] >= 0 && cand[0] < matrix.length && cand[1] >= 0 && cand[1] < matrix[0].length && matrix[i][j] >= matrix[cand[0]][cand[1]] && visited[cand[0]][cand[1]] == false ) {
        //         if(!visited[cand[0]][cand[1]]) {
        //             dfs(matrix, cand[0], cand[1], Pac, Atl, ans, visited);
        //             if(Pac[cand[0]][cand[1]] == 1)Pac[i][j] = 1;
        //             if(Atl[cand[0]][cand[1]] == 1)Atl[i][j] = 1;
        //         }
        //     }
        // }
    } 
}