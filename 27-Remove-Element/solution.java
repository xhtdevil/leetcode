public class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0, temp, n = nums.length;
        while(i < nums.length){
            if(nums[i] == val){
                temp = nums[i];
                nums[i] = nums[n - 1];
                nums[n - 1] = temp;
                if(n > 0){n--;}else{break;}
            }else{
                i++;
            }
        }
        return n;
    }
}