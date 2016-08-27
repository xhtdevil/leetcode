public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        //bottom up dp
        
        int n = triangle.size();
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            ans[i] = triangle.get(n - 1).get(i);
        }
        for(int i = n - 2; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                ans[j] = Math.min(ans[j], ans[j + 1]) + triangle.get(i).get(j);
            }
        }
        return ans[0];
    }
    
    // private int helper(List<List<Integer>> triangle, int row, int col){
    //     if(row == triangle.length - 1)return triangle.get(row).get(col);
    //     return Math.min(helper(triangle, row + 1, col), helper(triangle, row + 1, col + 1)) + triangle.get(row).get(col);
    // }
}