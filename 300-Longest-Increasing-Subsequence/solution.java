public class Solution {
    public int lengthOfLIS(int[] nums) {
        int i = 0, size = 0, j = 0;
        int[] tails = new int[nums.length];
        for(int x : nums){
            i = 0;
            j =  size;
            while(i != j){
                int m = i + (j - i) / 2;
                if(tails[m] < x){
                    i = m + 1;
                }
                else{
                    j = m;
                }
            }
            tails[i] = x;
            if(i == size){size++;}
        }
        return size;
    }
}