public class Solution {
    
    private static final int base = 1337;
    
    public int superPow(int a, int[] b) {
        return helper(a, b, b.length);
    }
    
    private int Pow(int a, int b){          //a * b % base
        a %= base;
        int ans = 1;
        for(int i = 0; i < b; i++){
            ans = (ans * a) % base;
        }
        return ans;
    }
    
    private int helper(int a, int[] b, int n){
        if(n == 0)return 1;
        int last = helper(a, b, n - 1);
        return ((Pow(last, 10)) * (Pow(a, b[n - 1]))) % base;
    }
}