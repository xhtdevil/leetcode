public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        int m = matrix.length;
        if(m == 0)return list;
        int n = matrix[0].length;
        if(n == 0)return list;
        int maxm = m, maxn = n, row = 0;
        while(maxm > 0 && maxn > 0){
            for(int i = 0; i < maxn; i++){
                list.add(matrix[row][i + row]);
            }
            for(int i = 0; i < maxm - 1; i++){
                list.add(matrix[i + row][m - row - 1]);
            }
            for(int i = 0; i < maxn - 1; i++){
                list.add(matrix[n - row - 1][m - 1 - row - i]);
            }
            for(int i = 1; i < maxm - 1; i++){
                list.add(matrix[m - 1 - i - row][row]);
            }
            row++;
            maxm -= 2;
            maxn -= 2;
        }
        return list;
    }
}