public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>(); 
        helper(candidates, new ArrayList<Integer>(), result, 0, target);
        return result;
    }
    
    private void helper(int[] candidates, List<Integer> curList, List<List<Integer>> ans, int start, int target){
       if(target == 0)ans.add(new ArrayList<Integer>(curList));
       //copy the curList instead of using curList directly because curList will change after added to the ans 
        //  if(target == 0)ans.add(curList);
        if(target > 0){
            for(int i = start; i < candidates.length && candidates[i] <= target; i++){
                    curList.add(candidates[i]);
                    helper(candidates, curList, ans, i, target - candidates[i]);
                    curList.remove(curList.size() - 1);
            }
        }
    }
}