public class Solution {
    public int numTrees(int n) {
        if(n == 1)return 1;
        if(n == 0)return 0;
        int sum[] = new int[n + 1];
        sum[0] = 1;
        sum[1] = 1;
        for(int i = 2; i < n + 1; i++){
            sum[i] = 0;
            for(int j = 0; j < i; j++){
                    sum[i] += sum[i - j - 1] * sum[j];
            }
        }
        return sum[n];
    }
}