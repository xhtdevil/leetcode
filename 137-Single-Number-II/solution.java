public class Solution {
    public int singleNumber(int[] nums) {
        int bit[] = new int[32];
        int res = 0;
        for(int i = 0; i < 32; i++){
            for(int j = 0; j < nums.length; j++){
                bit[i] += (nums[j] >> i) & 1; 
            }
            res |= (bit[i] % 3 << i);
        }
        return res;
    }
}