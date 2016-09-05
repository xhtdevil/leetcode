public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        if(nums.length == 0)return list;
        if(nums.length == 1){
            list.add(nums[0]);
            return list;
        }
        int res1 = 0, res2 = 0, count1 = 0, count2 = 0;
        for(int i = 0; i < nums.length; i++){
            if(res1 == nums[i])count1++;
            else if(res2 == nums[i])count2++;
            else if(count1 == 0){res1 = nums[i];count1 = 1;}
            else if(count2 == 0){res2 = nums[i];count2 = 1;}
            else{
                count1--;
                count2--;
            }
        }
        int c1 = 0, c2 = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == res1)c1++;
            else if(nums[i] == res2)c2++;
        }
        if(c1 > nums.length / 3)list.add(res1);
        if(c2 > nums.length / 3)list.add(res2);
        return list;
    }
}