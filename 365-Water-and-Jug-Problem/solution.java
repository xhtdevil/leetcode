public class Solution {
    Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
    public boolean canMeasureWater(int x, int y, int z) {
        if(z == 0)return true;
        if(x == 0 && y == 0)return false;
        if(z > x + y)return false;
        
        int s = Math.min(x, y);
        int b = Math.max(x, y);
        int sub = b - s;
        if(z % s == 0)return true;
        int f = s - b % s;
        if(z == f || z == f + s || z == f + b || z == sub || z == sub + s || z == sub + b || z == s + b || z == s || z == b)return true;
        //return help(x, y, sub, z);
        else return false;
    }
    
    private boolean help(int a1, int a2, int a3, int sum){
        if(map.containsKey(sum))return map.get(sum);
        if(sum == 0)return true;
        if(sum < 0)return false;
        else{
            boolean ans;
            if((a2 == a3 || a1 == a2) && a1 != a3){
                ans =  help(a1, a2, a3, sum - a1) || help(a1, a2, a3, sum - a3);
            }
            else if(a1 != a2 && a1 == a3){
                ans = help(a1, a2, a3, sum - a1) || help(a1, a2, a3, sum - a2);
            }
            else if(a1 == a2 && a1 == a3){
                ans = help(a1, a2, a3, sum - a1);
            }
            else {
                ans = help(a1, a2, a3, sum - a1) || help(a1, a2, a3, sum - a2) || help(a1, a2, a3, sum - a3);
            }
            map.put(sum, ans);
            return ans;
        }
    }
}