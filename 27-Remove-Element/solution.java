public class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0, temp, n = nums.length;
        while(i < n){
            if(nums[i] == val){
                if(n > 0){
                    temp = nums[i];
                    nums[i] = nums[n - 1];
                    nums[n - 1] = temp;
                    n--;
                }else{break;}
            }else{
                i++;
            }
        }
        return n;
    }
}