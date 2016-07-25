public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> numLoc = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            if(!numLoc.containsKey(nums[i])){numLoc.put(nums[i],i);}
            else if(i - numLoc.get(nums[i]) <= k){return true;}
            else{numLoc.put(nums[i],i);}
        }
        return false;
    }
}