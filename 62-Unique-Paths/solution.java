public class Solution {
    
    private HashMap<int[], Integer> map = new HashMap<int[], Integer>();
    
    public int uniquePaths(int m, int n) {
        if(m == 1 && n == 1)return 1; 
        int[] loc = {m, n};
        int[] locRev = {n, m};
        int ans = 0;
        if(map.containsKey(loc) || map.containsKey(locRev)){
            ans = map.get(loc);
            return ans;
        }

        int upperPaths = 0;
        int leftPaths = 0;
        
        if(m > 1){
            upperPaths = uniquePaths(m - 1, n);
        }
        if(n > 1){
            leftPaths = uniquePaths(m, n - 1);
        }
        ans = upperPaths + leftPaths;
        map.put(loc, ans);
        map.put(locRev, ans);
        return ans;
    }
}