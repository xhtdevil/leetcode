public class Solution {
    public List<List<Integer>> permute(int[] nums) {
         return helper(nums, nums.length);                                               
    }
    
    private List<List<Integer>> helper(int[] nums, int n){
        if(n == 1){
            List<List<Integer>> ans = new ArrayList<List<Integer>>();
            ans.add(new ArrayList<Integer>());
            ans.get(0).add(nums[0]);
            return ans;
        }
        List<List<Integer>> last = helper(nums, n - 1);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for(int i = 0; i < last.size(); i++){
            for(int j = 0; j < n; j++){
                ans.add(new ArrayList<Integer>());
                for(int m = 0; m < last.get(i).size(); m++){//copy all of the element in last 
                    ans.get(i * n + j).add(last.get(i).get(m));
                }
                ans.get(i * n + j).add(j, nums[n - 1]);
            }
        }
        return ans;
    }
}