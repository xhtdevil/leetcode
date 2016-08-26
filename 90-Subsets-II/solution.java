public class Solution {
    
    private int duplicate = 0;
    //private HashSet<List<Integer>> set = new HashSet<List<Integer>>();
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<List<Integer>>();
        List<Integer> curList = new ArrayList<Integer>();
        return helper(nums, nums.length);
    }
    
    private List<List<Integer>> helper(int[] nums, int n){
        List<List<Integer>> lastList = new ArrayList<List<Integer>>();
        if(n == 0){
            lastList.add(new ArrayList<Integer>());
            return lastList;
        } 
        lastList = helper(nums, n - 1);
        if(n == 1 || nums[n - 1] != nums[n - 2]){
            duplicate = 0;
        }else{
            duplicate++;
        }
        List<List<Integer>> curList = new ArrayList<List<Integer>>();
        for(int i = 0; i < lastList.size(); i++){
            List<Integer> cur = new ArrayList<Integer>(lastList.get(i));
            if(n == 1 || nums[n - 1] != nums[n - 2]){
                cur.add(nums[n - 1]);
                curList.add(cur);
            }
            else if(!cur.contains(nums[n - 1])){
                for(int j = 0; j < duplicate + 1; j++){
                    cur.add(nums[n - 1]);
                }
                curList.add(cur);
            }
            curList.add(lastList.get(i));
           // if(set.add(cur)){
           //     curList.add(cur);
            //}
        }
        return curList;
    }
}