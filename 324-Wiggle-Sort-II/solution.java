public class Solution {
//     public void wiggleSort(int[] nums) {
//         if(nums.length <= 1)return;
//         int i = 1, j = 0;
//         while(i < nums.length && j + 1 < nums.length){
//             if(j % 2 == 0){
//                 if(nums[i] > nums[j]){
//                     swap(nums, i, j + 1);
//                     j++;
//                     i = j + 1;
//                 }
//                 else{
//                     i++;
//                 }
//             }else{
//                 if(nums[i] < nums[j]){
//                     swap(nums, i, j + 1);
//                     j++;
//                     i = j + 1;
//                 }
//                 else{
//                     i++;
//                 }
//             }
//         }
//         if((nums[nums.length - 1] < nums[nums.length - 2] && nums.length % 2 == 0) || (nums[nums.length - 1] > nums[nums.length - 2] && nums.length % 2 == 1))swap(nums, nums.length - 1, nums.length - 2);
//     }
    
     private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    public void wiggleSort(int[] nums) {
        int median = findKthLargest(nums, (nums.length + 1) / 2);
        int n = nums.length;

        int left = 0, i = 0, right = n - 1;

        while (i <= right) {

            if (nums[newIndex(i,n)] > median) {
                swap(nums, newIndex(left++,n), newIndex(i++,n));
            }
            else if (nums[newIndex(i,n)] < median) {
                swap(nums, newIndex(right--,n), newIndex(i,n));
            }
            else {
                i++;
            }
        }


    }

    private int newIndex(int index, int n) {
        return (1 + 2*index) % (n | 1);
    }
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
    

    // private int findKthLargest(int[] nums, int k, int left, int right){
    //     if(nums.length == 0)return 0;
    //     if(left == right)return nums[left];
    //     int i = left + 1, j = right;
    //     while(i < j){
    //         if(nums[i] > nums[left]){
    //             swap(nums, i, j);
    //             j--;
    //         }
    //         else{
    //             i++;
    //         }
    //     }
    //     if(i == k)return nums[left];
    //     else if(i > k){return findKthLargest(nums, k, left, i - 1);}
    //     else{return findKthLargest(nums, k - i, i, right);}
    // }
}