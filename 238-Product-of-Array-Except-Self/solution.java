public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] products = new int[n];
        products[0] = 1;
        for(int i = 1; i < n; i++){                         //multiply all elements in the left
            products[i] = products[i - 1] * nums[i - 1];
        }
        int right = 1;
        for(int i = n - 1; i >= 0; i--){                    //multiply all elements in the right
            products[i] *= right;
            right *= nums[i];
        }
        return products;
    }
}