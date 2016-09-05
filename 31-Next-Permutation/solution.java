public class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int des = n - 1;
       while(des > 0 && nums[des] <= nums[des - 1]){
           des--;
       }
        if(des < 1){
            Arrays.sort(nums);
            return;
        }
        int min = des;
        for(int i = des; i < n; i++){
            if(nums[i] > nums[des - 1])min = i;
        }
        swap(nums, min, des - 1);
        ascend(nums, des);
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void ascend(int[] nums, int startIndex){
        int[] temp = new int[nums.length - startIndex];
        for(int i = startIndex; i < nums.length; i++){
            temp[i - startIndex] = nums[i];
        }
        Arrays.sort(temp);
        for(int i = startIndex; i < nums.length; i++){
            nums[i] = temp[i - startIndex];
        }
    }
    
}