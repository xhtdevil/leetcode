public class Solution {
    
    private HashMap<int[], Integer> map = new HashMap<int[], Integer>();
    
    public int uniquePaths(int m, int n) {
        Integer[][] map = new Integer[m][n];
        for(int i = 0; i<m;i++){
            map[i][0] = 1;
        }
        for(int j= 0;j<n;j++){
            map[0][j]=1;
        }
        for(int i = 1;i<m;i++){
            for(int j = 1;j<n;j++){
                map[i][j] = map[i-1][j]+map[i][j-1];
            }
        }
        return map[m-1][n-1];
        
        //Time Exceed
        // if(m == 1 && n == 1)return 1; 
        // int[] loc = {m, n};
        // int[] locRev = {n, m};
        // int ans = 0;
        // if(map.containsKey(loc) || map.containsKey(locRev)){
        //     ans = map.get(loc);
        //     return ans;
        // }

        // int upperPaths = 0;
        // int leftPaths = 0;
        
        // if(m > 1){
        //     upperPaths = uniquePaths(m - 1, n);
        // }
        // if(n > 1){
        //     leftPaths = uniquePaths(m, n - 1);
        // }
        // ans = upperPaths + leftPaths;
        // map.put(loc, ans);
        // map.put(locRev, ans);
        // return ans;
    }
}