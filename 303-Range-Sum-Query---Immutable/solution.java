public class NumArray {
    
    private int array[];

    public NumArray(int[] nums) {
        int length = nums.length;
        array = new int[length];
        for(int i = 0; i < length; i++){
            array[i] = nums[i];
        }
    }

    public int sumRange(int i, int j) {
        int sum = 0;
        for(int n = i; n < j + 1; n++){
            sum += array[n];
        }
        return sum;
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);