public class Solution {
    Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
    public boolean canMeasureWater(int x, int y, int z) {
        int sub = Math.abs(x - y);
        return help(x, y, sub, z);
    }
    
    private boolean help(int a1, int a2, int a3, int sum){
        if(map.containsKey(sum))return map.get(sum);
        if(sum == 0)return true;
        if(sum < 0)return false;
        else{
            
            boolean ans = help(a1, a2, a3, sum - a1) || help(a1, a2, a3, sum - a2) || help(a1, a2, a3, sum - a3);
            map.put(sum, ans);
            return ans;
        }
    }
}