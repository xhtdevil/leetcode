public class Solution {
    public int[] singleNumber(int[] nums) {
        int dif = 0;
        for(int i = 0; i < nums.length; i++){
            dif ^= nums[i];
        }
        dif &= -dif;
        int res[] = {0,0};
        for(int i = 0; i < nums.length; i++){
            if((nums[i] & dif) == 0){
                res[0] ^= nums[i];
            }
            else{
                res[1] ^= nums[i];
            }
        }
        return res;
    }
}