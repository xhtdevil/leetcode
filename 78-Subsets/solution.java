public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        return helper(nums, nums.length);
    }
    
    private List<List<Integer>> helper(int[] nums, int n){
        List<List<Integer>> lastList = new ArrayList<List<Integer>>();
        if(n == 0){
            lastList.add(new ArrayList<Integer>());
            return lastList;
        }
        lastList = helper(nums, n - 1);
        List<List<Integer>> resList = new ArrayList<List<Integer>>();
        for(int i = 0; i < lastList.size(); i++){
            List<Integer> temp = new ArrayList<Integer>();
            temp.addAll(lastList.get(i));                       //copy last list
            temp.add(nums[n - 1]);                                  //add new element
            resList.add(lastList.get(i));
            resList.add(temp);
        }
        return resList;
    }
}