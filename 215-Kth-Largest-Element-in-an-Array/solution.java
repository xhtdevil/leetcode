public class Solution {
    public int findKthLargest(int[] nums, int k) {//selection algorithm
        if(nums.length == 1)return 1;
        int low = 0, high = nums.length - 1;
        k = nums.length - k; //(k+1)th smallest number
        while(low < high){
            int j = splitNum(low, high, nums);
            if(j < k){
                low = j + 1;
            }
            else if(j > k){
                high = j - 1;
            }
            else{
                break;
            }
        }
        return nums[k];
    }
    
    private int splitNum(int low, int high, int[] nums){
        int j = low + 1, i = low;
        while(j <= high){
            if(nums[j] <= nums[low]){
                i++;
                if(i != j)swap(nums, i, j);
            }
            j++;
        }
        swap(nums, low, i);
        return i;
    }
    
    private void swap(int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}