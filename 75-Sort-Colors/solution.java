public class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int i = n - 1, j = n - 1;
        int m = 0;
        while(m <= i){
            if(nums[m] == 1){
                swap(nums, i, m);
                i--;
            }
            else if(nums[m] == 2){
                swap(nums, i, j);
                if(m != i){
                    swap(nums, j, m);
                }
                j--;
                i--;
            }
            else{
                m++;
            }
        }
    }
    
    private void swap(int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}