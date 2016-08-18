public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n]; 
        if(n == 0)return matrix;
        // if(n == 1){
        //     matrix[0][0] = 1;
        //     return matrix;
        // } 
        helper(1, 0, n, matrix);
        return matrix;
    }
    private void helper(int init, int loc, int n, int[][] matrix){
        int num = init;
        if(2 * loc + 1 > n)return;
        if(2 * loc + 1 == n){
            matrix[loc][loc] = num;
            return;
        }
        for(int i = loc; i < n - loc - 1; i++){
            matrix[loc][i] = num;
            num++;
        }
        for(int i = loc; i < n - loc - 1; i++){
            matrix[i][n - 1 -loc] = num;
            num++;
        }
        for(int i = loc; i < n - loc - 1; i++){
            matrix[n - 1 - loc][n - 1 - i] = num;
            num++;
        }
        for(int i = loc; i < n - loc - 1; i++){
            matrix[n - 1 - i][loc] = num;
            num++;
        }
        helper(num, loc + 1, n, matrix);
    }
}