public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(nums.length < 3)return ans;
        help3Sum(nums, ans);
        return ans;
    }
    
    private void help3Sum(int[] nums, List<List<Integer>> ans){
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i - 1])continue;            // detect duplication situation
            if(nums[i] + nums[nums.length - 1] + nums[nums.length - 2] >= 0 && nums[i] + nums[0] + nums[1] <= 0){
                
                help2Sum(nums[i], i, nums, ans, used);
                
            }
        }
    }
    
    private void help2Sum(int num, int start, int[] nums, List<List<Integer>> ans, boolean[] used){
        for(int i = start + 1; i < nums.length; i++){
            if(nums[i - 1] == nums[i] && start != i - 1)continue;
            if(nums[i] + nums[nums.length - 1] + num >= 0 && nums[i] + nums[0] + num <= 0){
                for(int j = i + 1; j < nums.length; j++){
                    if(j - 1 != i && nums[j] == nums[j - 1])continue;
                    if(num + nums[i] + nums[j] == 0){
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(num);
                        list.add(nums[i]);
                        list.add(nums[j]);
                        
                        ans.add(list);
                    }
                }
            }
        }
    }
}