public class Solution {
    public int nthUglyNumber(int n) {
        int factor2 = 2, factor3 = 3, factor5 = 5;
        int index2 = 0, index3 = 0, index5 = 0;
        int[] ans = new int[n];
        ans[0] = 1;
        for(int i = 1; i < n; i++){
            ans[i] = Math.min(Math.min(factor2, factor3), factor5);
            if(ans[i] == factor2){factor2 = ans[++index2] * 2;}
            if(ans[i] == factor3){factor3 = ans[++index3] * 3;}
            if(ans[i] == factor5){factor5 = ans[++index5] * 5;}
        }
        return ans[n - 1];
    }
}