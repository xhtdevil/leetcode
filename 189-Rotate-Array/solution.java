public class Solution {
    public void rotate(int[] nums, int k) {

    if(nums == null || nums.length < 2){
        return;
    }
    
    k = k % nums.length;
    reverse(nums, 0, nums.length - k - 1);
    reverse(nums, nums.length - k, nums.length - 1);
    reverse(nums, 0, nums.length - 1);
    
}

private void reverse(int[] nums, int i, int j){
    int tmp = 0;       
    while(i < j){
        tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
        i++;
        j--;
    }
}
    // public void rotate(int[] nums, int k) {
    //     int length = nums.length;
    //     for(int i = nums.length - k; i <length; i++){
    //         int temp = nums[i];
    //         nums[i] = nums[length - k - i];
    //         nums[length - k - i] = temp;
    //     }
        
        
    //     //exceed time limit
    //     // k = k % nums.length;
    //     // for(int i = nums.length - k; i < nums.length; i++){
    //     //     for(int j = i; j > i + k - nums.length; j--){
    //     //         int temp = nums[j];
    //     //         nums[j] = nums[j - 1];
    //     //         nums[j - 1] = temp;
    //     //     }
    //     // }
    // }
}