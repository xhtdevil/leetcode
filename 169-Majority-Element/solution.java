public class Solution {
    public int majorityElement(int[] nums) {
        //moore voting algorithm
        // delete two different elements in nums every time and the only element left will be the majority element
        
        int res = 0, count = 0;
        for(int num: nums){
            if(count == 0)res = num;
            if(num != res)count--;
            else count++;
        }
        return res;
    }
}