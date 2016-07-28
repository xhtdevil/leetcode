public class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        for(int i = nums.length - k; i < nums.length; i++){
            for(int j = i; j > i + k - nums.length; j--){
                int temp = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = temp;
            }
        }
    }
}