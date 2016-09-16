public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(nums.length < 4)return ans;
        Arrays.sort(nums);
        int max = nums[nums.length - 1];
        int min = nums[0];
        if(max * 4 < target || min * 4 > target)return ans;
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i - 1])continue;
            if((nums[i] + 3 * max) < target)continue;
            if(nums[i] * 4 >= target){
                if(nums[i] * 4 == target && i + 3 < nums.length && nums[i + 3] == nums[i]){
                    ans.add(Arrays.asList(nums[i], nums[i], nums[i], nums[i]));
                }   
                break;
            }
            fourToThreeSum(nums, target - nums[i], nums[i], i + 1, nums.length - 1, ans);
        }
        return ans;
    }
    
    private void fourToThreeSum(int[] nums, int target, int z1, int low, int high, List<List<Integer>> ans){
        if(high - low < 2)return;
        if(nums[low] * 3 > target)return;
        for(int i = low; i < nums.length; i++){
            if(i > low && nums[i - 1] == nums[i])continue;
            if(nums[i] + nums[high] * 2  < target)continue;
            if(nums[i] * 3 >= target){
                if(nums[i] * 3 == target && i + 2 <= high && nums[i] == nums[i + 2]){
                    ans.add(Arrays.asList(z1, nums[i], nums[i], nums[i]));
                }
                break;
            }
            fourToTwoSum(nums, target - nums[i], z1, nums[i], i + 1, nums.length - 1, ans);
        }
    }
    
    private void fourToTwoSum(int[] nums, int target, int z1, int z2, int low, int high, List<List<Integer>> ans){
        if(high - low < 1)return;
        if(nums[low] * 2 > target)return;
        for(int i = low; i < nums.length; i++){
            if(i > low && nums[i - 1] == nums[i])continue;
            if(nums[i] + nums[high]  < target)continue;
            if(nums[i] * 2 >= target){
                if(nums[i] * 2 == target && i + 1 <= high && nums[i] == nums[i + 1]){
                   ans.add(Arrays.asList(z1, z2, nums[i], nums[i]));
                }
                break;
            }
            fourToOneSum(nums, target - nums[i], z1, z2, nums[i], i + 1, nums.length - 1, ans);
        }
    }
    
    private void fourToOneSum(int[] nums, int target, int z1, int z2, int z3, int low, int high, List<List<Integer>> ans){
        if(high - low < 0)return;
        if(nums[low]  > target)return;
        if(nums[high] < target)return;
        for(int i = low; i < nums.length; i++){
            if(i > low && nums[i] == nums[i - 1])continue;
            if(nums[i] == target){
                ans.add(Arrays.asList(z1, z2, z3, nums[i]));
            }
        }
    }
}