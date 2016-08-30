public class Solution {
    //time limit exceed(O(n^3))
    // private int min = Integer.MAX_VALUE;
    
    // private int ans = 0;
    
    // public int threeSumClosest(int[] nums, int target) {
    //     int times = 3;
    //     helper(nums, target, 0, 0, times);
    //     return ans;
    // }
    
    // private void helper(int[] nums, int target, int start, int sum, int times){
    //     if(times == 0){
    //         if(Math.abs(target) < min){
    //             ans = sum;
    //             min = Math.abs(target);
    //         }
    //     }
    //     for(int i = start; i < nums.length; i++){
    //         sum += nums[i];
    //         helper(nums, target - nums[i], i + 1, sum, times - 1);
    //         sum -= nums[i];
    //     }
    // } 
    
    //O(n^2)
    public int threeSumClosest(int[] nums, int target) {
        int result = nums[0] + nums[1] + nums[nums.length - 1];
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            int start = i + 1, end = nums.length - 1;
            while(start < end){
                int sum = nums[i] + nums[start] + nums[end];
                if(sum < target){
                    start++;
                }else if(sum > target){
                    end--;
                }else{return sum;}
                if(Math.abs(sum - target) < Math.abs(result - target)){
                    result = sum;
                }
            }
        }
        return result;
    }
}