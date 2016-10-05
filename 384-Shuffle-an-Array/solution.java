public class Solution {
    private Random random;
    private int[] save;
    public Solution(int[] nums) {
        random = new Random();
        save = nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return save;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] a = save.clone();
        for(int j = 1; j < save.length; j++) {
            int i = random.nextInt(j + 1);
            swap(i, j, a);
        }
        return a;
    }
    
    private void swap(int i, int j, int[] a) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */